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
    $data = json_decode(file_get_contents('php://input'), true);
    $idEquipe = isset($data['IdEquipe']) ? $data['IdEquipe'] : null;
    $idEtudiant = isset($data['IdEtudiant']) ? $data['IdEtudiant'] : null;

    if ($idEquipe === null || $idEtudiant === null) {
        echo json_encode(['status' => 'error', 'message' => 'Données du formulaire manquantes']);
        exit;
    }
    // verifie si l'etudiant n'est pas deja dans l'equipe
    $stmt = $conn->prepare("SELECT * FROM teams_students WHERE IdUsers = :idUsers");
    $stmt->execute(['idUsers' => $idEtudiant]);
    $result = $stmt->fetch(PDO::FETCH_ASSOC);
    if ($result) {
        echo json_encode(['status' => 'error', 'message' => 'Étudiant déjà dans l\'équipe']);
        exit;
    }

    // Si l'étudiant existe, insère l'ID de l'équipe et l'ID de l'étudiant dans la table teams_students
    $stmt = $conn->prepare("INSERT INTO teams_students (IdUsers, IdTeam) VALUES (:idUsers, :idTeam)");
    $stmt->execute(['idUsers' => $idEtudiant, 'idTeam' => $idEquipe]);
    echo json_encode(['status' => 'success', 'message' => 'Étudiant ajouté à l\'équipe avec succès']);
} catch(PDOException $e) {
    echo json_encode(['status' => 'error', 'message' => $e->getMessage()]);
}
?>