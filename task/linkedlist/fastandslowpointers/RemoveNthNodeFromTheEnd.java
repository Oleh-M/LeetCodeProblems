package linkedlist.fastandslowpointers;

import linkedlist.ListNode;

public class RemoveNthNodeFromTheEnd {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2));
        System.out.println(removeNthFromEnd(listNode, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        var dummy = new ListNode(0, head);
        var left = dummy;
        var right = head;

        while (n > 0) {
            right = right.next;
            n--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }
}
