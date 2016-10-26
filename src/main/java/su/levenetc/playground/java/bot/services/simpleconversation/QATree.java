package su.levenetc.playground.java.bot.services.simpleconversation;

/**
 * Created by eugene.levenetc on 23/10/2016.
 */
public class QATree {

    private QA current;

    public QA add(QA qa) {
        if (current == null) current = qa;
        return qa;
    }


}
