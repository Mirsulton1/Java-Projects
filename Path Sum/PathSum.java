import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x){
        val = x;
    }
}

public class PathSum {
    // Main method
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Input tree as level order
        System.out.println("Enter tree nodes in level order: ");
        String[] nodes = sc.nextLine().split(",");
        TreeNode root = buildTree(nodes);

        System.out.print("Enter target sum: ");
        int targetSum = sc.nextInt();

        PathSum counter = new PathSum();
        int result = counter.pathSum(root, targetSum);
        System.out.println("Number of paths sum = " + targetSum + ": " + result);
    }

    // Build a binary tree from level-order input
    public static TreeNode buildTree(String[] values){
        if(values.length == 0 || values[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;

        while(!queue.isEmpty() && index < values.length){
            TreeNode current = queue.poll();

            if(!values[index].equals("null")){
                current.left = new TreeNode(Integer.parseInt(values[index]));
                queue.add(current.left);
            }
            index++;

            if(index < values.length && !values[index].equals("null")){
                current.right = new TreeNode(Integer.parseInt(values[index]));
                queue.add(current.right);
            }
            index++;
        }
        return root;
    }

    // Main pathSum logic
    public int pathSum(TreeNode root, int targetSum){
        if (root == null) return 0;
        return DFS(root, targetSum) +
                pathSum(root.left, targetSum) +
                pathSum(root.right, targetSum);
    }

    // DFS to count paths from current node
    private int DFS(TreeNode node, int remainingSum){
        if (node == null) return 0;

        int count = 0;
        if (node.val == remainingSum) count++;

        count += DFS(node.left, remainingSum - node.val);
        count += DFS(node.right, remainingSum - node.val);

        return count;
    }
}