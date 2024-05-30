package com.faas.core.base.middleware.process.details.trigger.content;

import com.faas.core.base.framework.process.details.trigger.content.TriggerTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.content.ProcessTriggerTempWSModel;
import com.faas.core.base.model.ws.process.details.trigger.content.dto.*;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TriggerTempMiddleware {


    @Autowired
    TriggerTempFramework triggerTempFramework;


    public ProcessTriggerTempWSModel getProcessTriggerTemps(long userId, String processId) {

        ProcessTriggerTempWSModel response = new ProcessTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessTriggerTempWSDTO processTriggerTempWSDTO = triggerTempFramework.getProcessTriggerTempsService(userId,processId);
        if (processTriggerTempWSDTO != null){
            response.setProcessTriggerTemp(processTriggerTempWSDTO);
        }

        general.setOperation("getProcessTriggerTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
