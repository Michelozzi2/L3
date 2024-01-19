package cdpoo.TD2.exo3;

public class Geometrie {

    public static void main(String args[]){

        System.out.println(perimetre(4));
        System.out.println(aire(4));
        
    }

    public static double perimetre(double r) {

        double resPerimetre = 0;
        resPerimetre = 2* Math.PI * r;
        return resPerimetre;

    }

    public static double aire(double r) {

        double resAire = 0;
        resAire = Math.PI * Math.pow(r, 2);
        return resAire;

    }
    
}
