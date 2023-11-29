package cdpoo.TD2.exo7;

public class Temperature {

    public static void main(String args[]){

        System.out.println(farenheit(45));
        System.out.println(celcius(113));
        
    }

    public static double farenheit(double t) {

        double resFarenheit = 0;
        resFarenheit = (t * 9/5) + 32;
        return resFarenheit;

    }

    public static double celcius(double t) {

        double resCelcius = 0;
        resCelcius = (t - 32)* 5/9;
        return resCelcius;

    }
    
}
