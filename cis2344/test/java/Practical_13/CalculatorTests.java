package Practical_13;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {
    @Test
    void CalculateRequiredPostfix() {
        var calculator = new Calculator();
        var postFixExpression = "4 5 + 1 2 * - 5 /";
        double result = 0;
        try {
            result = calculator.calculatePostfix(postFixExpression);
        } catch (InvalidPostfixExpressionException | InvalidTokenTypeException e) {
            e.printStackTrace();
        }

        assertEquals(1.4, result);
    }

    @Test
    void CalculatePostfix2() {
        var calculator = new Calculator();
        var postFixExpression = "6 9 * 2 1 - + 3 /";
        double result = 0;
        try {
            result = calculator.calculatePostfix(postFixExpression);
        } catch (InvalidPostfixExpressionException | InvalidTokenTypeException e) {
            e.printStackTrace();
        }

        assertEquals(18.3, result);
    }
}
