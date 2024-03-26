<?php
/*
 Code de cours de dev web 2023
 PA Bisgambiglia 
 Controleur de l'application
*/
require_once "modelUtilisateur.php";
// define variables and set to empty values
$login = $score = "";
// qu'est-ce l'on va renvoyer
header('Access-Control-Allow-Origin: *');
header("Content-Type: application/json; charset=utf-8");
header("Access-Control-Allow-Methods: POST");
header("Allow: GET, POST, OPTIONS, PUT, DELETE");
header("Access-Control-Allow-Headers: X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method, Access-Control-Allow-Origin");

if ($_SERVER["REQUEST_METHOD"] == "GET")
{
    // lecture
    if (isset($_GET['pseudo']))
    {
        $login = test_input($_GET['pseudo']);
        // charger la classe et renvoyer le score
        $aRes = Utilisateur::isNew($login);
        if ($aRes===0){
            $sortie = array("message" => "pas de compte","saisie" => $login);
        } 
        else{
            $sortie = array("login" => $aRes['pseudo_user'],"score"=>$aRes['score_user']);
        }
        echo json_encode($sortie );
    }
    // afficher tous les scores
    else if (isset($_GET['all']))
    {
        $tabargumenet = array("pseudo" => "pab", "score" => 0);
        $unUtilisateur = new Utilisateur($tabargumenet);
        // renvoyer les données
        echo $unUtilisateur->toJSON(2);       
    }
    else{
        //echo "GET : ça ne marche pas";
        header('Location: vue.html');
        exit;
    }
}
else if ($_SERVER["REQUEST_METHOD"] == "POST")
{
    // écriture
	if (isset($_POST['pseudo']) && isset($_POST['score']))
    {
        $login = test_input($_POST['pseudo']); 
        $score = test_input($_POST['score']);
        // charger la classe pour écrire en BD
        $tabargumenet = array("pseudo" => $login);
        $unUtilisateur = new Utilisateur($tabargumenet);
        $unUtilisateur->setScore($score);
        // renvoyer les données
        echo $unUtilisateur->toJSON();
        //echo json_encode(array("pseudo"=>$login,"score"=>$score));
    }
    else{
        //echo json_encode($_POST);
        //echo "POST : ça ne marche pas";
        header('Location: vue.html');
        exit;
    }
}
else{
    header("HTTP/1.1 404 Not Found");
    exit;
}

function test_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    $data = strtolower($data);
    return $data;
}

?>