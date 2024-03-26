<?php
// Paramètres de connexion à la base de données
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Hackathon";

// Récupère la chaîne de recherche depuis la requête GET
$search = $_GET['search'];

try {
    // Crée une nouvelle connexion à la base de données
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // Prépare une requête SQL pour sélectionner les étudiants dont le nom ou le prénom contient la chaîne de recherche
    $stmt = $conn->prepare("SELECT Nom, Prenom, Promo FROM students WHERE Nom LIKE :search OR Prenom LIKE :search");
    // Exécute la requête avec la chaîne de recherche
    $stmt->execute(['search' => '%' . $search . '%']);

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