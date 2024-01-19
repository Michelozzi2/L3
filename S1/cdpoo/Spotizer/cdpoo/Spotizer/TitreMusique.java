/**
 * La classe `TitreMusique` représente un titre musical avec des propriétés telles que le nom, la
 * durée, le style, l'album, l'artiste et des indicateurs pour les versions remix et reprises.
 */
public class TitreMusique {
    private String nomTitre;
    private Float duree; // en secondes
    private String style;
    private Album album;
    private Artiste artiste;
    private boolean estRemix;
    private boolean estReprise;

    // Le constructeur `public TitreMusique` est utilisé pour créer une nouvelle instance de la classe
    // `TitreMusique`. Il prend plusieurs paramètres : `nomTitre`, `durée`, `style`, `album`,
    // `artiste`, `estRemix` et `estReprise`.
    public TitreMusique(String nomTitre, Float duree, String style, Album album, Artiste artiste, boolean estRemix,
        boolean estReprise) {
        this.nomTitre = nomTitre;
        this.duree = duree;
        this.style = style;
        this.album = album;
        this.artiste = artiste;
        this.estRemix = estRemix;
        this.estReprise = estReprise;
    }

    public String getNomTitre() {
        return nomTitre;
    }

    public void setNomTitre(String nomTitre) {
        this.nomTitre = nomTitre;
    }

    public Float getDuree() {
        return duree;
    }

    public void setDuree(Float duree) {
        this.duree = duree;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }

    public boolean isEstRemix() {
        return estRemix;
    }

    public void setEstRemix(boolean estRemix) {
        this.estRemix = estRemix;
    }

    public boolean EstReprise() {
        return estReprise;
    }

    public void setEstReprise(boolean estReprise) {
        this.estReprise = estReprise;
    }

    @Override
    public String toString() {
        return "\nTitreMusique [nomTitre= " + this.nomTitre + ", duree= " + this.duree + ", style= " + this.style + ", album= " + this.album
                + ", artiste= " + this.artiste + ", estRemix= " + this.estRemix + ", estReprise= " + this.estReprise + "]";
    }

}
