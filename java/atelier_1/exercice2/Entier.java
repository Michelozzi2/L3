package atelier_1.exercice2;


public class Entier {
    private int valeur;
    private final int borneMin;
    private final int borneMax;

    public Entier(int borneMin, int borneMax) {
        this.borneMin = borneMin;
        this.borneMax = borneMax;
        this.valeur = 0; // Valeur par défaut à 0 si rien n'est spécifié
    }

    public Entier(int borneMin, int borneMax, int valeur) {
        this.borneMin = borneMin;
        this.borneMax = borneMax;
        this.valeur = Math.max(borneMin, Math.min(borneMax, valeur)); // Assurer que la valeur est dans les bornes
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        if (valeur >= borneMin && valeur <= borneMax) {
            this.valeur = valeur;
        }
    }

    public void incremente() {
        if (valeur < borneMax) {
            valeur++;
        }
    }

    public void incremente(int n) {
        if (valeur + n <= borneMax) {
            valeur += n;
        }
    }

   
    public String toString() {
        return Integer.toString(valeur);
    }

   
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Entier other = (Entier) obj;
        return valeur == other.valeur && borneMin == other.borneMin && borneMax == other.borneMax;
    }
}