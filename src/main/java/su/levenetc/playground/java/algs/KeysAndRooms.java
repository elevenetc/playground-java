package su.levenetc.playground.java.algs;

import java.util.List;

public class KeysAndRooms {
    public static boolean isAllVisitable(List<List<Integer>> rooms) {
        List<Integer> room = rooms.get(0);

        exploreRoom(rooms, room);

        for (List<Integer> r : rooms) {
            for (int key : r) {
                if (key > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void exploreRoom(List<List<Integer>> rooms, List<Integer> room) {
        for (int i = 0; i < room.size(); i++) {
            int key = room.get(i);
            if (key >= 0) {
                room.set(i, -1);
                exploreRoom(rooms, rooms.get(key));
            }
        }
    }
}