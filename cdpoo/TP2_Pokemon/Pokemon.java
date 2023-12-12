package cdpoo.TP2_Pokemon;

import java.io.Serializable;

public class Pokemon implements Serializable{
    protected String nom;
    protected String type;
    protected String type2;
    protected int pv;
    protected int pc;

    public Pokemon(String nom, String type, int pv, int pc) {
        this.nom = nom;
        this.type = type;
        this.pv = pv;
        this.pc = pc;
    }

    public Pokemon(String nom, String type, String type2, int pv, int pc) {
        this.nom = nom;
        this.type = type;
        this.type2 = type2;
        this.pv = pv;
        this.pc = pc;
    }

    public String getNom() {
        return this.nom;
    }

    public String getType() {
        return this.type;
    }

    public int getPv() {
        return this.pv;
    }

    public int getPc() {
        return this.pc;
    }

    public void setPC(int pc) {
        this.pc = pc;
    }

    public void setPV(int pv) {
        this.pv = pv;
    }

    @Override
    public String toString() {
        if (type2 != null) {
             return nom + " [type = " + type +", "+ type2 + ", pv = " + pv + ", pc= " + pc + "] \n";
        }
       else{
            return nom + " [type = " + type + ", pv = " + pv + ", pc= " + pc + "] \n";
       }
    }
 
    
}