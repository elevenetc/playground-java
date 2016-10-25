package su.levenetc.playground.java.utils;

/**
 * Created by eleven on 25/10/2016.
 */
public class RuntimeUtils {
	public static void nullCheck(Object... params) {
		for (int i = 0; i < params.length; i++) {
			Object o = params[i];
			if (o == null) throw new NullPointerException((i + 1) + "th param is null");
		}
	}
}
