import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    void positiveTest(){
        assertEquals (7, Calculator.add(3, 4));
        assertEquals (2, Calculator.divide(8, 4));
    }
    @Test
    void boundarytest (){
        assertEquals(0,Calculator.add(0, 0));
        assertEquals(0, Calculator.multiply(0, 5));
    }
    @Test
    void negativeTest () {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(5, 0));
    }
}
