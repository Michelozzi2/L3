package cdpoo.TP2_Pokemon;

import java.util.ArrayList;


public class GestionTypeCombat {

    private final static double[][] tableType=
    {
        {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.5,0.0,1.0,1.0,0.5},
        {1.0,0.5,0.5,2.0,1.0,2.0,1.0,1.0,1.0,1.0,1.0,2.0,0.5,1.0,0.5,1.0,2.0},
        {1.0,2.0,0.5,0.5,1.0,1.0,1.0,1.0,2.0,1.0,1.0,1.0,2.0,1.0,0.5,1.0,1.0},
        {1.0,0.5,2.0,0.5,1.0,1.0,1.0,0.5,2.0,0.5,1.0,0.5,2.0,1.0,0.5,1.0,0.5},
        {1.0,1.0,2.0,0.5,0.5,1.0,1.0,1.0,0.0,2.0,1.0,1.0,1.0,1.0,0.5,1.0,1.0},
        {1.0,0.5,0.5,2.0,1.0,0.5,1.0,1.0,2.0,2.0,1.0,1.0,1.0,1.0,2.0,1.0,0.5},
        {2.0,1.0,1.0,1.0,1.0,2.0,1.0,0.5,1.0,0.5,0.5,0.5,2.0,0.0,1.0,2.0,2.0},
        {1.0,1.0,1.0,2.0,1.0,1.0,1.0,0.5,0.5,1.0,1.0,1.0,0.5,0.5,1.0,1.0,0.0},
        {1.0,2.0,1.0,0.5,2.0,1.0,1.0,2.0,1.0,0.0,1.0,0.5,2.0,1.0,1.0,1.0,2.0},
        {1.0,1.0,1.0,2.0,0.5,1.0,2.0,1.0,1.0,1.0,1.0,2.0,0.5,1.0,1.0,1.0,0.5},
        {1.0,1.0,1.0,1.0,1.0,1.0,2.0,2.0,1.0,1.0,0.5,1.0,1.0,1.0,1.0,0.0,0.5},
        {1.0,0.5,1.0,2.0,1.0,1.0,0.5,0.5,1.0,0.5,2.0,1.0,1.0,0.5,1.0,2.0,0.5},
        {1.0,2.0,1.0,1.0,1.0,2.0,0.5,1.0,0.5,2.0,1.0,2.0,1.0,1.0,1.0,1.0,0.5},
        {0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0,1.0,2.0,1.0,0.5,0.5},
        {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0,0.5},
        {1.0,1.0,1.0,1.0,1.0,1.0,0.5,1.0,1.0,1.0,2.0,1.0,1.0,2.0,1.0,0.5,0.5},
        {1.0,0.5,0.5,1.0,1.0,2.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0,1.0,1.0,0.5}
    };
   
    private static ArrayList <Integer> type_def=new ArrayList<Integer>(2);

    //on asssocie chaque type à un numero pour acceder à 
    //la matrice des resistances
    public static int getNum(String type){
        if(type.equals("normal")){
            return 0;
        }
        else if(type.equals("feu")){
            return 1;
        }
        else if(type.equals("eau")){
            return 2;
        }
        else if(type.equals("plante")){
            return 3;
        }
        else if(type.equals("électrick")){
            return 4;
        }
        else if(type.endsWith("glace")){
            return 5;
        }
        else if(type.equals("combat")){
            return 6;
        }
        else if(type.equals("poison")){
            return 7;
        }
        else if(type.equals("sol")){
            return 8;
        }
        else if(type.equals("vol")){
            return 9;
        }
        else if(type.equals("psy")){
            return 10;
        }
        else if(type.equals("insecte")){
            return 11;
        }
        else if(type.equals("roche")){
            return 12;
        }
        else if(type.equals("spectre")){
            return 13;
        }
        else if(type.equals("dragon")){
            return 14;
        }
        else if(type.equals("ténèbres")){
            return 15;
        }
        //type acier
        else {
            return 16;
        }    
    }

    public static double[][] getTableType() {
        return tableType;
    }

    public static ArrayList<Integer> getType_def() {
        return type_def;
    }

    public static int attackOnline(Pokemon pokemon, String attType1, String attType2, String defType1, String defType2){
        ArrayList <Integer> type_def=new ArrayList<Integer>(2);
        int choix1=getNum(attType1);
        int choix2= attType2.equals("none") ? -1 : getNum(attType2);
        type_def.add(getNum(defType1));
        if(!defType2.equals("none")){
            type_def.add(getNum(defType2));
        }
        double typeEffectiveness = 1.0;
        if(type_def.size()==1){
            typeEffectiveness = tableType[choix1][type_def.get(0)];
            if(choix2 != -1) typeEffectiveness *= tableType[choix2][type_def.get(0)];
        }
        else{
            typeEffectiveness = tableType[choix1][type_def.get(0)] * tableType[choix1][type_def.get(1)];
            if(choix2 != -1) typeEffectiveness *= tableType[choix2][type_def.get(0)] * tableType[choix2][type_def.get(1)];
        }
        // Multiply the Pokemon's PC by the type effectiveness
        int damage = (int) Math.round(pokemon.getPc() * typeEffectiveness);
        return damage;
    }

}

    

