package dfs;

import graph.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {
        return countPathsRec(root, S, new ArrayList<>());
    }

    public static int countPathsRec(TreeNode currentNode,
                                              int S,
                                              List<Integer> currentPath) {

        if (currentNode == null) return 0;
        currentPath.add(currentNode.val); // adding node for current path to iterate over

        // if the sum of any sub-path is equal to 'S' we increment our path count.
        int pathSum = 0, pathCount = 0;
        // find the sums of all sub-paths in the current path list
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            if(pathSum == S) pathCount++;
        }

        pathCount += countPathsRec(currentNode.left, S, currentPath);
        pathCount += countPathsRec(currentNode.right, S, currentPath);

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);

        return pathCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
//        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
        TreeNode nodes = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
                        new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));
//        System.out.println("Tree has path: " + CountAllPathSum.countPaths(nodes, 8));

        TreeNode nn = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4, new TreeNode(5), new TreeNode(1))));

        System.out.println("Tree has path: " + CountAllPathSum.countPaths(nn, 22));
    }
}
