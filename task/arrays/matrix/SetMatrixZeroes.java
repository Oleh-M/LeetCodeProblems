package arrays.matrix;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        var rowZero = false;

        // determine which rows and cols need to be zero
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    if (r > 0) matrix[r][0] = 0;
                    else rowZero = true;
                }
            }
        }

        // zero all values except first row and col
        for (int r = 1; r < ROWS; r++) {
            for (int c = 1; c < COLS; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // zero first column
        if (matrix[0][0] == 0) {
            for (int i = 0; i < ROWS; i++) {
                matrix[i][0] = 0;
            }
        }

        // zero the first row
        if (rowZero) {
            for (int i = 0; i < COLS; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        var test1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(test1);
        System.out.println(Arrays.deepToString(test1));

        var test2 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(test2);
        System.out.println(Arrays.deepToString(test2));
    }
}
