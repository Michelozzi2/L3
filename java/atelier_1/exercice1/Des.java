package atelier_1.exercice1;
import java.util.*;



/* 
 
Modifier la classe De pour prendre en compte un tableau de valeurs au lieu d'un nombre de faces fixes. 
Vous pouvez également ajouter un constructeur pour préciser les valeurs des faces du dé lors de sa création.

Adapter la méthode lancer pour choisir une valeur aléatoire dans le tableau des valeurs pour représenter le résultat du lancer.


*/

/**
 * La classe "Des" représente un dé avec un nombre spécifié de faces et fournit des méthodes pour
 * lancer le dé et récupérer des informations le concernant.
 */
public class Des {
   
    private String nomDes = "De";
    private int nbFaces;
    private final static int minFaces = 3 , maxFaces = 120;
    private static int nbDes = 0;
    private static Random r = new Random();
    

    // Le code `public Des(){ this.nbFaces = 6; nbDes ++; }` est un constructeur pour la classe `Des`.
    public Des(){
        this.nbFaces = 6;
        nbDes ++;
    }


   // Le code `public Des(int nbFaces){ setNbFace(nbFaces); nomDes += nbDes; nbDes ++; }` est un
   // constructeur pour la classe `Des`. Il prend un paramètre entier `nbFaces` et définit le nombre de
   // faces des dés en utilisant la méthode `setNbFace`. Il ajoute également la valeur de « nbDes » à
   // la chaîne « nomDes » et incrémente la variable « nbDes ».
    public Des(int nbFaces){
        
        setNbFace(nbFaces);
        
        nomDes += nbDes;
        nbDes ++;
    }





   // Le code `public Des(String nomDes){ this.nomDes = nomDes; this.nbFaces = maxFaces; nomDes +=
   // nbDes; nbDes ++; }` est un constructeur pour la classe `Des`. Il prend un paramètre `nomDes` et
   // l'assigne à la variable d'instance `nomDes`. Il définit également le nombre de faces des dés au
   // nombre maximum de faces (« maxFaces »). De plus, il ajoute la valeur de « nbDes » à la chaîne «
   // nomDes » et incrémente la variable « nbDes ».
    public Des(String nomDes){
        this.nomDes = nomDes;
        this.nbFaces = maxFaces;
        
        nomDes += nbDes;
        nbDes ++;

    }


    /**
     * La fonction définit le nombre de faces pour un objet, mais uniquement si l'entrée est comprise
     * entre une valeur minimale et maximale.
     * 
     * @param nbFaces Le paramètre nbFaces représente le nombre de faces sur un dé.
     */
    public void setNbFace(int nbFaces){

        if(nbFaces >= minFaces && nbFaces <= maxFaces){
            this.nbFaces = nbFaces;
        }
        else{
            System.err.println("Nombre pas compris entre 3 et 120");
        }
    }



    /**
     * La fonction renvoie le nombre de faces.
     * 
     * @return La méthode renvoie la valeur de la variable "nbFaces".
     */
    public int getNbFace(){
        return nbFaces;
    }




    /**
     * La fonction "getNom" renvoie la valeur de la variable "nomDes" sous forme de chaîne.
     * 
     * @return La méthode renvoie la valeur de la variable "nomDes".
     */
    public String getNom(){
        return nomDes;
    }




    // Getter pour le nombre de dés créés
   /**
    * La fonction "getNombreDesCrees" renvoie la valeur de la variable "nbDes".
    * 
    * @return La méthode renvoie la valeur de la variable "nbDes".
    */
    public static int getNombreDesCrees() {
        return nbDes;
    }




    /**
     * La fonction "lancer" renvoie un nombre aléatoire compris entre 1 et le nombre de faces d'un dé.
     * 
     * @return La méthode renvoie une valeur entière, qui est le nombre généré aléatoirement entre 1 et
     * le nombre de faces.
     */
    public int lancer(){

        int nbAleatoire= r.nextInt(this.nbFaces)+1 ;
        return nbAleatoire;

    }



    // Méthode pour lancer le dé un nombre nb donné de fois et retourner le meilleur résultat
    /**
     * La fonction "lancer" prend un paramètre entier "nb" représentant le nombre de fois où lancer un
     * dé, et renvoie le résultat le plus élevé obtenu à partir de ces lancers.
     * 
     * @param nb Le paramètre "nb" représente le nombre de fois où les dés seront lancés.
     * @return La méthode renvoie le meilleur résultat obtenu à partir d’un nombre spécifié de lancers.
     */
    public int lancer(int nb) {
        if (nb <= 0) {
            System.err.println("Erreur : Le nombre de lancers doit être supérieur à zéro.");
            return -1; // Valeur d'erreur
        }

        int meilleurLancer = lancer(); // Premier lancer pour initialiser le meilleur résultat

        for (int i = 1; i < nb; i++) {
            int lancerActuel = lancer();
            if (lancerActuel > meilleurLancer) {
                meilleurLancer = lancerActuel;
            }
        }

        return meilleurLancer;
    }




   /**
    * La fonction toString() renvoie une représentation sous forme de chaîne du nom de l'objet et du
    * nombre de faces qu'il possède.
    * 
    * @return La méthode renvoie une chaîne qui inclut le nom du dé (nomDes) et le nombre de faces
    * qu'il possède (nbFaces).
    */
    public String toString() {
        return "Nom: " + nomDes + ", a été lancé : " + nbFaces + " faces";
    }


   /**
    * La fonction vérifie si deux objets sont égaux en fonction de leur nombre de faces.
    * 
    * @param obj Le paramètre "obj" est un objet de type "Object" dont l'égalité est comparée à l'objet
    * actuel.
    * @return La méthode renvoie une valeur booléenne.
    */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Des other = (Des) obj;
        return nbFaces == other.nbFaces ;
    }

    
}


