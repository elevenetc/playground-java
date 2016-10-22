package su.levenetc.playground.java.bot.services;

import su.levenetc.playground.java.bot.platforms.Platform;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public abstract class Service {

    protected Platform platform;

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public abstract void start();
}
