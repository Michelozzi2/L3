package cdpoo.exo2;

public class Multiplication {

    public static void main(String args[]){

        multiplication(5);
        
    }

    public static int multiplication(int n) {

        int res = 1 ;
        for(int i = 0; i <= 10; i++){

            res = n * i;
            System.out.println(n + "*" + i + " = " +res);

        }
        return n;

    }
    
}
