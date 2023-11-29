package cdpoo.TD2.exo10;

public class Carre extends Rectangle {
    private double cote;

    public Carre(String nomFigure, double cote) {
        super(nomFigure, cote, cote); // Appeler le constructeur de Rectangle avec longueur et largeur égaux
        this.cote = cote;
    }

    @Override
    public double calculerPerimetre() {
        return 4 * cote;
    }

    @Override
    public double calculerAire() {
        return cote * cote;
    }
}
