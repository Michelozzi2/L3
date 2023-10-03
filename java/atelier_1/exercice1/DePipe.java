package atelier_1.exercice1;

public class DePipe extends Des {
    private int borneMinimale;

    // Constructeur pour un dé pipé avec une valeur minimale spécifiée
    public DePipe(int nbFaces, String nom, int borneMinimale) {
        super(nbFaces); // Appel au constructeur de la classe mère pour initialiser nbFaces 
        setBorneMinimale(borneMinimale);
    }

    // Getter pour la borne minimale
    public int getBorneMinimale() {
        return borneMinimale;
    }

    // Setter pour la borne minimale (vérifie si la valeur est correcte)
    private void setBorneMinimale(int borneMinimale) {
        if (borneMinimale >= 1 && borneMinimale <= getNbFace()) {
            this.borneMinimale = borneMinimale;
        } else {
            System.err.println("Erreur : La borne minimale doit être comprise entre 1 et le nombre de faces.");
        }
    }

    // Surcharge de la méthode lancer pour un dé pipé
    public int lancer() {
        int resultat;
        do {
            resultat = super.lancer(); // Utilise la méthode lancer de la classe mère pour obtenir un résultat
        } while (resultat <= borneMinimale); // Répète le lancer jusqu'à obtenir un résultat supérieur à la borne minimale
        return resultat;
    }
}
