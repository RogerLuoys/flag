package com.luoys.upgrade.flag.api;

import java.util.Random;

public class NumberSender {

    private static final String FLAG_PREFIX = "1";
    private static final Integer RANDOM_BOUND = 9;

    private static Random rd = new Random();

    public static String createFlagId() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        long currentTime = System.currentTimeMillis();
        int num = rd.nextInt(RANDOM_BOUND);
        return FLAG_PREFIX + Long.toString(currentTime) + Integer.toString(num);
    }

}
