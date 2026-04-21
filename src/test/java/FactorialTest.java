import org.example.Factorial;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FactorialTest {
    @Test
    public void positiveTest () {
        assertEquals (Factorial.calculate(5),120);
    }
    @Test
    public void boundaryTest () {
        assertEquals(Factorial.calculate(0),1);
    }
    @Test (expectedExceptions = IllegalArgumentException.class)
    public void negativeTest () {
        Factorial.calculate(-1);
    }
}
