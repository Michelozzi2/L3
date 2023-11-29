package cdpoo.TD4.exo6;

import java.util.Comparator;

public class MilitaireComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int diff = o1.length() - o2.length();
        return (diff != 0) ? diff : o1.compareToIgnoreCase(o2);
    }
}
