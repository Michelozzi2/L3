package qualite_logiciel.exo_LSP2;

public class test {
         public static void main(String[] args) {
            // Créer une instance de PresencesCours
            PresencesCours presences = new PresencesCours();
    
            // Créer une personne
            Personne personne = new Personne(false, "John Doe");
    
            // Arrivée en cours avec PresencesCours
            System.out.println("Avec PresencesCours :");
            presences.arriveEnCours(personne);
    
            // Remplacer PresencesCours par PresencesProf
            presences = new PresencesProf();
    
            // Arrivée en cours avec PresencesProf
            System.out.println("\nAvec PresencesProf :");
            presences.arriveEnCours(personne);
        }
    }
    

