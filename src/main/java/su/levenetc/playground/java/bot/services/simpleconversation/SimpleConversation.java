package su.levenetc.playground.java.bot.services.simpleconversation;

import su.levenetc.playground.java.bot.models.Message;
import su.levenetc.playground.java.bot.services.Service;

/**
 * Created by eugene.levenetc on 23/10/2016.
 */
public class SimpleConversation extends Service {

    private StringQuestion initQuestion;
    private ConversationProcessor conversationProcessor;
    private boolean conversationStarted;

    @Override
    public void start() {
        getPlatform()
                .getMessageObservable()
                .filter(message -> "sss".equals(message.getMessage()))
                .observeOn(getScheduler())
                .subscribe(this::startConversation);

        getPlatform()
                .getMessageObservable()
                .filter(message -> conversationStarted)
                .observeOn(getScheduler())
                .subscribe(this::handleConversationMessage);

        initQuestion = new StringQuestion("How old are you?");
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
    }

    private void startConversation(Message message) {
        conversationProcessor = new ConversationProcessor(initQuestion);
        updateMode();
        getPlatform().sendMessage(message.respond(initQuestion.getValue())).subscribe();
        conversationStarted = true;
    }

    private void handleConversationMessage(Message message) {
        final Question next = conversationProcessor.next(new StringAnswer(message.getMessage()));
        if (next != null) {
            getPlatform().sendMessage(message.respond((String) next.getValue())).subscribe();
            updateMode();
        }
    }

    private void updateMode() {
        setMode(conversationProcessor.isWaitingForAnswer() ? Mode.WAITING_DIRECT_ANSWER : Mode.IDLE);
    }

}
