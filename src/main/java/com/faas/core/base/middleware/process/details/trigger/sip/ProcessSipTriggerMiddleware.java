package com.faas.core.base.middleware.process.details.trigger.sip;

import com.faas.core.base.framework.process.details.trigger.sip.ProcessSipTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.sip.ProcessSipTriggerWSModel;
import com.faas.core.base.model.ws.process.details.trigger.sip.dto.ProcessSipTriggerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessSipTriggerMiddleware {


    @Autowired
    ProcessSipTriggerFramework processSipTriggerFramework;


    public ProcessSipTriggerWSModel getProcessSipTriggers(long userId, String processId) {

        ProcessSipTriggerWSModel response = new ProcessSipTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessSipTriggerWSDTO> processSipTriggerWSDTOS = processSipTriggerFramework.getProcessSipTriggersService(userId,processId);
        if (processSipTriggerWSDTOS != null){
            response.setProcessSipTriggers(processSipTriggerWSDTOS);
        }

        general.setOperation("getProcessSipTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSipTriggerWSModel getProcessSipTrigger(long userId, String triggerId) {

        ProcessSipTriggerWSModel response = new ProcessSipTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSipTriggerWSDTO> processSipTriggerWSDTOS = new ArrayList<>();

        ProcessSipTriggerWSDTO processSipTriggerWSDTO = processSipTriggerFramework.getProcessSipTriggerService(userId,triggerId);
        if (processSipTriggerWSDTO != null){
            processSipTriggerWSDTOS.add(processSipTriggerWSDTO);
        }

        response.setProcessSipTriggers(processSipTriggerWSDTOS);
        general.setOperation("getProcessSipTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSipTriggerWSModel createProcessSipTrigger(long userId, String processId, String trigger, String accountId, String callerId, long typeId) {

        ProcessSipTriggerWSModel response = new ProcessSipTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSipTriggerWSDTO> processSipTriggerWSDTOS = new ArrayList<>();

        ProcessSipTriggerWSDTO processSipTriggerWSDTO = processSipTriggerFramework.createProcessSipTriggerService(userId,processId,trigger,accountId,callerId,typeId);
        if (processSipTriggerWSDTO != null){
            processSipTriggerWSDTOS.add(processSipTriggerWSDTO);
        }

        response.setProcessSipTriggers(processSipTriggerWSDTOS);
        general.setOperation("createProcessSipTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSipTriggerWSModel updateProcessSipTrigger(long userId, String triggerId, String trigger, String accountId, String callerId) {

        ProcessSipTriggerWSModel response = new ProcessSipTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSipTriggerWSDTO> processSipTriggerWSDTOS = new ArrayList<>();

        ProcessSipTriggerWSDTO processSipTriggerWSDTO = processSipTriggerFramework.updateProcessSipTriggerService(userId,triggerId,trigger,accountId,callerId);
        if (processSipTriggerWSDTO != null){
            processSipTriggerWSDTOS.add(processSipTriggerWSDTO);
        }

        response.setProcessSipTriggers(processSipTriggerWSDTOS);
        general.setOperation("updateProcessSipTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSipTriggerWSModel removeProcessSipTrigger(long userId, String triggerId) {

        ProcessSipTriggerWSModel response = new ProcessSipTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSipTriggerWSDTO> processSipTriggerWSDTOS = new ArrayList<>();

        ProcessSipTriggerWSDTO processSipTriggerWSDTO = processSipTriggerFramework.removeProcessSipTriggerService(userId,triggerId);
        if (processSipTriggerWSDTO != null){
            processSipTriggerWSDTOS.add(processSipTriggerWSDTO);
        }

        response.setProcessSipTriggers(processSipTriggerWSDTOS);
        general.setOperation("removeProcessSipTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
