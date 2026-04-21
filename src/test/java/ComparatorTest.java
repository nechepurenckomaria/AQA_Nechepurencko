import org.example.Comparator;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ComparatorTest {
    @Test
    public void positiveTest () {
        assertEquals (Comparator.compare(5, 5), 0);
    }
    @Test
    public void boundaryTest () {
        assertTrue(Comparator.compare(-1, 0)< 0);
    }
    @Test
    public void negativeTest () {
        assertTrue(Comparator.compare(10, 1)> 0);
    }
}
