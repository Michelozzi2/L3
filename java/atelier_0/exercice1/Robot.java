package atelier_0.exercice1;

public class Robot {
    String refRobot = "ROB", nomRobot;
    int x, y;
    int orientation;
    public final static int NORD = 1, SUD = 2, EST = 3, OUEST = 4;
    static int nbRobot ;

    public Robot(String nomRobot, int x, int y, int orientation){

        this.nomRobot = nomRobot;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        nbRobot += 1;
        refRobot += nbRobot;


    }

    public Robot(String nomRobot){

        this.nomRobot = nomRobot;
        this.x = 0;
        this.y = 0;
        nbRobot +=1;
        refRobot += nbRobot;
        this.orientation = NORD;
        //this(nomRobot, x: 0,y: 0, Robot.NORD); (appel au constructeur precedent)

    }



    public void modificationOrientation(int modOrientation){

        this.orientation = modOrientation;

    }




    public void deplacer(){
        if(orientation == NORD){
            y+= 1;
        }
        else if (orientation == SUD && y > 0){
            y-= 1;
        }
        else if (orientation == EST){
            x += 1;
        }
        else if(orientation == OUEST && x > 0){
            x -= 1;
        }



        if (x > 0 && y > 0  )
        {
            if (orientation == NORD)
            {
                y += 1;
            }
            else if (orientation == SUD)
            {
                y -= 1;   
            }
            else if (orientation == EST)
            {
                x += 1;
            }
            else if (orientation == OUEST)
            {
                x -= 1;
            }
        }
        else
        {
           if (orientation == NORD)
           {
            y += 1;
           }
           else if (orientation == EST)
           {
            x += 1;
           }
           else
           {
            System.out.println("Erreur pas de coordonnés negatives");
           }
        }

    }



    public void afficheToi(){

        System.out.println(nomRobot +","+ refRobot);
        System.out.println(x);
        System.out.println(y);
        System.out.println(orientation);




    }


    public String toString() {
        return "Nom: " + nomRobot + ", Position X: " + x + ", Position Y: " + y + ", Orientation: " + orientation;
    }


    
}
