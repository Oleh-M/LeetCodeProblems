package interval;

public class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    Interval(int[] range) {
        this.start = range[0];
        this.end = range[1];
    }
}
