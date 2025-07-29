import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tree nodes in level order (use 'null' for empty):");
        String[] parts = sc.nextLine().split(",");
        TreeNode root = buildTree(parts);

        System.out.print("Enter key to delete: ");
        int key = sc.nextInt();

        DeleteNode sol = new DeleteNode();
        TreeNode newRoot = sol.deleteNode(root, key);

        System.out.print("Resulting BST (in-order): ");
        printInOrder(newRoot);
    }

    // Build tree from level order
    public static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < nodes.length) {
            TreeNode curr = queue.poll();

            if (!nodes[i].trim().equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i].trim()));
                queue.add(curr.left);
            }
            i++;
            if (i < nodes.length && !nodes[i].trim().equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i].trim()));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
}