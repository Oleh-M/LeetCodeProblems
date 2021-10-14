package graph.bfs;

import graph.TreeNode;

import java.util.*;

public class RightViewTree {
    public static List<Integer> traverse(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
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
            result.add(currNode.val);
        }
        return result;
    }
}
