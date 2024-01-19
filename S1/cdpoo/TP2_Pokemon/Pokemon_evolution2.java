package cdpoo.TP2_Pokemon;

/**
 * Cette classe représente une évolution d'un Pokémon.
 * Elle hérite de la classe Pokemon.
 */
public class Pokemon_evolution2 extends Pokemon {
    protected String nom;
    protected String type;
    protected String type2;
    protected int pv;
    protected int pc;
    /**
     * Constructeur pour un Pokémon avec une seule évolution.
     * @param nom le nom du Pokémon
     * @param type le type du Pokémon
     * @param pv les points de vie du Pokémon
     * @param pc les points de combat du Pokémon
     */
    public Pokemon_evolution2(String nom, String type, int pv, int pc) {
        super(nom, type, pv, pc);
    }

    /**
     * Constructeur pour un Pokémon avec deux types et une seule évolution.
     * @param nom le nom du Pokémon
     * @param type le premier type du Pokémon
     * @param type2 le deuxième type du Pokémon
     * @param pv les points de vie du Pokémon
     * @param pc les points de combat du Pokémon
     */
    public Pokemon_evolution2(String nom, String type, String type2, int pv, int pc) {
        super(nom, type,type2, pv, pc);
    }
}