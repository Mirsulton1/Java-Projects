import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RightSideViewTest {
    Solution sol = new Solution();

    TreeNode build(String data) {
        return Main.buildTree(data);
    }

    @Test
    void testExample1() {
        TreeNode root = build("1,2,3,null,5,null,4");
        List<Integer> result = sol.rightSideView(root);
        assertEquals(Arrays.asList(1, 3, 4), result);
    }

    @Test
    void testExample2() {
        TreeNode root = build("1,2,3,4,null,null,null,5");
        List<Integer> result = sol.rightSideView(root);
        assertEquals(Arrays.asList(1, 3, 4, 5), result);
    }

    @Test
    void testExample3() {
        TreeNode root = build("1,null,3");
        List<Integer> result = sol.rightSideView(root);
        assertEquals(Arrays.asList(1, 3), result);
    }

    @Test
    void testEmptyTree() {
        TreeNode root = build("");
        List<Integer> result = sol.rightSideView(root);
        assertTrue(result.isEmpty());
    }
}
