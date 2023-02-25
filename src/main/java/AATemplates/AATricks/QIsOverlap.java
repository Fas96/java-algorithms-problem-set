package AATemplates.AATricks;

import java.util.Arrays;

public class QIsOverlap {
    class Q252MeetingRooms{
        public boolean canAttendMeetings(int[][] intervals) {
            if (intervals.length <= 1) return true;
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int[] cur = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                if (isOverlap(cur, intervals[i])) return false;
                cur = intervals[i];
            }
            return true;
        }
        private boolean isOverlap(int[] a, int[] b) {
            int l = Math.max(a[0], b[0]);
            int r = Math.min(a[1], b[1]);
            return l < r;
        }

    }
}
