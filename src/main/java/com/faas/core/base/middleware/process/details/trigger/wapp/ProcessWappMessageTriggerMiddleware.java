package com.faas.core.base.middleware.process.details.trigger.wapp;

import com.faas.core.base.framework.process.details.trigger.wapp.ProcessWappMessageTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.wapp.ProcessWappMessageTriggerWSModel;
import com.faas.core.base.model.ws.process.details.trigger.wapp.dto.ProcessWappMessageTriggerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessWappMessageTriggerMiddleware {


    @Autowired
    ProcessWappMessageTriggerFramework processWappMessageTriggerFramework;


    public ProcessWappMessageTriggerWSModel getProcessWappMessageTriggers(long userId, String processId) {

        ProcessWappMessageTriggerWSModel response = new ProcessWappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = processWappMessageTriggerFramework.getProcessWappMessageTriggersService(userId,processId);
        if (processWappMessageTriggerWSDTOS != null){
            response.setProcessWappMessageTriggers(processWappMessageTriggerWSDTOS);
        }

        general.setOperation("getProcessWappMessageTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWappMessageTriggerWSModel getProcessWappMessageTrigger(long userId, String triggerId) {

        ProcessWappMessageTriggerWSModel response = new ProcessWappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = new ArrayList<>();

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processWappMessageTriggerFramework.getProcessWappMessageTriggerService(userId,triggerId);
        if (processWappMessageTriggerWSDTO != null){
            processWappMessageTriggerWSDTOS.add(processWappMessageTriggerWSDTO);
        }

        response.setProcessWappMessageTriggers(processWappMessageTriggerWSDTOS);
        general.setOperation("getProcessWappMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWappMessageTriggerWSModel createProcessWappMessageTrigger(long userId, String processId, String trigger, String accountId, String wappTitle, String wappBody, long typeId) {

        ProcessWappMessageTriggerWSModel response = new ProcessWappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = new ArrayList<>();

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processWappMessageTriggerFramework.createProcessWappMessageTriggerService(userId,processId,trigger,accountId,wappTitle,wappBody,typeId);
        if (processWappMessageTriggerWSDTO != null){
            processWappMessageTriggerWSDTOS.add(processWappMessageTriggerWSDTO);
        }

        response.setProcessWappMessageTriggers(processWappMessageTriggerWSDTOS);
        general.setOperation("createProcessWappMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWappMessageTriggerWSModel updateProcessWappMessageTrigger(long userId, String triggerId, String trigger, String accountId, String wappTitle, String wappBody) {

        ProcessWappMessageTriggerWSModel response = new ProcessWappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = new ArrayList<>();

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processWappMessageTriggerFramework.updateProcessWappMessageTriggerService(userId,triggerId,trigger,accountId,wappTitle,wappBody);
        if (processWappMessageTriggerWSDTO != null){
            processWappMessageTriggerWSDTOS.add(processWappMessageTriggerWSDTO);
        }

        response.setProcessWappMessageTriggers(processWappMessageTriggerWSDTOS);
        general.setOperation("updateProcessWappMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWappMessageTriggerWSModel removeProcessWappMessageTrigger(long userId, String triggerId) {

        ProcessWappMessageTriggerWSModel response = new ProcessWappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = new ArrayList<>();

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processWappMessageTriggerFramework.removeProcessWappMessageTriggerService(userId,triggerId);
        if (processWappMessageTriggerWSDTO != null){
            processWappMessageTriggerWSDTOS.add(processWappMessageTriggerWSDTO);
        }

        response.setProcessWappMessageTriggers(processWappMessageTriggerWSDTOS);
        general.setOperation("removeProcessWappMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
