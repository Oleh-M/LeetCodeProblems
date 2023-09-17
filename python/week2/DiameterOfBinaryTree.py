from typing import Optional

from python.TreeNode import TreeNode


class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        def dfs(root: Optional[TreeNode]):
            nonlocal max_diameter

            if not root:
                return 0

            left_height = dfs(root.left)
            right_height = dfs(root.right)

            max_diameter = max(max_diameter, left_height + right_height)

            return 1 + max(left_height, right_height)

        max_diameter = 0
        dfs(root)
        return max_diameter


if __name__ == '__main__':
    res1 = Solution().diameterOfBinaryTree(TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3)))
    print(res1)
