package atelier_1.exercice1;
import java.util.*;

/* 
 
Modifier la classe De pour prendre en compte un tableau de valeurs au lieu d'un nombre de faces fixes. 
Vous pouvez également ajouter un constructeur pour préciser les valeurs des faces du dé lors de sa création.

Adapter la méthode lancer pour choisir une valeur aléatoire dans le tableau des valeurs pour représenter le résultat du lancer.


*/

public class Des {
    private String nomDes = "De";
    private int nbFaces;
    private final static int minFaces = 3 , maxFaces = 120;
    private static int nbDes = 0;
    private static Random r = new Random();
    

    public Des(){
        this.nbFaces = 6;
        nbDes ++;
    }

    public Des(int nbFaces){
        
        setNbFace(nbFaces);
        
        nomDes += nbDes;
        nbDes ++;
    }

    public Des(String nomDes){
        this.nomDes = nomDes;
        this.nbFaces = maxFaces;
        
        nomDes += nbDes;
        nbDes ++;

    }


    public void setNbFace(int nbFaces){

        if(nbFaces >= minFaces && nbFaces <= maxFaces){
            this.nbFaces = nbFaces;
        }
        else{
            System.err.println("Nombre pas compris entre 3 et 120");
        }
    }

    public int getNbFace(){
        return nbFaces;
    }

    public String getNom(){
        return nomDes;
    }

    // Getter pour le nombre de dés créés
    public static int getNombreDesCrees() {
        return nbDes;
    }

    public int lancer(){

        int nbAleatoire= r.nextInt(this.nbFaces)+1 ;
        return nbAleatoire;

    }

    // Méthode pour lancer le dé un nombre nb donné de fois et retourner le meilleur résultat
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

    public String toString() {
        return "Nom: " + nomDes + ", a été lancé : " + nbFaces + " faces";
    }

    
}


