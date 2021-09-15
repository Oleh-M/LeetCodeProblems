package fastandslowpointers;

import fastandslowpointers.addTwoNumbers.ListNode;

import java.util.*;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        boolean listNode = isPalindrome(
                new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))
        );

        System.out.println(listNode);
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;

        // find the middle of the list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse the second half
        ListNode prev = null, tmp;
        while(slow != null) {
            tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }

        // check palindrome
        fast = head;
        slow = prev;
        while (slow != null) {
            if(fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    public static boolean isPalindrome1(ListNode head) {
        List<Integer> nodes = new ArrayList<>();

        while(head != null) {
            nodes.add(head.val);
            head = head.next;
        }

        for (int i = 0, j = nodes.size() - 1; i < nodes.size() / 2 || j > nodes.size() / 2; i++, j--) {
            if(!Objects.equals(nodes.get(i), nodes.get(j))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        stack.push(head.val);
        list.add(head.val);
        while (head.next != null) {
            list.add(head.next.val);
            stack.push(head.next.val);
            head = head.next;
        }

        for (Integer integer : list) {
            if (!stack.pop().equals(integer)) return false;
        }

        return true;
    }
}
