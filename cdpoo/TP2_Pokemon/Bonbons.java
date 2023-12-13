package cdpoo.TP2_Pokemon;

import java.util.HashMap;

/**
 * Cette classe représente une collection de bonbons.
 */
public class Bonbons {
    static HashMap<String, Integer> Bonbon = new HashMap<>();

    /**
     * Ajoute un certain nombre de bonbons d'un certain type à la collection.
     * Si le type de bonbon existe déjà, le nombre de bonbons est mis à jour.
     * Sinon, un nouveau type de bonbon est ajouté à la collection.
     * @param type le type de bonbon
     * @param nbrbonbons le nombre de bonbons à ajouter
     */
    public static void ajouterBonbons(String type, int nbrbonbons) {
        if (Bonbon.containsKey(type)) {
            int currentBonbons = Bonbon.get(type);
            Bonbon.put(type, currentBonbons + nbrbonbons);
        } else {
            Bonbon.put(type, nbrbonbons);
        }
        System.out.println("Vous avez " + Bonbon.get(type) + " bonbons " + type);
    }

    /**
     * Supprime un certain nombre de bonbons d'un certain type de la collection.
     * Si le type de bonbon existe déjà, le nombre de bonbons est mis à jour.
     * @param type le type de bonbon
     * @param nbrbonbons le nombre de bonbons à supprimer
     */
    public static void supprimerBonbons(String type, int nbrbonbons) {
        if (Bonbon.containsKey(type)) {
            int currentBonbons = Bonbon.get(type);
            Bonbon.put(type, currentBonbons - nbrbonbons);
        } 
        System.out.println("\nIl vous reste " + Bonbon.get(type) + " bonbons " + type);
    }

    /**
     * Renvoie le dictionnaire de bonbons contenant les types de bonbons et leur nombre.
     * @return le dictionnaire de bonbons
     */
    public static HashMap<String, Integer> getDictionnaireBonbons() {
        return Bonbon;
    }
}