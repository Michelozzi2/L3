package cdpoo.exo11;

import java.util.Map;

public class TestRallye {

    public static void main(String[] args) {
        Personne pilote1 = new Personne("Pilote1", "A+", 30);
        Personne coPilote1 = new Personne("Co-pilote1", "B-", 25);
        
        Personne pilote2 = new Personne("Pilote2", "0+", 28);
        Personne coPilote2 = new Personne("Co-pilote2", "B+", 26);

        Voiture voiture1 = new Voiture("Modèle1", "Groupe N");
        Voiture voiture2 = new Voiture("Modèle2", "Groupe A");

        // Associez les pilotes et co-pilotes aux voitures
        voiture1.setPilote(pilote1);
        voiture1.setCoPilote(coPilote1);

        voiture2.setPilote(pilote2);
        voiture2.setCoPilote(coPilote2);

        Course course1 = new Course("Course 1");
        course1.ajouterVoitureParticipante(voiture1);
        course1.ajouterVoitureParticipante(voiture2);

        course1.enregistrerTemps(voiture1, 120.5);
        course1.enregistrerTemps(voiture2, 115.0);

         // Deuxième course
        Voiture voiture3 = new Voiture("Modèle3", "Groupe R");
        Voiture voiture4 = new Voiture("Modèle4", "Groupe N");
        
        Personne pilote3 = new Personne("Pilote3", "A-", 35);
        Personne coPilote3 = new Personne("Co-pilote3", "o+", 27);
        
        Personne pilote4 = new Personne("Pilote4", "B+", 32);
        Personne coPilote4 = new Personne("Co-pilote4", "AB-", 29);

        voiture3.setPilote(pilote3);
        voiture3.setCoPilote(coPilote3);

        voiture4.setPilote(pilote4);
        voiture4.setCoPilote(coPilote4);

        Course course2 = new Course("Course 2");
        course2.ajouterVoitureParticipante(voiture3);
        course2.ajouterVoitureParticipante(voiture4);

        course2.enregistrerTemps(voiture3, 110.0);
        course2.enregistrerTemps(voiture4, 125.5);

        Rallye rallye = new Rallye();
        rallye.ajouterCourse(course1);
        rallye.ajouterCourse(course2);

         Map<Voiture, Double> classementGeneral = rallye.calculerClassementGeneral();

        for (Course course : rallye.getCourses()) {
            System.out.println("Course : " + course.getNomCourse());
            System.out.println("------------------------------");

            for (Map.Entry<Voiture, Double> entry : classementGeneral.entrySet()) {
                Voiture voiture = entry.getKey();
                double tempsTotal = entry.getValue();

                if (course.getVoituresParticipantes().contains(voiture)) {
                    Personne pilote = voiture.getPilote();
                    Personne coPilote = voiture.getCoPilote();

                    System.out.println("Voiture : " + voiture.getModele());
                    System.out.println("Pilote : " + pilote.getNom() + " (Âge : " + pilote.getAge() + ", Groupe Sanguin : " + pilote.getGroupeSanguin() + ")");
                    System.out.println("Co-pilote : " + coPilote.getNom() + " (Âge : " + coPilote.getAge() + ", Groupe Sanguin : " + coPilote.getGroupeSanguin() + ")");
                    System.out.println("Temps total : " + tempsTotal);
                    System.out.println("------------------------------");
                }
            }
        }
    }
}
    //System.out.println(voiture1.toString());
    //System.out.println(pilote1.toString());

    

    

