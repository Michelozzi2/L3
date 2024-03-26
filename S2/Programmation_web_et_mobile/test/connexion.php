<?php
/*
 Code de cours de dev web 2023
 PA Bisgambiglia 
 Connexion à la base de données
*/
function myConnection($servername = "localhost", $username = "root", $password = "root", $dbname = "2023_L3")
{
	try {
		$conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
		// set the PDO error mode to exception
		$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		//echo "Connected successfully \n";
		return $conn;
	}
	catch(PDOException $e)
	{
		echo "Connection failed: " . $e->getMessage();
	}
}