package su.levenetc.playground.java.bot.services;

import su.levenetc.playground.java.bot.models.Message;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class PingService extends Service {

    @Override
    public void start() {
        platform.getMessageObservable()
                .filter(message -> "ping".equals(message.getMessage())).subscribe(this::handleMessage);

    }

    private void handleMessage(Message message) {
        platform.sendMessage(message.respond("pong!")).subscribe();
    }

}