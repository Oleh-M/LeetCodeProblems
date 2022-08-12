package interval;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int currentEnd = intervals[0][1];
        var removeCounter = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (currentEnd > intervals[i][0]) {
                currentEnd = Math.min(currentEnd, intervals[i][1]);
                removeCounter++;
            } else {
                currentEnd = Math.max(currentEnd, intervals[i][1]);
            }
        }

        return removeCounter;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
    }
}
