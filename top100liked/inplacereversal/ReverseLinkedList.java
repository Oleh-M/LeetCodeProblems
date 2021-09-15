package inplacereversal;

import fastandslowpointers.addTwoNumbers.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode = reverseList(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))
        );

        System.out.println(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) return new ListNode();
        if(head.next == null) return head;

        ListNode prev = null, curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
