package graph;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        var pacific = new boolean[row][col];
        var atlantic = new boolean[row][col];

        for (int i = 0; i < col; i++) {
            dfs(heights, 0, i, heights[0][i], pacific); // pacific top left to right
            dfs(heights, row - 1, i, heights[row - 1][i], atlantic); // atlantic bottom left to right
        }

        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, heights[i][0], pacific); // rightmost pacific top to bottom
            dfs(heights, i, col - 1, heights[i][col - 1], atlantic); // leftmost atlantic top to bottom
        }

        var result = new ArrayList<List<Integer>>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private static void dfs(int[][] input, int r, int c, int prevHeight, boolean[][] visited) {
        if (r < 0 || c < 0
                || c >= input[0].length || r >= input.length
                || prevHeight > input[r][c]
                || visited[r][c]) return;

        visited[r][c] = true;
        dfs(input, r - 1, c, input[r][c], visited);
        dfs(input, r, c - 1, input[r][c], visited);
        dfs(input, r + 1, c, input[r][c], visited);
        dfs(input, r, c + 1, input[r][c], visited);
    }

    public static void main(String[] args) {
        System.out.println(pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
    }
}
