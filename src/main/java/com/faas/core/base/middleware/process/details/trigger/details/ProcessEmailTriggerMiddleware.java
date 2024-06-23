package com.faas.core.base.middleware.process.details.trigger.details;

import com.faas.core.base.framework.process.details.trigger.details.ProcessEmailTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.ProcessEmailTriggerWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessEmailTriggerWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessEmailTriggerMiddleware {


    @Autowired
    ProcessEmailTriggerFramework processEmailTriggerFramework;


    public ProcessEmailTriggerWSModel getProcessEmailTriggers(long userId, String processId) {

        ProcessEmailTriggerWSModel response = new ProcessEmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessEmailTriggerWSDTO> processEmailTriggerWSDTOS = processEmailTriggerFramework.getProcessEmailTriggersService(userId,processId);
        if (processEmailTriggerWSDTOS != null){
            response.setProcessEmailTriggers(processEmailTriggerWSDTOS);
        }

        general.setOperation("getProcessEmailTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessEmailTriggerWSModel getProcessEmailTrigger(long userId, String triggerId) {

        ProcessEmailTriggerWSModel response = new ProcessEmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTriggerWSDTO> processEmailTriggerWSDTOS = new ArrayList<>();

        ProcessEmailTriggerWSDTO processEmailTriggerWSDTO = processEmailTriggerFramework.getProcessEmailTriggerService(userId,triggerId);
        if (processEmailTriggerWSDTO != null){
            processEmailTriggerWSDTOS.add(processEmailTriggerWSDTO);
        }

        response.setProcessEmailTriggers(processEmailTriggerWSDTOS);
        general.setOperation("getProcessEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessEmailTriggerWSModel createProcessEmailTrigger(long userId, String processId, String trigger, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender, long typeId) {

        ProcessEmailTriggerWSModel response = new ProcessEmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTriggerWSDTO> processEmailTriggerWSDTOS = new ArrayList<>();

        ProcessEmailTriggerWSDTO processEmailTriggerWSDTO = processEmailTriggerFramework.createProcessEmailTriggerService(userId,processId,trigger,accountId,emailSubject,emailTitle,emailBody,emailSender,typeId);
        if (processEmailTriggerWSDTO != null){
            processEmailTriggerWSDTOS.add(processEmailTriggerWSDTO);
        }

        response.setProcessEmailTriggers(processEmailTriggerWSDTOS);
        general.setOperation("createProcessEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessEmailTriggerWSModel updateProcessEmailTrigger(long userId, String triggerId, String trigger, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender) {

        ProcessEmailTriggerWSModel response = new ProcessEmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTriggerWSDTO> processEmailTriggerWSDTOS = new ArrayList<>();

        ProcessEmailTriggerWSDTO processEmailTriggerWSDTO = processEmailTriggerFramework.updateProcessEmailTriggerService(userId,triggerId,trigger,accountId,emailSubject,emailTitle,emailBody,emailSender);
        if (processEmailTriggerWSDTO != null){
            processEmailTriggerWSDTOS.add(processEmailTriggerWSDTO);
        }

        response.setProcessEmailTriggers(processEmailTriggerWSDTOS);
        general.setOperation("updateProcessEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessEmailTriggerWSModel removeProcessEmailTrigger(long userId, String triggerId) {

        ProcessEmailTriggerWSModel response = new ProcessEmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTriggerWSDTO> processEmailTriggerWSDTOS = new ArrayList<>();

        ProcessEmailTriggerWSDTO processEmailTriggerWSDTO = processEmailTriggerFramework.removeProcessEmailTriggerService(userId,triggerId);
        if (processEmailTriggerWSDTO != null){
            processEmailTriggerWSDTOS.add(processEmailTriggerWSDTO);
        }

        response.setProcessEmailTriggers(processEmailTriggerWSDTOS);
        general.setOperation("removeProcessEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
