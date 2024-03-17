package com.faas.core.utils.job;

import com.faas.core.utils.service.job.JobSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobScheduler {

    @Autowired
    JobSchedulerService jobSchedulerService;

    @Scheduled(fixedRate = 5000)
    public void jobScheduleCycle() {

     //   systemTaskService.refreshWappAccounts();
    }

}
