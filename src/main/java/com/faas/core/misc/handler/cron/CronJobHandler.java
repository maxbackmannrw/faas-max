package com.faas.core.misc.handler.cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronJobHandler {

    @Scheduled(fixedRate = 360000)
    public void cronJobScheduler() {

        System.out.println("cronJob Scheduler Running... ");
    }

}
