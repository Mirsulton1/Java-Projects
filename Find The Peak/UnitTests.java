import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTests{
    @Test
    public void test1(){
        FindThePeak finder = new FindThePeak();
        int[] nums = {1,2,3,1};
        int index = finder.findPeakElement(nums);
        assertTrue(index == 2);
    }

    @Test
    public void test2(){
        FindThePeak finder = new FindThePeak();
        int[] nums = {1,2,1,3,5,6,4};
        int index = finder.findPeakElement(nums);
        assertTrue(nums[index] > (index > 0 ? nums[index - 1] : Integer.MIN_VALUE));
        assertTrue(nums[index] > (index < nums.length - 1 ? nums[index + 1] : Integer.MIN_VALUE));
    }

    @Test
    public void test3(){
        FindThePeak finder = new FindThePeak();
        int[] nums = {42};
        int index = finder.findPeakElement(nums);
        assertEquals(0, index);
    }

    @Test
    public void test4(){
        FindThePeak finder = new FindThePeak();
        int[] nums = {1, 2};
        int index = finder.findPeakElement(nums);
        assertTrue(index == 1);
    }

    @Test
    public void test5(){
        FindThePeak finder = new FindThePeak();
        int[] nums = {5,4,3,2,1};
        int index = finder.findPeakElement(nums);
        assertEquals(0, index);
    }
}