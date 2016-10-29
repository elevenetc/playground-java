package bot;

import io.reactivex.Single;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import su.levenetc.playground.java.bot.platforms.Platform;
import su.levenetc.playground.java.bot.services.PingService;

import static io.reactivex.Observable.just;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static su.levenetc.playground.java.bot.models.Message.message;

/**
 * Created by eugene.levenetc on 29/10/2016.
 */
public class TestServices {

    private Platform platform;

    @Before
    public void before(){
        platform = Mockito.mock(Platform.class);
    }

    @Test
    public void testPing() {

        PingService pingService = new PingService();
        pingService.setPlatform(platform);

        when(platform.personalMessages()).thenReturn(just(message("ping")));
        when(platform.sendMessage(any())).thenReturn(Single.create(e -> e.onSuccess(new Object())));

        pingService.start();

        verify(platform, times(1)).sendMessage(MessageBuilderUtils.respondTo("pong"));
    }
}
