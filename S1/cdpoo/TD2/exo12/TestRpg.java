package cdpoo.TD2.exo12;

public class TestRpg {
    public static void main(String[] args) {
        Arme epee = new Arme("Épée en acier", 15);
        Arme epee2 = new Arme("Épée en acier", 0);
        Joueur joueur1 = new Joueur("Héros", 1, 100, 5, 10,epee, Personnage.NORD);
        joueur1.equiperArme(epee);
       

        Ennemi ennemi1 = new Ennemi("Monstre", 50, 100, 6, 11,epee2, Personnage.SUD);

        System.out.println("Début du combat !");
        boolean tourJoueur = true; // Pour alterner les tours entre le joueur et le monstre
        while (joueur1.pointDeVie > 0 && ennemi1.pointDeVie > 0) {
            // Vérifie si le joueur et l'ennemi sont à 1 d'écart en x ou y
            if (Math.abs(joueur1.x - ennemi1.x) == 1 || Math.abs(joueur1.y - ennemi1.y) == 1) {
                if (tourJoueur) {
                    joueur1.combatJoueurVsEnnemi(joueur1, ennemi1); // Tour du joueur
                } else {
                    ennemi1.combatJoueurVsEnnemi(joueur1, ennemi1); // Tour de l'ennemi
                }

                tourJoueur = !tourJoueur; // Alterner les tours
                System.out.println("\n");
                
            } else {
                System.out.println("Pas de combat possible, le joueur et l'ennemi sont trop éloignés.");
                break;
            }
            
        }

        System.out.println("Fin du combat !");
    }
}