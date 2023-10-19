package cdpoo.exo12;

import java.util.Random;

public class Personnage {
    String refPersonnage = "ROB",nom;
    int pointDeForce;
    int pointDeVie;
    int x, y;
    int orientation;
    public final static int NORD = 1, SUD = 2, EST = 3, OUEST = 4;
    static int nbPersonnage;

    public Personnage(String nom, int pointDeForce, int pointDeVie, int x, int y, int orientation){
        this.nom = nom;
        this.pointDeForce = pointDeForce;
        this.pointDeVie = pointDeVie;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        nbPersonnage += 1;
        refPersonnage += nbPersonnage;
    }

    public void modificationOrientation(int modOrientation){

        this.orientation = modOrientation;

    }

    public void deplacer() {
        switch (orientation) {
            case NORD: // NORD
                y++;
                break;
            case EST: // EST
                x++;
                break;
            case SUD: // SUD
                y--;
                break;
            case OUEST: // OUEST
                x--;
                break;
        }

        // Vérifier que les coordonnées ne deviennent pas négatives
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
    }

    void attaquer(Personnage cible) {
        int degats = new Random().nextInt(pointDeForce) + 1;
        System.out.println(nom + " attaque " + cible.nom + " et inflige " + degats + " points de dégâts.");
        cible.subirDegats(degats);
    }

    void subirDegats(int degats) {
        pointDeVie -= degats;
        if (pointDeVie <= 0) {
            System.out.println(nom + " a été vaincu!");
        }
    }

    public String toString() {
        return "Nom: " + nom + ", Position X: " + x + ", Position Y: " + y + ", Orientation: " + orientation;
    }



    
}
