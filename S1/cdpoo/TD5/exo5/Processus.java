package cdpoo.TD5.exo5;

public class Processus extends Thread {
    int compteur = 0;
    public Processus(){
       
    }

    public void dodo(long temps) throws InterruptedException{
        sleep(temps * 1000);
        compteur += 1;
        System.out.println(("Le thread " + compteur + " a attentdu " + temps + " secondes"));

    }

}
    

