import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTests {

    private TreeNode buildSampleTree(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        return root;
    }

    @Test
    public void test1(){
        SearchInBST sol = new SearchInBST();
        TreeNode root = buildSampleTree();
        TreeNode result = sol.searchBST(root, 2);
        assertNotNull(result);
        assertEquals(2, result.val);
        assertEquals(1, result.left.val);
        assertEquals(3, result.right.val);
    }

    @Test
    public void test2() {
        SearchInBST sol = new SearchInBST();
        TreeNode root = buildSampleTree();
        TreeNode result = sol.searchBST(root, 3);
        assertNotNull(result);
    }

    @Test
    public void test3(){
        SearchInBST sol = new SearchInBST();
        TreeNode root = buildSampleTree();
        TreeNode result = sol.searchBST(root, 4);
        assertNotNull(result);
    }
}
