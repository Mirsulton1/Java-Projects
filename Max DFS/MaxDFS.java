import com.sun.source.tree.Tree;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int val){
        this.val = val;
    }
}

public class MaxDFS{
    // Recursive function to calculate max depth
    public static int maxDFS(TreeNode root){
        if(root == null) return 0;

        int leftDepth = maxDFS(root.left);
        int rightDepth = maxDFS(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    // Helper function to build tree from level order input
    public static TreeNode buildTree(String[] nodes){
        if (nodes.length == 0 || nodes[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while(i < nodes.length){
            TreeNode current = queue.poll();

            if(i < nodes.length && !nodes[i].equals("null")){
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(current.left);
            }
            i++;

            if (i <  nodes.length && !nodes[i].equals("null")){
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tree nodes in level order separated by space: ");
        String line = sc.nextLine();
        String[] values = line.split(" ");

        TreeNode root = buildTree(values);
        int depth = maxDFS(root);

        System.out.println("Maximum depth is: " + depth);
    }
}
