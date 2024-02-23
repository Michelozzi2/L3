<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Hackathon";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // sql to create table
    $sql = "CREATE TABLE IF NOT EXISTS students (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Nom VARCHAR(30) NOT NULL,
    Prenom VARCHAR(30) NOT NULL,
    Promo VARCHAR(30) NOT NULL
    )";

    // use exec() because no results are returned
    $conn->exec($sql);
    echo "Table students created successfully";

    // Add unique index to Nom and Prenom
    $sql = "ALTER TABLE students ADD UNIQUE INDEX(Nom, Prenom)";
    $conn->exec($sql);

    if (isset($_FILES['file']) && $_FILES['file']['error'] == UPLOAD_ERR_OK && is_uploaded_file($_FILES['file']['tmp_name'])) {
        $csvFile = $_FILES['file']['tmp_name'];

        // Open the file for reading
        if (($handle = fopen($csvFile, "r")) !== FALSE) {
            // Skip the header row
            fgetcsv($handle);

            // Loop through the file
            while (($data = fgetcsv($handle, 1000, ";")) !== FALSE) {
                $nom = $data[0];
                $prenom = $data[1];
                $promo = $data[2];

                $sql = "INSERT INTO students (Nom, Prenom, Promo) VALUES('$nom', '$prenom', '$promo') ON DUPLICATE KEY UPDATE Promo='$promo'";
                $conn->exec($sql);
            }

            fclose($handle);
        }
    }

    echo "Data inserted successfully";

} catch(PDOException $e) {
    echo $sql . "<br>" . $e->getMessage();
}

$conn = null;
header("Location: index.html");
die();
?>