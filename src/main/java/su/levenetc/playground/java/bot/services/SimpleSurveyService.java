package su.levenetc.playground.java.bot.services;

import su.levenetc.playground.java.bot.models.User;

import java.util.List;

/**
 * Created by eugene.levenetc on 30/10/2016.
 */
public class SimpleSurveyService extends Service {

    @Override
    public void start() {
        platform().getUsers().subscribe(this::handleUsers);
    }

    private void handleUsers(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            platform()
                    .sendPrivateMessageTo(users.get(i), "ZZZ")
                    .subscribe();
        }
    }
}
