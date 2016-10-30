package bot;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import su.levenetc.playground.java.bot.platforms.Platform;
import su.levenetc.playground.java.bot.services.PingService;

import static bot.MessageBuilderUtils.respond;
import static bot.PlatformUtils.success;
import static io.reactivex.Observable.just;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static su.levenetc.playground.java.bot.models.Message.message;
import static su.levenetc.playground.java.bot.services.PingService.PING;
import static su.levenetc.playground.java.bot.services.PingService.PONG;

/**
 * Created by eugene.levenetc on 29/10/2016.
 */
public class TestServices {

    private Platform platform;

    @Before
    public void before() {
        platform = Mockito.mock(Platform.class);
    }

    @Test
    public void testPing() {

        PingService pingService = new PingService();
        pingService.setPlatform(platform);

        when(platform.personalMessages()).thenReturn(just(message(PING)));
        when(platform.sendMessage(any())).thenReturn(success());

        pingService.start();

        verify(platform).sendMessage(respond(PONG));
    }
}
