package com.faas.core.base.middleware.process.details.inquiry.content;

import com.faas.core.base.framework.process.details.inquiry.content.ProcessInquiryFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.TriggerWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.TriggerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProcessInquiryMiddleware {

    @Autowired
    ProcessInquiryFramework processInquiryFramework;


    public TriggerWSModel getProcessTriggers(long userId, String processId) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<TriggerWSDTO> triggerWSDTOS = processInquiryFramework.getProcessTriggersService(userId,processId);
        if (triggerWSDTOS != null){
            response.setTriggers(triggerWSDTOS);
        }

        general.setOperation("getProcessTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
