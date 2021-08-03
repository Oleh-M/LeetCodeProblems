public class IslandProblem {

    public static void main(String[] args) {
        char[][] M = new char[][]{{'1','1','0','0','0'},
                                  {'1','1','0','0','0'},
                                  {'0','0','1','0','0'},
                                  {'0','0','0','1','1'},
                                  };

        int t = numIslands(M);
        System.out.println(t);
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '#';
        dfs(grid, row+1, col); // down
        dfs(grid, row-1, col); // up
        dfs(grid, row, col+1); // right
        dfs(grid, row, col-1); // left
    }
}
