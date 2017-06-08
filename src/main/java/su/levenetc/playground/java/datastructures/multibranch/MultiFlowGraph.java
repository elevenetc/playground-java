package su.levenetc.playground.java.datastructures.multibranch;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import su.levenetc.playground.java.utils.Out;

/**
 * Created by eugene.levenetc on 07/06/2017.
 */
public class MultiFlowGraph {

    private Node last;
    private List<Deque<FlowStep>> branches = new LinkedList<>();

    public FlowStep startWith(FlowStep root) {
        final LinkedList<FlowStep> rootBranch = new LinkedList<>();
        rootBranch.add(root);
        branches.add(rootBranch);
        this.last = new Node(root);
        return root;
    }

    void goTo(FlowStep from, Class<? extends FlowStep> target) {

    }

    public void goToNext(FlowStep from) {

    }

    public void then(FlowStep from, FlowStep to) {

        prependOrAppend(from, to);

        Out.pln("Then: " + from + " to " + to);
    }

    public void thenOneOf(FlowStep from, FlowStep... next) {

        List<Deque<FlowStep>> branches = new LinkedList<>();

        for (int i = 0; i < next.length; i++) {

            Deque<FlowStep> queue = new LinkedList<>();
            queue.add(from);

            final FlowStep last = next[i];
            final Deque<FlowStep> queuePart = getQueueByLast(last);

            removeQueueByLast(last);

            queue.addAll(queuePart);
            branches.add(queue);
        }

        this.branches = branches;

        Out.pln("ThenOnOf: " + from + " to " + next);
    }

    private boolean hasQueueWithLast(FlowStep step) {
        for (int i = 0; i < branches.size(); i++) {
            Deque<FlowStep> queue = branches.get(i);
            final FlowStep peek = queue.peekLast();
            if (peek == step) {
                return true;
            }
        }
        return false;
    }

    private boolean hasQueueWithFirst(FlowStep step) {
        for (int i = 0; i < branches.size(); i++) {
            Deque<FlowStep> queue = branches.get(i);
            if (queue.peekFirst() == step) {
                return true;
            }
        }
        return false;
    }

    private void removeQueueByLast(FlowStep step) {
        for (int i = 0; i < branches.size(); i++) {
            Deque<FlowStep> queue = branches.get(i);
            if (queue.peekLast() == step) {
                branches.remove(i);
            }
        }
    }

    private Deque<FlowStep> getQueueByLast(FlowStep step) {
        for (int i = 0; i < branches.size(); i++) {
            Deque<FlowStep> queue = branches.get(i);
            final FlowStep peek = queue.peekLast();
            if (peek == step) {
                return queue;
            }
        }
        return null;
    }

    private Deque<FlowStep> getQueueByFirst(FlowStep step) {
        for (int i = 0; i < branches.size(); i++) {
            Deque<FlowStep> queue = branches.get(i);
            if (queue.peekFirst() == step) {
                return queue;
            }
        }
        return null;
    }

    private void prependOrAppend(FlowStep from, FlowStep to) {
        final boolean hasWithFirst = hasQueueWithFirst(from);
        final boolean hasWithLast = hasQueueWithLast(from);

        if (!hasWithFirst && !hasWithLast) {
            createNewQueue(from, to);
        } else if (hasWithFirst) {
            prepend(from, to);
        } else {
            append(from, to);
        }
    }

    private void createNewQueue(FlowStep from, FlowStep to) {
        Deque<FlowStep> last = new LinkedList<>();
        last.add(from);
        last.add(to);
        branches.add(last);
    }

    private void append(FlowStep from, FlowStep to) {
        Deque<FlowStep> queue = getQueueByLast(from);
        queue.add(to);
    }

    private void prepend(FlowStep from, FlowStep to) {
        Deque<FlowStep> queue = getQueueByFirst(from);
        queue.add(to);
    }

}