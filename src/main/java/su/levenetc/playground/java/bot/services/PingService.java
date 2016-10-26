package su.levenetc.playground.java.bot.services;

import su.levenetc.playground.java.bot.models.Message;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class PingService extends Service {

    @Override
    public void start() {
        getPlatform().getMessageObservable()
                .filter(message -> "ping".equals(message.getMessage())).subscribe(this::handlePingMessage);

    }

    private void handlePingMessage(Message message) {
        getPlatform().sendMessage(message.respond("pong!")).subscribe();
    }

}