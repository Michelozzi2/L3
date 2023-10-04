package atelier_1.exercice2;



/**
 * La classe « Entier » représente un entier avec des limites minimales et maximales spécifiées et
 * fournit des méthodes pour définir et incrémenter la valeur dans ces limites.
 */
public class Entier {
    private int valeur;
    private final int borneMin;
    private final int borneMax;


    
    // L'extrait de code est un constructeur pour la classe `Entier`. Il prend deux paramètres
    // `borneMin` et `borneMax`, qui représentent les limites minimale et maximale de la valeur de
    // l'objet `Entier`.
    public Entier(int borneMin, int borneMax) {
        this.borneMin = borneMin;
        this.borneMax = borneMax;
        this.valeur = 0; // Valeur par défaut à 0 si rien n'est spécifié
    }




   // Le constructeur `public Entier(int borneMin, int borneMax, int valeur)` crée une nouvelle
   // instance de la classe `Entier` avec les limites minimale et maximale spécifiées (`borneMin` et
   // `borneMax`) et une valeur initiale spécifiée (` valeur`).
    public Entier(int borneMin, int borneMax, int valeur) {
        this(borneMin, borneMax);
        setValeur(valeur); // Assurer que la valeur est dans les bornes
    }




    /**
     * La fonction "getValeur" renvoie la valeur d'une variable appelée "valeur".
     * 
     * @return La méthode renvoie la valeur de la variable "valeur".
     */
    public int getValeur() {
        return valeur;
    }




    /**
     * La fonction définit la valeur d'une variable si elle se situe dans une plage spécifiée.
     * 
     * @param valeur Le paramètre « valeur » est une valeur entière transmise à la méthode.
     */
    public void setValeur(int valeur) {
        if (valeur >= borneMin && valeur <= borneMax) {
            this.valeur = valeur;
        }
    }



    /**
     * La fonction "incremente" incrémente la valeur de 1 si elle est inférieure à la limite maximale.
     */
    public void incremente() {
        if (valeur < borneMax) {
            valeur++;
        }
    }




    /**
     * La fonction "incrémente" augmente la valeur d'un nombre donné si la somme est inférieure ou
     * égale à une limite maximale.
     * 
     * @param n Le paramètre "n" est une valeur entière qui représente le montant dont la variable
     * "valeur" doit être incrémentée.
     */
    public void incremente(int n) {
        if (valeur + n <= borneMax) {
            valeur += n;
        }
    }

   



    /**
     * La fonction toString() renvoie la valeur entière sous forme de chaîne.
     * 
     * @return La méthode renvoie une représentation sous forme de chaîne de la valeur entière.
     */
    public String toString() {
        return Integer.toString(valeur);
    }



   
    /**
     * La fonction vérifie si deux objets sont égaux en fonction de leurs valeurs et limites.
     * 
     * @param obj Le paramètre "obj" est un objet de type Object, qui est la superclasse de toutes les
     * autres classes en Java. Dans cette méthode, il est utilisé pour comparer l'objet actuel (ceci)
     * avec un autre objet pour vérifier s'ils sont égaux.
     * @return La méthode renvoie une valeur booléenne.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Entier other = (Entier) obj;
        return valeur == other.valeur && borneMin == other.borneMin && borneMax == other.borneMax;
    }
}