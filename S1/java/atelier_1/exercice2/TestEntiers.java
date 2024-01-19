package atelier_1.exercice2;

public class TestEntiers {
    public static void main(String[] args) {
        // Test de la classe Entier
        Entier entier1 = new Entier(0, 10);
        System.out.println("Entier1: " + entier1); // Devrait afficher "Entier1: 0"

        entier1.incremente();
        System.out.println("Entier1 après incrémentation: " + entier1); // Devrait afficher "Entier1: 1"

        entier1.setValeur(5);
        System.out.println("Entier1 après setValeur(5): " + entier1); // Devrait afficher "Entier1: 5"

        Entier entier2 = new Entier(0, 10, 8);
        System.out.println("Entier2: " + entier2); // Devrait afficher "Entier2: 8"

        entier2.incremente(5);
        System.out.println("Entier2 après incrémentation de 5: " + entier2); // Devrait afficher "Entier2: 10"

        // Test de la classe EntierFou
        EntierFou entierFou1 = new EntierFou(0, 20, 6);
        System.out.println("EntierFou1: " + entierFou1);

        for (int i = 0; i < 5; i++) {
            entierFou1.incremente();
            System.out.println("EntierFou1 après incrémentation aléatoire: " + entierFou1);
        }
    }
}
