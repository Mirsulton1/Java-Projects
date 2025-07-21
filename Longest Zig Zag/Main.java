import  java.util.*;

public class Main {
    public static TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].trim().equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();
            if (i < values.length && !values[i].trim().equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i].trim()));
                queue.add(current.left);
            }
            i++;
            if (i < values.length && !values[i].trim().equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i].trim()));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the tree in level order with 'null' for empty nodes (comma-separated):");
        String input = sc.nextLine();
        String[] values = input.split(",");
        TreeNode root = buildTree(values);

        // Assuming LongestZigZagPath class is defined elsewhere
        LongestZigZagPath solution = new LongestZigZagPath();
        int result = solution.longestZigZag(root);
        System.out.println("Longest ZigZag Path Length: " + result);
    }
}
