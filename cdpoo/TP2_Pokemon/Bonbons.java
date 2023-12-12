package cdpoo.TP2_Pokemon;

import java.util.HashMap;

public class Bonbons {   
        static HashMap<String, Integer> Bonbon = new HashMap<>();

        public static void ajouterBonbons(String nom, int nbrbonbons) {
            Bonbon.put(nom, nbrbonbons);
            System.out.println("Vous avez " + nbrbonbons + " bonbons " + nom);
        }

        public static HashMap<String, Integer> getDictionnaireBonbons() {
            return Bonbon;
        }
}