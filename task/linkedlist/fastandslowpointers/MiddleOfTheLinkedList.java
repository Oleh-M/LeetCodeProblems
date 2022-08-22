package linkedlist.fastandslowpointers;

import linkedlist.ListNode;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        System.out.println(middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))));
//        System.out.println(middleNode(new ListNode(1, new ListNode(2))));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null) {
            if (fast.next == null) {
                return slow.next;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
