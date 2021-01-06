package com.wqh.quart.cronSchedule;

import org.quartz.SchedulerException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName MyStartupRunner
 * @Author wqh
 * @Date 2021/1/6 19:40
 * @Description TODO
 * @Version 1.0
 */
@Component
public class MyStartupRunner implements CommandLineRunner {

    @Resource
    public CronSchedulerJob scheduleJobs;

    @Override
    public void run(String... args) throws Exception {
        scheduleJobs.scheduleJobs();
        System.out.println(">>>>>>>>>>>>>>>定时任务开始执行<<<<<<<<<<<<<");
    }

}