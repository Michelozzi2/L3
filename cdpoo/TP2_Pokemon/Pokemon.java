package cdpoo.TP2_Pokemon;

import java.io.Serializable;
import java.util.List;

/**
 * Cette classe représente un Pokémon.
 */
public class Pokemon implements Serializable {
    protected String nom;
    protected String type;
    protected String type2;
    protected int pv;
    protected int pvSave;
    protected int pc;

    /**
     * Constructeur de la classe Pokemon.
     * 
     * @param nom  le nom du Pokémon
     * @param type le type du Pokémon
     * @param pv   les points de vie du Pokémon
     * @param pc   les points de combat du Pokémon
     */
    public Pokemon(String nom, String type, int pv, int pc) {
        this.nom = nom;
        this.type = type;
        this.pv = pv;
        this.pc = pc;
    }

    /**
     * Constructeur de la classe Pokemon.
     * 
     * @param nom   le nom du Pokémon
     * @param type  le type du Pokémon
     * @param type2 le deuxième type du Pokémon
     * @param pv    les points de vie du Pokémon
     * @param pc    les points de combat du Pokémon
     */
    public Pokemon(String nom, String type, String type2, int pv, int pc) {
        this.nom = nom;
        this.type = type;
        this.type2 = type2;
        this.pv = pv;
        this.pc = pc;
    }

    /**
     * Retourne le nom du Pokémon.
     * 
     * @return le nom du Pokémon
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Retourne le type du Pokémon.
     * 
     * @return le type du Pokémon
     */
    public String getType() {
        return this.type;
    }

    /**
     * Retourne le deuxième type du Pokémon.
     * 
     * @return le deuxième type du Pokémon
     */
    public String getType2() {
        return this.type2;
    }

    /**
     * Retourne les points de vie du Pokémon.
     * 
     * @return les points de vie du Pokémon
     */
    public int getPv() {
        return this.pv;
    }

    /**
     * Retourne les points de combat du Pokémon.
     * 
     * @return les points de combat du Pokémon
     */
    public int getPc() {
        return this.pc;
    }

    /**
     * Modifie les points de combat du Pokémon.
     * 
     * @param pc les nouveaux points de combat du Pokémon
     */
    public void setPC(int pc) {
        this.pc = pc;
    }

    /**
     * Modifie les points de vie du Pokémon.
     * 
     * @param pv les nouveaux points de vie du Pokémon
     */
    public void setPV(int pv) {
        this.pv = pv;
    }

    public void setPvSave(int pvSave) {
        this.pvSave = pvSave;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du Pokémon.
     * 
     * @return la représentation du Pokémon
     */
    @Override
    public String toString() {
        if (type2 != null) {
            return nom + " [type = " + type + ", " + type2 + ", pv = " + pv + ", pc= " + pc + "] \n";
        } else {
            return nom + " [type = " + type + ", pv = " + pv + ", pc= " + pc + "] \n";
        }
    }

    /**
     * Méthode pour faire évoluer un Pokémon de la première à la deuxième évolution.
     * 
     * @param choixPokemon      l'indice du Pokémon à faire évoluer
     * @param nonEvoPokemons    la liste des Pokémon non évolués
     * @param pokemonEvolution1 la liste des Pokémon de première évolution
     * @return le Pokémon évolué
     */
    public static Pokemon_evolution1 evoluer1(int choixPokemon, List<Pokemon> nonEvoPokemons,
            List<Pokemon_evolution1> pokemonEvolution1) {
        // Augmente les points de combat (PC) du Pokémon évolué en ajoutant 50 aux PC à
        // ceux deja existant du pokemon non évolué
        // Pokémon non évolué
        pokemonEvolution1.get(choixPokemon).setPC(nonEvoPokemons.get(choixPokemon).getPc() + 50);
        // Augmente les points de vie (PV) du Pokémon évolué en ajoutant 50 aux PV à
        // ceux deja existant du pokemon non évolué
        pokemonEvolution1.get(choixPokemon).setPV(nonEvoPokemons.get(choixPokemon).getPv() + 50);
        // Retourne le Pokémon évolué
        return pokemonEvolution1.get(choixPokemon);
    }

    public int attaque(Pokemon pokemon) {
        pokemon.setPV(pokemon.getPv() - this.getPc());
        return 0;
    }
}