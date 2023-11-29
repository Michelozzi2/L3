package cdpoo.TD2.exo11;

public class Voiture {
    private String modele;
    private String puissance;
    private Personne pilote;
    private Personne coPilote;

    public Voiture(String modele, String puissance) {
        this.modele = modele;
        this.puissance = puissance;
    }

    public String getModele() {
        return modele;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPilote(Personne pilote) {
        this.pilote = pilote;
    }

    public void setCoPilote(Personne coPilote) {
        this.coPilote = coPilote;
    }

    public Personne getPilote() {
        return pilote;
    }

    public Personne getCoPilote() {
        return coPilote;
    }

    public String toString(){
		String result="\nModele : "+ modele + "\nPuissance : " + puissance;
		return result;
	}
}
