<?php
// Paramètres de connexion à la base de données
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Hackathon";

try {
    // Crée une nouvelle connexion à la base de données
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // Prépare une requête SQL pour sélectionner tous les étudiants
    $stmt = $conn->prepare("SELECT Nom, Prenom, Promo FROM students");
    // Exécute la requête
    $stmt->execute();

    // Récupère tous les résultats sous forme de tableau associatif
    $result = $stmt->fetchAll(PDO::FETCH_ASSOC);

    // Envoie les résultats au client sous forme de JSON
    echo json_encode($result);

} catch(PDOException $e) {
    // Affiche l'erreur si quelque chose se passe mal
    echo "Error: " . $e->getMessage();
}

// Ferme la connexion à la base de données
$conn = null;
?>