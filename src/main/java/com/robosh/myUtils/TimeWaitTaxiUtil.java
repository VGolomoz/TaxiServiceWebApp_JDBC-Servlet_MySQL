package com.robosh.myUtils;

/**
 * class that contains only one static method
 *
 * @author Orest Shemelyuk
 */

public class TimeWaitTaxiUtil {
    private TimeWaitTaxiUtil() {
    }

    public static int getTimeWait() {
        return (int) (Math.random() * 10);
    }
}
