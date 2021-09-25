package fastandslowpointers;

import fastandslowpointers.addTwoNumbers.ListNode;

import java.util.*;

public class LinkedListCycle {

    public static void main(String[] args) {
        System.out.println(hasCycle(
                new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4, new ListNode(1)))))
        ));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
