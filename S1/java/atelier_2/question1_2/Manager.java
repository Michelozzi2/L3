package atelier_2.question1_2;

import java.util.*;

public class Manager extends Employe {
    private GregorianCalendar dateEmbauche;

    private Manager(String leNom, String lePrenom, GregorianCalendar laDate, Adresse lAdresse, double salaire, GregorianCalendar dateEmbauche) {
        super(leNom, lePrenom, laDate, lAdresse, salaire, dateEmbauche);
        this.dateEmbauche = dateEmbauche;
       
    }

    public double getSalaire() {
        return super.getSalaire();
    }

    /**
     * La fonction crée un objet employé avec les paramètres donnés, mais uniquement si la date
     * d'embauche est valide (pas avant l'âge minimum de 16 ans).
     * 
     * @param leNom Le nom de famille de l'employé.
     * @param lePrenom Le prénom du salarié.
     * @param j Le paramètre « j » représente le jour du mois correspondant à la date de naissance du
     * salarié.
     * @param m Le paramètre « m » représente le mois de naissance du salarié. Il s'agit d'une valeur
     * entière comprise entre 0 et 11, où 0 représente janvier et 11 représente décembre.
     * @param a Le paramètre « a » représente l'année de naissance du salarié.
     * @param numero Le paramètre "numéro" représente le numéro de rue de l'adresse du salarié.
     * @param rue Le paramètre « rue » représente le nom de la rue de l'adresse du salarié.
     * @param code_postal Le paramètre « code_postal » représente le code postal de l'adresse du
     * salarié.
     * @param ville Le paramètre « ville » représente la ville où réside le salarié.
     * @param salaire Le paramètre "salaire" représente le salaire du salarié. Il est de type double,
     * ce qui signifie qu'il peut stocker des valeurs décimales.
     * @param dateEmbauche Le paramètre « dateEmbauche » représente la date d'embauche du salarié.
     * @return La méthode renvoie une instance de la classe Employe si la date d'emploi est valide. Si
     * la date d'emploi n'est pas valide, elle renvoie null.
     */
    public static Manager createManager(String leNom, String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville, double salaire, GregorianCalendar dateEmbauche) {
        GregorianCalendar dateNaissance = new GregorianCalendar(j, m, a);

        // Date limite minimale (16 ans)
        GregorianCalendar dateLimiteMin = (GregorianCalendar) dateNaissance.clone();
        dateLimiteMin.add(GregorianCalendar.YEAR, 16);

        // Date limite maximale (65 ans)
        GregorianCalendar dateLimiteMax = (GregorianCalendar) dateNaissance.clone();
        dateLimiteMax.add(GregorianCalendar.YEAR, 65);

        // Vérifier si la date d'embauche est valide
        if (!dateEmbauche.before(dateLimiteMin) || dateEmbauche.equals(dateLimiteMin)) {
            return new Manager(leNom, lePrenom, dateNaissance, new Adresse(numero, rue, code_postal, ville), salaire, dateEmbauche);
        } else {
            return null; // Création invalide d'employé
        }
    }

    /**
     * La fonction augmente le salaire d'un pourcentage donné.
     * 
     * @param pourcentage Le paramètre « pourcentage » représente le pourcentage dont le salaire doit
     * être augmenté.
     */
    public void augmenterLeSalaire(double pourcentage) {
        
        double annuite = this.calculAnnuite();
        double res = pourcentage + (annuite * 0.5); 
        super.augmenterLeSalaire(res);
        
    }
        

    /**
     * La fonction calcule le nombre d'années depuis la date d'emploi.
     * 
     * @return La méthode renvoie le nombre d'années depuis la date d'emploi.
     */
    public int calculAnnuite() {
        GregorianCalendar dateActuelle = new GregorianCalendar();
        int annees = dateActuelle.get(GregorianCalendar.YEAR) - dateEmbauche.get(GregorianCalendar.YEAR);
        if (dateActuelle.get(GregorianCalendar.DAY_OF_YEAR) < dateEmbauche.get(GregorianCalendar.DAY_OF_YEAR)) {
            annees--;
        }
        return annees;
    }
    
}
