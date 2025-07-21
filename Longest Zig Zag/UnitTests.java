import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTests{
    private TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].equalsIgnoreCase("null"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        // Only loop while there are both nodes to attach children to and tokens left
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < values.length && !values[i].equalsIgnoreCase("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < values.length && !values[i].equalsIgnoreCase("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    @Test
    public void testExample1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.left.right = new TreeNode(1);

        LongestZigZagPath solution = new LongestZigZagPath();
        assertEquals(5, solution.longestZigZag(root));
    }

    @Test
    public void testExample2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.left.right.left.right = new TreeNode(1);

        LongestZigZagPath solution = new LongestZigZagPath();
        assertEquals(4, solution.longestZigZag(root));
    }

    @Test
    public void testSingleNode() {
        TreeNode root = new TreeNode(1);

        LongestZigZagPath solution = new LongestZigZagPath();
        assertEquals(0, solution.longestZigZag(root));
    }

    @Test
    public void testStraightLeftPath() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        LongestZigZagPath solution = new LongestZigZagPath();
        assertEquals(1, solution.longestZigZag(root));
    }

    @Test
    public void testStraightRightPath() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        LongestZigZagPath solution = new LongestZigZagPath();
        assertEquals(1, solution.longestZigZag(root));
    }

    @Test
    public void testZigZagInMiddle() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.left.right.left.right = new TreeNode(1);
        root.left.right.left.right.left = new TreeNode(1);

        LongestZigZagPath solution = new LongestZigZagPath();
        assertEquals(5, solution.longestZigZag(root));
    }
}
