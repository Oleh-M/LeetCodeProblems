package dfs;

import graph.TreeNode;

public class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        return findSumOfPathNumsRec(root, 0);
    }

    private static int findSumOfPathNumsRec(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) return sum;

        return findSumOfPathNumsRec(root.left, sum) +
                findSumOfPathNumsRec(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
