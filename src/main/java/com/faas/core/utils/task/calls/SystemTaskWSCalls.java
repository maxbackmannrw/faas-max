package com.faas.core.utils.task.calls;

import com.faas.core.utils.task.service.SystemTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SystemTaskWSCalls {

    @Autowired
    SystemTaskService systemTaskService;

    @Scheduled(fixedRate = 30000)
    public void externalHeartBeats() {

     //   systemTaskService.refreshWappAccounts();
    }

}
