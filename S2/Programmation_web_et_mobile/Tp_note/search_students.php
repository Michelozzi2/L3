<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Hackathon";

$search = $_GET['search'];

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $stmt = $conn->prepare("SELECT Nom, Prenom FROM students WHERE Nom LIKE :search OR Prenom LIKE :search");
    $stmt->execute(['search' => '%' . $search . '%']);

    $result = $stmt->fetchAll(PDO::FETCH_ASSOC);

    echo json_encode($result);

} catch(PDOException $e) {
    echo "Error: " . $e->getMessage();
}

$conn = null;
?>