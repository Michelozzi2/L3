package cdpoo.exo9;

import cdpoo.exo5.InverseChaine;

public class Palindrome {

         public static void main(String args[]){

            System.out.println(verifPalindrome("radar"));

        }

        public static boolean verifPalindrome(String chaine) {

            boolean resPalindrome = false;
            String chaineIverse = InverseChaine.inversechaine(chaine);
            if(chaine.equals(chaineIverse)) {
                resPalindrome = true ;
            }
            return resPalindrome;

            

        }
}