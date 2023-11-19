package compilation.compilateurJava;

public class InterpreterTest {
    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter(100);

        // Tableau d'instructions P-CODE avec de nouvelles instructions
        Instruction[] pCode = {
            new Instruction("LDI", 2),
            new Instruction("LDI", 2),
            new Instruction("ADD", 0),
            new Instruction("LDI", 2),
            new Instruction("MUL", 0),
            new Instruction("LDA", 10),
            new Instruction("STO", 0),
            new Instruction("LDA", 10),
            new Instruction("LDV", 0),
            new Instruction("PRN", 0),
            new Instruction("HLT", 0)
        };

        interpreter.execute(pCode);

        // Affiche le résultat en haut de la pile
        System.out.println("Résultat : " + interpreter.peek());
    }
}