package atelier_2.question1_2;

import java.util.GregorianCalendar;

public class TestPersonne {

    public static void main(String[] args) {

        /* 

        Personne p1 = new Personne("michelozzi", "Matthieu", 10, 10, 2000, 0, "rtnh", "gebht", "rgret");
        Personne p2 = new Personne("aze", "cvbn", 10, 10, 2000, 0, "rtndfsc", "gebhfqdt", "rgcvbret");
        
        System.out.println(p1);

        boolean compare = p1.plusAgee(p2);
        System.out.println(compare);

        System.out.println("p1 == p2 : " + p1.equals(p2));
        */

        // Création d'une personne
        Personne personne1 = new Personne("Doe", "John", 1980, 5, 15, 123, "Main St", "12345", "City");
        System.out.println("Personne1 : " + personne1.toString());

        Personne personne2 = new Personne("Michelozzi", "Matthieu", 1990, 5, 15, 123, "Main St", "12345", "City");
        System.out.println("\n Personne2 : " + personne2.toString());

        System.out.println("--------------");
        
         boolean compare = personne1.plusAgee(personne2);
        System.out.println("Premiere personne plus agée que la deuxieme : "+ compare);
        System.out.println("personne1 == personne2 : " + personne1.equals(personne2));

        System.out.println("---------------");

        // Création d'un employé valide
        GregorianCalendar dateEmbaucheEmploye1 = new GregorianCalendar(2020, 7, 1);
        Employe employe1 = Employe.createEmploye("Smith", "Jane", 1985, 8, 20, 456, "Oak St", "54321", "Town", 50000, dateEmbaucheEmploye1);
        if (employe1 != null) {
            System.out.println("Employe1 : " + employe1.toString());

            // Augmentation du salaire de l'employé valide
            employe1.augmenterLeSalaire(5);
            System.out.println("Nouveau salaire de Employe1 après augmentation : " + employe1.getSalaire());

            // Calcul de l'ancienneté de l'employé valide
            int ancienneteEmploye1 = employe1.calculAnnuite();
            System.out.println("Ancienneté de Employe1 : " + ancienneteEmploye1 + " années");
        } else {
            System.out.println("Employe1 : Création invalide d'employé.");
        }


        // Tentative de création d'un employé trop jeune
        GregorianCalendar dateEmbaucheEmploye2 = new GregorianCalendar(2022, 3, 10);
        Employe employe2 = Employe.createEmploye("Young", "Joe", 2010, 2, 3, 789, "Elm St", "98765", "Village", 40000, dateEmbaucheEmploye2);
        if (employe2 != null) {
            System.out.println(" \nEmploye2 : " + employe2.toString());
        } else {
            System.out.println(" \nEmploye2 : Création invalide d'employé.");
        }

        // Création d'un manager valide
        GregorianCalendar dateEmbaucheEmploye3 = new GregorianCalendar(2019, 7, 1);
        Manager manager1 = Manager.createManager("Youngs", "Joe", 1985, 2, 3, 789, "Elm St", "98765", "Village", 40000, dateEmbaucheEmploye3);
        if (manager1 != null) {
            System.out.println("\n manager1 : " + manager1.toString());

             // Augmentation du salaire de l'employé valide
            manager1.augmenterLeSalaire(5);
            System.out.println("Nouveau salaire de Manager1 après augmentation : " + manager1.getSalaire());

            // Calcul de l'ancienneté de l'employé valide
            int ancienneteManager1 = manager1.calculAnnuite();
            System.out.println("Ancienneté de manager1 : " + ancienneteManager1 + " années");
        } else {
            System.out.println("\n manager1 : Création invalide du manager.");
        }
    }

    
}
