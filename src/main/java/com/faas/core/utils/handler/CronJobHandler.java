package com.faas.core.utils.handler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronJobHandler {

    @Scheduled(fixedRate = 360000)
    public void cronJobScheduler() {

        System.out.println("cronJob Scheduler Running... ");
    }

}
