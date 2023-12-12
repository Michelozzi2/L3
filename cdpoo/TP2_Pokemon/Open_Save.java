package cdpoo.TP2_Pokemon;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Open_Save {
    public Dresseur ouvrirSave(String fichier) {
        Dresseur d = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fichier))) {
            d = (Dresseur) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return d;
    }
}