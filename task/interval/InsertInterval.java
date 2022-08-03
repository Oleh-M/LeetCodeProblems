package interval;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        var result = new ArrayList<int[]>();

        for (int[] interval : intervals) {
            if (newInterval[1] < interval[0]) {
                result.add(newInterval);
                newInterval = interval;
            } else if (newInterval[0] > interval[1]) {
                result.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        var a = insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        System.out.println(Arrays.toString(a));

        var b = insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        System.out.println(Arrays.toString(b));
    }
}
