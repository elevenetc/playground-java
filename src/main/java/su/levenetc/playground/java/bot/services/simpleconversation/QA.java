package su.levenetc.playground.java.bot.services.simpleconversation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene.levenetc on 23/10/2016.
 */
public class QA {

    Question question;
    List<QA> next = new ArrayList<>();
    List<Answer> answers = new ArrayList<>();

    public QA(Question question) {
        this.question = question;
    }

    public void addAnswer(Answer... answers) {
        for (Answer answer : answers) {
            this.answers.add(answer);
        }
    }

    public Question getQuestion() {
        return question;
    }

    public void addNext(QA qa) {
        this.next.add(qa);
    }

    public void addNext(QA... qa) {
        for (QA value : qa) this.next.add(value);
    }

    public List<QA> getNext() {
        return next;
    }
}
