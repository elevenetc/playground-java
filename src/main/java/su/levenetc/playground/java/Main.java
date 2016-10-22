package su.levenetc.playground.java;

import su.levenetc.playground.java.bot.HelloBot;
import su.levenetc.playground.java.utils.ThreadsUtils;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        HelloBot.create().init();
        ThreadsUtils.sleepForever();
    }
}