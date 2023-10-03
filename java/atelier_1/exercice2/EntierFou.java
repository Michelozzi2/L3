package atelier_1.exercice2;
import java.util.Random;

public class EntierFou extends Entier {
    private int niveauDeFolie;
    private Random random = new Random();

    public EntierFou(int borneMin, int borneMax, int niveauDeFolie) {
        super(borneMin, borneMax);
        this.niveauDeFolie = niveauDeFolie;
    }

    public EntierFou(int borneMin, int borneMax, int valeur, int niveauDeFolie) {
        super(borneMin, borneMax, valeur);
        this.niveauDeFolie = niveauDeFolie;
    }

   
    public void incremente() {
        int increment = random.nextInt(niveauDeFolie + 1);
        super.incremente(increment);
    }
}
