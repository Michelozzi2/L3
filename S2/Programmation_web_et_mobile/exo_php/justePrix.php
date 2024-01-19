<?php
session_start();

if (!isset($_SESSION['randomNumber'])) {
    $_SESSION['randomNumber'] = rand(1, 10);
    $_SESSION['counter'] = 0;
}

$message = '';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = $_POST['name'];
    $number = $_POST['number'];
    $_SESSION['counter']++;

    if ($number == $_SESSION['randomNumber']) {
        $message = "Bravo " . $name . " !, vous avez trouvé le juste prix en " . $_SESSION['counter'] . " coups !";
        session_destroy();
    } else if ($number > $_SESSION['randomNumber']) {
        $message = "Désolé, votre nombre " . $number ." est trop grand. Essayez encore !";
    } else {
        $message = "Désolé, votre nombre " . $number ." est trop petit. Essayez encore !";
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>JustePrix</title>
</head>
<body>
    <h1>Juste Prix</h1>
    <form action="justePrix.php" method="post">
        <div>
            <label for="name">Pseudo:</label>
            <input type="text" id="name" name="name" required minlength="3" maxlength="10" size="10" value="<?php echo isset($_POST['name']) ? $_POST['name'] : '' ?>" />
        </div>

        <div>
            <label for="number">Nombre entre 1 et 10:</label>
            <input type="number" id="number" name="number" required min="1" max="10" />
        </div>

        <input type="submit" value="Valider">
    </form>
    <div id="message"><?php echo $message; ?></div>
</body>
</html>