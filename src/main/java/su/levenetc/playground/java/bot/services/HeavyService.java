package su.levenetc.playground.java.bot.services;

import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadsUtils;

/**
 * Created by eugene.levenetc on 23/10/2016.
 */
public class HeavyService extends Service {
    @Override
    public void start() {
        getPlatform().getMessageObservable()
                .filter(message -> "zzz".equals(message.getMessage()))
                .observeOn(getScheduler())
                .subscribe(message -> heavy());
    }

    private void heavy() {
        Out.pln("Start heavy...");
        Out.plnCurrentThread();
        ThreadsUtils.sleep(10000);
        Out.pln("End heavy.");
    }

}
