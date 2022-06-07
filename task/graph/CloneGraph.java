package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {

    public static Node cloneGraph(Node node) {
        if (node == null) return null;

        var newNode = new Node(node.val);
        var map = new HashMap<Integer, Node>();
        map.put(newNode.val, newNode);

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            var currentNode = queue.poll();
            for (Node neighbor : currentNode.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    queue.add(neighbor);
                    map.put(neighbor.val, new Node(neighbor.val));
                }

                map.get(currentNode.val).neighbors.add(map.get(neighbor.val));
            }
        }

        return newNode;
    }
}
