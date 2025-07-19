import java.util.*;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int x){
        val = x;
    }
}

class Solution{
    public int goodNodes(TreeNode root){
        return DFS(root, root.val);
    }

    private int DFS(TreeNode node, int maxSoFar){
        if(node == null) return 0;
        int count = 0;
        if (node.val >= maxSoFar) count++;
        maxSoFar = Math.max(maxSoFar, node.val);
        count += DFS(node.left, maxSoFar);
        count += DFS(node.right, maxSoFar);
        return count;
    }
}
