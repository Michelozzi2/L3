package qualite_logiciel.exo_OCP;

public class TestCaculator {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		Addition addition = new Addition(5, 3);
		Substraction substraction = new Substraction(5, 3);
		double result = calculator.calculate(addition);
		double result2 = calculator.calculate(substraction);
		System.out.println(result);  // Affiche 8.0
		System.out.println(result2); // Affiche 2.0

	}

}
