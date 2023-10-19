package cdpoo.exo11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Rallye {
    private List<Course> courses;

    public Rallye() {
        courses = new ArrayList<>();
    }

    public void ajouterCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Map<Voiture, Double> calculerClassementGeneral() {
        Map<Voiture, Double> classementGeneral = new HashMap<>();

        for (Course course : courses) {
            Map<Voiture, Double> tempsParVoiture = course.getTempsParVoiture();
            for (Map.Entry<Voiture, Double> entry : tempsParVoiture.entrySet()) {
                Voiture voiture = entry.getKey();
                double temps = entry.getValue();
                classementGeneral.put(voiture, classementGeneral.getOrDefault(voiture, 0.0) + temps);
            }
        }

        return classementGeneral;
    }
}
