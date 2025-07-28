class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val){
        this.val = val;
    }
}

class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val){
        if (root == null || root.val == val){
            return root;
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
