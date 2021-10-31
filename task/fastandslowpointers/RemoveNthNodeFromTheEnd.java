package fastandslowpointers;

import fastandslowpointers.addTwoNumbers.ListNode;

public class RemoveNthNodeFromTheEnd {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2));
        System.out.println(removeNthFromEnd(listNode, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode pointer = head,
                prev = new ListNode(0, head);
        int counter = 0;

        while (pointer != null) {
            counter++;
            pointer = pointer.next;
        }

        pointer = head;
        while (pointer != null) {
            if (counter-- == n) {
                if (pointer == head) {
                    head = pointer.next;
                } else {
                    prev.next = pointer.next;
                }
            }
            pointer = pointer.next;
            prev = prev.next;
        }

        return head;
    }
}
