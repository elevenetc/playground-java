package su.levenetc.playground.java.bot.services;

import su.levenetc.playground.java.bot.models.Message;

import java.util.List;

/**
 * Created by eugene.levenetc on 26/10/2016.
 */
public class CurrentRunningService extends Service {

    @Override
    public void start() {

        platform().allMessages()
                .filter(message -> "runningServices".equals(message.getMessage()))
                .observeOn(getScheduler())
                .subscribe(this::handleRunningServices);
    }

    private void handleRunningServices(Message message) {
        final List<Service> services = getServicesPool().getServices();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < services.size(); i++) {
            final Service service = services.get(i);
            sb.append("[");
            sb.append(service.getClass().getSimpleName());
            sb.append(":");
            sb.append(service.getMode());
            sb.append("]");
        }
//        platform()
//                .sendMessage(message.respond(sb.toString()))
//                .subscribe();
    }
}
