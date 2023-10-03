package atelier_0.exercice2;

public class Vecteur3D {

    private double x;
    private double y;
    private double z;

    public Vecteur3D(double x, double y, double z){

        this.x = x;
        this.y = y;
        this.z = z;

    }

    public Vecteur3D(){

        //this.x = 0;
        //this.y = 0;
        //this.z = 0;
        this(0 , 0 , 0);
    }

    public void afficher(){

        System.out.println("<"+ x + "," + y + "," + z + ">");
       

    }


    public double calculerNorme(){
        
        return Math.sqrt(x * x + y * y + z * z);
        

    }



    public double produitScalaire(Vecteur3D secondVecteur){

        return x * secondVecteur.x + y * secondVecteur.y + z * secondVecteur.z;

    }



    public Vecteur3D sommVecteur(Vecteur3D secondVecteur){


        return new Vecteur3D(x + secondVecteur.x , y + secondVecteur.y , z + secondVecteur.z);

    }



    // Méthode statique pour calculer le produit scalaire de deux vecteurs (méthode de classe)
    public static double produitScalaire(Vecteur3D v1, Vecteur3D v2) {

        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;

    }



    // Méthode statique pour calculer la somme de deux vecteurs (méthode de classe)
    public static Vecteur3D sommVecteur(Vecteur3D v1, Vecteur3D v2) {

        return new Vecteur3D(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);


    }




    public String toString() {
        return "<" + x + ", " + y + ", " + z + ">";
    }


}



