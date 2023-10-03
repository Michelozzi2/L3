package atelier_1.exercice1;

public class DeEffetMemoire extends Des {
    private int derniereValeur = -1; // Initialise la dernière valeur à une valeur impossible

    // Constructeur pour un dé à effet mémoire
    public DeEffetMemoire(int nbFaces, String nom) {
        super(nbFaces);
    }

    // Surcharge de la méthode lancer pour un dé à effet mémoire
    public int lancer() {
        int resultat;
        do {
            resultat = super.lancer(); // Utilise la méthode lancer de la classe mère pour obtenir un résultat
        } while (resultat == derniereValeur); // Répète le lancer jusqu'à obtenir une valeur différente de la dernière
        derniereValeur = resultat; // Met à jour la dernière valeur
        return resultat;
    }

    public static void main(String[] args) {
        // Testez la classe DeEffetMemoire
        DeEffetMemoire deMemoire = new DeEffetMemoire(6, "Dé à effet mémoire");
        for (int i = 0; i < 10; i++) {
            System.out.println(deMemoire.getNom() + " a été lancé : " + deMemoire.lancer());
        }
    }
}
