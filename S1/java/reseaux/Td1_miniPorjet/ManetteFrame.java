package reseaux.Td1_miniPorjet;

public class ManetteFrame {
    private float joystickX1;
    private float joystickY1;
    private float joystickX2;
    private float joystickY2;
    private boolean[] boutons;

    
    public ManetteFrame(float joystickX1, float joystickY1, float joystickX2, float joystickY2, boolean[] boutons) {
        this.joystickX1 = joystickX1;
        this.joystickY1 = joystickY1;
        this.joystickX2 = joystickX2;
        this.joystickY2 = joystickY2;
        this.boutons = boutons;
    }

    public float getJoystickX1() {
        return joystickX1;
    }

    public float getJoystickY1() {
        return joystickY1;
    }

    public float getJoystickX2() {
        return joystickX2;
    }

    public float getJoystickY2() {
        return joystickY2;
    }

    public boolean[] getBoutons() {
        return boutons;
    }

    
}
