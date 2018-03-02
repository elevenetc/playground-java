package su.levenetc.playground.java.bot.services;

import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadUtils;

/**
 * Created by eugene.levenetc on 23/10/2016.
 */
public class HeavyService extends Service {
    @Override
    public void start() {
        platform().allMessages()
                .filter(message -> "zzz".equals(message.getMessage()))
                .observeOn(getScheduler())
                .subscribe(message -> heavy());
    }

    private void heavy() {
        Out.pln("Start heavy...");
        Out.plnCurrentThread();
        ThreadUtils.sleep(10000);
        Out.pln("End heavy.");
    }

}
