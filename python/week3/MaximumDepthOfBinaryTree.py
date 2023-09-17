from typing import Optional

from python.TreeNode import TreeNode


class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        left_size = self.maxDepth(root.left)
        right_size = self.maxDepth(root.right)

        return 1 + max(left_size, right_size)


if __name__ == '__main__':
    res1 = Solution().maxDepth(TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7))))
    print(res1)
