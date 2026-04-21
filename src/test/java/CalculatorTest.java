import org.example.Calculator;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CalculatorTest {
    @Test
    public void positiveTest () {
        assertEquals (Calculator.add(3, 4), 7);
        assertEquals(Calculator.divide(8, 4), 2);
    }
    @Test
    public void boundaryTest () {
        assertEquals(Calculator.add(0, 0),0);
        assertEquals(Calculator.multiply(0, 5),0);

    }
    @Test (expectedExceptions = ArithmeticException.class)
    public void negativeTest () {
        Calculator.divide(5, 0);
    }
}
