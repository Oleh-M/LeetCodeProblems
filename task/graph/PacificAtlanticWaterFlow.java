package graph;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        var row = heights.length;
        var col = heights[0].length;

        var pacific = new boolean[row][col];
        var atlantic = new boolean[row][col];

        // left right
        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, heights[i][0], pacific);
            dfs(heights, i, col - 1, heights[i][col - 1], atlantic);
        }

        // top bottom
        for (int i = 0; i < col; i++) {
            dfs(heights, 0, i, heights[0][i], pacific);
            dfs(heights, row - 1, i, heights[row - 1][i], atlantic);
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

    public static void dfs(int[][] heights,
                           int r, int c,
                           int prevHeight,
                           boolean[][] visited) {
        if (r < 0 || c < 0
                || r >= heights.length
                || c >= heights[0].length
                || prevHeight > heights[r][c]
                || visited[r][c]) return;

        visited[r][c] = true;
        dfs(heights, r - 1, c, heights[r][c], visited);
        dfs(heights, r + 1, c, heights[r][c], visited);
        dfs(heights, r, c - 1, heights[r][c], visited);
        dfs(heights, r, c + 1, heights[r][c], visited);
    }

    public static void main(String[] args) {

    }
}
