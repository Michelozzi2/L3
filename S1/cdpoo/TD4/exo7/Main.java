package cdpoo.TD4.exo7;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne("Doe", "John", 30));
        personnes.add(new Personne("Smith", "Alice", 25));
        personnes.add(new Personne("Doe", "Jane", 30));
        personnes.add(new Personne("Smith", "Bob", 25));

        // Tri de la collection de Personne
        Collections.sort(personnes);

        // Affichage après le tri
        for (Personne p : personnes) {
            System.out.println("Nom: " + p.getNom() + ", Prénom: " + p.getPrenom() + ", Âge: " + p.getAge());
        }
    }
}
