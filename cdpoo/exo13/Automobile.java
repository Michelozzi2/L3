package cdpoo.exo13;

public abstract class Automobile {
    public int puissance,espace;
    public String couleur, modele;
    

    
    public Automobile(int puissance, int espace, String couleur, String modele) {
        this.puissance = puissance;
        this.espace = espace;
        this.couleur = couleur;
        this.modele = modele;
    }

    public abstract void afficherCaracteristique();
    
}

