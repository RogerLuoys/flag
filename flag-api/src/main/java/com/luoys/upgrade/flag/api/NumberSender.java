package com.luoys.upgrade.flag.api;

import java.util.Random;

public class NumberSender {
    static Random rd = new Random();

    public static String flagID() throws InterruptedException {

        Thread.sleep(1);
        long time1 = System.currentTimeMillis();
        int num = rd.nextInt(9);
        String id = "1" + Long.toString(time1) + Long.toString(num);
        System.out.println(id);
    }

}
