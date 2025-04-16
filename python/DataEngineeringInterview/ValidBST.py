from typing import Optional

from python.TreeNode import TreeNode


class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        seen = set()
        def checkBST(node: Optional[TreeNode], min_val: float, max_val: float):
            if not node:
                return True
            if node.val in seen or node.val < min_val or node.val > max_val:
                return False
            seen.add(node.val)

            return checkBST(node.left, min_val, node.val) and checkBST(node.right, node.val, max_val)
        return checkBST(root, float('-inf'), float('inf'))