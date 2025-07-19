import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class SolutionTest {

    private TreeNode buildTreeFromList(String[] parts) {
        if (parts.length == 0 || parts[0].equalsIgnoreCase("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < parts.length) {
            TreeNode current = queue.poll();

            if (i < parts.length && !parts[i].equalsIgnoreCase("null")) {
                current.left = new TreeNode(Integer.parseInt(parts[i]));
                queue.offer(current.left);
            }
            i++;

            if (i < parts.length && !parts[i].equalsIgnoreCase("null")) {
                current.right = new TreeNode(Integer.parseInt(parts[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    @Test
    void testExample1() {
        String[] input = {"3","1","4","3","null","1","5"};
        TreeNode root = buildTreeFromList(input);
        Solution sol = new Solution();
        assertEquals(4, sol.goodNodes(root));
    }

    @Test
    void testExample2() {
        String[] input = {"3","3","null","4","2"};
        TreeNode root = buildTreeFromList(input);
        Solution sol = new Solution();
        assertEquals(3, sol.goodNodes(root));
    }

    @Test
    void testExample3() {
        String[] input = {"1"};
        TreeNode root = buildTreeFromList(input);
        Solution sol = new Solution();
        assertEquals(1, sol.goodNodes(root));
    }

    @Test
    void testAllIncreasingLeft() {
        String[] input = {"1", "2", "null", "3", "null", "4"};
        TreeNode root = buildTreeFromList(input);
        Solution sol = new Solution();
        assertEquals(4, sol.goodNodes(root));
    }

    @Test
    void testAllSameValues() {
        String[] input = {"2", "2", "2", "2", "2"};
        TreeNode root = buildTreeFromList(input);
        Solution sol = new Solution();
        assertEquals(5, sol.goodNodes(root));
    }
}
