package dfs;

import graph.TreeNode;

public class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        if (root == null) return sequence.length == 0;

        return findPathRec(root, sequence, 0);
    }

    private static boolean findPathRec(TreeNode currentNode, int[] sequence, int sequenceIndex) {
        if (currentNode == null) return false;

        if (sequence.length <= sequenceIndex || currentNode.val != sequence[sequenceIndex])
            return false;

        if (currentNode.left == null && currentNode.right == null && sequenceIndex == sequence.length - 1)
            return true;

        return findPathRec(currentNode.left, sequence, sequenceIndex + 1) ||
                findPathRec(currentNode.right, sequence, sequenceIndex + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[]{1, 0, 7}));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[]{1, 1, 6}));
    }
}
