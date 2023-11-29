package cdpoo.TD2.exo10;

public class Rectangle extends Figure2D {
    double longueur;
    double largeur;
    

    public Rectangle( String nomFigure, double longueur, double largeur){
        super(nomFigure);
        this.longueur = longueur;
        this.largeur = largeur;

    }

    @Override
    public double calculerPerimetre() {
        return 2 * (longueur + largeur);
    }

    @Override
    public double calculerAire() {
        return longueur * largeur;
    }
    
}
