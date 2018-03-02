package su.levenetc.playground.java.bot.services;

import io.reactivex.Scheduler;
import su.levenetc.playground.java.bot.ServicesPool;
import su.levenetc.playground.java.bot.platforms.Platform;
import su.levenetc.playground.java.bot.platforms.slack.InitData;
import su.levenetc.playground.java.utils.ThreadUtils;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public abstract class Service {

    private Platform platform;
    private Scheduler scheduler;
    private Mode mode = Mode.IDLE;
    private ServicesPool servicesPool;
    private InitData initData;

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Platform platform() {
        return platform;
    }

    public abstract void start();

    public Mode getMode() {
        return mode;
    }

    protected void setMode(Mode mode) {
        this.mode = mode;
    }

    protected Scheduler getScheduler() {
        if (scheduler == null)
            scheduler = ThreadUtils.createScheduler(getClass().getCanonicalName());
        return scheduler;
    }

    protected ServicesPool getServicesPool() {
        return servicesPool;
    }

    public void setServicesPool(ServicesPool servicesPool) {
        this.servicesPool = servicesPool;
    }

    public void setInitData(InitData initData) {
        this.initData = initData;
    }

    public enum Mode {
        WAITING_DIRECT_ANSWER, IDLE
    }
}
