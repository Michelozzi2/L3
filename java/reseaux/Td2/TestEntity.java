package reseaux.Td2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class TestEntity {
    public static void main(String[] args) {
        Entity2D ent_1 = new Entity2D("test1", 0.0f, 0.0f);
        ent_1.putItem(5);
        ent_1.putItem(7);
        ent_1.putItem(-1);
        ObjectOutputStream oos = null;

        // Writing into a file
        try {
            FileOutputStream fichier = new FileOutputStream("donnees.ser");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(ent_1);
            oos.flush();
            oos.close();
            fichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // How long is the file?
        File saved = new File("donnees.ser");
        System.out.println("Taille du fichier : " + saved.length() + " octets");
        System.out.println(ent_1);
        
        // À compléter...

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

            // Sérialisation en utilisant la méthode toBytes
            ent_1.toBytes(dataOutputStream);

            // Afficher la taille du paquet transféré
            int packetSize = byteArrayOutputStream.size();
            System.out.println("Taille du paquet transféré : " + packetSize + " octets");

            // Vous pouvez maintenant envoyer byteArrayOutputStream.toByteArray() sur le réseau.

            // Exemple de désérialisation (lecture du paquet)
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            Entity2D deserializedEntity = Entity2D.fromBytes(dataInputStream);

            System.out.println("Entity2D désérialisée : " + deserializedEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    

        // Deserialization
        
                
                
                
        // Entity2D deserializedEntity = null;
        // try {
        //     FileInputStream fichier = new FileInputStream("donnees.ser");
        //     ObjectInputStream ois = new ObjectInputStream(fichier);
        //     deserializedEntity = (Entity2D) ois.readObject();
        //     ois.close();
        //     fichier.close();
        // } catch (IOException | ClassNotFoundException e) {
        //     e.printStackTrace();
        // }
        
                
                
    }
}
