package graph.dfs;

import graph.TreeNode;

public class MergeTwoBinaryTrees {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;

        int rootNode1 = root1 != null ? root1.val : 0;
        int rootNode2 = root2 != null ? root2.val : 0;

        return new TreeNode(rootNode1 + rootNode2,
                mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left),
                mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right));
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode tree2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));

        TreeNode treeNode = mergeTrees(tree1, tree2);

        System.out.println();
    }
}
