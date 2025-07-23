import java.util.*;

public class Main{
    // Helper to build tree from level-order input with nulls
    public static TreeNode buildTree(String input){
        if(input == null || input.isEmpty()){
            return null;
        }
        String[] parts = input.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(parts[0].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while(!queue.isEmpty() && i < parts.length){
            TreeNode current = queue.poll();

            if (i < parts.length && !parts[i].trim().equals("null")){
                current.left = new TreeNode(Integer.parseInt(parts[i].trim()));
                queue.offer(current.left);
            }
            i++;

            if (i < parts.length && ! parts[i].trim().equals("null")){
                current.right = new TreeNode(Integer.parseInt(parts[i].trim()));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter tree in level-order: ");
        String input = sc.nextLine();

        TreeNode root = buildTree(input);
        Solution sol = new Solution();
        List<Integer> rightView = sol.rightSideView(root);
        System.out.println("Right side view: " + rightView);
    }
}