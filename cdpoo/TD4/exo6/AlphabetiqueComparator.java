package cdpoo.TD4.exo6;

import java.util.Comparator;


public class AlphabetiqueComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
}
