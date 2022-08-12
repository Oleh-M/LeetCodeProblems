package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        var result = new ArrayList<int[]>();
        var currInterval = intervals[0];
        result.add(currInterval);

        for (int[] interval : intervals) {
            var currEnd = currInterval[1];
            var nextStart = interval[0];
            var nextEnd = interval[1];

            if (currEnd >= nextStart) {
                currInterval[1] = Math.max(currInterval[1], nextEnd);
            } else {
                result.add(interval);
                currInterval = interval;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        merge(new int[][]{{1, 4}, {5, 6}});
        merge(new int[][]{{1, 4}, {4, 6}});
    }
}
