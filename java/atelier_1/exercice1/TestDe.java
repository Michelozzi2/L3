package atelier_1.exercice1;


public class TestDe {

    public static void main(String[] args) {
        // Testez les différents constructeurs
        Des de1 = new Des();
        Des de2 = new Des(6);
        Des de = new Des(6);
        Des de3 = new Des("Mon Dé");

        System.out.println("Nombre de dés créés : " + Des.getNombreDesCrees());

        System.out.println(de1);
        System.out.println(de2);
        System.out.println(de);
        System.out.println(de3);

        System.out.println("--------------");

        // Testez le lancer de dés
        System.out.println(de1.getNom() + " a été lancé : " + de1.lancer());
        System.out.println(de2.getNom() + " a été lancé : " + de2.lancer());
        System.out.println(de.getNom() + " a été lancé : " + de.lancer());
        System.out.println(de3.getNom() + " a été lancé : " + de3.lancer());

        // Testez la surcharge de la méthode lancer
        int meilleurResultat = de1.lancer(3); // Lance le dé 5 fois et garde le meilleur résultat
        System.out.println(de1.getNom() + " a obtenu le meilleur résultat : " + meilleurResultat);

        System.out.println("------------------");
        DePipe dePipe = new DePipe(6, "Dé pipé", 4);
        System.out.println(dePipe.getNom() + " a été lancé : " + dePipe.lancer());
       
        System.out.println("------------------");
        DeEffetMemoire deMemoire = new DeEffetMemoire(6, "Dé à effet mémoire");
        for (int i = 0; i < 10; i++) {
            System.out.println(deMemoire.getNom() + " a été lancé : " + deMemoire.lancer());
        }
    }

        
        
        
    
}
    

