import org.example.Comparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComparatorTest {
    @Test
    void positiveTest () {
        assertEquals (0, Comparator.compare(5, 5));

    }
    @Test
    void boundaryTest () {
        assertTrue(Comparator.compare(-1, 0) <0);
    }
    @Test
    void negativeTest () {
        // проверка противоположного условия (а > b )
        assertTrue(Comparator.compare(10, 1)>0);
    }
}
