package cdpoo.TD3.exo4;

public class Ducks <T> {
    public T riri;
    public T fifi;
    public T loulou;

    public Ducks(T riri, T fifi, T loulou) {
        this.riri = riri;
        this.fifi = fifi;
        this.loulou = loulou;
    }

    public T getRiri() {
        return riri;
    }

    public T getfifi () {
        return fifi;
    }

    public T getLoulou() {
        return loulou;
    }   

    public void afficher() {
        System.out.println("Riri : " + riri);
        System.out.println("Fifi : " + fifi);
        System.out.println("Loulou : " + loulou);
    }

    

}