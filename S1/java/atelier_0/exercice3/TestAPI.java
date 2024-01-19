package atelier_0.exercice3;

/*
Question3.1)
1)
Cette classe possede 2 attributs E, PI de type double.



2)
-Les attributs de la classe Math sont en fait des constantes (variables finales) 
qui sont utilisées pour certaines opérations mathématiques, telles que qui Math.PIreprésentent 
la valeur de π.

-Les méthodes de la classe Math sont toutes statiques, ce qui signifie qu'elles peuvent être appelées directement 
sur la classe elle-même, sans avoir besoin d'instancier un objet Math. Ces méthodes assurent des 
opérations mathématiques de base telles que des fonctions trigonométriques, des logarithmes, des racines carrées, etc.



3)
La méthode permettant de générer un nombre aléatoire compris entre 0 et 1 est Math.random(). 
Elle a la signature suivante :

public static double random()

C'est une méthode de classe.




4)
Il y a 4 méthodes nommées "max" dans la classe Math :

La première permet de trouver le maximum entre deux valeurs :

-public static int max(int a, int b)

La seconde permet de trouver le maximum entre deux valeurs de type long:

-public static long max(long a, long b)

-public static double max(double a, double b)

-public static float max(float a, float b)

Les différences résidentes dans le type des paramètres (int, long, double et float).


5)
a) L'instruction int x = Math.max(5);n'est pas correcte au niveau syntaxique, 
car la méthode max nécessite deux arguments. Vous devez définir deux valeurs pour obtenir le maximum entre elles. 

b) L'instruction int x = Math.max(5, 6);est correcte. 
La valeur finale de la variable x sera 6, car c'est le maximum entre 5 et 6.


Question3.2)
1)
La méthode compareTode la classe String à la signature suivante :

public int compareTo(String anotherString)

Il s'agit d'une méthode d'instance.



2)
L'instruction String res = String.compareTo("bonjour");n'est pas correcte pour au moins deux raisons :

-compareTo est une méthode d'instance, vous devez l'appeler sur une instance de la classe String, 
par exemple :"hello".compareTo("bonjour");
-La méthode compareTo compare deux chaînes de caractères et retourne un résultat entier qui indique la relation 
lexicographique entre les deux chaînes. 
Dans l'instruction incorrecte, on essaye de  stocker le résultat dans une variable String, alors que le résultat 
est de type int. 
Il faudrait plutôt déclarer la variable res comme un int pour stocker correctement le résultat.


3)
La méthode lengthde la classe String à la signature suivante :

public int length()

Il s'agit d'une méthode d'instance.


4)
L'instruction int lg = String.length(st);n'est pas correcte, car la méthode lengthdoit être appelée directement 
sur l'instance de la chaîne.

int lg = st.length();


*/

public class TestAPI {
    public static void main(String[] args) {
        // Afficher le nombre PI
        System.out.println("PI : " + Math.PI);

        // Afficher un nombre réel aléatoire entre 0 et 1 (exclu)
        double randomReal = Math.random();
        System.out.println("Nombre réel aléatoire : " + randomReal);

        // Afficher un nombre entier aléatoire entre 1 et 3 (inclus)
        int randomInt = (int) (Math.random() * 3) + 1;
        System.out.println("Nombre entier aléatoire : " + randomInt);

        // Définir deux variables entières x1 et x2, les initialiser et afficher le plus grand
        int x1 = 10;
        int x2 = 5;
        int max = Math.max(x1, x2);
        System.out.println("Le plus grand entre x1 et x2 : " + max);

        // Définir deux variables String n1 et n2, les initialiser et afficher le premier selon l'ordre alphabétique
        String n1 = "apple";
        String n2 = "banana";
        int comparisonResult = n1.compareTo(n2);
        if (comparisonResult < 0) {
            System.out.println("n1 est avant n2 dans l'ordre alphabétique.");
        } else if (comparisonResult > 0) {
            System.out.println("n2 est avant n1 dans l'ordre alphabétique.");
        } else {
            System.out.println("n1 et n2 sont égaux dans l'ordre alphabétique.");
        }
    }
}