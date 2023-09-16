package com.faas.core.base.middleware.process.details.trigger;

import com.faas.core.base.framework.process.details.trigger.ProcessTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.ProcessTriggerWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessTriggerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessTriggerMiddleware {


    @Autowired
    ProcessTriggerFramework processTriggerFramework;


    public ProcessTriggerWSModel getProcessTriggers(long userId, String processId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = processTriggerFramework.getProcessTriggersService(userId,processId);
        if (processTriggerWSDTOS != null){
            response.setProcessTriggers(processTriggerWSDTOS);
        }

        general.setOperation("getProcessTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessTriggerWSModel getProcessTriggersByType(long userId, String processId, String baseType) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = processTriggerFramework.getProcessTriggersByTypeService(userId,processId,baseType);
        if (processTriggerWSDTOS != null){
            response.setProcessTriggers(processTriggerWSDTOS);
        }

        general.setOperation("getProcessTriggersByType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessTriggerWSModel getProcessTrigger(long userId, String triggerId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.getProcessTriggerService(userId,triggerId);
        if (processTriggerWSDTO != null){
            processTriggerWSDTOS.add(processTriggerWSDTO);
        }

        response.setProcessTriggers(processTriggerWSDTOS);
        general.setOperation("getProcessTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessTriggerWSModel createAITrigger(long userId, String processId, String accountId, String trigger, long typeId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.createAITriggerService(userId,processId,accountId,trigger,typeId);
        if (processTriggerWSDTO != null){
            processTriggerWSDTOS.add(processTriggerWSDTO);
        }

        response.setProcessTriggers(processTriggerWSDTOS);
        general.setOperation("createAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessTriggerWSModel updateAITrigger(long userId, String triggerId, String accountId, String trigger) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.updateAITriggerService(userId,triggerId,accountId,trigger);
        if (processTriggerWSDTO != null){
            processTriggerWSDTOS.add(processTriggerWSDTO);
        }

        response.setProcessTriggers(processTriggerWSDTOS);
        general.setOperation("updateAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessTriggerWSModel createEmailTrigger(long userId, String processId, String accountId, String trigger, String emailSubject, String emailTitle, String emailBody, String emailSender, long typeId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.createEmailTriggerService(userId,processId,accountId,trigger,emailSubject,emailTitle,emailBody,emailSender,typeId);
        if (processTriggerWSDTO != null){
            processTriggerWSDTOS.add(processTriggerWSDTO);
        }

        response.setProcessTriggers(processTriggerWSDTOS);
        general.setOperation("createEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessTriggerWSModel updateEmailTrigger(long userId, String triggerId, String accountId, String trigger, String emailSubject, String emailTitle, String emailBody, String emailSender) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.updateEmailTriggerService(userId,triggerId,accountId,trigger,emailSubject,emailTitle,emailBody,emailSender);
        if (processTriggerWSDTO != null){
            processTriggerWSDTOS.add(processTriggerWSDTO);
        }

        response.setProcessTriggers(processTriggerWSDTOS);
        general.setOperation("updateEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessTriggerWSModel createSipTrigger(long userId, String processId, String accountId, String trigger, String callerId, long typeId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.createSipTriggerService(userId,processId,accountId,trigger,callerId,typeId);
        if (processTriggerWSDTO != null){
            processTriggerWSDTOS.add(processTriggerWSDTO);

        }

        response.setProcessTriggers(processTriggerWSDTOS);
        general.setOperation("createSipTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessTriggerWSModel updateSipTrigger(long userId, String triggerId, String accountId, String trigger, String callerId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.updateSipTriggerService(userId,triggerId,accountId,trigger,callerId);
        if (processTriggerWSDTO != null){
            processTriggerWSDTOS.add(processTriggerWSDTO);
        }

        response.setProcessTriggers(processTriggerWSDTOS);
        general.setOperation("updateSipTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessTriggerWSModel createSmsTrigger(long userId, String processId, String accountId, String trigger, String smsTitle, String smsBody, String senderId, long typeId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.createSmsTriggerService(userId,processId,accountId,trigger,smsTitle,smsBody,senderId,typeId);
        if (processTriggerWSDTO != null){
            processTriggerWSDTOS.add(processTriggerWSDTO);
        }

        response.setProcessTriggers(processTriggerWSDTOS);
        general.setOperation("createSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessTriggerWSModel updateSmsTrigger(long userId, String triggerId, String accountId, String trigger, String smsTitle, String smsBody, String senderId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.updateSmsTriggerService(userId,triggerId,accountId,trigger,smsTitle,smsBody,senderId);
        if (processTriggerWSDTO != null){
            processTriggerWSDTOS.add(processTriggerWSDTO);
        }

        response.setProcessTriggers(processTriggerWSDTOS);
        general.setOperation("updateSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessTriggerWSModel createWappCallTrigger(long userId, String processId, String accountId, String trigger, long typeId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.createWappCallTriggerService(userId,processId,accountId,trigger,typeId);
        if (processTriggerWSDTO != null){
            processTriggerWSDTOS.add(processTriggerWSDTO);
        }

        response.setProcessTriggers(processTriggerWSDTOS);
        general.setOperation("updateWappTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessTriggerWSModel updateWappCallTrigger(long userId, String triggerId, String accountId, String trigger) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.updateWappCallTriggerService(userId,triggerId,accountId,trigger);
        if (processTriggerWSDTO != null){
            processTriggerWSDTOS.add(processTriggerWSDTO);
        }

        response.setProcessTriggers(processTriggerWSDTOS);
        general.setOperation("updateWappTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessTriggerWSModel createWappMessageTrigger(long userId, String processId, String accountId, String trigger, String wappTitle, String wappBody, long typeId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.createWappMessageTriggerService(userId,processId,accountId,trigger,wappTitle,wappBody,typeId);
        if (processTriggerWSDTO != null){
            processTriggerWSDTOS.add(processTriggerWSDTO);
        }

        response.setProcessTriggers(processTriggerWSDTOS);
        general.setOperation("createWappTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessTriggerWSModel updateWappMessageTrigger(long userId, String triggerId, String accountId, String trigger, String wappTitle, String wappBody) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.updateWappMessageTriggerService(userId,triggerId,accountId,trigger,wappTitle,wappBody);
        if (processTriggerWSDTO != null){
            processTriggerWSDTOS.add(processTriggerWSDTO);
        }

        response.setProcessTriggers(processTriggerWSDTOS);
        general.setOperation("updateWappTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessTriggerWSModel removeProcessTrigger(long userId, String triggerId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.removeProcessTriggerService(userId,triggerId);
        if (processTriggerWSDTO != null){
            processTriggerWSDTOS.add(processTriggerWSDTO);
        }

        response.setProcessTriggers(processTriggerWSDTOS);
        general.setOperation("removeProcessTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
