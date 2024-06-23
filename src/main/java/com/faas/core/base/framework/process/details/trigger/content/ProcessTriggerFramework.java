package com.faas.core.base.framework.process.details.trigger.content;

import com.faas.core.base.model.ws.process.details.trigger.dto.*;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.process.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessTriggerFramework {


    @Autowired
    ProcessHelper processHelper;

    @Autowired
    AppUtils appUtils;


    public ProcessTriggerWSDTO getProcessTriggersService(long userId, String processId) {

        ProcessTriggerWSDTO processTriggerWSDTO = new ProcessTriggerWSDTO();
        processTriggerWSDTO.setProcessAITriggers(processHelper.createProcessAITriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessEmailTriggers(processHelper.createProcessEmailTriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessSipTriggers(processHelper.createProcessSipTriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessSmsTriggers(processHelper.createProcessSmsTriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessWappCallTriggers(processHelper.createProcessWappCallTriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessWappMessageTriggers(processHelper.createProcessWappMessageTriggerWSDTOS(processId));

        return processTriggerWSDTO;
    }




}
