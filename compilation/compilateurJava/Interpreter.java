package compilation.compilateurJava;

public class Interpreter {
    private int[] mem;  // Tableau de la pile
    private int sp;     // Pointeur de pile

    public Interpreter(int stackSize) {
        mem = new int[stackSize];
        sp = 0;  // Initialisation du pointeur de pile
    }

    // Méthodes pour effectuer des opérations sur la pile
    public void push(int value) {
        mem[sp++] = value;
    }

    public int pop() {
        return mem[--sp];
    }

    public int peek() {
        if (sp > 0) {
            return mem[sp - 1];
        } else {
            // Gérer le cas où la pile est vide
            throw new IllegalStateException("La pile est vide");
        }
    }

    public void execute(Instruction[] pCode) {
        int pc = 0;  // Pointeur d'instruction
        while (pc < pCode.length) {
            Instruction inst = pCode[pc];
            String operation = inst.getOperation();
            int value = inst.getValue();

            switch (operation) {
                case "ADD":
                    push(pop() + pop());
                    break;
                case "SUB":
                    push(pop() - pop());
                    break;
                case "MUL":
                    push(pop() * pop());
                    break;
                case "DIV":
                    push(pop() / pop());
                    break;
                case "EQL":
                    push(pop() == pop() ? 1 : 0);
                    break;
                case "NEQ":
                    push(pop() != pop() ? 1 : 0);
                    break;
                case "GTR":
                    push(pop() > pop() ? 1 : 0);
                    break;
                case "LSS":
                    push(pop() < pop() ? 1 : 0);
                    break;
                case "GEQ":
                    push(pop() >= pop() ? 1 : 0);
                    break;
                case "LEQ":
                    push(pop() <= pop() ? 1 : 0);
                    break;
                case "PRN":
                    System.out.println(pop()); // Imprime la valeur en haut de la pile
                    break;
                case "INN":
                    // Vous devrez mettre en place une entrée utilisateur pour lire un entier et le stocker au sommet de la pile
                    break;
                case "INT":
                    sp += value;  // Incrémente le pointeur de pile de la valeur
                    break;
                case "LDI":
                    push(value);  // Charge la valeur sur la pile
                    break;
                case "LDA":
                    // Vous devrez gérer l'opération pour empiler l'adresse
                    break;
                case "LDV":
                    // Vous devrez gérer l'opération pour charger la valeur à partir de l'adresse
                    break;
                case "STO":
                    // Vous devrez gérer l'opération pour stocker la valeur à l'adresse
                    break;
                case "BRN":
                    pc = value;  // Saute à l'instruction indiquée
                    break;
                case "BZE":
                    if (pop() == 0) {
                        pc = value;  // Saute à l'instruction indiquée si le sommet est 0
                    }
                    break;
                case "HLT":
                    return;  // Arrête l'exécution
                default:
                    // Gérez ici toute instruction inconnue ou non prise en charge
                    break;
            }

            pc++;  // Passe à l'instruction suivante
        }
    }

}