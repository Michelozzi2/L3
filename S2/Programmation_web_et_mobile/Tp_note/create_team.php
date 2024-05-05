<?php
// Connexion à la base de données
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Hackathon";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // Récupération des données du formulaire
    $nomEquipe = $_POST['NomEquipe'];

    // Validation et nettoyage du nom de l'équipe
    $nomEquipe = filter_var($nomEquipe, FILTER_SANITIZE_STRING);
    if (empty($nomEquipe)) {
        throw new Exception('Le nom de l équipe est requis.');
    }

    // Vérifie si une équipe avec le même nom existe déjà
    $stmt = $conn->prepare("SELECT * FROM teams WHERE NomEquipe = :nomEquipe");
    $stmt->execute(['nomEquipe' => $nomEquipe]);
    $team = $stmt->fetch();

    if ($team) {
        // Si une équipe avec le même nom existe déjà, renvoie une erreur
        echo json_encode(['status' => 'error', 'message' => 'Une équipe avec ce nom existe déjà.']);
    } else {
        // Sinon, insère la nouvelle équipe dans la base de données
        $stmt = $conn->prepare("INSERT INTO teams (NomEquipe) VALUES (:nomEquipe)");
        $stmt->execute(['nomEquipe' => $nomEquipe]);
        echo json_encode(['status' => 'success', 'message' => 'Équipe créée avec succès']);
    }
} catch(PDOException $e) {
    echo json_encode(['status' => 'error', 'message' => $e->getMessage(), 'stack' => $e->getTraceAsString()]);
} catch(Exception $e) {
    echo json_encode(['status' => 'error', 'message' => $e->getMessage(), 'stack' => $e->getTraceAsString()]);
}
?>