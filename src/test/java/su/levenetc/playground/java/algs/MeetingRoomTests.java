package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.MeetingRoom.minMeetingRooms;

public class MeetingRoomTests {
    @Test
    public void test0() {
        assertEquals(1, minMeetingRooms(intervals(i(0, 1), i(2, 3))));
        assertEquals(2, minMeetingRooms(intervals(i(0, 1), i(2, 3), i(0, 3))));
        assertEquals(3, minMeetingRooms(intervals(i(0, 1), i(2, 3), i(0, 3), i(0, 3))));
    }

    private static MeetingRoom.Interval[] intervals(MeetingRoom.Interval... intervals) {
        return intervals;
    }

    public static MeetingRoom.Interval i(int start, int end) {
        return new MeetingRoom.Interval(start, end);
    }
}
