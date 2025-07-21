// Program to convert a left unbalanced BST to a balanced BST
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node (int value){
        data = value;
        left = null;
        right = null;
    }
}

class BalancedBst {
    // Inorder traversal to store elements of the tree in sorted order
    static void storeInorder(Node root, ArrayList<Integer> nodes){
        if(root == null){
            return;
        }
        // Traverse the left subtree
        storeInorder(root.left, nodes);

        // Store the node data
        nodes.add(root.data);

        // Traverse the right subtree
        storeInorder(root.right, nodes);
    }

    // Function to build a balanced BST from a sorted array
    static Node buildBalancedTree(ArrayList<Integer> nodes, int start, int end){

        // Base case
        if (start > end){
            return null;
        }

        // Get the middle element and make it the root
        int mid = (start + end) / 2;
        Node root = new Node(nodes.get(mid));

        // Recursively build the left and right subtrees
        root.left = buildBalancedTree(nodes, start, mid - 1);
        root.right = buildBalancedTree(nodes, mid + 1, end);
        return root;
    }

    // Function to balance a BST
    static Node balanceBST(Node root){
        ArrayList<Integer> nodes = new ArrayList<>();

        // Store the nodes in sorted order
        storeInorder(root, nodes);

        // Build the balanced tree from the sorted nodes
        return buildBalancedTree(nodes, 0, nodes.size() - 1);
    }

    // Print tree as level order
    static void printLevelOrder(Node root){
        if (root == null){
            System.out.print("N ");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int nonNull = 1;

        while (!queue.isEmpty() && nonNull > 0 ){
            Node current = queue.poll();

            if (current == null){
                System.out.print("N ");
                continue;
            }
            nonNull--;

            System.out.print(current.data + " ");
            queue.add(current.left);
            queue.add(current.right);
            if (current.left != null){
                nonNull++;
            }
            if (current.right != null){
                nonNull++;
            }
        }
    }
}
