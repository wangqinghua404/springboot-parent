package com.wqh.quart.cronSchedule;

import org.quartz.*;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName CronSchedulerJob
 * @Author wqh
 * @Date 2021/1/6 19:39
 * @Description TODO
 * @Version 1.0
 */
@Component
public class CronSchedulerJob {

    @Resource
    private SchedulerFactoryBean schedulerFactoryBean;

    private void scheduleJob1(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class).withIdentity("job1", "group1").build();
        // 6的倍数秒执行 也就是 6 12 18 24 30 36 42 ....
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/6 * * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .usingJobData("name", "王智1").withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    /**
     * @return void
     * @Author Smith
     * @Description 同时启动两个定时任务
     * @Date 16:31 2019/1/24
     * @Param
     **/
    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduleJob1(scheduler);
    }
}
