package com.vibe.quartz_demo.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @description: 3秒跑一次的job
 * @author: vibe
 * @create: 2021-11-07 19:38
 **/
@Slf4j
public class TestJob2 extends QuartzJobBean{
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("----------------------");
        log.info("测试定时任务2（每3S执行一次）");
        log.info("----------------------");
    }
}
