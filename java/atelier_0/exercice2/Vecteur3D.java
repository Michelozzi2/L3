package atelier_0.exercice2;

public class Vecteur3D {

    private double x;
    private double y;
    private double z;

    // Le code `public Vecteur3D(double x, double y, double z)` est un constructeur pour la classe
    // Vecteur3D. Il prend trois paramètres « x », « y » et « z » et les affecte aux variables
    // d'instance correspondantes « this.x », « this.y » et « this.z ». Ce constructeur vous permet de
    // créer un nouvel objet Vecteur3D et d'initialiser ses valeurs x, y et z en une seule étape.
    public Vecteur3D(double x, double y, double z){

        this.x = x;
        this.y = y;
        this.z = z;

    }

    // Le code `public Vecteur3D(){...}` est un constructeur pour la classe Vecteur3D. Il crée un
    // nouvel objet de type Vecteur3D avec des valeurs par défaut pour x, y et z.
    public Vecteur3D(){

        //this.x = 0;
        //this.y = 0;
        //this.z = 0;
        this(0 , 0 , 0);
    }

    /**
     * La fonction "afficher" imprime les valeurs des variables x, y et z au format "<x, y, z>".
     */
    public void afficher(){

        System.out.println("<"+ x + "," + y + "," + z + ">");
       

    }

   /**
    * La fonction calcule la norme d'un vecteur 3D à l'aide de la formule de distance euclidienne.
    * 
    * @return La méthode renvoie la norme calculée d'un vecteur, qui est la racine carrée de la somme
    * des carrés de ses composantes (x, y et z).
    */
    public double calculerNorme(){
        
        return Math.sqrt(x * x + y * y + z * z);
    
    }


    /**
     * La fonction calcule le produit scalaire de deux vecteurs 3D.
     * 
     * @param secondVecteur Le paramètre "secondVecteur" est un objet Vecteur3D représentant le
     * deuxième vecteur avec lequel vous souhaitez calculer le produit scalaire.
     * @return La méthode renvoie le produit scalaire du vecteur actuel et du deuxième vecteur.
     */
    public double produitScalaire(Vecteur3D secondVecteur){

        return x * secondVecteur.x + y * secondVecteur.y + z * secondVecteur.z;

    }


   /**
    * La fonction "sommVecteur" prend un deuxième vecteur et renvoie un nouveau vecteur qui est la
    * somme des deux vecteurs d'entrée.
    * 
    * @param secondVecteur Le paramètre "secondVecteur" est un objet de type Vecteur3D, qui représente
    * un vecteur tridimensionnel.
    * @return La méthode renvoie une nouvelle instance de la classe Vecteur3D avec les valeurs x, y et
    * z de l'instance actuelle ajoutées aux valeurs x, y et z du paramètre secondVecteur.
    */
    public Vecteur3D sommVecteur(Vecteur3D secondVecteur){


        return new Vecteur3D(x + secondVecteur.x , y + secondVecteur.y , z + secondVecteur.z);

    }


    // Méthode statique pour calculer le produit scalaire de deux vecteurs (méthode de classe)
   /**
    * La fonction calcule le produit scalaire de deux vecteurs 3D.
    * 
    * @param v1 Un objet Vecteur3D représentant le premier vecteur.
    * @param v2 Le code ci-dessus définit une méthode appelée "produitScalaire" qui prend deux
    * paramètres de type "Vecteur3D" (qui je suppose est une classe personnalisée représentant un
    * vecteur 3D). La méthode calcule le produit scalaire des deux vecteurs et renvoie le résultat sous
    * forme de double.
    * @return La méthode renvoie le produit scalaire de deux vecteurs 3D.
    */
    public static double produitScalaire(Vecteur3D v1, Vecteur3D v2) {

        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;

    }



    // Méthode statique pour calculer la somme de deux vecteurs (méthode de classe)
    /**
     * La fonction "sommVecteur" prend deux vecteurs 3D en entrée et renvoie leur somme sous forme d'un
     * nouveau vecteur 3D.
     * 
     * @param v1 Le premier vecteur (v1) est un objet Vecteur3D de coordonnées (x1, y1, z1).
     * @param v2 Le paramètre v2 est un objet Vecteur3D, qui représente un vecteur tridimensionnel. Il
     * comporte trois composantes : x, y et z.
     * @return La méthode renvoie une nouvelle instance de la classe Vecteur3D avec les composants x, y
     * et z de v1 et v2 additionnés.
     */
    public static Vecteur3D sommVecteur(Vecteur3D v1, Vecteur3D v2) {

        return new Vecteur3D(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);


    }


    /**
     * La fonction toString() renvoie une représentation sous forme de chaîne des coordonnées x, y et z
     * d'un objet.
     * 
     * @return La méthode renvoie une représentation sous forme de chaîne des coordonnées de l'objet au
     * format "<x, y, z>".
     */
    public String toString() {
        return "<" + x + ", " + y + ", " + z + ">";
    }


}



