package su.levenetc.playground.java.bot;


import io.reactivex.Single;
import su.levenetc.playground.java.bot.platforms.Platform;
import su.levenetc.playground.java.bot.platforms.slack.InitData;
import su.levenetc.playground.java.bot.services.Service;
import su.levenetc.playground.java.bot.wws.SocketClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene.levenetc on 21/10/2016.
 */
public class HellBot {

    private ServicesPoolImpl servicesPool = new ServicesPoolImpl();
    private Builder builder;
    private Platform platform;

    private HellBot() {

    }

    public Single<InitData> start() {
        return platform.start().doOnSuccess(bot -> servicesPool.startAll(platform, bot));
    }

    public static class Builder {

        Platform platform;
        SocketClient.Factory wwsFactory;
        List<Service> services = new ArrayList<>();

        public Builder setPlatform(Platform platform) {
            this.platform = platform;
            return this;
        }

        public Builder setSocketFactory(SocketClient.Factory wwsFactory) {
            this.wwsFactory = wwsFactory;
            return this;
        }

        public Builder addService(Service service) {
            services.add(service);
            return this;
        }

        public HellBot build() {
            //TODO: check fields
            HellBot result = new HellBot();
            result.builder = this;
            result.platform = platform;
            result.servicesPool.setServices(services);
            return result;
        }
    }


}
