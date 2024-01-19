/**
 * La classe `Utilisateur` représente un utilisateur avec des propriétés telles
 * que le nom
 * d'utilisateur, le solde, le statut de l'abonnement et l'accès HD.
 */
public class Utilisateur {
    private String nomUtilisateur;
    private String email;
    private double solde;
    private boolean estAbonne;
    private boolean aUnAccesHD;

    // Le `public Utilisateur(String nomUtilisateur)` est une méthode constructeur
    // pour la classe
    // `Utilisateur`. Il permet de créer une nouvelle instance de la classe
    // `Utilisateur` et
    // d'initialiser ses propriétés.
    public Utilisateur(String nomUtilisateur, String email) {
        this.nomUtilisateur = nomUtilisateur;
        this.email = email;
        this.solde = 0.0;
        this.estAbonne = false;
        this.aUnAccesHD = false;
    }

    /**
     * La fonction "ajouterAuSolde" ajoute un montant donné au solde actuel.
     * 
     * @param montant Le paramètre "montant" est une variable de type double qui
     *                représente le montant
     *                à ajouter au solde courant.
     */
    public void ajouterAuSolde(double montant) {
        solde += montant;
    }

    public double getSolde() {
        return solde;
    }

    public boolean estAbonne() {
        return estAbonne;
    }

    public void souscrireAbonnement() {
        estAbonne = true;
    }

    public void resilierAbonnement() {
        estAbonne = false;
    }

    public boolean aUnAccesHD() {
        return aUnAccesHD;
    }

    public void activerAccesHD() {
        aUnAccesHD = true;
    }

    public void desactiverAccesHD() {
        aUnAccesHD = false;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public boolean isEstAbonne() {
        return estAbonne;
    }

    public void setEstAbonne(boolean estAbonne) {
        this.estAbonne = estAbonne;
    }

    public boolean isaUnAccesHD() {
        return aUnAccesHD;
    }

    public void setaUnAccesHD(boolean aUnAccesHD) {
        this.aUnAccesHD = aUnAccesHD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nUtilisateur [nomUtilisateur=" + nomUtilisateur + ", solde=" + solde + ", estAbonne=" + estAbonne
                + ", aUnAccesHD=" + aUnAccesHD + "]";
    }
}


