/**
 * La classe `Album` représente un album, avec des propriétés telles que le nom, l'artiste, la liste
 * des titres musicaux et le visuel.
 */
import java.util.ArrayList;
import java.util.List;

public class Album {
    private String nom;
    private Artiste artiste;
    private List<TitreMusique> titresMusicaux = new ArrayList<>();
    private String visuel;

    // Constructeur, getters et setters
   // Le code que vous avez fourni est un constructeur pour la classe `Album`.
    public Album(String nom, Artiste artiste, List<TitreMusique> titresMusicaux, String visuel) {
        this.nom = nom;
        this.artiste = artiste;
        this.titresMusicaux = titresMusicaux;
        this.visuel = visuel;
    }


    public String getNom() {
        return nom;
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public List<TitreMusique> getTitresMusicaux() {
        return titresMusicaux;
    }

    public String getVisuel() {
        return visuel;
    }


   public void setNom(String nom) {
        this.nom = nom;
    }


    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }


    public void setTitresMusicaux(List<TitreMusique> titresMusicaux) {
        this.titresMusicaux = titresMusicaux;
    }


    public void setVisuel(String visuel) {
        this.visuel = visuel;
    }


/**
    * La fonction "ajouterTitreMusical" ajoute un titre musical à une liste de titres musicaux.
    * 
    * @param titre Le paramètre "titre" est de type "TitreMusical", qui est une classe représentant un
    * titre musical.
    */
    public void ajouterTitreMusical(TitreMusique titre) {
        titresMusicaux.add(titre);
    }


    @Override
    public String toString() {
        return "\nAlbum [nom= " + this.nom + ", artiste= " + this.artiste + ", titresMusicaux= " + this.titresMusicaux + ", visuel= " + this.visuel
                + "]";
    }

    
    
}