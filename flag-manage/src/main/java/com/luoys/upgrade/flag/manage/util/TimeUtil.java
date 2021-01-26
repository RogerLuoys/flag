package com.luoys.upgrade.flag.manage.util;

import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    private static Date getToday(int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }

    /**
     * 默认当天为周日，只能用于按周循环的模板
     * @param cycle task表里的周cycle
     * @return 以周为周期的每日任务开始时间
     */
    public static Date getWeekCycleStartTime(int cycle) {
        if (cycle < 1 || cycle > 7) {
            return null;
        }
        // 获取当天零点
        Date todayStart = getToday(0, 0, 0);
        return new Date(todayStart.getTime() + 24 * 60 * 60 * 1000 * cycle);
    }

    /**
     * 默认当天为周日，只能用于按周循环的模板
     * @param cycle task表里的周cycle
     * @return 以周为周期的每日任务开始时间
     */
    public static Date getWeekCycleStartTime(String cycle) {
        return getWeekCycleStartTime(Integer.parseInt(cycle));
    }

    /**
     * 默认当天为周日，只能用于按周循环的模板
     * @param cycle task表里的周cycle
     * @return 以周为周期的每日任务结束时间
     */
    public static Date getWeekCycleEndTime(int cycle) {
        if (cycle < 1 || cycle > 7) {
            return null;
        }
        // 获取当天半夜
        Date todayEnd = getToday(23, 59, 59);
        return new Date(todayEnd.getTime() + 24 * 60 * 60 * 1000 * cycle);
    }

    /**
     * 默认当天为周日，只能用于按周循环的模板
     * @param cycle task表里的周cycle
     * @return 以周为周期的每日任务结束时间
     */
    public static Date getWeekCycleEndTime(String cycle) {
        return getWeekCycleEndTime(Integer.parseInt(cycle));
    }
}
