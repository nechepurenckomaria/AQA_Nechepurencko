import org.example.Triangle;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TriangleTest {
    @Test
    public void  positiveTest () {
        assertEquals (Triangle.area(5, 6), 15.0);
    }
    @Test
    public void boundryTest (){
        assertEquals(Triangle.area(1, 1), 0.5);
    }
    @Test (expectedExceptions = IllegalArgumentException.class)
    public void negativeTest () {
        Triangle.area(0, 5);
    }
}
