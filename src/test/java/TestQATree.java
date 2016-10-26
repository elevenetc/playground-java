import org.junit.Test;
import su.levenetc.playground.java.bot.services.simpleconversation.Clarification;
import su.levenetc.playground.java.bot.services.simpleconversation.ConversationProcessor;
import su.levenetc.playground.java.bot.services.simpleconversation.StringAnswer;
import su.levenetc.playground.java.bot.services.simpleconversation.StringQuestion;

/**
 * Created by eugene.levenetc on 23/10/2016.
 */
public class TestQATree {
    @Test
    public void fillTree() {

        final StringQuestion initQuestion = new StringQuestion("How old are you?");
        initQuestion.addAnswer(
                new StringAnswer("10")
                        .setNext(new StringQuestion("Oh, so young. Do you want candy?")
                                .addAnswer(
                                        new StringAnswer("yes").setNext(new StringQuestion("Ok here. Good bye.")),
                                        new StringAnswer("no").setNext(new StringQuestion("So, fine. Good bye."))
                                ).addClarification(new Clarification("Can understand. Yes or no?"))
                        ),
                new StringAnswer("20")
                        .setNext(new StringQuestion("Oh, so old. Do you want vodka?")
                                .addAnswer(
                                        new StringAnswer("yes").setNext(new StringQuestion("Sorry, I don't have vodka. Bye.")),
                                        new StringAnswer("no").setNext(new StringQuestion("Oh, fine. Good bye"))
                                ).addClarification(new Clarification("Can understand. Yes or no?"))
                        )
        ).addClarification(new Clarification("Sorry, can understand you. Could you repeat? Should be either 10 or 20"));

        final ConversationProcessor conversationProcessor = new ConversationProcessor(initQuestion);
        conversationProcessor.next(new StringAnswer("10"));
        conversationProcessor.next(new StringAnswer("yezz"));
        conversationProcessor.next(new StringAnswer("yes"));
    }

    private static class DialogBuilder {

    }
}
