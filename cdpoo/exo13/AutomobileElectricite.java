package cdpoo.exo13;


public class AutomobileElectricite extends Automobile{
    
    public AutomobileElectricite(int puissance, int espace, String couleur, String modele){
        super(puissance, espace, couleur, modele);

    }
    
    public void afficherCaracteristique() {
        System.out.println("Puissance : "+ this.puissance +
        "\nEspace : " + this.espace + "\nModèle : "+ this.modele
        + "\nCouleur : "+ this.couleur
       );
       
    }
}
