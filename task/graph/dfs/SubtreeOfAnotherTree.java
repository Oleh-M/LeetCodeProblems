package graph.dfs;

import graph.TreeNode;

public class SubtreeOfAnotherTree {
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (verifySubTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    public static boolean verifySubTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root != null && subRoot != null && root.val == subRoot.val) {
            return verifySubTree(root.left, subRoot.left) && verifySubTree(root.right, subRoot.right);
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                new TreeNode(5)
        );
        TreeNode subTree1 = new TreeNode(4, new TreeNode(1), new TreeNode(2));

        TreeNode tree2 = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2, null, new TreeNode(0))),
                new TreeNode(5)
        );

        TreeNode tree3 = new TreeNode(1, new TreeNode(1), null);
        TreeNode subTree2 = new TreeNode(1);

        System.out.println(isSubtree(tree1, subTree1));
        System.out.println(isSubtree(tree2, subTree1));
        System.out.println(isSubtree(tree3, subTree2));
    }
}
