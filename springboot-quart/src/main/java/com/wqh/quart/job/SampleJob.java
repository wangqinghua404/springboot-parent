package com.wqh.quart.job;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @ClassName SampleJob
 * @Author wqh
 * @Date 2021/1/6 19:33
 * @Description TODO
 * @Version 1.0
 */
public class SampleJob extends QuartzJobBean {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        System.out.println("Quartz ---->  Hello, " + this.name);
    }
}
