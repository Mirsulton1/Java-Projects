import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;

public class UnitTests {

    public TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < values.length && !values[i].trim().equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i].trim()));
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < values.length && !values[i].trim().equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i].trim()));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    @Test
    public void testExample1() {
        String[] input = {"1", "7", "0", "7", "-8"};
        TreeNode root = buildTree(input);
        MaxLevelSumOfBST sol = new MaxLevelSumOfBST();
        assertEquals(2, sol.maxLevelSum(root));
    }

    @Test
    public void testExample2() {
        String[] input = {"989", "null", "10250", "98693", "-89388", "null", "null", "null", "-32127"};
        TreeNode root = buildTree(input);
        MaxLevelSumOfBST sol = new MaxLevelSumOfBST();
        assertEquals(2, sol.maxLevelSum(root));
    }

    @Test
    public void testSingleNode() {
        String[] input = {"5"};  // Expect level 1 to have sum = 5
        TreeNode root = buildTree(input);
        MaxLevelSumOfBST sol = new MaxLevelSumOfBST();
        assertEquals(1, sol.maxLevelSum(root)); // Level 1 should have the max sum
    }
}
