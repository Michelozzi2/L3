package atelier_2.question1_2;

import java.util.*;



public class Personne{
    private static final Adresse ADRESSE_INCONNUE = null;
    private String nom;
    private String prenom;
    private final GregorianCalendar dateNaissance;
    private Adresse adresse=ADRESSE_INCONNUE;
	private static int nbPersonne = 0;
	private static boolean resFinal = false;
	
	/**
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le pr�nom de la personne
	 * @param laDate la date de naissance de la personne
	 * @param lAdresse l'adresse de la personne
	 */
	public Personne(String leNom,String lePrenom, GregorianCalendar laDate, Adresse lAdresse){
		nom = leNom.toUpperCase();
		prenom=lePrenom;
		dateNaissance=laDate;
		adresse=lAdresse;
		nbPersonne ++ ;
	}
	
	/** 
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le pr�nom de la personne
	 * @param j le jour de naissance
	 * @param m le mois de naissance
	 * @param a l'ann�e de naissance
	 * @param numero le n� de la rue
	 * @param rue la rue
	 * @param code_postal le code postal de l'adresse
	 * @param ville la ville ou la personne habite
	 */
	public Personne(String leNom,String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville){
		this(leNom, lePrenom, new GregorianCalendar(j,m,a),new Adresse(numero,rue,code_postal,ville));
		
	}

	/**
	 * Accesseur
	 * @return retourne le nom
	 */
	public String getNom(){
		return nom;
	}
	/**
	 * Accesseur
	 * @return retourne le pr�nom
	 */
	public String getPrenom(){
		return prenom;
	}
	/**
	 * Accesseur
	 * @return retourne la date de naissance	 
	 */
	public GregorianCalendar getDateNaissance() {
		return dateNaissance;
	}
	/**
	 * Accesseur
	 * @return retourne l'adresse	 
	 */
	public Adresse getAdresse() {
		return adresse;
	}
	/**
	 * Modificateur
	 * @param retourne l'adresse	 
	 */
	public void setAdresse(Adresse a) {
		adresse=a;
	}
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String result="\nNom : "+ nom +  "\n"  +"Pr�nom : "   +  prenom+  "\n"  +  "N�(e) le : "+dateNaissance.get(Calendar.DAY_OF_MONTH)+
		"-"+ dateNaissance.get(Calendar.MONTH)   +  "-"  +  dateNaissance.get(Calendar.YEAR)  +  "\n" +   "Adresse : "+ adresse.toString() 
		+  "\n"  + "Nombre de peronne : " + nbPersonne ;
		return result;
	}


	/**
	 * La fonction vérifie si deux objets Personne sont égaux en comparant leurs attributs nom, prenom et
	 * dateNaissance.
	 * 
	 * @param obj Le paramètre obj est un objet dont nous comparons l'égalité avec l'objet actuel.
	 * @return La méthode renvoie une valeur booléenne.
	 */
	public boolean equals(Object obj) {

        boolean result = false;
        if((obj != null) && (obj instanceof Personne)) {
            Personne other = (Personne) obj;
            result = ((this.nom == other.nom)&&(this.prenom.equals(other.prenom)&&(this.dateNaissance.equals(other.dateNaissance))));
        }
        return result;

    }


	// La méthode `plusAgee` compare les dates de naissance de deux objets `Personne`. Il utilise la
	// méthode `compareTo` de la classe `GregorianCalendar` pour comparer les dates de naissance.
	public boolean plusAgee(Personne jPersonne) {
		int res = this.dateNaissance.compareTo(jPersonne.dateNaissance);

		if(res == 0) {
			resFinal = false;
		}
		else if(res == 1) {
			resFinal = false;
		}
		else if(res == -1) {
			resFinal = true;
		}
		return resFinal;

	}
}

    
   
   