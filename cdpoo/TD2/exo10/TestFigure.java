package cdpoo.TD2.exo10;

public class TestFigure {
    public static void main(String[] args) {
        Carre carre = new Carre("MonCarre", 5);
        Rectangle rectangle = new Rectangle("MonRectangle", 4, 6);
        Cercle cercle = new Cercle("MonCercle", 3);

        System.out.println(carre.nomFigure+ " - Périmètre: " + carre.calculerPerimetre() + " Aire: " + carre.calculerAire());
        System.out.println(rectangle.nomFigure + " - Périmètre: " + rectangle.calculerPerimetre() + " Aire: " + rectangle.calculerAire());
        System.out.println(cercle.nomFigure + " - Périmètre: " + cercle.calculerPerimetre() + " Aire: " + cercle.calculerAire());
    }
}
