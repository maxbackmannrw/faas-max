package com.faas.core.base.middleware.process.details.trigger.details;

import com.faas.core.base.framework.process.details.trigger.details.ProcessSmsTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.details.ProcessSmsTriggerWSModel;
import com.faas.core.base.model.ws.process.details.trigger.details.dto.ProcessSmsTriggerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProcessSmsTriggerMiddleware {


    @Autowired
    ProcessSmsTriggerFramework processSmsTriggerFramework;


    public ProcessSmsTriggerWSModel getProcessSmsTriggers(long userId, String processId) {

        ProcessSmsTriggerWSModel response = new ProcessSmsTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessSmsTriggerWSDTO> processSmsTriggerWSDTOS = processSmsTriggerFramework.getProcessSmsTriggersService(userId,processId);
        if (processSmsTriggerWSDTOS != null){
            response.setProcessSmsTriggers(processSmsTriggerWSDTOS);
        }

        general.setOperation("getProcessSmsTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSmsTriggerWSModel getProcessSmsTrigger(long userId, String triggerId) {

        ProcessSmsTriggerWSModel response = new ProcessSmsTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTriggerWSDTO> processSmsTriggerWSDTOS = new ArrayList<>();

        ProcessSmsTriggerWSDTO processSmsTriggerWSDTO = processSmsTriggerFramework.getProcessSmsTriggerService(userId,triggerId);
        if (processSmsTriggerWSDTO != null){
            processSmsTriggerWSDTOS.add(processSmsTriggerWSDTO);
        }

        response.setProcessSmsTriggers(processSmsTriggerWSDTOS);
        general.setOperation("getProcessSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSmsTriggerWSModel createProcessSmsTrigger(long userId, String processId, String trigger, String accountId, String smsTitle, String smsBody, String senderId, long typeId) {

        ProcessSmsTriggerWSModel response = new ProcessSmsTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTriggerWSDTO> processSmsTriggerWSDTOS = new ArrayList<>();

        ProcessSmsTriggerWSDTO processSmsTriggerWSDTO = processSmsTriggerFramework.createProcessSmsTriggerService(userId,processId,trigger,accountId,smsTitle,smsBody,senderId,typeId);
        if (processSmsTriggerWSDTO != null){
            processSmsTriggerWSDTOS.add(processSmsTriggerWSDTO);
        }

        response.setProcessSmsTriggers(processSmsTriggerWSDTOS);
        general.setOperation("createProcessSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSmsTriggerWSModel updateProcessSmsTrigger(long userId, String triggerId, String trigger, String accountId, String smsTitle, String smsBody, String senderId) {

        ProcessSmsTriggerWSModel response = new ProcessSmsTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTriggerWSDTO> processSmsTriggerWSDTOS = new ArrayList<>();

        ProcessSmsTriggerWSDTO processSmsTriggerWSDTO = processSmsTriggerFramework.updateProcessSmsTriggerService(userId,triggerId,trigger,accountId,smsTitle,smsBody,senderId);
        if (processSmsTriggerWSDTO != null){
            processSmsTriggerWSDTOS.add(processSmsTriggerWSDTO);
        }

        response.setProcessSmsTriggers(processSmsTriggerWSDTOS);
        general.setOperation("updateProcessSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSmsTriggerWSModel removeProcessSmsTrigger(long userId, String triggerId) {

        ProcessSmsTriggerWSModel response = new ProcessSmsTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTriggerWSDTO> processSmsTriggerWSDTOS = new ArrayList<>();

        ProcessSmsTriggerWSDTO processSmsTriggerWSDTO = processSmsTriggerFramework.removeProcessSmsTriggerService(userId,triggerId);
        if (processSmsTriggerWSDTO != null){
            processSmsTriggerWSDTOS.add(processSmsTriggerWSDTO);
        }

        response.setProcessSmsTriggers(processSmsTriggerWSDTOS);
        general.setOperation("removeProcessSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
