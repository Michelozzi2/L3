package cdpoo.TD2.exo11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Course {
    private String nomCourse;
    private List<Voiture> voituresParticipantes;
    private Map<Voiture, Double> tempsParVoiture;

    public Course(String nomCourse) {
        this.nomCourse = nomCourse;
        voituresParticipantes = new ArrayList<>();
        tempsParVoiture = new HashMap<>();
    }

    public void ajouterVoitureParticipante(Voiture voiture) {
        voituresParticipantes.add(voiture);
    }

    public void enregistrerTemps(Voiture voiture, double temps) {
        tempsParVoiture.put(voiture, temps);
    }

    public String getNomCourse() {
        return nomCourse;
    }

    public Map<Voiture, Double> getTempsParVoiture() {
        return tempsParVoiture;
    }

    public List<Voiture> getVoituresParticipantes() {
        return voituresParticipantes;
    }

    
}

