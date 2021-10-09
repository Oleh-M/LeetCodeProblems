package graph.bfs;

import graph.TreeNode;

import java.util.*;

public class AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {
        System.out.println(averageOfLevels(
                new TreeNode(3,
                        new TreeNode(9), new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)))));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return Collections.emptyList();

        List<Double> res = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        double levelSum;
        TreeNode currentNode;
        while (!nodes.isEmpty()) {
            levelSum = 0;

            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                currentNode = nodes.poll();
                levelSum += currentNode.val;

                if(currentNode.left != null) nodes.offer(currentNode.left);
                if(currentNode.right != null) nodes.offer(currentNode.right);
            }
            res.add(levelSum / size);
        }

        return res;
    }
}
