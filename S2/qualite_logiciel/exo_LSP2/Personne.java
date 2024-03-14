package qualite_logiciel.exo_LSP2;

public class Personne {
	 private boolean estProf;
	 private String nom;
	 
	 public Personne(boolean estProf, String name) {
			super();
			this.estProf = estProf;
			this.nom = name;
		}
	public void sePresente( String msg ) {
		System.out.println(msg);
	}
	public boolean estProf() {
		return estProf;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}	
	
}
