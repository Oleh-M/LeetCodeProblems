package graph;

import java.util.*;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null;

        var newNode = new Node(node.val);
        var resMap = new HashMap<Integer, Node>();
        resMap.put(newNode.val, newNode);

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            var currNode = nodes.poll();
            for (Node neighbor : currNode.neighbors) {

                if (!resMap.containsKey(neighbor.val)) {
                    resMap.put(neighbor.val, new Node(neighbor.val));
                    nodes.add(neighbor);
                }
                resMap.get(currNode.val).neighbors.add(resMap.get(neighbor.val));
            }

        }

        return newNode;
    }
}
