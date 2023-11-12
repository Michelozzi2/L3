package cdpoo.exo13;

public class ScooterElectricite extends Scooter{
    public ScooterElectricite(int puissance, String couleur, String modele){
        super(puissance, couleur, modele);

    }
    
    public void afficherCaracteristique() {
        System.out.println("Puissance : "+ this.puissance +
        "\nModèle : "+ this.modele
        + "\nCouleur : "+ this.couleur
       );
       
    }
    
}
