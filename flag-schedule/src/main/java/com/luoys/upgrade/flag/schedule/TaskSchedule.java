package com.luoys.upgrade.flag.schedule;

import com.luoys.upgrade.flag.manager.TaskManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author luoys
 * @since 2020-12-11
 */
@Component
public class TaskSchedule {

    private static final Logger LOG = LoggerFactory.getLogger(TaskSchedule.class);

    @Autowired
    private TaskManager taskManager;

    // 每周日凌晨1点执行
    @Scheduled(cron = "0 0 1 ? * 7")
    // 每5分钟执行一次，测试用
//    @Scheduled(cron = "0 0/5 * * * ?")
    public void automaticConvertWeekTask() {
        LOG.info("=====定时任务:按周期生成每日任务开始 {}=====", new Date());
        taskManager.automaticConvertWeekTask();
        LOG.info("=====定时任务:按周期生成每日任务结束 {}=====", new Date());
    }
}
