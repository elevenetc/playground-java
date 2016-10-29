package bot;

import su.levenetc.playground.java.bot.models.Message;

/**
 * Created by eugene.levenetc on 29/10/2016.
 */
public class MessageBuilderUtils {
    public static Message.Builder respondTo(String text) {
        final Message.Builder result = new Message.Builder();
        result.setAction(Message.Builder.Action.RESPOND_TO);
        result.setText(text);
        return result;
    }

}
