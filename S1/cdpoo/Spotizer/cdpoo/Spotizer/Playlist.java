/**
 * La classe Playlist représente un objet playlist qui contient un nom, un créateur et une liste de
 * titres musicaux.
 */
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nom;
    private Utilisateur createur;
    private List<TitreMusique> morceaux;

    // La `public Playlist(String nom, Utilisateur createur)` est un constructeur pour la classe
    // `Playlist`. Il prend deux paramètres, `nom` et `createur`, qui représentent respectivement le
    // nom de la playlist et le créateur de la playlist.
    public Playlist(String nom, Utilisateur createur) {
        this.nom = nom;
        this.createur = createur;
        this.morceaux = new ArrayList<>();
    }

    /**
     * La fonction "ajouterMorceau" ajoute un titre musical à une liste de titres musicaux.
     * 
     * @param morceau Le paramètre "morceau" est de type "TitreMusique" et représente un titre musical
     * ou une chanson.
     */
    public void ajouterMorceau(TitreMusique morceau) {
        morceaux.add(morceau);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Utilisateur getCreateur() {
        return createur;
    }

    public void setCreateur(Utilisateur createur) {
        this.createur = createur;
    }

    public List<TitreMusique> getMorceaux() {
        return morceaux;
    }

    public void setMorceaux(List<TitreMusique> morceaux) {
        this.morceaux = morceaux;
    }

    @Override
    public String toString() {
        return "\nPlaylist [nom=" + nom + ", createur=" + createur + ", morceaux=" + morceaux + "]";
    }

    

}