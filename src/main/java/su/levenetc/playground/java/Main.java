package su.levenetc.playground.java;

import java.util.PriorityQueue;

import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadsUtils;

public class Main {

    public static void main(String[] args) {
        ThreadsUtils.sleep(50);
        Out.pln();
        run();
        Out.pln();
        ThreadsUtils.sleep(50);
    }

    static void run() {

        Out.pln(5/2);
        Out.pln(3/2);

    }

    static boolean isEven(int value) {
        return (value & 1) == 0;
    }

}