package su.levenetc.playground.java.algs;

import java.util.*;

/**
 * Created by eugene.levenetc on 04/05/2017.
 * https://www.hackerrank.com/challenges/maximum-element
 */
public class MaxElem {

    public static List<Integer> get(Action... actions) {

        List<Integer> result = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (Action action : actions) {
            int command = action.command;
            if (command == 1) {
                int value = action.value;
                stack.push(value);

                int amount = 1;

                if (map.containsKey(value)) amount = map.get(value) + 1;

                map.put(value, amount);

            } else if (command == 2) {
                int popped = stack.pop();
                int res = map.get(popped) - 1;
                if (res == 0) {
                    map.remove(popped);
                } else {
                    map.put(popped, res);
                }

            } else if (command == 3) {

                result.add(map.lastKey());
            }
        }

        return result;

    }

    public static class Action {

        public static Action add(int value) {
            return new Action(1, value);
        }

        public static Action remove() {
            return new Action(2, 0);
        }

        public static Action print() {
            return new Action(3, 0);
        }

        public int command;
        public int value;

        public Action(int command, int value) {
            this.command = command;
            this.value = value;
        }
    }
}
