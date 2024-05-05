<?php
// Connexion à la base de données
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Hackathon";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // Sélectionne toutes les équipes
    $stmt = $conn->prepare("SELECT * FROM teams");
    $stmt->execute();

    // Récupère toutes les équipes sous forme de tableau associatif
    $teams = $stmt->fetchAll(PDO::FETCH_ASSOC);

    // Renvoie les équipes sous forme de JSON
    echo json_encode($teams);
} catch(PDOException $e) {
    echo json_encode(['status' => 'error', 'message' => $e->getMessage()]);
}
?>