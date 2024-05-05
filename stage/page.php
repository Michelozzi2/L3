
<?php 
ini_set('display_errors', 1);
error_reporting(E_ALL);


$ids = [12,13,14,16];

require_once("./connection.php");

$db = (Connexion::getInstance())->getConnection();


$file = fopen("./pages_parcours_url_csv.csv", "r");
$numRows = 0;
$dataTable = [];

if ($file !== FALSE) {
    $header = fgetcsv($file, 1000, ",");

    while (($data = fgetcsv($file, 1000, ",")) !== FALSE) {
        $data = array_map("utf8_encode", $data);
        $num = count($data);
        
        $dataTable[$numRows] = [];
        
        for ($i = 0; $i < $num; $i++) {
            $dataTable[$numRows][$header[$i]] = $data[$i];
        }
        $numRows++;
    }

    echo var_dump($dataTable);

    fclose($file);
   for($i =0 ;$i< count($dataTable);$i++){


    $inserted_ids = [];

    try {

       
       // Fetch thumbnail ID from the sitepage table
       $sitepageSql = "SELECT * FROM site_page WHERE slug = :slug";
       $sitepageStmt = $db->prepare($sitepageSql);
       $sitepageStmt->execute([':slug' => $dataTable[$i]['Nom']]);
       $sitepageRow = $sitepageStmt->fetch(PDO::FETCH_ASSOC);
       echo var_dump($sitepageRow);

       if ($sitepageRow) {


        $db->beginTransaction();

        for($j = 0 ; $j <count($ids);$j++){

                    // Insert into newpagesite table
                    $newpagesiteSql = "INSERT INTO site_page (
                        site_id,
                        slug,
                        title,
                        is_public,
                        created,
                        modified) 
                                    VALUES (:site_id, :slug, :title, :is_public, NOW(), NOW())";
                    $newpagesiteStmt = $db->prepare($newpagesiteSql);
                    $newpagesiteParams = [
                        ':site_id' => $ids[$j], 
                        ':slug' => $sitepageRow['slug'],
                        ':title' => $sitepageRow['title'],
                        ':is_public' => 1
                    ];
                    $newpagesiteStmt->execute($newpagesiteParams);
                    $newpagesiteId = $db->lastInsertId();
                    $inserted_ids[] = $newpagesiteId;
        }

        $sitepageblockSql = "SELECT * FROM site_page_block WHERE page_id =:page_id";
        $sitepageblockStmt = $db->prepare($sitepageblockSql);
        $sitepageblockParams = [
            ':page_id' =>  $sitepageRow['id']
        ];
        $sitepageblockStmt->execute($sitepageblockParams);
        $sitepageBlockRows = $sitepageblockStmt->fetchAll(PDO::FETCH_ASSOC);

        for($z = 0 ; $z <count($inserted_ids);$z++){


            for($x = 0; $x < count($sitepageBlockRows) ;$x++){

                $sitepagenewblockSql = "INSERT INTO site_page_block(page_id, layout, data, position) VALUES (:page_id, :layout, :data, :position)";
                $sitepagenewblockStmt = $db->prepare($sitepagenewblockSql);
                $sitepagenewblockParams = [
                    ':page_id' =>  $inserted_ids[$z],
                    ':layout' =>  $sitepageBlockRows[$x]['layout'],
                    ':data' =>  $sitepageBlockRows[$x]['data'],
                    ':position' =>   $sitepageBlockRows[$x]['position'],
                ];
                echo var_dump($sitepagenewblockParams);
                $sitepagenewblockStmt->execute($sitepagenewblockParams);
            }
        }
            $db->commit();
            echo " PAGE EN-CO-IT-ES Inserted for: " . $dataTable[$i]['Nom'] . "\n";

        } else {
           echo "No matching sitepage found for: " . $dataTable[$i]['Nom'] . "\n";
        }
      }catch (Exception $e) {
        $db->rollback();
        echo "Error: " . $e->getMessage();
     }
  }
}
?>








