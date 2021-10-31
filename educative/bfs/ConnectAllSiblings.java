package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {
    public static void connect(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        TreeNode currNode = null;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                if (currNode != null) {
                    currNode.next = nodes.poll();
                    currNode = currNode.next;
                } else currNode = nodes.poll();

                if (currNode.left != null) nodes.offer(currNode.left);
                if (currNode.right != null) nodes.offer(currNode.right);
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode(int x) {
            val = x;
            left = right = next = null;
        }
    }

    ;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNode current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
