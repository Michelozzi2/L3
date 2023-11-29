package cdpoo.TD2.exo13;

public class TestAnnotation {

        public TestAnnotation(){}
        
        @Deprecated
        public static int oldMethod() {
            System.out.println("Cette methode n'est plus utiles");
            return 0;
        }
        
        public static void main(String[] args) {
            // Appel de la méthode dépréciée
            oldMethod();
        }
        
    }