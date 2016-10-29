package bot;

import io.reactivex.Single;

/**
 * Created by eugene.levenetc on 30/10/2016.
 */
public class PlatformUtils {
    public static <T> Single<T> success() {
        return Single.create(e -> e.onSuccess((T) new Object()));
    }
}
