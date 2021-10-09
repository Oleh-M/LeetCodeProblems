package bfs;

import graph.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ReverseLevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        TreeNode currNode;
        while(!nodes.isEmpty()) {
            int nodesSize = nodes.size();
            List<Integer> nestedList = new ArrayList<>(nodesSize);

            for (int i = 0; i < nodesSize; i++) {
                currNode = nodes.poll();
                if (currNode != null) nestedList.add(currNode.val);
                else continue;

                if(currNode.left != null) nodes.offer(currNode.left);
                if (currNode.right != null) nodes.offer(currNode.right);
            }

            result.add(0, nestedList);
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
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}
