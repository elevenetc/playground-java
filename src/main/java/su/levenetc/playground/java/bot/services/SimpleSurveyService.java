package su.levenetc.playground.java.bot.services;

import io.reactivex.functions.Consumer;
import su.levenetc.playground.java.bot.models.User;

import java.util.List;

/**
 * Created by eugene.levenetc on 30/10/2016.
 */
public class SimpleSurveyService extends Service {

    @Override
    public void start() {
        platform()
                .getUsers().subscribe(new Consumer<List<User>>() {
            @Override
            public void accept(List<User> users) throws Exception {

            }
        });
    }
}
