import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }
}

class Solution{
    public int pairSum(ListNode head){
        // Step 1: Store all values in a list
        List<Integer> values = new ArrayList<>();
        ListNode current = head;

        while(current != null){
            values.add(current.val);
            current = current.next;
        }

        // Step 2: Compute max twin sum
        int maxSum = 0;
        int n = values.size();

        for (int i = 0; i < n; i++){
            int twinSum = values.get(i) + values.get(n - 1 - i);
            maxSum = Math.max(maxSum, twinSum);
        }

        return maxSum;
    }
}

public class MaximumTwinSum {
    // Create a linked list from array input
    public static ListNode createList(int[] arr){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int num : arr){
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter even number of list values: ");
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        if (arr.length % 2 != 0){
            System.out.println("Error: Number of values must be even.");
            return;
        }

        ListNode head = createList(arr);
        System.out.print("Linked list: ");
        printList(head);

        Solution sol = new Solution();
        int result = sol.pairSum(head);

        System.out.println("Maxim twin sum: " + result);
    }
}
