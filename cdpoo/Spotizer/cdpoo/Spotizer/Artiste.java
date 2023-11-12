/**
 * La classe `Artiste` représente un artiste et contient des propriétés telles que son nom, une liste
 * de titres musicaux et une représentation visuelle.
 */
import java.util.ArrayList;
import java.util.List;

public class Artiste {

    private String nom;
    private List<TitreMusique> titreMusiques = new ArrayList<>();
    private String visuel;
   
   // Le `public Artiste(String nom, List<TitreMusique> titreMusiques, String visuel)` est une méthode
   // constructeur pour la classe `Artiste`. Il est utilisé pour créer une nouvelle instance de la
   // classe `Artiste` et initialiser ses propriétés (`nom`, `titreMusiques` et `visuel`) avec les
   // valeurs passées en arguments au constructeur.
    public Artiste(String nom, List<TitreMusique> titreMusiques, String visuel) {
        this.nom = nom;
        this.titreMusiques = titreMusiques;
        this.visuel = visuel;
    }


    public String getNom() {
        return nom;
    }


    public List<TitreMusique> getTitresMusicaux() {
        return titreMusiques;
    }


    public String getVisuel() {
        return visuel;
    }

    
    public void setNom(String nom) {
        this.nom = nom;
    }


    public void setTitreMusiques(List<TitreMusique> titreMusiques) {
        this.titreMusiques = titreMusiques;
    }


    public void setVisuel(String visuel) {
        this.visuel = visuel;
    }

    public void addTitreMusical(TitreMusique titre) {
        titreMusiques.add(titre);
    }


    @Override
    public String toString() {
        return "\nArtiste [nom= " + this.nom + ", titresMusicaux= " + this.titreMusiques + ", visuel= " + this.visuel + "]";
    }

    
}