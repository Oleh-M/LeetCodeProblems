package linkedlist;

import fastandslowpointers.addTwoNumbers.ListNode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode headA1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode headB1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode intersectionNode1 = mergeTwoLists(headA1, headB1);
        System.out.println(intersectionNode1);

        ListNode headA = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(7, new ListNode(8)))));
        ListNode headB = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode intersectionNode = mergeTwoLists(headA, headB);
        System.out.println(intersectionNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        var result = new ListNode(0);
        var dummy = result;

        while (l1 != null || l2 != null) {
            if (l1 != null && (l2 == null || l1.val < l2.val)) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        return result.next;
    }

    public static ListNode mergeTwoListsRec(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoListsRec(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRec(l1, l2.next);
            return l2;
        }
    }
}
