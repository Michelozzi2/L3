package reseaux.Td1_miniPorjet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ManetteFrameSerializer {

   /**
    * La fonction `serializeManetteFrame` prend un objet `ManetteFrame` et sérialise ses données dans
    * un tableau d'octets.
    * 
    * @param frame Le paramètre "frame" est un objet de type "ManetteFrame". Il représente une trame de
    * données provenant d'un contrôleur de jeu (manette) et contient des informations telles que les
    * positions du joystick et l'état des boutons.
    * @return La méthode renvoie un tableau d'octets.
    */
    public static byte[] serializeManetteFrame(ManetteFrame frame) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

            dataOutputStream.writeFloat(frame.getJoystickX1());
            dataOutputStream.writeFloat(frame.getJoystickY1());
            dataOutputStream.writeFloat(frame.getJoystickX2());
            dataOutputStream.writeFloat(frame.getJoystickY2());

            for (boolean bouton : frame.getBoutons()) {
                dataOutputStream.writeBoolean(bouton);
            }

            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * La fonction deserializeManetteFrame prend un tableau d'octets en entrée et renvoie un objet
     * ManetteFrame en lisant et en extrayant les données du tableau d'octets.
     * 
     * @param data Le paramètre "data" est un tableau d'octets qui contient les données sérialisées
     * d'un objet ManetteFrame.
     * @return La méthode renvoie un objet ManetteFrame.
     */
    public static ManetteFrame deserializeManetteFrame(byte[] data) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

            float joystickX1 = dataInputStream.readFloat();
            float joystickY1 = dataInputStream.readFloat();
            float joystickX2 = dataInputStream.readFloat();
            float joystickY2 = dataInputStream.readFloat();

            boolean[] boutons = new boolean[9];
            for (int i = 0; i < 9; i++) {
                boutons[i] = dataInputStream.readBoolean();
            }

            dataInputStream.close();

            return new ManetteFrame(joystickX1, joystickY1, joystickX2, joystickY2, boutons);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    
}
