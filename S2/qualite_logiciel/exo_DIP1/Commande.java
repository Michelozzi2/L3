package qualite_logiciel.exo_DIP1;

public class Commande {
	
	private double taux;
	private double montantHT;
	
	public Commande(TVA tva) {
		this.taux = tva.getTaux();
	}
	
	public double getTotalTTC() {
		return (taux+1)*montantHT;	
	}
}
