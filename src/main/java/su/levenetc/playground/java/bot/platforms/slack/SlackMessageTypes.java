package su.levenetc.playground.java.bot.platforms.slack;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class SlackMessageTypes {
    public static final int RECONNECT_URL = 100;
    public static final int PRESENCE_CHANGE = 101;
    public static final int HELLO = 102;
    public static final int TYPING = 103;
    public static final int MESSAGE = 104;
    public static final int IM_MARKED = 105;
    public static final int GROUP_MARKED = 106;
    public static final int ERROR = 107;
    public static final int CHANNEL_MARKED = 108;
    public static final int PREF_CHANGE = 109;
    public static int DELIVERED = -1;
}
