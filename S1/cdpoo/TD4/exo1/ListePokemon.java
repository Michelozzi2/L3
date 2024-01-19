package cdpoo.TD4.exo1;

import java.util.ArrayList;
import java.util.List;

public class ListePokemon {

    public static void main(String[] args) {
    List<String> pokemons = new ArrayList<String>();
    pokemons.add("Pikachu");
    pokemons.add("Bulbizarre");
    pokemons.add("Salamèche");
    pokemons.add("Carapuce");

    for (String pokemon : pokemons) {
        System.out.println(pokemon);
    }

    pokemons.add(0, "magicarpe");
    System.out.println(pokemons);

    pokemons.remove(1);
    System.out.println(pokemons);

    }
    
}