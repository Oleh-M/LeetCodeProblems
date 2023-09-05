from typing import Optional

from ListNode import ListNode


class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return False

        slow, fast = head, head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                return True

        return False

if __name__ == '__main__':
    Solution().hasCycle(ListNode(3, ListNode(2, ListNode(0, ListNode(4)))))
    print()