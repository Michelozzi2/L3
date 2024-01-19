package cdpoo.TD4.exo5;

import java.util.Map;
import java.util.HashMap;

public class HashMapList {
    public static void main(String[] args) {
            Map<Integer, String> tableau = new HashMap<Integer, String>();
            tableau.put(20191218, "Buteau Lucia");
            tableau.put(20190628, "CASTELLI SERENA");
            tableau.put(20190556, "JOND JEAN");
            tableau.put(20192688, "LEFEVRE JULIEN");
            tableau.put(20190628, "MARIACCIA MARIE-DOMINIQUE");
            tableau.put(20190707, "MORETTI PIERRE-FRANCOIS");

            System.out.println(tableau);
    }
    
}
