import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class BalancedBstTest {
    // Helper method for in-order traversal
    private void inorderTraversal(Node root, List<Integer> result) {
        if (root == null) return;
        inorderTraversal(root.left, result);
        result.add(root.data);
        inorderTraversal(root.right, result);
    }

    // Helper method to check if BST is balanced
    private int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private boolean isBalanced(Node root) {
        if (root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    @Test
    void testBalancedBstStructureAndSortedOrder() {
        // Create unbalanced BST
        Node root = new Node(4);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.left.left = new Node(1);
        root.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);

        Node balancedRoot = BalancedBst.balanceBST(root);

        // Check if the tree is balanced
        assertTrue(isBalanced(balancedRoot), "Tree should be balanced");

        // Check if inorder traversal gives sorted elements
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(balancedRoot, inorder);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), inorder);
    }

    @Test
    void testEmptyTree() {
        Node root = null;
        Node balancedRoot = BalancedBst.balanceBST(root);
        assertNull(balancedRoot);
    }

    @Test
    void testSingleElementTree() {
        Node root = new Node(42);
        Node balancedRoot = BalancedBst.balanceBST(root);
        assertNotNull(balancedRoot);
        assertEquals(42, balancedRoot.data);
        assertNull(balancedRoot.left);
        assertNull(balancedRoot.right);
    }

    @Test
    void testTwoElementsTree() {
        Node root = new Node(10);
        root.left = new Node(5);
        Node balancedRoot = BalancedBst.balanceBST(root);

        // In-order should be [5, 10]
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(balancedRoot, inorder);
        assertEquals(Arrays.asList(5, 10), inorder);
        assertTrue(isBalanced(balancedRoot));
    }

    @Test
    void testAlreadyBalancedTree() {
        // Tree:
        //     2
        //    / \
        //   1   3
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        Node balancedRoot = BalancedBst.balanceBST(root);
        assertTrue(isBalanced(balancedRoot));

        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(balancedRoot, inorder);
        assertEquals(Arrays.asList(1, 2, 3), inorder);
    }
}
