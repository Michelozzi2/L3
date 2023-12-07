package cdpoo.TD5.exo1;

import java.io.FileReader;

public class LectureFichier {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("cdpoo/TD5/exo1/text.txt");
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

}
