package qualite_logiciel.exo_LSP2;

public class PresencesProf extends PresencesCours {
	public void arriveEnCours(Personne p ) {	  
		  if ( p.estProf() ) {
			 signalerArrivee(p);
		     enregistreArrivee(p);
		     presenterCours(p );	
		  }	  
	 }
	 private void presenterCours(Personne p) {
			p.sePresente(p.getNom()+" est enseignant dans ce cours");
	 }
}
