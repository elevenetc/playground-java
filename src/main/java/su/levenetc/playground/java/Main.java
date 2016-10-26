package su.levenetc.playground.java;

import io.reactivex.functions.Consumer;
import su.levenetc.playground.java.bot.HellBot;
import su.levenetc.playground.java.bot.platforms.slack.SlackMoshiParser;
import su.levenetc.playground.java.bot.platforms.slack.SlackPlatform;
import su.levenetc.playground.java.bot.services.HeavyService;
import su.levenetc.playground.java.bot.services.PingService;
import su.levenetc.playground.java.bot.services.simpleconversation.SimpleConversation;
import su.levenetc.playground.java.bot.wws.OkHttpSocketClient;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadsUtils;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final HellBot.Builder builder = new HellBot.Builder();
        builder.setPlatform(new SlackPlatform(new OkHttpSocketClient(), new SlackMoshiParser(), System.getenv("BOT_TOKEN")));
        builder.addService(new PingService());
        builder.addService(new HeavyService());
        builder.addService(new SimpleConversation());
        builder.build().start().subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                Out.pln("Connected");
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Out.pln("Error connection:");
                throwable.printStackTrace();
            }
        });

        ThreadsUtils.sleepForever();
    }
}