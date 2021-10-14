package bfs;

import graph.TreeNode;

import java.util.*;

public class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        if(root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        TreeNode currentNode;
        while (!nodes.isEmpty()) {

            int size = nodes.size();
            List<Integer> nestedList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                currentNode = nodes.poll();
                if (currentNode != null) nestedList.add(currentNode.val);
                else continue;

                if (currentNode.left != null) nodes.offer(currentNode.left);
                if (currentNode.right != null) nodes.offer(currentNode.right);
            }

            result.add(nestedList);
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
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
