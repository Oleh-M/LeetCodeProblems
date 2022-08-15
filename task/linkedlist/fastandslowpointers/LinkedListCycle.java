package linkedlist.fastandslowpointers;

import fastandslowpointers.addTwoNumbers.ListNode;

public class LinkedListCycle {

    public static void main(String[] args) {
        System.out.println(hasCycle(
                new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4, new ListNode(2)))))
        ));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        if (head == head.next) return true;

        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
