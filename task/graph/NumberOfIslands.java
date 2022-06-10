package graph;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int horizontal = grid.length;
        int vertical = grid[0].length;

        var count = 0;
        for (int i = 0; i < horizontal; i++) {
            for (int j = 0; j < vertical; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int h, int v) {
        if (h < 0 || v < 0
                || h >= grid.length || v >= grid[0].length
                || grid[h][v] == '0') return;
        grid[h][v] = '0';
        dfs(grid, h - 1, v);
        dfs(grid, h + 1, v);
        dfs(grid, h, v - 1);
        dfs(grid, h, v + 1);
    }
}
