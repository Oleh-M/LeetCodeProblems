from TreeNode import TreeNode


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while root:
            if root.val < p.val and root.val < q.val:
                root = root.right
            elif root.val > p.val and root.val > q.val:
                root = root.left
            else:
                return root


if __name__ == '__main__':
    sol = Solution().lowestCommonAncestor(
        TreeNode(6, TreeNode(2, TreeNode(0), TreeNode(4, TreeNode(3), TreeNode(5))),
                 TreeNode(8, TreeNode(7), TreeNode(9))),
        TreeNode(2),
        TreeNode(8)
    )

    print()
