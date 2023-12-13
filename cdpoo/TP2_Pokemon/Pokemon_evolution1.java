package cdpoo.TP2_Pokemon;

import java.util.List;

/**
 * Cette classe représente la première évolution d'un Pokémon.
 * Elle hérite de la classe Pokemon et ajoute des méthodes spécifiques à la première évolution.
 */
public class Pokemon_evolution1 extends Pokemon {

    protected String nom;
    protected String type;
    protected String type2;
    protected int pv;
    protected int pc;
    
    /**
     * Constructeur pour créer un Pokémon de première évolution avec un seul type.
     * @param nom le nom du Pokémon
     * @param type le type du Pokémon
     * @param pv les points de vie du Pokémon
     * @param pc les points de combat du Pokémon
     */
    public Pokemon_evolution1(String nom, String type, int pv, int pc) {
        super(nom, type, pv, pc);
    }

    /**
     * Constructeur pour créer un Pokémon de première évolution avec deux types.
     * @param nom le nom du Pokémon
     * @param type le premier type du Pokémon
     * @param type2 le deuxième type du Pokémon
     * @param pv les points de vie du Pokémon
     * @param pc les points de combat du Pokémon
     */
    public Pokemon_evolution1(String nom, String type, String type2, int pv, int pc) {
        super(nom, type, type2, pv, pc);
    }

    /**
     * Méthode pour faire évoluer un Pokémon de la deuxième à la troisième évolution.
     * @param choixPokemon l'indice du Pokémon à faire évoluer dans les listes Evo1 et Evo2
     * @param Evo1 la liste des Pokémon de deuxième évolution
     * @param Evo2 la liste des Pokémon de troisième évolution
     * @return le Pokémon évolué
     */
    public static Pokemon_evolution2 evoluer2(int choixPokemon, List<Pokemon_evolution1> Evo1,
            List<Pokemon_evolution2> Evo2) {
        // Augmente les points de combat (PC) du Pokémon évolué en ajoutant 50 aux PC du
        // Pokémon de deuxième évolution
        Evo2.get(choixPokemon).setPC(Evo1.get(choixPokemon).getPc() + 50);
        // Augmente les points de vie (PV) du Pokémon évolué en ajoutant 50 aux PV du
        // Pokémon de deuxième évolution
        Evo2.get(choixPokemon).setPV(Evo1.get(choixPokemon).getPv() + 50);
        // Retourne le Pokémon évolué
        return Evo2.get(choixPokemon);
    }
}