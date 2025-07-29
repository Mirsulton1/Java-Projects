import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTests{
    private TreeNode createTree(){
        // Tree: [5,3,6,2,4,null,7]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        return root;
    }

    @Test
    public void test1(){
        TreeNode root = createTree();
        DeleteNode sol = new DeleteNode();
        TreeNode newRoot = sol.deleteNode(root, 3);
        assertEquals(5, newRoot.val);
        assertEquals(4, newRoot.left.val);
    }

    @Test
    public void test2(){
        TreeNode root = createTree();
        DeleteNode sol = new DeleteNode();
        TreeNode newRoot = sol.deleteNode(root, 10);
        assertEquals(5, newRoot.val);
    }

    @Test
    public void test3(){
        TreeNode root = createTree();
        DeleteNode sol = new DeleteNode();
        TreeNode newRoot = sol.deleteNode(root, 5);
        assertNotNull(newRoot);
        assertNotEquals(5, newRoot.val);
    }
}