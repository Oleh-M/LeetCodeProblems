import java.util.*;
import java.util.stream.Collectors;

public class AdjacencyListImpl {

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addValues("Bob", Arrays.asList("Alice", "Rob"));
        graph.addValues("Alice", Arrays.asList("Mark", "Maria"));
        graph.addValues("Mark", Arrays.asList("Mark", "Maria"));
        graph.addValues("Rob", Arrays.asList("Mark"));
        graph.addValues("Maria", Arrays.asList("Mark"));

        System.out.println(graph);
    }

    public void DFS(Graph graph, String root) {
        Set<String> visited = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push(root);
        String vertex;
        while (!stack.isEmpty()) {
            vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }
    }

    public static void matrixDFS(int[][] graph, boolean[] visited) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // beginning
        int v;
        while (!stack.isEmpty()) {
            v = stack.pop();
            if (!visited[v]) {
                visited[v] = true;
            }
            for (int i = 0; i < graph.length; i++) {
                if (graph[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    stack.push(v);
                    v = i;
                }
            }
        }
    }

    static class Vertex {
        String label;

        public Vertex(String label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return label.equals(vertex.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }
    }

    static class Graph {
        Map<Vertex, List<Vertex>> graph;

        public Graph(Map<Vertex, List<Vertex>> graph) {
            this.graph = graph;
        }

        public Graph(int size) {
            this(new HashMap<>(size));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Graph graph = (Graph) o;
            return Objects.equals(this.graph, graph.graph);
        }

        @Override
        public int hashCode() {
            return Objects.hash(graph);
        }

        public Map<Vertex, List<Vertex>> getGraph() {
            return graph;
        }

        public void setGraph(Map<Vertex, List<Vertex>> graph) {
            this.graph = graph;
        }

        public void addValues(String label, List<String> vertices) {
            List<Vertex> vertices1 = vertices.stream()
                    .map(Vertex::new)
                    .collect(Collectors.toList());
            this.graph
                    .put(new Vertex(label), vertices1);
        }

        List<Vertex> getAdjVertices(String label) {
            return graph.getOrDefault(new Vertex(label), Collections.emptyList());
        }

        void addVertex(String label) {
            graph.putIfAbsent(new Vertex(label), new ArrayList<>(0));
        }

        void addEdge(String label1, String label2) {
            Vertex v1 = new Vertex(label1);
            Vertex v2 = new Vertex(label2);
            graph.getOrDefault(v1, new ArrayList<>(0)).add(v2);
            graph.getOrDefault(v2, new ArrayList<>(0)).add(v1);
        }
    }
}
