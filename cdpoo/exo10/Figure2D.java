package cdpoo.exo10;

public class Figure2D {
    String refFigure = "Figure";
    String nomFigure;
    static int nbFigure;

    public Figure2D(String nomFigure) {
        this.nomFigure = nomFigure;
        nbFigure += 1;
        refFigure += nbFigure;
    }

    public double calculerPerimetre() {
        return 0.0; // Les classes dérivées doivent implémenter cette méthode
    }

    public double calculerAire() {
        return 0.0; // Les classes dérivées doivent implémenter cette méthode
    }
}