package lesson.utils;

import java.util.concurrent.TimeUnit;

public class Utils {

    public static void sleep(long timeoutMillis) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeoutMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
