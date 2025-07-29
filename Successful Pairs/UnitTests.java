import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTests {
    @Test
    public void test1(){
        SuccessfulPairs sp = new SuccessfulPairs();
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        long success = 7;
        int[] expected = {4, 0, 3};
        assertArrayEquals(expected, sp.successfulPairs(spells, potions, success));
    }

    @Test
    public void test2(){
        SuccessfulPairs sp = new SuccessfulPairs();
        int[] spells = {3,1,2};
        int[] potions = {8,5,8};
        long success = 16;
        int[] expected = {2,0,2};
        assertArrayEquals(expected, sp.successfulPairs(spells, potions, success));
    }

    @Test
    public void test3(){
        SuccessfulPairs sp = new SuccessfulPairs();
        int[] spells = {1,1,1};
        int[] potions = {1,1,1};
        long success = 10;
        int[] expected = {0,0,0};
        assertArrayEquals(expected, sp.successfulPairs(spells, potions, success));
    }

    @Test
    public void test4(){
        SuccessfulPairs sp = new SuccessfulPairs();
        int[] spells = {10,10,10};
        int[] potions = {1,2,3};
        long success = 5;
        int[] expected = {3,3,3};
        assertArrayEquals(expected, sp.successfulPairs(spells, potions, success));
    }
}