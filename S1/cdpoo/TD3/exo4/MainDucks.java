package cdpoo.TD3.exo4;

public class MainDucks {

    public static void main(String[] args) {
        Ducks <String> d1 = new Ducks<>("Riri", "Fifi", "Loulou");
        d1.afficher();
        Ducks <Integer> d2 = new Ducks<>(1, 2, 3);
        d2.afficher();
        Ducks <?> d3 = new Ducks<>(1, "Fifi", 3.0);
        d3.afficher();
    }
    
}
