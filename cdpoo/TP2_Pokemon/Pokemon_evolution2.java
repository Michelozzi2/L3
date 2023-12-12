package cdpoo.TP2_Pokemon;

public class Pokemon_evolution2 extends Pokemon {
    public Pokemon_evolution2(String nom, String type, int pv, int pc) {
        super(nom, type, pv, pc);
    }

    public Pokemon_evolution2(String nom, String type, String type2, int pv, int pc) {
        super(nom, type,type2, pv, pc);
    }
}