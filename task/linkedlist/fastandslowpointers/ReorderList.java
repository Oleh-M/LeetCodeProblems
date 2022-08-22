package linkedlist.fastandslowpointers;

import linkedlist.ListNode;

public class ReorderList {
    public static void reorderList(ListNode head) {
        var slow = head;
        var fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var second = slow.next;
        var prev = slow.next = null;
        while (second != null) {
            var tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        var first = head;
        second = prev;
        while (second != null) {
            var tmp1 = first.next;
            var tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }

    public static void main(String[] args) {
        reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }
}
