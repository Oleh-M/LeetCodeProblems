package fastandslowpointers;

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

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
