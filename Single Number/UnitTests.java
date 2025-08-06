import static org.junit.Assert.*;
import org.junit.Test;

public class UnitTests {

    @Test
    public void testExample1() {
        assertEquals(1, SingleNumber.singleNumber(new int[]{2, 2, 1}));
    }

    @Test
    public void testExample2() {
        assertEquals(4, SingleNumber.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    @Test
    public void testSingleElement() {
        assertEquals(1, SingleNumber.singleNumber(new int[]{1}));
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals(-3, SingleNumber.singleNumber(new int[]{-1, -1, -3}));
    }
}
