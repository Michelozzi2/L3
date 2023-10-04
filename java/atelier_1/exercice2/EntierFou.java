package atelier_1.exercice2;
import java.util.Random;

/**
 * La classe EntierFou étend la classe Entier et ajoute un niveau d'aléatoire à la méthode
 * d'incrémentation.
 */
public class EntierFou extends Entier {
    private int niveauDeFolie;
    private Random random = new Random();


    
    // L'extrait de code est un constructeur pour la classe `EntierFou`. Il prend trois paramètres :
    // `borneMin`, `borneMax` et `niveauDeFolie`.
    public EntierFou(int borneMin, int borneMax, int niveauDeFolie) {
        super(borneMin, borneMax);
        this.niveauDeFolie = niveauDeFolie;
    }



    // L'extrait de code est un constructeur pour la classe `EntierFou`. Il prend quatre paramètres :
    // `borneMin`, `borneMax`, `valeur` et `niveauDeFolie`.
    public EntierFou(int borneMin, int borneMax, int valeur, int niveauDeFolie) {
        super(borneMin, borneMax, valeur);
        this.niveauDeFolie = niveauDeFolie;
    }

   
   // La méthode `incremente()` de la classe `EntierFou` remplace la méthode `incremente()` de la
   // superclasse `Entier`.
    public void incremente() {
        int increment = random.nextInt(niveauDeFolie);
        super.incremente(increment);
    }
}
