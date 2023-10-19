package cdpoo.exo10;

public class Cercle extends Figure2D {
    private double rayon;

    public Cercle(String nomFigure, double rayon) {
        super(nomFigure);
        this.rayon = rayon;
    }

    @Override
    public double calculerPerimetre() {
        return 2 * Math.PI * rayon;
    }

    @Override
    public double calculerAire() {
        return Math.PI * rayon * rayon;
    }
}
