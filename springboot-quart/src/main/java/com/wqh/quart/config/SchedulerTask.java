package com.wqh.quart.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName SchedulerTask
 * @Author wqh
 * @Date 2021/1/6 16:58
 * @Description TODO
 * @Version 1.0
 */
//@Component
public class SchedulerTask implements SchedulingConfigurer {

    private int count = 0;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // 设置没6秒执行一次
//    @Scheduled(cron = "*/6 * * * * ?")
//    @Scheduled(cron = "${scheduled.repays}")
//    private void process() {
//        System.out.println("this is scheduler task running " + (count++));
//    }

    // 设置没6秒执行一次
//    @Scheduled(fixedRate = 6000)
//    private void process() {
//        System.out.println("now time is " + dateFormat.format(new Date()));
//    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() -> System.out.println("间隔时间：" + 6000),
                triggerContext -> {
                    System.out.println("当前时间:" + LocalDateTime.now());
                    return new PeriodicTrigger(6000).nextExecutionTime(triggerContext);
                }
        );
    }
}
