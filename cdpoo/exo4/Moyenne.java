package cdpoo.td4;

public class Moyenne {

    public static void main(String args[]){

        int tableau[] = {16, 5, 13, 54, 17, 2, 38, 42, 67};
        System.out.println(moyenne(tableau));

    }


    public static float moyenne(int[] array) {

        int somme = 0;
        for(int i = 0; i < array.length; i++){

            somme += array[i];

        }
        float moyenne = (float) somme / array.length;
        return moyenne;
 
    
    }

    
}
