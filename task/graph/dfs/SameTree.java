package graph.dfs;

import graph.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SameTree {

    public static void main(String[] args) {
        System.out.println(
                isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                        new TreeNode(1, new TreeNode(2), new TreeNode(3)))
        );

        System.out.println(
                isSameTree(new TreeNode(1, new TreeNode(2), null),
                        new TreeNode(1, null, new TreeNode(2)))
        );

        System.out.println(
                isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(1)),
                        new TreeNode(1, new TreeNode(1), new TreeNode(2)))
        );
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> nodesForP = new ArrayDeque<>();
        Deque<TreeNode> nodesForQ = new ArrayDeque<>();

        nodesForP.push(p);
        nodesForQ.push(q);

        TreeNode currPNode, currQNode;
        while (!nodesForP.isEmpty() && !nodesForQ.isEmpty()) {
            currPNode = nodesForP.poll();
            currQNode = nodesForQ.poll();

            if (currPNode.val != currQNode.val) return false;

            if ((currPNode.left == null && currQNode.left != null) ||
                    (currPNode.left != null && currQNode.left == null)) return false;
            if ((currPNode.right == null && currQNode.right != null) ||
                    (currPNode.right != null && currQNode.right == null)) return false;

            if (currPNode.left != null && currQNode.left != null) {
                nodesForP.push(currPNode.left);
                nodesForQ.push(currQNode.left);
            }

            if (currPNode.right != null && currQNode.right != null) {
                nodesForP.push(currPNode.right);
                nodesForQ.push(currQNode.right);
            }
        }

        return true;
    }
}
