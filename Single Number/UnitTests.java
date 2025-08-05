import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class UnitTests {

    @Test
    public void test1() {
        assertArrayEquals(new int[]{0, 1, 1}, SingleNumber.countBits(2));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, SingleNumber.countBits(5));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[]{0}, SingleNumber.countBits(0));
    }

    @Test
    public void test4() {
        assertArrayEquals(new int[]{0, 1}, SingleNumber.countBits(1));
    }
}
