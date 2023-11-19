package cdpoo.TD3.exo2;

public class MainRacine {
    public static void main(String[] args) {
    try {
        double resultat = Racine.calculer(-2);
        System.out.println("La Racine de 2 est : "+ resultat);
    }

    catch (ValeurNegativeException e) {
        System.err.println("Erreur :" + e.getMessage());
    }

}
    
}
