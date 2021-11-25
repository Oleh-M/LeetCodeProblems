package graph.dfs;

import graph.TreeNode;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2), null);

        System.out.println(diameterOfBinaryTree(treeNode));
    }

    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        diameterSearchRec(root);
        return diameter;
    }

    public static int diameterSearchRec(TreeNode root) {
        if (root == null) return -1;

        int diamL = diameterSearchRec(root.left);
        int diamR = diameterSearchRec(root.right);

        diameter = Math.max(diameter, diamL + diamR + 2);

        return Math.max(diamL, diamR) + 1;
    }
}
