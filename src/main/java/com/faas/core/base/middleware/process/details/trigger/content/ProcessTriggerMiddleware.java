package com.faas.core.base.middleware.process.details.trigger.content;

import com.faas.core.base.framework.process.details.trigger.content.ProcessTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.ProcessTriggerWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.*;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProcessTriggerMiddleware {


    @Autowired
    ProcessTriggerFramework processTriggerFramework;


    public ProcessTriggerWSModel getProcessTriggers(long userId, String processId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.getProcessTriggersService(userId,processId);
        if (processTriggerWSDTO != null){
            response.setProcessTrigger(processTriggerWSDTO);
        }

        general.setOperation("getProcessTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
