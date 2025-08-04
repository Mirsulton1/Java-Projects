import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class UnitTests{

    @Test
    public void test1(){
        CombinationSum sol = new CombinationSum();
        List<List<Integer>> result = sol.combinationSum3(3,7);
        assertTrue(result.contains(Arrays.asList(1,2,4)));
        assertEquals(1, result.size());
    }

    @Test
    public void test2(){
        CombinationSum sol = new CombinationSum();
        List<List<Integer>> result = sol.combinationSum3(3,9);
        assertTrue(result.contains(Arrays.asList(1,2,6)));
        assertTrue(result.contains(Arrays.asList(1,3,5)));
        assertTrue(result.contains(Arrays.asList(2,3,4)));
        assertEquals(3, result.size());
    }

    @Test
    public void test3(){
        CombinationSum sol = new CombinationSum();
        List<List<Integer>> result = sol.combinationSum3(4,1);
        assertEquals(0, result.size());
    }
}
