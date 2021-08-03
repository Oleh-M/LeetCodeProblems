/*
Snakes may now move in any of four directions - up, down, left, or right - one square at a time, but they will never return to a square that they've already visited.  If a snake enters the board on an edge square, we want to catch it at a different exit square on the board's edge.

The snake is familiar with the board and will take the route to the nearest reachable exit, in terms of the number of squares it has to move through to get there. Note that there may not be a reachable exit.

Here is an example board:

    col-->        0  1  2  3  4  5  6  7  8
               +---------------------------
    row      0 |  +  +  +  +  +  +  +  0  0
     |       1 |  +  +  0  0  0  0  0  +  +
     |       2 |  0  0  0  0  0  +  +  0  +
     v       3 |  +  +  0  +  +  +  +  0  0
             4 |  +  +  0  0  0  0  0  0  +
             5 |  +  +  0  +  +  0  +  0  +

Write a function that takes a rectangular board with only +'s and 0's, along with a starting point on the edge of the board, and returns the coordinates of the nearest exit to which it can travel.  If there is a tie, return any of the nearest exits.

Example:
find_exit(board_1, (2,0)) => (5,2)

All test cases:
find_exit(board_1, start_1_1) => (5, 2)
find_exit(board_1, start_1_2) => (0, 8)
find_exit(board_1, start_1_3) => (2, 0) or (5, 5)
find_exit(board_1, start_1_4) => (5, 7)
find_exit(board_2, start_2_1) => null (or a special value representing no possible exit)
find_exit(board_2, start_2_2) => null
find_exit(board_3, start_3_1) => (1, 0)
find_exit(board_3, start_3_2) => (3, 0)
find_exit(board_3, start_3_3) => (1, 4)
find_exit(board_3, start_3_4) => (3, 4)
find_exit(board_4, start_4_1) => (0, 1)
find_exit(board_4, start_4_2) => (0, 3)
find_exit(board_4, start_4_3) => (4, 1)
find_exit(board_4, start_4_4) => (4, 3)
find_exit(board_5, start_5_1) => (0, 2)
find_exit(board_5, start_5_2) => (0, 1)
*/


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class SnakeExit {

    public static void main(String[] argv) {


        char[][] board1 = new char[][]{{'+', '+', '+', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '+', '+'},
                {'0', '0', '0', '0', '0', '+', '+', '0', '+'},
                {'+', '+', '0', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '0', '+'},
                {'+', '+', '0', '+', '+', '0', '+', '0', '+'}};


        int[] start1_1 = {2, 0}; // Expected output = {5, 2}
        int[] start1_2 = {0, 7}; // Expected output = {0, 8}
        int[] start1_3 = {5, 2}; // Expected output = {2, 0} or {5, 5}
        int[] start1_4 = {5, 5}; // Expected output = {5, 7}

        char[][] board2 = new char[][]{{'+', '+', '+', '+', '+', '+', '+'},
                {'0', '0', '0', '0', '+', '0', '+'},
                {'+', '0', '+', '0', '+', '0', '0'},
                {'+', '0', '0', '0', '+', '+', '+'},
                {'+', '+', '+', '+', '+', '+', '+'}};

        int[] start2_1 = {1, 0}; // Expected output = null (or a special value representing no possible exit)
        int[] start2_2 = {2, 6}; // Expected output = null

        char[][] board3 = new char[][]{{'+', '0', '+', '0', '+'},
                {'0', '0', '+', '0', '0'},
                {'+', '0', '+', '0', '+'},
                {'0', '0', '+', '0', '0'},
                {'+', '0', '+', '0', '+'}};

        int[] start3_1 = {0, 1}; // Expected output = {1, 0}
        int[] start3_2 = {4, 1}; // Expected output = {3, 0}
        int[] start3_3 = {0, 3}; // Expected output = {1, 4}
        int[] start3_4 = {4, 3}; // Expected output = {3, 4}

        char[][] board4 = new char[][]{{'+', '0', '+', '0', '+'},
                {'0', '0', '0', '0', '0'},
                {'+', '+', '+', '+', '+'},
                {'0', '0', '0', '0', '0'},
                {'+', '0', '+', '0', '+'}};

        int[] start4_1 = {1, 0}; // Expected output = {0, 1}
        int[] start4_2 = {1, 4}; // Expected output = {0, 3}
        int[] start4_3 = {3, 0}; // Expected output = {4, 1}
        int[] start4_4 = {3, 4}; // Expected output = {4, 3}

        char[][] board5 = new char[][]{{'+', '0', '0', '0', '+'},
                {'+', '0', '+', '0', '+'},
                {'+', '0', '0', '0', '+'},
                {'+', '0', '+', '0', '+'}};

        int[] start5_1 = {0, 1}; // Expected output = (0, 2)
        int[] start5_2 = {3, 1}; // Expected output = (0, 1)


        ShortestDistance exit = find_exit(board3, start3_1);

        System.out.println(exit);

    }

    private static ShortestDistance find_exit(char[][] board, int[] start) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.push(start);

        int[][] distances = new int[board.length][board[0].length];
        Arrays.stream(distances).forEach(v -> Arrays.fill(v, Integer.MAX_VALUE));
        distances[start[0]][start[1]] = 0;

        int[][] directions = new int[][]{
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };

        ShortestDistance shortestDistance = new ShortestDistance(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

        int[] v;
        while (!queue.isEmpty()) {
            v = queue.pop();

            for (int[] ints : directions) {
                int x = ints[0] + v[0];
                int y = ints[1] + v[1];
                if (x >= 0 && y >= 0 & x < board.length && y < board[0].length && board[x][y] == '0') {
                    if (distances[x][y] == Integer.MAX_VALUE || distances[x][y] > distances[v[0]][v[1]] + 1) {
                        int newDistance = distances[v[0]][v[1]] + 1;
                        distances[x][y] = newDistance;
                        queue.push(new int[]{x, y});

                        if ((x == 0 || y == 0 || x == board.length - 1 || y == board[0].length - 1) && newDistance < shortestDistance.distance) {
                            shortestDistance = new ShortestDistance(x, y, newDistance);
                        }
                    }
                }
            }
        }

        return shortestDistance;
    }

    static class ShortestDistance {
        public int col;
        public int row;
        public int distance;

        public ShortestDistance(int col, int row, int distance) {
            this.col = col;
            this.row = row;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "(" + col + ", " + row + ")";
        }
    }

}
