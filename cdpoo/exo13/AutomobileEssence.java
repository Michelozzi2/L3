package cdpoo.exo13;

public class AutomobileEssence extends Automobile {
    
    public AutomobileEssence(int puissance, int espace, String couleur, String modele){
        super(puissance, espace, couleur, modele);

    }
    
    public void afficherCaracteristique() {
        System.out.println("Puissance : "+ this.puissance +
        "\nEspace : " + this.espace + "\nModèle : "+ this.modele
        + "\nCouleur : "+ this.couleur
       );
       
    }
    
}
