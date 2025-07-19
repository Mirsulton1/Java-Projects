import java.util.*;
public class UserInput {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter binary tree as list: ");
        String input = sc.nextLine();
        input = input.replaceAll("\\[|\\]|\\s+", "");
        String[] parts = input.split(",");

        TreeNode root = buildTree(parts);
        Solution sol = new Solution();
        int result = sol.goodNodes(root);
        System.out.println("Number of good nodes: " + result);
    }

    private static TreeNode buildTree(String[] parts){
        if (parts.length == 0 || parts[0].equalsIgnoreCase("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < parts.length){
            TreeNode current = queue.poll();

            // Left child
            if (i < parts.length && !parts[i].equalsIgnoreCase("null")){
                current.left = new TreeNode(Integer.parseInt(parts[i]));
                queue.add(current.left);
            }
            i++;

            // Right child
            if(i < parts.length && !parts[i].equalsIgnoreCase("null")){
                current.right = new TreeNode(Integer.parseInt(parts[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
}