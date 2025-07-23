import java.util.*;

public class Main {
    public static void main(String[] args){
        /*
         Example tree:
                  3
                /   \
               5     1
              / \   / \
             6   2 0   8
                / \
               7   4
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Example: find LCA of nodes 5 and 1
        TreeNode p = root.left;  // 5
        TreeNode q = root.right;  // 1

        LowestCommonAncestor sol = new LowestCommonAncestor();
        TreeNode lca = sol.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is " + lca.val);
    }
}
