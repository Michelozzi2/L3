<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <script src="tirer_Aleatoire.js"></script>
    <title>Document</title>
</head>
<body>
    <?php
    // Lire le fichier noms.txt
    $noms = file("noms.txt");

    // Afficher les prénoms sous forme de listes à puces
    echo "<ul>";
    foreach ($noms as $nom) {
        echo "<li>$nom</li>";
    }
    echo "</ul>";
    ?>

    <button type="button" onclick="tirerAleatoire()">Tirer au sort</button>
</body>
</html>