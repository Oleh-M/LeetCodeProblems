package bfs;

import graph.TreeNode;

import java.util.*;

public class RightViewTree {
    public static List<TreeNode> traverse(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        TreeNode currNode = null;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                currNode = nodes.poll();

                if (currNode.left != null) nodes.offer(currNode.left);
                if (currNode.right != null) nodes.offer(currNode.right);
            }
            result.add(currNode);
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
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewTree.traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}
