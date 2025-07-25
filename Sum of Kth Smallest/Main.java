// Find Sum of All elements smaller than or equal to Kth smallest element in BST
class Node{
    int data;
    Node left, right;

    Node(int x){
        data = x;
        left = right = null;
    }
}

class KthSmallest{
    // Recursive function to calculate the sum of the first k smallest elements
    static void calculateSum(Node root, int[] k, int[] ans){
        if (root.left != null){
            calculateSum(root.left, k, ans);
        }
        if (k[0] > 0){
            ans[0] += root.data;
            k[0]--;
        }
        else {
            return;
        }
        if (root.right != null){
            calculateSum(root.right, k, ans);
        }
    }
    // Function to find the sum of the first k smallest elements
    static int sum(Node root, int k){
        int[] ans = {0};
        int[] kArr = {k};
        calculateSum(root, kArr, ans);
        return ans[0];
    }

    public static void main(String[] args){
        // Input BST
        //         8
        //       /   \
        //      7     10
        //    /      /  \
        //   2      9    13
        Node root = new Node(8);
        root.left = new Node(7);
        root.right = new Node(10);
        root.left.left = new Node(2);
        root.right.right = new Node(9);
        root.right.right = new Node(13);

        int k = 3;
        System.out.println(sum(root, k));
    }
}
