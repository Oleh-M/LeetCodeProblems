package bfs;

import graph.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        TreeNode currentNode;
        while (!nodes.isEmpty()) {
            currentNode = nodes.poll();
            if (currentNode.left != null) nodes.offer(currentNode.left);
            if (currentNode.right != null) nodes.offer(currentNode.right);

            if(currentNode.val == key) break;
        }

        return nodes.poll();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}
