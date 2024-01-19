package compilation.compilateurJava;

public class Instruction {
    
    private String operation;
    private int value;  // La valeur associée dépend de l'instruction

    public Instruction(String operation, int value) {
        this.operation = operation;
        this.value = value;
    }

    public String getOperation() {
        return operation;
    }

    public int getValue() {
        return value;
    }
    
}
