package cdpoo.TD2.exo11;


public class Personne {
    private String nom;
    private int age;
    private String groupeSanguin;

    public Personne(String nom, String groupeSanguin, int age) {
        this.nom = nom;
        this.groupeSanguin = groupeSanguin;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public int getAge() {
        return age;
    }

    public String toString(){
		String result="\nNom : "+ nom + "\nGroupeSanguin : " + groupeSanguin + "\nAge : "+ age ;
		return result;
	}

    
}
