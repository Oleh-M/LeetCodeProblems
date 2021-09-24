package fastandslowpointers;

import fastandslowpointers.addTwoNumbers.ListNode;

public class LinkedListCycle2 {
    public static void main(String[] args) {
        ListNode ln = new ListNode(3,
                new ListNode(2,
                        new ListNode(0,
                                new ListNode(-4))));

        System.out.println(detectCycle(ln));
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head,
                fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                while(head != fast) {
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }

        return null;
    }
}
