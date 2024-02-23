<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Hackathon";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $stmt = $conn->prepare("SELECT Nom, Prenom, Promo FROM students");
    $stmt->execute();

    $result = $stmt->fetchAll(PDO::FETCH_ASSOC);

    echo json_encode($result);

} catch(PDOException $e) {
    echo "Error: " . $e->getMessage();
}

$conn = null;
?>