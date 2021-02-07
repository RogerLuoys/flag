package com.luoys.upgrade.flag.api;

import java.util.Random;

public class NumberSender {

    private static final String FLAG_PREFIX = "1";
    private static final String TASK_PREFIX = "2";
    private static final String TASK_DAILY_PREFIX = "3";
    private static final String USER_PREFIX = "4";
    private static final Integer RANDOM_BOUND = 9;

    private static Random rd = new Random();

    public static String createIdByCurrentTime() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        long currentTime = System.currentTimeMillis();
        int num = rd.nextInt(RANDOM_BOUND);
        return Long.toString(currentTime) + Integer.toString(num);
    }

    public static String createFlagId() {

        return FLAG_PREFIX + createIdByCurrentTime();
    }

    public static String createTaskId() {

        return TASK_PREFIX + createIdByCurrentTime();
    }

    public static String createTaskDailyId() {

        return TASK_DAILY_PREFIX + createIdByCurrentTime();
    }

    public static String createUserId() {

        return USER_PREFIX + createIdByCurrentTime();
    }
}
