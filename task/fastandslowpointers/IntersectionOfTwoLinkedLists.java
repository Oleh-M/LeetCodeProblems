package fastandslowpointers;

import fastandslowpointers.addTwoNumbers.ListNode;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode headA = new ListNode(2, new ListNode(6, new ListNode(4)));
        ListNode headB = new ListNode(1, new ListNode(5));
        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode aPointer = headA,
                bPointer = headB;

        while (aPointer != bPointer) {
            if (aPointer == null) {
                aPointer = headB;
            } else {
                aPointer = aPointer.next;
            }
            if (bPointer == null) {
                bPointer = headA;
            } else {
                bPointer = bPointer.next;
            }
        }

        return aPointer;
    }
}
