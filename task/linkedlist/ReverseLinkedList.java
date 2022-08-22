package linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode = reverseList(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))
        );

        System.out.println(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode result = null;
        while (head != null) {
            var tmp = head.next;
            head.next = result;
            result = head;
            head = tmp;
        }

        return result;
    }
}
