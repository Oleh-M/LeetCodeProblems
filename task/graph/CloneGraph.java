package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {

    public static Node cloneGraph(Node node) {
        if (node == null) return null;

        var clone = new Node(node.val);
        Queue<Node> queue = new LinkedList<>();
        var map = new HashMap<Integer, Node>();
        map.put(clone.val, clone);

        queue.add(node);

        while (!queue.isEmpty()) {
            var currentNode = queue.poll();
            for (Node neighbor : currentNode.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    queue.add(neighbor);
                    map.put(neighbor.val, new Node(neighbor.val));
                }

                map.get(currentNode.val)
                        .neighbors.add(map.get(neighbor.val));
            }
        }

        return clone;
    }
}
