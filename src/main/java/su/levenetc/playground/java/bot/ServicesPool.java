package su.levenetc.playground.java.bot;

import su.levenetc.playground.java.bot.services.Service;

import java.util.List;

/**
 * Created by eugene.levenetc on 26/10/2016.
 */
public interface ServicesPool {
    List<Service> getServices();
}
