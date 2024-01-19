package cdpoo.TD6.exo1;

public class Main {
    public static void main(String[] args) {
        Personne p = new Personne("Doe", "John", 42);
        Serialiser s = new Serialiser();
        s.serialize(p, "cdpoo/TD6/exo1/personne.txt");

        Deserialiser d = new Deserialiser();
        Personne p2 = d.Deserialise("cdpoo/TD6/exo1/personne.txt");
        System.out.println(p2);
    }
    
}
