package cdpoo.exo12;

public class Joueur extends Personnage {
    Arme arme;  

    public Joueur(String nom, int pointDeForce, int pointDeVie, int x, int y, Arme arme, int orientation){
        super(nom, pointDeForce, pointDeVie, x, y, arme, orientation);
    }

    void equiperArme(Arme arme) {
        this.arme = arme;
    }

    void combatJoueurVsEnnemi(Joueur joueur, Ennemi ennemi) {
        System.out.println("Combat entre " + joueur.nom + " et " + ennemi.nom + ":");
        joueur.deplacer();
        joueur.attaquer(ennemi);
        if (ennemi.pointDeVie <= 0) {
            System.out.println(joueur.nom + " a vaincu " + ennemi.nom + " !");
        }
    }
    
}
