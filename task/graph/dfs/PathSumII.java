package graph.dfs;

import graph.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathSumII {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        if (sum == 0) return Collections.emptyList();
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathsRec(root, sum, currentPath, allPaths);

        return allPaths;
    }

    private static void findPathsRec(TreeNode currentNode,
                                     int sum,
                                     List<Integer> currentPath,
                                     List<List<Integer>> allPath) {
        if (currentNode == null) return;
        currentPath.add(currentNode.val);
        if (currentNode.val == sum && currentNode.left == null && currentNode.right == null)
            allPath.add(new ArrayList<>(currentPath));
        else {
            findPathsRec(currentNode.left, sum - currentNode.val, currentPath, allPath);
            findPathsRec(currentNode.right, sum - currentNode.val, currentPath, allPath);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = PathSumII.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
