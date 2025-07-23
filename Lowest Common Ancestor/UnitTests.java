import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UnitTests{
    @Test
    public void test1(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestor sol = new LowestCommonAncestor();
        TreeNode lca = sol.lowestCommonAncestor(root, root.left, root.right); // 5 and 1
        assertEquals(3, lca.val);
    }

    @Test
    public void test2(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestor sol = new LowestCommonAncestor();
        TreeNode lca = sol.lowestCommonAncestor(root, root.left, root.left.right.right); // 5 and 4
        assertEquals(5, lca.val);
    }

    @Test
    public void test3(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        LowestCommonAncestor sol = new LowestCommonAncestor();
        TreeNode lca = sol.lowestCommonAncestor(root, root, root.left);
        assertEquals(1, lca.val);
    }
}