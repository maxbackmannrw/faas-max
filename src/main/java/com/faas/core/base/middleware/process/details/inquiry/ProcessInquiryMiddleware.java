package com.faas.core.base.middleware.process.details.inquiry;

import com.faas.core.base.framework.process.details.inquiry.ProcessInquiryFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.inquiry.ProcessInquiryWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessTriggerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProcessInquiryMiddleware {


    @Autowired
    ProcessInquiryFramework processInquiryFramework;


    public ProcessInquiryWSModel getProcessInquiry(long userId, String processId) {

        ProcessInquiryWSModel response = new ProcessInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = processInquiryFramework.getProcessInquiryService(userId,processId);
        if (processTriggerWSDTOS != null){
        }

        general.setOperation("getProcessInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
