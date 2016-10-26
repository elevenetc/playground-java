package su.levenetc.playground.java.bot.services.simpleconversation;

/**
 * Created by eugene.levenetc on 23/10/2016.
 */
public class Answer<T> {

    Question next;
    private T value;

    public Answer(T value) {
        this.value = value;
    }

    public Answer setNext(Question next) {
        this.next = next;
        return this;
    }

    public Question getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer<?> answer = (Answer<?>) o;

        return value.equals(answer.value);

    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
