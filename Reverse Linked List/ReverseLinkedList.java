class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;        // This will become the new head
        ListNode current = head;     // Start with the current node at head

        while (current != null) {
            ListNode nextNode = current.next; // Save next node
            current.next = prev;              // Reverse the pointer
            prev = current;                   // Move prev forward
            current = nextNode;               // Move current forward
        }

        return prev; // prev is now the new head
    }
}
public class ReverseLinkedList {
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5};
        int[] input2 = {1, 2};
        int[] input3 = {};

        Solution sol = new Solution();

        for (int[] input : new int[][]{input1, input2, input3}) {
            ListNode head = createList(input);
            System.out.print("Original: ");
            printList(head);

            ListNode reversed = sol.reverseList(head);
            System.out.print("Reversed: ");
            printList(reversed);

            System.out.println("-----------");
        }
    }
}
