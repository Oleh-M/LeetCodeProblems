package fastandslowpointers;

import fastandslowpointers.addTwoNumbers.ListNode;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode listNode = deleteDuplicates(
                new ListNode(1, new ListNode(2,
                        new ListNode(3, new ListNode(3,
                                new ListNode(4, new ListNode(5,
                                        new ListNode(6)))))
                ))
        );

        ListNode listNode1 = deleteDuplicates(
                new ListNode(1, new ListNode(1, new ListNode(2)))
        );

        ListNode listNode2 = deleteDuplicates(
                new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))))
        );

        ListNode listNode3 = deleteDuplicates(
                new ListNode(1, new ListNode(1, new ListNode(1)))
        );

        System.out.println(listNode);
        System.out.println(listNode1);
        System.out.println(listNode2);
        System.out.println(listNode3);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode current = head,
                next = head.next;

        while (next != null) {
            if (next.val == current.val) {
                current.next = next.next;
            } else {
                current = next;
            }
            next = next.next;
        }
        return head;
    }
}
