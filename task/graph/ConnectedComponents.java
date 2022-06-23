package graph;

import java.util.LinkedList;

public class ConnectedComponents {
    public static int findCircleNumBFS(int[][] isConnected) {
        var nodesToVisit = new LinkedList<Integer>();
        var visited = new boolean[isConnected.length];
        var counter = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                nodesToVisit.add(i);
                counter++;
            }

            while (!nodesToVisit.isEmpty()) {
                var current = nodesToVisit.poll();
                visited[current] = true;
                for (int j = 0; j < isConnected[0].length; j++) {
                    if (!visited[j] && isConnected[current][j] == 1 && current != j) {
                        nodesToVisit.add(j);
                    }
                }
            }
        }

        return counter;
    }

    public static int findCircleNumDFS(int[][] isConnected) {
        var visited = new boolean[isConnected.length];
        var counter = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                counter++;
                findCircleNumRec(isConnected, visited, i);
            }
        }

        return counter;
    }

    private static void findCircleNumRec(int[][] graph, boolean[] visited, int current) {
        visited[current] = true;
        for (int i = 0; i < graph[0].length; i++) {
            if (!visited[i] && graph[current][i] == 1 && current != i) {
                findCircleNumRec(graph, visited, i);
            }
        }
    }

    public int findCircleNumUnion(int[][] isConnected) {
        var unionFind = new UnionFind(isConnected.length);

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        return unionFind.getNumberOfDisconnectedEdges();
    }

    public static void main(String[] args) {
        System.out.println(findCircleNumBFS(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
        System.out.println(findCircleNumBFS(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(findCircleNumBFS(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }
}

class UnionFind {
    private int size;
    private int[] ids;
    private int[] sz;
    private int numConnected;

    public UnionFind(int size) {
        this.size = size;
        this.ids = new int[size];
        this.sz = new int[size];

        for (int i = 0; i < size; i++) {
            ids[i] = i;
            sz[i] = 1;
        }

        this.numConnected = size;
    }

    public int find(int p) {
        if (p == ids[p]) return p;
        else return ids[p] = find(ids[p]);
    }

    public void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;

        if (sz[u] > sz[v]) {
            ids[v] = u;
            sz[u] += sz[v];
        } else {
            ids[u] = v;
            sz[v] += sz[u];
        }
        this.numConnected--;
    }

    public int getNumberOfDisconnectedEdges() {
        return numConnected;
    }
}
