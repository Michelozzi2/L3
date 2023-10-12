package reseaux.miniPorjet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ManetteFrameSerializer {

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
