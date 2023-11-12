/**
 * La classe `Ecoute` représente une session d'écoute et garde une trace du nom, de l'utilisateur, de
 * la liste des morceaux de musique et de la durée totale de la session.
 */
import java.util.ArrayList;
import java.util.List;

public class Ecoute {
    private String nom;
    private Utilisateur user;
    private List<TitreMusique> morceaux;
    private Float dureeTotale; 

   // Le constructeur `public Ecoute(String nom, Utilisateur user)` initialise une nouvelle instance de
   // la classe `Ecoute` avec les paramètres `nom` et `user` fournis. Il initialise également la liste
   // `morceaux` comme une `ArrayList` vide et définit la `dureeTotale` sur 0,0.
    public Ecoute(String nom, Utilisateur user) {
        this.nom = nom;
        this.user = user;
        this.morceaux = new ArrayList<>();
        this.dureeTotale = 0.f;
    }

   /**
    * La fonction "ajouterMorceau" ajoute un morceau de musique à une liste et met à jour la durée
    * totale.
    * 
    * @param morceau Le paramètre « morceau » est de type « TitreMusique », qui représente une piste
    * musicale ou une chanson.
    */
    public void ajouterMorceau(TitreMusique morceau) {
        morceaux.add(morceau);
        dureeTotale += morceau.getDuree(); 
    }

   /**
    * La fonction "CalculerDureeTotale" calcule la durée totale d'une collection de morceaux de
    * musique.
    */
    public void CalculerDureeTotale() {
        dureeTotale = 0.f;
        for (TitreMusique morceau : morceaux) {
            dureeTotale += morceau.getDuree();
        }
    }

    public Float getDureeTotale() {
        return dureeTotale;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Utilisateur getuser() {
        return user;
    }

    public void setuser(Utilisateur user) {
        this.user = user;
    }

    public List<TitreMusique> getMorceaux() {
        return morceaux;
    }

    public void setMorceaux(List<TitreMusique> morceaux) {
        this.morceaux = morceaux;
    }

    public void setDureeTotale(Float dureeTotale) {
        this.dureeTotale = dureeTotale;
    }

    @Override
    public String toString() {
        return "\nEcoute [nom=" + nom + ", user=" + user + ", morceaux=" + morceaux + ", dureeTotale="
                + dureeTotale + "]";
    }

    
}