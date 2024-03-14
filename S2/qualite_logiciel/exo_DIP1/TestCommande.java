package qualite_logiciel.exo_DIP1;

public class TestCommande {

	public static void main(String[] args) {
		Commande c1= new Commande(new TVANormal());
		System.out.println("Cas Normal: Montant TTC = " + c1.getTotalTTC());
		c1= new Commande(new TVALuxe());
		System.out.println("Cas Luxe : Montant TTC= " + c1.getTotalTTC());
	}

}
