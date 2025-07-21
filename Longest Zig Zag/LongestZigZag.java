class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LongestZigZagPath {
    private int maxZigZag = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);  // Start by going left
        dfs(root, false, 0); // Start by going right
        return maxZigZag;
    }

    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) return;

        maxZigZag = Math.max(maxZigZag, length);

        if (isLeft) {
            dfs(node.left, false, length + 1); // Switch to right
            dfs(node.right, true, 1);          // Start new zigzag path
        } else {
            dfs(node.right, true, length + 1); // Switch to left
            dfs(node.left, false, 1);          // Start new zigzag path
        }
    }
}
