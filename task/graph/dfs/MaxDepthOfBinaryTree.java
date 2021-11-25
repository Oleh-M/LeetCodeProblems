package graph.dfs;

import graph.TreeNode;

public class MaxDepthOfBinaryTree {
    static int maxDepthVal = 0;

    public static int maxDepth(TreeNode root) {
        maxDepthRec(root, 0);
        return maxDepthVal;
    }

    public static void maxDepthRec(TreeNode root, int currentDepth) {
        if(root == null) {
            maxDepthVal = Math.max(maxDepthVal, currentDepth);
            return;
        }

        maxDepthRec(root.left, currentDepth + 1);
        maxDepthRec(root.right, currentDepth + 1);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

//        System.out.println(maxDepth(tree));
        System.out.println(maxDepth(new TreeNode(1, null, new TreeNode(2))));
    }
}
