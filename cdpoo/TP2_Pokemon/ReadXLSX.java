package cdpoo.TP2_Pokemon;

import java.util.*;
import java.util.zip.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class ReadXLSX {
    // Méthode pour lire un fichier Excel (xlsx)
    public List<List<String>> readXLSX() throws Exception {
        // Ouvre le fichier Excel comme un fichier Zip
        ZipFile zipFile = new ZipFile("cdpoo/TP2_Pokemon/Liste_Pokemon.xlsx");

        // Lit les chaînes partagées (sharedStrings.xml)
        ZipEntry sharedStringXML = zipFile.getEntry("xl/sharedStrings.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(zipFile.getInputStream(sharedStringXML));
        NodeList list = doc.getElementsByTagName("t");
        List<String> sharedStrings = new ArrayList<>();
        for (int i = 0; i < list.getLength(); i++) {
            sharedStrings.add(list.item(i).getTextContent());
        }

        // Lit les données de la feuille (sheet1.xml)
        ZipEntry sheetXML = zipFile.getEntry("xl/worksheets/sheet1.xml");
        doc = dBuilder.parse(zipFile.getInputStream(sheetXML));
        NodeList rowNodes = doc.getElementsByTagName("row");

        // Stocke les données de chaque cellule dans une liste de listes
        List<List<String>> data = new ArrayList<>();
        for (int i = 0; i < rowNodes.getLength(); i++) {
            NodeList cellNodes = ((Element) rowNodes.item(i)).getElementsByTagName("c");
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cellNodes.getLength(); j++) {
                Element cellElement = (Element) cellNodes.item(j);
                String cellValue = getCellValue(cellElement, sharedStrings);
                row.add(cellValue);
            }
            data.add(row);

        }
        // Si un Pokémon a moins de trois évolutions, insère un espace avant le premier
        // type
        for (List<String> colonne : data) {
            if (colonne.size() < 4) {
                colonne.add(colonne.size() - 1, " ");
            }
        }

        // Ferme le fichier Zip et supprime la première ligne (en-têtes)
        zipFile.close();
        data.remove(0);
        return data;
    }

    // Méthode pour obtenir la valeur d'une cellule
    private static String getCellValue(Element cellElement, List<String> sharedStrings) {
        String cellValue = "";
        NodeList vNodes = cellElement.getElementsByTagName("v");
        if (vNodes.getLength() > 0) {
            String value = vNodes.item(0).getTextContent();
            if (cellElement.getAttribute("t").equals("s")) {
                int idx = Integer.parseInt(value);
                cellValue = sharedStrings.get(idx);
            } else {
                cellValue = value;
            }
        }
        return cellValue;
    }
}