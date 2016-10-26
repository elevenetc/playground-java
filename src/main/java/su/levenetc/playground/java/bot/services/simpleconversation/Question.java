package su.levenetc.playground.java.bot.services.simpleconversation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene.levenetc on 23/10/2016.
 */
public class Question<T> {

    private T value;
    private List<Answer> answers = new ArrayList<>();
    private Clarification clarification;

    public Question(T value) {
        this.value = value;
    }

    public Question addAnswer(Answer... answers) {
        for (Answer answer : answers) {
            this.answers.add(answer);
        }
        return this;
    }

    public T getValue() {
        return value;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public Clarification getClarification() {
        return clarification;
    }

    public boolean hasNoAnswers() {
        return answers == null || answers.isEmpty();
    }

    public boolean hasClarification() {
        return clarification != null;
    }

    public Question<T> addClarification(Clarification clarification) {
        this.clarification = clarification;
        return this;
    }
}