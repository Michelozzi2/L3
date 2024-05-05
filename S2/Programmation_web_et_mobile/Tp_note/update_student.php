<?php
require_once 'Student.php';

$pdo = new PDO('mysql:host=localhost;dbname=Hackathon', 'root', '');

$student = new Student($pdo);

$name = $_POST['name'];
$firstName = $_POST['firstName'];
$promo = $_POST['promo'];
$skills = $_POST['skills'];

if ($student->updateStudent($name, $firstName, $promo, $skills)) {
    echo 'Les informations de l\'étudiant ont été mises à jour avec succès.';
} else {
    echo 'Une erreur s\'est produite lors de la mise à jour des informations de l\'étudiant.';
}
?>