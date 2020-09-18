package com.example.quartz.controller;

import com.example.quartz.job.BTestJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
@Slf4j
public class JobController {

    private final Scheduler scheduler;

    public JobController(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @GetMapping
    public String newJob() {
        try {
            JobDetail jobDetail =
                    JobBuilder.newJob(BTestJob.class).withIdentity("BTestJob")
                            .build();

            Trigger trigger = TriggerBuilder
                    .newTrigger().withIdentity("BTestJobTrigger")
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1).withIntervalInSeconds(30).withRepeatCount(5))
                    .startNow().build();

            scheduler.scheduleJob(jobDetail, trigger);

            return "BTestJob";
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
            return "Error";
        }
    }
}
