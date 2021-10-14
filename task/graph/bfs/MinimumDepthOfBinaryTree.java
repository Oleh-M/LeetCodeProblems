package graph.bfs;

import graph.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        System.out.println(minDepth(
                new TreeNode(3,
                        new TreeNode(9), new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)))));

        System.out.println(minDepth(
                new TreeNode(2, null, new TreeNode(3,
                        null, new TreeNode(4,
                        null, new TreeNode(5,
                        null, new TreeNode(6)))))
        ));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        int minDepth = 0;
        TreeNode currentNode;
        while (!nodes.isEmpty()) {
            int nodesSize = nodes.size();
            minDepth++;

            for (int i = 0; i < nodesSize; i++) {
                currentNode = nodes.poll();
                if (currentNode != null &&
                        currentNode.left == null &&
                        currentNode.right == null) return minDepth;

                if (currentNode.left != null) nodes.offer(currentNode.left);
                if (currentNode.right != null) nodes.offer(currentNode.right);
            }
        }

        return minDepth;
    }
}
