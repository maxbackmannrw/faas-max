package com.faas.core.base.framework.process.details.trigger.content;

import com.faas.core.base.model.ws.process.details.trigger.dto.*;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.process.ProcessHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessTriggerFramework {


    @Autowired
    ProcessHelpers processHelpers;

    @Autowired
    AppUtils appUtils;


    public ProcessTriggerWSDTO getProcessTriggersService(long userId, String processId) {

        ProcessTriggerWSDTO processTriggerWSDTO = new ProcessTriggerWSDTO();
        processTriggerWSDTO.setProcessAITriggers(processHelpers.createProcessAITriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessEmailTriggers(processHelpers.createProcessEmailTriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessSipTriggers(processHelpers.createProcessSipTriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessSmsTriggers(processHelpers.createProcessSmsTriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessWappCallTriggers(processHelpers.createProcessWappCallTriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessWappMessageTriggers(processHelpers.createProcessWappMessageTriggerWSDTOS(processId));

        return processTriggerWSDTO;
    }




}
