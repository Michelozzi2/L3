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

    // Crée une nouvelle table 'students' si elle n'existe pas déjà
    $sql = "CREATE TABLE IF NOT EXISTS students (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Nom VARCHAR(30) NOT NULL,
    Prenom VARCHAR(30) NOT NULL,
    Promo VARCHAR(30) NOT NULL
    )";
    $conn->exec($sql);

    // Ajoute un index unique sur les colonnes 'Nom' et 'Prenom'
    $sql = "ALTER TABLE students ADD UNIQUE INDEX(Nom, Prenom)";
    $conn->exec($sql);

    // Vérifie si un fichier a été téléchargé
    if (isset($_FILES['file']) && $_FILES['file']['error'] == UPLOAD_ERR_OK && is_uploaded_file($_FILES['file']['tmp_name'])) {
        $csvFile = $_FILES['file']['tmp_name'];

        // Ouvre le fichier pour la lecture
        if (($handle = fopen($csvFile, "r")) !== FALSE) {
            // Ignore la première ligne (en-tête)
            fgetcsv($handle);

            // Parcourt le fichier ligne par ligne
            while (($data = fgetcsv($handle, 1000, ";")) !== FALSE) {
                $nom = $data[0];
                $prenom = $data[1];
                $promo = $data[2];

                // Insère les données dans la table 'students' ou met à jour la ligne existante si une ligne avec le même 'Nom' et 'Prenom' existe déjà
                $sql = "INSERT INTO students (Nom, Prenom, Promo) VALUES('$nom', '$prenom', '$promo') ON DUPLICATE KEY UPDATE Promo='$promo'";
                $conn->exec($sql);
            }

            fclose($handle);
        }
    }

} catch(PDOException $e) {
    // Affiche l'erreur si quelque chose se passe mal
    echo $sql . "<br>" . $e->getMessage();
}

// Ferme la connexion à la base de données
$conn = null;

// Redirige l'utilisateur vers 'index.html'
header("Location: index.html");
die();
?>