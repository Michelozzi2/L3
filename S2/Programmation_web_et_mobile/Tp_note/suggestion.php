<?php
require_once 'student.php';

// Connectez-vous à votre base de données
$pdo = new PDO('mysql:host=localhost;dbname=Hackathon', 'root', '');

$student = new Student($pdo);

$query = $_GET['query']; // Obtenez la requête de l'utilisateur

$suggestions = $student->getSuggestions($query);

echo json_encode($suggestions); // Renvoyez les suggestions au format JSON
?>