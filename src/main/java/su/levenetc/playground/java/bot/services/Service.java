package su.levenetc.playground.java.bot.services;

import io.reactivex.Scheduler;
import su.levenetc.playground.java.bot.platforms.Platform;
import su.levenetc.playground.java.utils.ThreadsUtils;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public abstract class Service {

    private Platform platform;
    private Scheduler scheduler;

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Platform getPlatform() {
        return platform;
    }

    public abstract void start();

    protected Scheduler getScheduler() {
        if (scheduler == null)
            scheduler = ThreadsUtils.createScheduler(getClass().getCanonicalName());
        return scheduler;
    }
}
