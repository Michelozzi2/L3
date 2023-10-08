package atelier_0.exercice1;

public class Robot {
    String refRobot = "ROB", nomRobot;
    int x, y;
    int orientation;
    public final static int NORD = 1, SUD = 2, EST = 3, OUEST = 4;
    static int nbRobot ;

    // Le constructeur `public Robot(String nomRobot, int x, int y, int orientation)` crée une nouvelle
    // instance de la classe `Robot` avec les paramètres donnés. Il initialise les variables d'instance
    // `nomRobot`, `x`, `y` et `orientation` avec les valeurs correspondantes passées en arguments. Il
    // incrémente également la variable `nbRobot` de 1 et l'ajoute à la chaîne `refRobot` pour créer
    // une référence unique pour le robot.
    public Robot(String nomRobot, int x, int y, int orientation){

        this.nomRobot = nomRobot;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        nbRobot += 1;
        refRobot += nbRobot;


    }

    // L'extrait de code est un constructeur pour la classe `Robot`. Il crée une nouvelle instance de
    // la classe `Robot` avec le paramètre `nomRobot` donné. Il initialise la variable `nomRobot` avec
    // la valeur passée en argument, définit les coordonnées `x` et `y` à 0, incrémente la variable
    // `nbRobot` de 1 et l'ajoute à la chaîne `refRobot` pour créer un unique référence pour le robot.
    // Enfin, il définit la variable `orientation` à la valeur de `NORD` (qui est une constante définie
    // dans la classe).
    public Robot(String nomRobot){

        this(nomRobot, 0, 0, Robot.NORD); //(appel au constructeur precedent)
        /* 
        this.nomRobot = nomRobot;
        this.x = 0;
        this.y = 0;
        nbRobot +=1;
        refRobot += nbRobot;
        this.orientation = NORD;
        */
        
        
    }



   /**
    * La fonction modifie l'orientation d'un objet.
    * 
    * @param modOrientation Le paramètre modOrientation est un entier qui représente la valeur
    * d'orientation modifiée.
    */
    public void modificationOrientation(int modOrientation){

        this.orientation = modOrientation;

    }


   /**
    * La fonction "déplacer" déplace un objet dans une direction précise (NORD, EST, SUD ou OUEST) et
    * garantit que les coordonnées ne deviennent pas négatives.
    */
    public void deplacer() {
        switch (orientation) {
            case NORD: // NORD
                y++;
                break;
            case EST: // EST
                x++;
                break;
            case SUD: // SUD
                y--;
                break;
            case OUEST: // OUEST
                x--;
                break;
        }

        // Vérifier que les coordonnées ne deviennent pas négatives
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
    }


   /**
    * La fonction "afficheToi" imprime le nom, la référence, les coordonnées et l'orientation d'un
    * robot.
    */
    public void afficheToi(){

        System.out.println(nomRobot +","+ refRobot);
        System.out.println(x);
        System.out.println(y);
        System.out.println(orientation);

    }


    /**
     * La fonction toString() renvoie une représentation sous forme de chaîne du nom, de la position et
     * de l'orientation du robot.
     * 
     * @return La méthode renvoie une représentation sous forme de chaîne du nom, de la position
     * (coordonnées x et y) et de l'orientation du robot.
     */
    public String toString() {
        return "Nom: " + nomRobot + ", Position X: " + x + ", Position Y: " + y + ", Orientation: " + orientation;
    }


    
}
