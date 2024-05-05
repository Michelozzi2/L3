<?php
class Student {
    private $pdo;

    public function __construct($pdo) {
        $this->pdo = $pdo;
    }

    public function getSuggestions($query) {
        $statement = $this->pdo->prepare("SELECT * FROM students WHERE nom LIKE ? OR prenom LIKE ?");
        $statement->execute([$query . '%', $query . '%']);
        return $statement->fetchAll(PDO::FETCH_ASSOC);
    }

    public function updateStudent($name, $firstName, $promo, $skills) {
        $sql = "UPDATE students SET prenom = ?, promo = ?, skills = ? WHERE nom = ?";
        $stmt = $this->pdo->prepare($sql);
        return $stmt->execute([$firstName, $promo, $skills, $name]);
    }
}
?>