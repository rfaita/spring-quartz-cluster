package com.example.quartz.config;


import com.example.quartz.job.ATestJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

    @Bean
    public JobDetail aTestJob() {
        return JobBuilder
                .newJob(ATestJob.class).withIdentity("ATestJob")
                .storeDurably().build();
    }

    @Bean
    public Trigger aTestTrigger(JobDetail jobADetails) {

        return TriggerBuilder.newTrigger().forJob(jobADetails)

                .withIdentity("ATestJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * ? * * *"))
                .build();
    }

}