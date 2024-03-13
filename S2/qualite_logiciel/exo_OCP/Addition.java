package qualite_logiciel.exo_OCP;

public class Addition implements CalculatorOperation {
    private double left;
    private double right;
    private double result = 0.0;


	public Addition(double left, double right) {
		this.left = left;
		this.right = right;
		this.result = this.left + this.right;
		
	}

	public double getResult() {
		return this.result;

	}
	
}
