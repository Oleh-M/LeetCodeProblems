from typing import Optional

from TreeNode import TreeNode


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def has_balanced(root: Optional[TreeNode]) -> (bool, int):
            if not root:
                return True, 1
            left, right = has_balanced(root.left), has_balanced(root.right)
            balanced = left[0] and right[0] and abs(right[1] - left[1]) <= 1
            return balanced, 1 + max(right[1], left[1])

        return has_balanced(root)[0]


if __name__ == '__main__':
   res2 = Solution().isBalanced(TreeNode(1, TreeNode(2, TreeNode(3, TreeNode(4), TreeNode(4)), TreeNode(3)), TreeNode(2)))
   res1 = Solution().isBalanced(TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7))))
   print()