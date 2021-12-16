package com.vibe.quartz_demo.config;

import com.vibe.quartz_demo.job.TestJob1;
import com.vibe.quartz_demo.job.TestJob2;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: quartz配置类
 * @author: vibe
 * @create: 2021-11-05 19:21
 **/
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail myJob1Detail() {
        return JobBuilder
                .newJob(TestJob1.class)
                .withIdentity("myJob1")
                .storeDurably()
                .build();
    }
    @Bean
    public Trigger myJob1Trigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/3 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(myJob1Detail())
                .withIdentity("myJob1Trigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }

    @Bean
    public JobDetail myJob2Detail() {
        return JobBuilder
                .newJob(TestJob2.class)
                .withIdentity("myJob2")
                .storeDurably()
                .build();
    }
    @Bean
    public Trigger myJob2Trigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/3 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(myJob2Detail())
                .withIdentity("myJob2Trigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }

}
