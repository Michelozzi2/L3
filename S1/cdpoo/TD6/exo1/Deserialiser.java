package cdpoo.TD6.exo1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;



public class Deserialiser {
    public Personne Deserialise(String filename) {
        Personne p = null;
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInput in = new ObjectInputStream(file);
            p =(Personne) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return p;
    }

}
