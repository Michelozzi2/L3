package cdpoo.TD4.exo6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TriPhrase {

    public static void main(String[] args) {
        String phrase = "C'est une époque de guerre civile. A bord de vaisseaux spatiaux opérant à partir d'une base cachée, les Rebelles ont emporté leur première victoire sur le maléfique Empire Galactique.";

        // Trie dans l'ordre alphabétique
        List<String> triAlphabetique = trierPhrase(phrase, new AlphabetiqueComparator());
        afficherResultat("Tri alphabétique", triAlphabetique);

        // Trie dans l'ordre militaire
        List<String> triMilitaire = trierPhrase(phrase, new MilitaireComparator());
        afficherResultat("Tri militaire", triMilitaire);

        // Trie dans l'ordre alphabétique inversé
        List<String> triInverse = trierPhrase(phrase, new InverseAlphabetiqueComparator());
        afficherResultat("Tri alphabétique inversé", triInverse);
    }

    private static List<String> trierPhrase(String phrase, Comparator<String> comparator) {
        String[] mots = phrase.split("\\s+");
        List<String> listeMots = new ArrayList<>();

        // Ajoute chaque mot à la liste
        for (String mot : mots) {
            // Supprime la ponctuation
            mot = mot.replaceAll("[^a-zA-ZÀ-ÖØ-öø-ÿ]", "");
            listeMots.add(mot);
        }

        // Trie la liste en utilisant le comparateur spécifié
        Collections.sort(listeMots, comparator);

        return listeMots;
    }

    private static void afficherResultat(String titre, List<String> liste) {
        System.out.println(titre + ":");
        for (String mot : liste) {
            System.out.print(mot + " ");
        }
        System.out.println("\n");
    }
}