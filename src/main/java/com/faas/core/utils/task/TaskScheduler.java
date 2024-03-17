package com.faas.core.utils.task;

import com.faas.core.utils.service.content.TaskSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskScheduler {

    @Autowired
    TaskSchedulerService taskSchedulerService;

    @Scheduled(fixedRate = 5000)
    public void jobScheduleCycle() {

        System.out.println("Task Scheduler Running... "+System.currentTimeMillis());
     //   systemTaskService.refreshWappAccounts();
    }

}
