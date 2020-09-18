package com.example.quartz.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TestService {

    private final Log logger = LogFactory.getLog(getClass());

    private final Random random = new Random();

    public void run(String id) throws Exception {
        logger.info("Running job on supervisor, job id " + id);
        if (random.nextInt(3) == 1) {
            throw new Exception("Randomly generated test exception on supervisor");
        }
        logger.info("Completed job on supervisor, job id " + id);
    }
}