package com.faas.core.base.middleware.process.details.trigger.wapp;

import com.faas.core.base.framework.process.details.trigger.wapp.ProcessWappCallTriggerFramework;
import com.faas.core.base.framework.process.details.trigger.wapp.ProcessWappMessageTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.wapp.ProcessWappCallTriggerWSModel;
import com.faas.core.base.model.ws.process.details.trigger.wapp.dto.ProcessWappCallTriggerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessWappCallTriggerMiddleware {


    @Autowired
    ProcessWappCallTriggerFramework processWappCallTriggerFramework;


    public ProcessWappCallTriggerWSModel getProcessWappCallTriggers(long userId, String processId) {

        ProcessWappCallTriggerWSModel response = new ProcessWappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = processWappCallTriggerFramework.getProcessWappCallTriggersService(userId,processId);
        if (processWappCallTriggerWSDTOS != null){
            response.setProcessWappCallTriggers(processWappCallTriggerWSDTOS);
        }

        general.setOperation("getProcessWappCallTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWappCallTriggerWSModel getProcessWappCallTrigger(long userId, String triggerId) {

        ProcessWappCallTriggerWSModel response = new ProcessWappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = new ArrayList<>();

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processWappCallTriggerFramework.getProcessWappCallTriggerService(userId,triggerId);
        if (processWappCallTriggerWSDTO != null){
            processWappCallTriggerWSDTOS.add(processWappCallTriggerWSDTO);
        }

        response.setProcessWappCallTriggers(processWappCallTriggerWSDTOS);
        general.setOperation("getProcessWappCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWappCallTriggerWSModel createProcessWappCallTrigger(long userId, String processId, String trigger, String accountId, long typeId) {

        ProcessWappCallTriggerWSModel response = new ProcessWappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = new ArrayList<>();

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processWappCallTriggerFramework.createProcessWappCallTriggerService(userId,processId,trigger,accountId,typeId);
        if (processWappCallTriggerWSDTO != null){
            processWappCallTriggerWSDTOS.add(processWappCallTriggerWSDTO);
        }

        response.setProcessWappCallTriggers(processWappCallTriggerWSDTOS);
        general.setOperation("createProcessWappCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWappCallTriggerWSModel updateProcessWappCallTrigger(long userId, String triggerId, String trigger, String accountId) {

        ProcessWappCallTriggerWSModel response = new ProcessWappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = new ArrayList<>();

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processWappCallTriggerFramework.updateProcessWappCallTriggerService(userId,triggerId,trigger,accountId);
        if (processWappCallTriggerWSDTO != null){
            processWappCallTriggerWSDTOS.add(processWappCallTriggerWSDTO);
        }

        response.setProcessWappCallTriggers(processWappCallTriggerWSDTOS);
        general.setOperation("updateProcessWappCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWappCallTriggerWSModel removeProcessWappCallTrigger(long userId, String triggerId) {

        ProcessWappCallTriggerWSModel response = new ProcessWappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = new ArrayList<>();

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processWappCallTriggerFramework.removeProcessWappCallTriggerService(userId,triggerId);
        if (processWappCallTriggerWSDTO != null){
            processWappCallTriggerWSDTOS.add(processWappCallTriggerWSDTO);
        }

        response.setProcessWappCallTriggers(processWappCallTriggerWSDTOS);
        general.setOperation("removeProcessWappCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
