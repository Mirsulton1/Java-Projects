import java.util.*;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution{
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            TreeNode lastNode = null;

            for (int i = 0; i < levelSize; i++){
                TreeNode current = queue.poll();
                lastNode = current;

                if (current.left != null){
                    queue.offer(current.left);
                }
                if (current.right != null){
                    queue.offer(current.right);
                }
            }
            result.add(lastNode.val);  // Rightmost node at this level
        }
        return result;
    }
}
