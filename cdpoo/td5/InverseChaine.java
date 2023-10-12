package cdpoo.td5;

public class InverseChaine {

    public static void main(String args[]){

        String chaine = "Ma chaine";
        System.out.println(inversechaine(chaine));

    }

    public static String inversechaine(String chaine) {

        int longueur = chaine.length();
        char resChar ;
        String resChaine = "";
        for(int i = 0; i < longueur ; i++){

            resChar = chaine.charAt(i) ;
            resChaine = resChar + resChaine;
        }
        return resChaine;



    }


    
}
