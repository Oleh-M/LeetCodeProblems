from typing import Optional

from python.ListNode import ListNode


class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head.next: return head

        slow, fast = head, head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        return slow


if __name__ == '__main__':
    res2 = Solution().middleNode(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6)))))))
    res1 = Solution().middleNode(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))))
    print()
