package cdpoo.exo13;

public class ScooterEssence extends Scooter {
    public ScooterEssence(int puissance, String couleur, String modele){
        super(puissance, couleur, modele);

    }
    
    public void afficherCaracteristique() {
        System.out.println("Puissance : "+ this.puissance +
         "\nModèle : "+ this.modele
        + "\nCouleur : "+ this.couleur
       );
       
    }
    
}
