package cdpoo.TP2_Pokemon;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Save_dresseur {
    public void enregistrerDresseur(Dresseur personne, String fichier) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichier))) {
            out.writeObject(personne);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}