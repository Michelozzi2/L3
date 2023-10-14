package cdpoo.exo1;

public class Addition {

    public static void main(String args[]){
        int resAddition = addition(5, 2);
        System.out.println(resAddition);

        int tableau[] = {1,2,3};
        int resAddition2 = addition2(tableau);
        System.out.println(resAddition2);

    }

    public static int addition(int a, int b) {

        int res = a + b;
        return res;

    }

    public static int addition2(int[] array) {

        int res = 0;
        for(int i = 0; i < array.length; i++){

            res = res + array[i];

        }
        return res;
        
    }





    
}