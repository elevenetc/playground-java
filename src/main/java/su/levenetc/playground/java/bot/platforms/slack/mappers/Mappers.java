package su.levenetc.playground.java.bot.platforms.slack.mappers;

import io.reactivex.functions.Function;
import su.levenetc.playground.java.bot.models.User;
import su.levenetc.playground.java.bot.platforms.slack.SlackPlatform;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene.levenetc on 30/10/2016.
 */
public class Mappers {
    public static Function<SlackPlatform.UsersResponse, List<User>> toUsers(){
        return usersResponse -> {
            List<User> result = new ArrayList<>();
            for (SlackPlatform.SlackUser member : usersResponse.members) {
                final User user = new User(member.id);
                user.setName(member.name);
                result.add(user);
            }
            return result;
        };
    }
}
