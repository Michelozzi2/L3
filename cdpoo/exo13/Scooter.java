package cdpoo.exo13;

public abstract class Scooter {
    public int puissance;
    public String couleur, modele;
    
    public Scooter(int puissance, String couleur, String modele) {
        this.puissance = puissance;
        this.couleur = couleur;
        this.modele = modele;
    }

    public abstract void afficherCaracteristique();
    
    
}
