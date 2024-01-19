package cdpoo.TD3.exo2;

public class Racine {
    
    public static double calculer(double a) throws ValeurNegativeException {
        if (a < 0) {
            throw new ValeurNegativeException();
            
        }
        return Math.sqrt(a);
    }
    
}
