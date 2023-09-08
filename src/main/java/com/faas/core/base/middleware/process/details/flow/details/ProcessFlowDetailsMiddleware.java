package com.faas.core.base.middleware.process.details.flow.details;

import com.faas.core.base.framework.process.details.flow.details.ProcessFlowDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.TriggerWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProcessFlowDetailsMiddleware {


    @Autowired
    ProcessFlowDetailsFramework processFlowDetailsFramework;


    public TriggerWSModel getProcessTriggers(long userId, String processId) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getProcessTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
