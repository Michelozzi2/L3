package cdpoo.TD2.exo12;

public class Ennemi extends Personnage {
    public Ennemi(String nom, int pointDeForce, int pointDeVie, int x, int y, Arme arme, int orientation) {
        super(nom, pointDeForce, pointDeVie, x, y, arme, orientation);
    }

    // Ajoutez la méthode pour le combat de l'ennemi contre le joueur
    void combatJoueurVsEnnemi(Joueur joueur, Ennemi ennemi) {
        System.out.println("Combat entre " + ennemi.nom + " et " + joueur.nom + ":");
        ennemi.deplacer();
        ennemi.attaquer(joueur);
        if (joueur.pointDeVie <= 0) {
            System.out.println(ennemi.nom + " a vaincu " + joueur.nom + " !");
        }
    }
}
