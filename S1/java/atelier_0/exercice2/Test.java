package atelier_0.exercice2;

public class Test {

    public static void main(String[] args) {
        Vecteur3D v1 = new Vecteur3D(2, 9, 3);
        Vecteur3D v2 = new Vecteur3D(4, 3, 3);

        v1.afficher();
        v2.afficher();

        double norme1 = v1.calculerNorme();
        double norme2 = v2.calculerNorme();

        System.out.println("La norme de v1 : " + norme1);
        System.out.println("La norme de v2 : " + norme2);

        double produitScalaireInstance = v1.produitScalaire(v2);
        Vecteur3D sommVecteur3d = v1.sommVecteur(v2);

        System.out.println("Le produit scalaire : " + produitScalaireInstance);
        System.out.println("La somme de v1 et v2 : " + sommVecteur3d);
    }
}