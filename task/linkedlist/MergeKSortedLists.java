package linkedlist;

import fastandslowpointers.addTwoNumbers.ListNode;

import java.util.ArrayList;

public class MergeKSortedLists {
    public static void main(String[] args) {
        var data = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };

        mergeKLists(data);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        while (lists.length > 1) {
            var merged = new ArrayList<ListNode>();
            for (int i = 0; i < lists.length; i += 2) {
                var l1 = lists[i];
                var l2 = i + 1 >= lists.length ? null : lists[i + 1];
                merged.add(mergeLists(l1, l2));
            }
            lists = merged.toArray(new ListNode[0]);
        }

        return lists[0];
    }

    public static ListNode mergeLists(ListNode l1, ListNode l2) {
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
}
