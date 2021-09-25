package fastandslowpointers;

import fastandslowpointers.addTwoNumbers.ListNode;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode listNode = removeElements(
                new ListNode(1, new ListNode(2,
                        new ListNode(6, new ListNode(3,
                                new ListNode(4, new ListNode(5,
                                        new ListNode(6)))))
                )), 6
        );

        System.out.println(listNode);
    }

    public static ListNode removeElements(ListNode head /* null */ , int val /* 6 */) {
        if (head == null) return null;

        // head == 2 -> 3 -> 6 -> 4 -> 5 -> 6 -> null
        ListNode next  = removeElements(head.next, val); // 1 -> 2 -> 3 -> 4 -> 5 -> null
        if(head.val == val) return next; // false
        head.next = next; // head == 1 -> 2 -> 3 -> 4 -> 5 -> null
        return head;
    }
}
