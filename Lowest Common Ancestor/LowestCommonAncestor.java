public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or matches either p or q
        if (root == null || root == p || root == q){
            return root;
        }

        // Recur for left and right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null, current node is LCA
        if (left != null && right != null){
            return root;
        }

        // Else return non-null node
        return left != null ? left : right;
    }
}
