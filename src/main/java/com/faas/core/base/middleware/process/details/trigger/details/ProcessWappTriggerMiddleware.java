package com.faas.core.base.middleware.process.details.trigger.details;

import com.faas.core.base.framework.process.details.trigger.details.ProcessWappTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.ProcessWappCallTriggerWSModel;
import com.faas.core.base.model.ws.process.details.trigger.ProcessWappMessageTriggerWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessWappCallTriggerWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessWappMessageTriggerWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessWappTriggerMiddleware {


    @Autowired
    ProcessWappTriggerFramework processWappTriggerFramework;


    public ProcessWappMessageTriggerWSModel getProcessWappMessageTriggers(long userId, String processId) {

        ProcessWappMessageTriggerWSModel response = new ProcessWappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = processWappTriggerFramework.getProcessWappMessageTriggersService(userId,processId);
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

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processWappTriggerFramework.getProcessWappMessageTriggerService(userId,triggerId);
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

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processWappTriggerFramework.createProcessWappMessageTriggerService(userId,processId,trigger,accountId,wappTitle,wappBody,typeId);
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

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processWappTriggerFramework.updateProcessWappMessageTriggerService(userId,triggerId,trigger,accountId,wappTitle,wappBody);
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

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processWappTriggerFramework.removeProcessWappMessageTriggerService(userId,triggerId);
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



    public ProcessWappCallTriggerWSModel getProcessWappCallTriggers(long userId, String processId) {

        ProcessWappCallTriggerWSModel response = new ProcessWappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = processWappTriggerFramework.getProcessWappCallTriggersService(userId,processId);
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

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processWappTriggerFramework.getProcessWappCallTriggerService(userId,triggerId);
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

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processWappTriggerFramework.createProcessWappCallTriggerService(userId,processId,trigger,accountId,typeId);
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

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processWappTriggerFramework.updateProcessWappCallTriggerService(userId,triggerId,trigger,accountId);
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

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processWappTriggerFramework.removeProcessWappCallTriggerService(userId,triggerId);
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
