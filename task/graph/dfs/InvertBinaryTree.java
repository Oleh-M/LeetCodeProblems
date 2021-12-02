package graph.dfs;

import graph.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static TreeNode invertTreeIterative(TreeNode root) {
        if(root == null) return null;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        TreeNode node;
        while(!queue.isEmpty()) {
            node = queue.poll();
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }

            var temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        return root;
    }

    public static void main(String[] args) {
        var tree = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        invertTree(tree);
        invertTreeIterative(tree);
    }
}
