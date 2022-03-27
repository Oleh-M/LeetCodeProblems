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

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            var currNode = nodes.poll();
            for (Node neighbor : currNode.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    map.put(neighbor.val, new Node(neighbor.val));
                    nodes.add(neighbor);
                }
                map.get(currNode.val)
                        .neighbors.add(map.get(neighbor.val)); // adding neighbours for current node
            }
        }

        return newNode;
    }
}
