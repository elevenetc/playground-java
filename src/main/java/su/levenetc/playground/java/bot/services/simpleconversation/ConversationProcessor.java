package su.levenetc.playground.java.bot.services.simpleconversation;

import su.levenetc.playground.java.utils.Out;

import java.util.List;

/**
 * Created by eugene.levenetc on 23/10/2016.
 */
public class ConversationProcessor {

    private Question question;

    public ConversationProcessor(Question question) {
        this.question = question;
    }

    public boolean isWaitingForAnswer() {
        return question != null && !question.hasNoAnswers();
    }

    public Question next(Answer answer) {

        Question result = question;
        List<Answer> answers = question.getAnswers();
        boolean answerFound = false;

        Out.pln("Q: " + question.getValue());

        for (Answer a : answers) {
            if (answer.equals(a)) {
                Out.pln("A: " + a.getValue());
                question = a.getNext();
                result = question;
                answerFound = true;

                if (question.hasNoAnswers()) {
                    Out.pln("Q: " + question.getValue());
                }

                break;
            }
        }

        if (!answerFound && question.hasClarification()) {
            Out.pln("A: " + answer.getValue());
            Out.pln("Q: " + question.getClarification().getValue());
            result = question.getClarification();
        }

        return result;
    }
}

