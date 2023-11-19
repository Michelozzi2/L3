package cdpoo.TD3.exo3;

public class MainBanque {

    public static void main(String[] args) {
        Banque b = new Banque(1000);
        try {
            int resultat = b.retrait(200);
            System.out.println("Le solde est : "+ resultat);
        } 
        catch (RetraitException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(b.getSolde());
    }
    
}
