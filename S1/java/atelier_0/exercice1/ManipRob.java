package atelier_0.exercice1;

public class ManipRob {

    public static void main(String args[]){
        Robot r1 = new Robot("Titi", 10, 20, Robot.NORD);
        Robot r2 = new Robot("Toto");
        Robot r3 = new Robot("Tato");

          
        r1.modificationOrientation(Robot.SUD);
        r1.deplacer();
        

        r2.modificationOrientation(Robot.NORD);
        r2.deplacer();
        

        r3.modificationOrientation(Robot.SUD);
        r3.deplacer();
        

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        
        
    }

}