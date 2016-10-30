package su.levenetc.playground.java.bot.services;

import su.levenetc.playground.java.bot.models.Message;

import static su.levenetc.playground.java.bot.services.filters.Filters.kindOf;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class PingService extends Service {

    public static final String PING = "ping";
    public static final String PONG = "pong";

    @Override
    public void start() {
        platform()
                .personalMessages()
                .filter(kindOf(PING))
                .subscribe(this::handlePingMessage);
    }


    private void handlePingMessage(Message message) {
        platform().sendMessage(
                Message.Builder.respondTo(message).with(PONG)
        ).subscribe();
    }

}