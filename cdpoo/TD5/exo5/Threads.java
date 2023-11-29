package cdpoo.TD5.exo5;

public class Threads {
    
    public static void main(String[] args) throws InterruptedException {
        Processus a = new Processus();
        for (int i = 0; i < 10; i++) {
            a.dodo((long) (Math.random() * (10 - 0)) + 0);
        }
    }
}
   
