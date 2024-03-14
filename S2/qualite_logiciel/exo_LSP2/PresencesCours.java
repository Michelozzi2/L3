package qualite_logiciel.exo_LSP2;

import java.util.HashMap;

public class PresencesCours extends Presences {
	private int numArrivee = 0;
	private HashMap<String, Integer> registre = new HashMap<String, Integer>();

	public void arriveEnCours(Personne p) {
		/* Post-condition?? */
		signalerArrivee(p);
		enregistreArrivee(p);
	}

	protected void enregistreArrivee(Personne p) {
		numArrivee++;
		registre.put(p.getNom(), numArrivee);
	}

	protected void signalerArrivee(Personne p) {
		p.sePresente(p.getNom()+" entre en cours");
	}
	

	public String toString() {
		return "Presences en cours [registre=" + registre + "]";
	}

}
