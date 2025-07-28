import java.util.*;

public class Main {
    // Builds a BST from level-order input
    public static TreeNode buildTree(Integer[] arr){
        if (arr.length == 0 || arr[0] == null){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length){
            TreeNode current = queue.poll();
            if (i < arr.length && arr[i] != null){
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != null){
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    // Print tree in preorder
    public static void printTree(TreeNode root){
        if (root == null){
            System.out.print("[]");
            return;
        }
        System.out.print(root.val);
        if(root.left != null || root.right != null){
            System.out.print(", ");
            printTree(root.left);
            System.out.print(", ");
            printTree(root.right);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter tree in level order (comma separated list): ");
        String[] parts = sc.nextLine().split(",");
        Integer[] treeInput = new Integer[parts.length];
        for (int i = 0; i < parts.length; i++){
            treeInput[i] = parts[i].trim().equals("null") ? null : Integer.parseInt(parts[i].trim());
        }

        System.out.print("Enter values to search: ");
        int val = sc.nextInt();

        TreeNode root = buildTree(treeInput);
        SearchInBST sol = new SearchInBST();
        TreeNode result = sol.searchBST(root, val);

        System.out.print("Output subtree: ");
        printTree(result);
    }
}