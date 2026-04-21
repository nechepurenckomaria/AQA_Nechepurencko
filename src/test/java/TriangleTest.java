import org.example.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    void positivetest (){
        assertEquals (15.0, Triangle.area(5,6));
    }
    @Test
    void boundarytest (){
        assertEquals(0.5, Triangle.area(1,1),0.0001);
    }
    @Test
    void negativeTest() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.area(0, 5));
    }
}
