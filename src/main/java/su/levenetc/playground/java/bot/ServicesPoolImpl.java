package su.levenetc.playground.java.bot;

import su.levenetc.playground.java.bot.platforms.Platform;
import su.levenetc.playground.java.bot.platforms.slack.InitData;
import su.levenetc.playground.java.bot.services.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by eugene.levenetc on 26/10/2016.
 */
class ServicesPoolImpl implements ServicesPool {

    private List<Service> services = new ArrayList<>();

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void startAll(Platform platform, InitData initData) {

        platform.setInitData(initData);

        for (Service service : services) {
            service.setPlatform(platform);
            service.setServicesPool(this);
            service.setInitData(initData);
        }
        services.forEach(Service::start);
    }

    @Override
    public List<Service> getServices() {
        return Collections.unmodifiableList(services);
    }
}
