package atelier_1.exercice1;

public class DeEffetMemoire extends Des {

    private int derniereValeur = -1; // Initialise la dernière valeur à une valeur impossible

    // Le code `public DeEffetMemoire(int nbFaces, String nom) { super(nbFaces, nom); }` est un
    // constructeur pour la classe `DeEffetMemoire`.
    public DeEffetMemoire(int nbFaces, String nom) {
        super(nbFaces, nom);
    }

    // Surcharge de la méthode lancer pour un dé à effet mémoire
    /**
     * La fonction "lancer" dans le code Java donné appelle à plusieurs reprises la méthode "lancer" de
     * la classe parent jusqu'à ce qu'elle obtienne un résultat différent du résultat précédent, puis
     * renvoie ce résultat.
     * 
     * @return La méthode renvoie une valeur entière, qui est le résultat du lancer de dés.
     */
    public int lancer() {
        int resultat;
        do {
            resultat = super.lancer(); // Utilise la méthode lancer de la classe mère pour obtenir un résultat
        } while (resultat == derniereValeur); // Répète le lancer jusqu'à obtenir une valeur différente de la dernière
        derniereValeur = resultat; // Met à jour la dernière valeur
        return resultat;
    }


}
