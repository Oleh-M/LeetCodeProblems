package bfs;

import graph.TreeNode;

import java.util.*;

public class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        TreeNode currNode;
        boolean leftToRight = true;
        while (!nodes.isEmpty()) {
            List<Integer> levelNodes = new LinkedList<>();
            int nodesSize = nodes.size();

            for (int i = 0; i < nodesSize; i++) {
                currNode = nodes.poll();
                if (currNode != null) {
                    if (leftToRight) {
                        levelNodes.add(currNode.val);
                    } else levelNodes.add(0, currNode.val);
                } else continue;

                if (currNode.left != null) nodes.offer(currNode.left);
                if (currNode.right != null) nodes.offer(currNode.right);
            }

            result.add(levelNodes);
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
