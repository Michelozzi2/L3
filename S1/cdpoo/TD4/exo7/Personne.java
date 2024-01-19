package cdpoo.TD4.exo7;



public class Personne implements Comparable<Personne> {
    private String nom;
    private String prenom;
    private int age;

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Personne autrePersonne) {
        // Comparaison par âge d'abord
        int comparaisonParAge = Integer.compare(this.age, autrePersonne.age);
        if (comparaisonParAge != 0) {
            return comparaisonParAge;
        }

        // Si les âges sont égaux, comparer par ordre alphabétique du nom et prénom
        int comparaisonParNom = this.nom.compareTo(autrePersonne.nom);
        if (comparaisonParNom != 0) {
            return comparaisonParNom;
        }

        return this.prenom.compareTo(autrePersonne.prenom);
    }
}

    

