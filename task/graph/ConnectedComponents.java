package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponents {
    public static int findCircleNumBFS(int[][] isConnected) {
        Queue<Integer> queue = new LinkedList<>();
        var visited = new boolean[isConnected.length];
        var counter = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                queue.add(i);
                counter++;
            }
            while (!queue.isEmpty()) {
                var current = queue.poll();
                visited[current] = true;
                for (int j = 0; j < isConnected[0].length; j++) {
                    if (j != current && isConnected[current][j] == 1 && !visited[j])
                        queue.add(j);
                }
            }
        }

        return counter;
    }

    public static int findCircleNumDFS(int[][] isConnected) {
        var visited = new boolean[isConnected.length];
        int counter = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                counter++;
                findCycleDfs(isConnected, visited, i);
            }
        }

        return counter;
    }

    private static void findCycleDfs(int[][] graph, boolean[] visited, int current) {
        for (int i = 0; i < graph[0].length; i++) {
            if (!visited[i] && graph[current][i] != 0) {
                visited[i] = true;
                findCycleDfs(graph, visited, i);
            }
        }
    }

    public int findCircleNumUnion(int[][] isConnected) {
        var unionFind = new UnionFind(isConnected.length);
        var counter = isConnected.length;

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
        findCircleNumBFS(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        findCircleNumBFS(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;
    private int numberOfDisconnectedEdges;

    public UnionFind(int size) {
        this.numberOfDisconnectedEdges = size;
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            this.parent[i] = i;
        }
        this.rank = new int[size];
    }

    public int find(int x) {
        if (this.parent[x] != x) this.parent[x] = find(this.parent[x]);
        return this.parent[x];
    }

    public boolean union(int x, int y) {
        int xr = this.find(x), yr = this.find(y);
        if (xr == yr) return false;
        else if (this.rank[xr] < this.rank[yr]) this.parent[xr] = yr;
        else if (this.rank[xr] > this.rank[yr]) this.parent[yr] = xr;
        else {
            this.parent[yr] = xr;
            this.rank[xr]++;
        }

        this.numberOfDisconnectedEdges--;
        return true;
    }

    public int getNumberOfDisconnectedEdges() {
        return this.numberOfDisconnectedEdges;
    }
}
