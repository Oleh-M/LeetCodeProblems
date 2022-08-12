package interval;

import java.util.Comparator;
import java.util.List;

/**
 * Given an array of meeting time intervals consisting
 * of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 * <p>
 * Example1
 * <p>
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: false
 * Explanation:
 * (0,30), (5,10) and (0,30),(15,20) will conflict
 * <p>
 * Example2
 * Input: intervals = [(5,8),(9,15)]
 * Output: true
 * Explanation:
 * Two times will not conflict
 */


public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null ||
                intervals.size() == 0 ||
                intervals.size() == 1) return true;

        intervals.sort(Comparator.comparingInt(i -> i.start));

        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end > intervals.get(i + 1).start) return false;
        }

        return true;
    }
}
