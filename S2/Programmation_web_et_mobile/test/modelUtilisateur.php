<?php
/*
 Code de cours de dev web 2023
 PA Bisgambiglia 
 Notre Modèle
*/
require_once "connexion.php";

// classe utilisateur
class Utilisateur
{
	private $_idnum = 0;
	private $_pseudo = "";
    private $_score = 0;
    public function __construct(array $args)
    {
        // Si le pseudo existe on charge l'utilisateur
		$aRes = self::isNew($args['pseudo']); 
		if ($aRes!=0){
            $this->_idnum = $aRes['id_user'];
            $this->_pseudo = $aRes['pseudo_user'];
            $this->_score = $aRes['score_user'];
        }
        // Sinon on le crée
        else{
            $this->_pseudo = $args['pseudo'];
            $this->_score = 0;
            self::save(array("pseudo_user" => $this->_pseudo, "score_user" => $this->_score));
        }
    }
    // vérification de la présence du joueur en base
    public static function isNew(string $value)
	{
		$conn = $conn = myConnection();
		$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		$stmt = $conn->prepare("SELECT * FROM utilisateur where pseudo_user LIKE '".strtolower($value)."'");
		$stmt->execute();
		$rows = $stmt->fetchAll();
		$conn = null;
		//var_dump($rows[0]);
		if (count($rows))
		{
			return $rows[0];
		}
		else return 0;
	}
    public function getScore(){
        return $this->_score;
    }
    public function setScore(int $newScore){
        $this->_score = $newScore; 
        $this->update();
    }
    public static function save(array $value)
	{
		$sql = "INSERT INTO utilisateur (id_user, pseudo_user, score_user) VALUES 
		(NULL, '".strtolower($value['pseudo_user'])."', '".$value['score_user']."')";
		$conn = myConnection();
		$stmt = $conn->prepare($sql);
        $stmt->execute();
		$conn = null;
	}
	public function update()
	{
		$sql = "UPDATE utilisateur SET score_user='".$this->_score."' where pseudo_user ='".$this->_pseudo."'";
		$conn = myConnection();
        $stmt = $conn->prepare($sql);
        $stmt->execute();
		$conn = null;
	}
    public function toJSON(int $args=1){
        // si l'args vaut 1, on renvoie l'user
        if ($args===1){
            return json_encode(array("pseudo"=>$this->_pseudo,"score"=>$this->_score));
        }
        // sinon on renvoie tous les utilisateurs
        else{
            $conn = $conn = myConnection();
            $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $stmt = $conn->prepare("SELECT pseudo_user, score_user FROM utilisateur ORDER BY score_user DESC");
            $stmt->execute();
            $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
            //var_dump($result);
            $conn = null;
            return json_encode($result);
        }
    }
    public function __toString()
    {
        return 'user: ' . $this->_pseudo . ', a un score de:' . $this->_score;
    }
}

/* prog de test de la classe
$monObjet = new Utilisateur(array("pseudo" => "toto"));
echo $monObjet;
echo "<br>";
$monObjet->setScore(9);
echo $monObjet->toJSON(2);
 */
