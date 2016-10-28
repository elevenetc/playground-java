package su.levenetc.playground.java.bot.services;

import su.levenetc.playground.java.bot.models.Message;

import static su.levenetc.playground.java.bot.services.filters.Filters.kindOf;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class PingService extends Service {

    @Override
    public void start() {
        platform()
                .personalMessages()
                .filter(kindOf("ping"))
                .subscribe(this::handlePingMessage);
    }


    private void handlePingMessage(Message message) {
        platform().respondTo(message).with("pong!");
    }

}