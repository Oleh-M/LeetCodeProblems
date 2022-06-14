package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidTree {
    public static boolean validTree(int n, int[][] edges) {
        if (n == 0) return true;

        var adj = new HashMap<Integer, List<Integer>>(n);

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        var visited = new boolean[n];
        if (dfs(0, -1, visited, adj)) return false;

        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }

    private static boolean dfs(int current, int prev, boolean[] visited, Map<Integer, List<Integer>> nodes) {
        if (visited[current]) return true;

        visited[current] = true;
        for (Integer i : nodes.get(current)) {
            if (i != prev && dfs(i, current, visited, nodes)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        System.out.println(validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
    }
}
