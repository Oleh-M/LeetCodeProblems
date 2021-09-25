package inplacereversal;

import fastandslowpointers.addTwoNumbers.ListNode;

import java.util.List;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode headA = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(7, new ListNode(8)))));
        ListNode headB = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode intersectionNode = mergeTwoLists(headA, headB);
        System.out.println(intersectionNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(0),
                resultPointer = result;

        while (l1 != null || l2 != null) {
            if (l1 != null && (l2 == null || l1.val <= l2.val)) {
                resultPointer.next = l1;
                l1 = l1.next;
            } else {
                resultPointer.next = l2;
                l2 = l2.next;
            }
            resultPointer = resultPointer.next;
        }

        return result.next;
    }
}
