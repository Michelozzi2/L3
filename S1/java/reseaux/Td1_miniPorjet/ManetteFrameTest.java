package reseaux.Td1_miniPorjet;

import java.util.Arrays;

public class ManetteFrameTest {
    public static void main(String[] args) {
        // Création d'une instance de ManetteFrame
        float joystickX1 = 0.75f;
        float joystickY1 = 0.5f;
        float joystickX2 = 0.2f;
        float joystickY2 = 0.9f;
        boolean[] boutons = {true, false, true, false, false, true, false, true, true};

        ManetteFrame frame = new ManetteFrame(joystickX1, joystickY1, joystickX2, joystickY2, boutons);

        // Sérialisation de la frame
        byte[] serializedData = ManetteFrameSerializer.serializeManetteFrame(frame);

        for (int i = 0; i < serializedData.length; i++) {
                System.out.println(serializedData[i]);
        }
        

        // Désérialisation de la frame
        ManetteFrame deserializedFrame = ManetteFrameSerializer.deserializeManetteFrame(serializedData);

        // Vérification des données désérialisées
        if (deserializedFrame != null) {
            System.out.println("Joystick X1: " + deserializedFrame.getJoystickX1());
            System.out.println("Joystick Y1: " + deserializedFrame.getJoystickY1());
            System.out.println("Joystick X2: " + deserializedFrame.getJoystickX2());
            System.out.println("Joystick Y2: " + deserializedFrame.getJoystickY2());
            System.out.println("Boutons: " + Arrays.toString(deserializedFrame.getBoutons()));
        } else {
            System.out.println("Échec de la désérialisation.");
        }
    }
    
}
