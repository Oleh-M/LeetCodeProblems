package graph.dfs;

import graph.TreeNode;

public class LCAOfBinaryTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if(p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(6,
                new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                new TreeNode(8, new TreeNode(7), new TreeNode(9)));

        TreeNode tree2 = new TreeNode(2, new TreeNode(1), null);
        TreeNode tree3 = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        TreeNode treeNode = lowestCommonAncestor(tree, new TreeNode(2), new TreeNode(4));
        TreeNode treeNode2 = lowestCommonAncestor(tree2, new TreeNode(2), new TreeNode(1));
        TreeNode treeNode3 = lowestCommonAncestor(tree3, new TreeNode(3), new TreeNode(1));
        System.out.println(treeNode.val);
        System.out.println(treeNode2.val);
        System.out.println(treeNode3.val);
    }
}
