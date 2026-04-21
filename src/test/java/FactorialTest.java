import org.example.Factorial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    @Test
    void positiveTest (){
        assertEquals (120, Factorial.calculate(5));
    }
    @Test
    void boundaryTest(){
        assertEquals(1, Factorial.calculate(0));
    }
    @Test
    void negativeTest (){
        // факториал определен только для n>= 0
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculate(-1));
    }
}
