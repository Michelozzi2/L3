package atelier_1.exercice1;

public class DePipe extends Des {
    
    private int borneMinimale;

    // Constructeur pour un dé pipé avec une valeur minimale spécifiée
    // C'est le constructeur de la classe `DePipe`. Il prend trois paramètres : `nbFaces` (nombre de
    // faces sur le dé), `nom` (nom du dé) et `borneMinimale` (valeur minimale du dé).
    public DePipe(int nbFaces, String nom, int borneMinimale) {
        super(nbFaces); // Appel au constructeur de la classe mère pour initialiser nbFaces 
        setBorneMinimale(borneMinimale);
    }

    // Getter pour la borne minimale
   /**
    * La fonction renvoie la valeur minimale d'une variable.
    * 
    * @return La méthode renvoie la valeur de la variable "borneMinimale".
    */
    public int getBorneMinimale() {
        return borneMinimale;
    }

    // Setter pour la borne minimale (vérifie si la valeur est correcte)
    /**
     * La fonction "setBorneMinimale" définit la valeur minimale d'une plage, mais uniquement si elle
     * se situe dans la plage valide de 1 au nombre de faces.
     * 
     * @param borneMinimale Le paramètre « borneMinimale » est une valeur entière représentant la
     * valeur minimale pouvant être lancée sur un dé.
     */
    private void setBorneMinimale(int borneMinimale) {
        if (borneMinimale >= 1 && borneMinimale <= getNbFace()) {
            this.borneMinimale = borneMinimale;
        } else {
            System.err.println("Erreur : La borne minimale doit être comprise entre 1 et le nombre de faces.");
        }
    }

    // Surcharge de la méthode lancer pour un dé pipé
    /**
     * La fonction "lancer" en Java appelle à plusieurs reprises la méthode "lancer" de la classe
     * parent jusqu'à ce qu'elle obtienne un résultat supérieur à la limite minimale, puis renvoie ce
     * résultat.
     * 
     * @return La méthode renvoie une valeur entière.
     */
    public int lancer() {
        int resultat;
        do {
            resultat = super.lancer(); // Utilise la méthode lancer de la classe mère pour obtenir un résultat
        } while (resultat <= borneMinimale); // Répète le lancer jusqu'à obtenir un résultat supérieur à la borne minimale
        return resultat;
    }
}
