package su.levenetc.playground.java.algs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom {
    public static int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        ends.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {

            Interval meeting = intervals[i];
            int shortestMeetingEnd = ends.peek();
            int meetingStart = meeting.start;

            if (meetingStart >= shortestMeetingEnd) {
                //meetings are not overlapping
                ends.poll();
            }
            ends.offer(meeting.end);
        }
        return ends.size();
    }

    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
