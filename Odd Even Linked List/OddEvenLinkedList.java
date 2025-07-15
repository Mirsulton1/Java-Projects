class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}

class Solution{
    public ListNode oddEvenList(ListNode head){
        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}

public class OddEvenLinkedList {
    public static void main(String[] args){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Enter space-separated integers: ");

        String[] input = sc.nextLine().split(" ");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String s : input){
            current.next = new ListNode(Integer.parseInt(s));
            current = current.next;
        }

        Solution sol = new Solution();
        ListNode result = sol.oddEvenList(dummy.next);
        System.out.println("Reordered list: ");
        while(result != null){
            System.out.println(result.val + " ");
            result = result.next;
        }

        sc.close();
    }
}
