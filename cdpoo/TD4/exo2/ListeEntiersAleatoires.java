package cdpoo.TD4.exo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class ListeEntiersAleatoires {
    
        public static void main(String[] args) {
            List<Integer> entiers = new ArrayList<Integer>(100);
            // L'extrait de code `for (int i = 0; i < 100; i++) { entiers.add((int) (Math.random() *
            // 100)); }` est une boucle qui itère 100 fois.
            for (int i = 0; i < 100; i++) {
                entiers.add((int) (Math.random() * 1000));
            }
            System.out.println(entiers);
            Collections.sort(entiers);
            System.out.println(entiers);

        }
    
}
