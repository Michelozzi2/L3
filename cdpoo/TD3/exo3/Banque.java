package cdpoo.TD3.exo3;

public class Banque {
    int solde;

    public Banque(int solde) {
        this.solde = solde;
    }

    public int getSolde() {
        return solde;
    }

    public int retrait(int somme) throws RetraitException {
        if (somme > this.solde)
            throw new RetraitException("solde insuffisant");
        else
        return this.solde -= somme;
        
    }
    
}
