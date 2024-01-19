package cdpoo.TD5.exo2;

import java.io.BufferedReader;
import java.io.FileReader;

public class LectureFichier2 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("cdpoo/TD5/exo2/text.txt"));
            String ligne;
            long startTime = System.currentTimeMillis();
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
            long endTime = System.currentTimeMillis();
            long timeTaken = endTime - startTime;
            System.out.println("Time taken: " + timeTaken + "ms");
            br.close();
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        
    }
    
}
