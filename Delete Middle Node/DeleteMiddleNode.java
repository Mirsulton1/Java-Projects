class ListNode {
    int val; // Stores the value of the node

    ListNode next; // Points to the next node

    ListNode() {} // Default constructor

    ListNode(int val){
        this.val = val;  // Creates node and sets its value
    }
    ListNode(int val, ListNode next) {
        this.val = val;  // Sets the value
        this.next = next;   // Points to the next node
    }
}

class Solution{
    public ListNode deleteMiddle(ListNode head){
        // If only one node, return null (nothing left after deletion)
        if (head == null || head.next == null) return null;

        // First, count the length of the list
        int length = 0;
        ListNode temp = head;
        // loop counts how many nodes are in the list by moving temp one step at a time
        while (temp != null){
            length++;
            temp = temp.next;
        }

        // Calculate the index of the middle node
        int middleIndex = length / 2;

        // Traverse to the node just before the middle
        temp = head;
        for (int i = 0; i < middleIndex - 1; i++){
            temp = temp.next;
        }

        // Remove the middle node
        temp.next = temp.next.next;

        return head;
    }
}

public class DeleteMiddleNode{
    // Helper to create list from array
    public static ListNode createList(int[] arr){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : arr){
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    // Helper to print the list
    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val);
            if (head.next != null){
                System.out.print(" -> ");
            }
            head = head.next;
        }
            System.out.println();
    }

    public static void runTest(int[] input){
        ListNode head = createList(input);
        System.out.println("Original List: ");
        printList(head);

        Solution sol = new Solution();
        ListNode result = sol.deleteMiddle(head);

        System.out.println("After Deleting Middle Node: ");
        printList(result);
        System.out.println("------------------------------");
    }

    public static void main(String[] args){
        int[] input1 = {1,3,4,7,1,2,6};
        runTest(input1);

        int[] input2 = {1,2,3,4};
        runTest(input2);

        int[] input3 = {2,1};
        runTest(input3);
    }
}
