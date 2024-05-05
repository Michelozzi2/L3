<?php
// Connexion à la base de données
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Hackathon";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // Sélectionne toutes les équipes et les prénoms des étudiants correspondants
    $stmt = $conn->prepare("
        SELECT teams.IdTeam, teams.NomEquipe,  GROUP_CONCAT(students.Prenom, ' ', students.Nom) as Etudiants
        FROM teams
        LEFT JOIN teams_students ON teams.IdTeam = teams_students.IdTeam
        LEFT JOIN students ON teams_students.IdUsers = students.idStudent
        GROUP BY teams.IdTeam
    ");
    $stmt->execute();

    // Récupère toutes les équipes et les prénoms des étudiants correspondants sous forme de tableau associatif
    $teams = $stmt->fetchAll(PDO::FETCH_ASSOC);

    // Renvoie les équipes et les prénoms des étudiants correspondants sous forme de JSON
    echo json_encode($teams);
} catch(PDOException $e) {
    echo json_encode(['status' => 'error', 'message' => $e->getMessage()]);
}
?>