import java.util.*;

public class Main{
    public static TreeNode buildTree(String[] values){
        if (values.length == 0 || values[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while(!queue.isEmpty() &&  i < values.length){
            TreeNode current = queue.poll();

            if (!values[i].equals("null")){
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;

            if (i < values.length && !values[i].equals("null")){
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter tree nodes in level order: ");
        String input = sc.nextLine();
        String[] values = input.split(",");

        TreeNode root = buildTree(values);
        MaxLevelSumOfBST sol = new MaxLevelSumOfBST();
        int result = sol.maxLevelSum(root);
        System.out.println("Max level sum is: " + result);
    }
}