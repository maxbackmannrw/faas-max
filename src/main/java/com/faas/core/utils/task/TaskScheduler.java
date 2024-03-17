package com.faas.core.utils.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskScheduler {


    @Scheduled(fixedRate = 360000)
    public void jobScheduleCycle() {
        System.out.println("Task Scheduler Running... ");
    }

}
