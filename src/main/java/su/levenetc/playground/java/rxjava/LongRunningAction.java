package su.levenetc.playground.java.rxjava;

import io.reactivex.functions.Action;
import su.levenetc.playground.java.utils.Out;

/**
 * Created by eugene.levenetc on 03/02/2017.
 */
public class LongRunningAction implements Action {

    private Object result;

    public static LongRunningAction create() {
        return new LongRunningAction();
    }


    @Override
    public void run() throws Exception {
        Out.pln(getClass().getSimpleName() + " started");
        Thread.sleep(1000);
        Out.pln(getClass().getSimpleName() + " finished");
    }
}
