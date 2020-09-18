package com.example.quartz.job;

import com.example.quartz.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ATestJob extends QuartzJobBean {

    private TestService testService;

    public ATestJob(TestService testService) {
        this.testService = testService;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("ATestJob Running");
        try {
            String id = jobExecutionContext.getJobDetail().getKey().getName();
            testService.run(id);
        } catch (Exception e) {
            throw new JobExecutionException(e);
        }
    }

}