package qualite_logiciel.exo_OCP;

import java.security.InvalidParameterException;

public class Calculator {
    public double calculate(CalculatorOperation operation) {
        if (operation == null) {
            throw new InvalidParameterException("Operation can't be null");
        }
        return operation.getResult();

    }
}
