/*

After catching your classroom students cheating before, you realize your students are getting craftier and hiding words
in 2D grids of letters. The word may start anywhere in the grid, and consecutive letters can be either immediately below
or immediately to the right of the previous letter.

Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates.
 If there are multiple matches, return anyone.

grid1 = [
    ['c', 'c', 'x', 't', 'i', 'b'],
    ['c', 'c', 'a', 't', 'n', 'i'],
    ['a', 'c', 'n', 'n', 't', 't'],
    ['t', 'c', 's',  'i', 'p', 't'],
    ['a', 'o', 'o', 'o', 'a', 'a'],
    ['o', 'a', 'a', 'a', 'o', 'o'],
    ['k', 'a', 'i', 'c', 'k', 'i'],
]
word1 = "catnip"
word2 = "cccc"
word3 = "s"
word4 = "bit"
word5 = "aoi"
word6 = "ki"
word7 = "aaa"
word8 = "ooo"

grid2 = [['a']]
word9 = "a"

find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
find_word_location(grid1, word2) =>
       [(0, 1), (1, 1), (2, 1), (3, 1)]
    OR [(0, 0), (1, 0), (1, 1), (2, 1)]
    OR [(0, 0), (0, 1), (1, 1), (2, 1)]
    OR [(1, 0), (1, 1), (2, 1), (3, 1)]
find_word_location(grid1, word3) => [(3, 2)]
find_word_location(grid1, word4) => [(0, 5), (1, 5), (2, 5)]
find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
find_word_location(grid1, word6) => [(6, 4), (6, 5)]
find_word_location(grid1, word7) => [(5, 1), (5, 2), (5, 3)]
find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
find_word_location(grid2, word9) => [(0, 0)]

r = number of rows
c = number of columns
w = length of the word
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterviewKarat {

    public static void main(String[] args) {
        char[][] grid1 = new char[][]{
                {'c', 'c', 'x', 't', 'i', 'b'},
                {'c', 'c', 'a', 't', 'n', 'i'},
                {'a', 'c', 'n', 'n', 't', 't'},
                {'t', 'c', 's', 'i', 'p', 't'},
                {'a', 'o', 'o', 'o', 'a', 'a'},
                {'o', 'a', 'a', 'a', 'o', 'o'},
                {'k', 'a', 'i', 'c', 'k', 'i'}
        };

        String word1 = "catnip";
        String word2 = "cccc";
        String word3 = "s";
        String word4 = "bit";
        String word5 = "aoi";
        String word6 = "ki";
        String word7 = "aaa";
        String word8 = "ooo";

        find_word_location(grid1, word1);
    }

    static int[][] iteration = new int[][]{
            {1, 0},
            {0, 1}
    };

    public static List<List<Integer>> find_word_location(char[][] grid, String word) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> pos = new ArrayList<>();

        int letterCounter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == word.charAt(letterCounter) && pos.isEmpty()) {
                    pos.add(new int[]{i, j});
                    res.add(Arrays.asList(i, j));
                    letterCounter++;
                } else if (grid[i][j] == word.charAt(letterCounter) && !pos.isEmpty()
                        && letterCounter != 0
                        && ((pos.get(letterCounter - 1)[0] == i + 1 && pos.get(letterCounter - 1)[1] == j)
                        || (pos.get(letterCounter - 1)[0] == i && pos.get(letterCounter - 1)[1] == j + 1))) {
                    res.add(Arrays.asList(i, j));
                    pos.add(new int[]{i, j});
                    letterCounter++;
                } else {
                    pos.remove(letterCounter - 1);
                    if (letterCounter != 0) letterCounter--;
                }
            }
        }

        return res;
    }
}
