package cdpoo.TD4.exo4;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetList {
    public static void main(String[] args) {
        Set<Integer> entiers = new TreeSet<Integer>();
        for (int i = 0; i < 1000; i++) {
            entiers.add((int) (Math.random() * 10));
        }
        System.out.println(entiers);
    }
    
}
