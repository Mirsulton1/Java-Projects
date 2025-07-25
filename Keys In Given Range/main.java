
import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class KeyInGivenRange {
    // Function to print nodes
    // that lie in the range.
    static ArrayList<Integer> printNearNodes (Node root, int low, int high) {

        ArrayList<Integer> ans = new ArrayList<>();
        Node curr = root;

        while (curr != null) {

            // if left child is null, check
            // curr node and move to right node.
            if (curr.left == null) {
                if (curr.data >= low && curr.data <= high)
                    ans.add(curr.data);
                curr = curr.right;
            } else {

                // Find the inorder predecessor of curr
                Node pre = curr.left;
                while (pre.right != null && pre.right != curr)
                    pre = pre.right;

                // Make curr as the right child of its
                // inorder predecessor and move to
                // left node.
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                }

                // Revert the changes made in the 'if' part to
                // restore the original tree i.e., fix the right
                // child of predecessor
                else {
                    pre.right = null;
                    if (curr.data >= low && curr.data <= high)
                        ans.add(curr.data);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // BST
        //       22
        //      /  \
        //    12    30
        //   /  \
        //  8    20
        Node root = new Node(22);
        root.left = new Node(12);
        root.right = new Node(30);
        root.left.left = new Node(8);
        root.left.right = new Node(20);
        int n1 = 10, n2 = 22;
        ArrayList<Integer> ans =
                printNearNodes(root, n1, n2);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
