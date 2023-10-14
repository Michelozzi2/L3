package cdpoo.exo8;

public class NbPremier {

    public static void main(String args[]){
        for(int i=1; i <= 100; i++) {
            System.out.println(i + " = "+ nbPremier(i));

        }

    }

    public static boolean nbPremier(int a) {

        int reste;
        boolean res = true;
                
        for(int i=2; i <= a/2; i++)
        {
            //nombre est divisible par lui-meme
            reste = a%i;
                    
            //si le reste est 0, alors arrete la boucle. Sinon continuer la boucle
            if(reste == 0)
            {
                res = false;
                break;
            }
        }
        return res;

    }
    
}
