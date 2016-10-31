package su.levenetc.playground.java;

import su.levenetc.playground.java.bot.HellBot;
import su.levenetc.playground.java.bot.models.User;
import su.levenetc.playground.java.bot.platforms.slack.SlackMoshiParser;
import su.levenetc.playground.java.bot.platforms.slack.SlackPlatform;
import su.levenetc.playground.java.bot.services.CurrentRunningService;
import su.levenetc.playground.java.bot.services.HeavyService;
import su.levenetc.playground.java.bot.services.PingService;
import su.levenetc.playground.java.bot.services.SimpleSurveyService;
import su.levenetc.playground.java.bot.services.simpleconversation.SimpleConversation;
import su.levenetc.playground.java.bot.wws.OkHttpSocketClient;
import su.levenetc.playground.java.utils.ThreadsUtils;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        new HellBot.Builder()
                .setPlatform(new SlackPlatform(new OkHttpSocketClient(), new SlackMoshiParser(), System.getenv("SLACK_TOKEN")))
                .addService(new HeavyService())
                .addService(new PingService())
                .addService(new CurrentRunningService())
                .addService(new SimpleConversation())
                .addService(new SimpleSurveyService())
                .setDebugUsers(new User("U04CXNETW"))
                .build()
                .start()
                .subscribe();
        ThreadsUtils.sleepForever();
    }
}