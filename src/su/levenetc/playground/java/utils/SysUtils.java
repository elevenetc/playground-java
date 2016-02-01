package su.levenetc.playground.java.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by elevenetc on 04/07/15.
 */
public class SysUtils {

	public static String time() {
		Date date = new Date(System.currentTimeMillis());
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
		return formatter.format(date);
	}

	public static String method() {
		return method(1);
	}

	public static String method(final int depth) {
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();

		//System. out.println(ste[ste.length-depth].getClassName()+"#"+ste[ste.length-depth].getMethodName());
		// return ste[ste.length - depth].getMethodName();  //Wrong, fails for depth = 0
		return ste[ste.length - 1 - depth].getMethodName(); //Thank you Tom Tresansky
	}
}
