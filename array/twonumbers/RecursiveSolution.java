package twonumbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RecursiveSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return calculate(l1, l2, 0);
    }

    private ListNode calculate(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry == 0) return null;
            return new ListNode(1);
        }

        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;

        ListNode head = new ListNode(sum % 10);
        head.next = calculate((l1 == null ? null : l1.next), (l2 == null ? null : l2.next), sum / 10);

        return head;
    }
}
