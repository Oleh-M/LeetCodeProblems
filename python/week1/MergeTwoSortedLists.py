from typing import Optional

from ListNode import ListNode


class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1:
            return list2
        if not list2:
            return list1

        dummy = ListNode()
        result = dummy
        while list1 and list2:
            if list1.val < list2.val:
                dummy.next = list1
                list1 = list1.next
            else:
                dummy.next = list2
                list2 = list2.next
            dummy = dummy.next

        if list1:
            result.next = list1
        else:
            result.next = list2

        return result


if __name__ == '__main__':
    Solution().mergeTwoLists(ListNode(1),
                             ListNode(2))
    Solution().mergeTwoLists(ListNode(1, ListNode(2, ListNode(4))),
                             ListNode(1, ListNode(3, ListNode(4))))
