package su.levenetc.playground.java.utils;

import rx.Scheduler;
import rx.schedulers.Schedulers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;

/**
 * Created by elevenetc on 04/07/15.
 */
public class SysUtils {

    public static void changeStaticField(Class clazz, String fieldName, String targetValue) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(clazz, targetValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static InputStream toIs(String string) {
        return new ByteArrayInputStream(string.getBytes());
    }

    public static Scheduler getNonDemon() {
        return Schedulers.from(Executors.newCachedThreadPool(Thread::new));
    }

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

        //System. out.println(ste[ste.size-depth].getClassName()+"#"+ste[ste.size-depth].getMethodName());
        // return ste[ste.size - depth].getMethodName();  //Wrong, fails for depth = 0
        return ste[ste.length - 1 - depth].getMethodName(); //Thank you Tom Tresansky
    }
}