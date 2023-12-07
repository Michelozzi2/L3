package cdpoo.TD6.exo1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialiser {
    public void serialize(Personne p, String filename) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(p);
            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
