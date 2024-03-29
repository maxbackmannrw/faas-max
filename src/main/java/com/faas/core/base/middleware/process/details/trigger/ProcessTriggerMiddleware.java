package com.faas.core.base.middleware.process.details.trigger;

import com.faas.core.base.framework.process.details.trigger.ProcessTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.*;
import com.faas.core.base.model.ws.process.details.trigger.dto.*;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessTriggerMiddleware {


    @Autowired
    ProcessTriggerFramework processTriggerFramework;


    public ProcessTriggerWSModel getProcessTrigger(long userId, String processId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.getProcessTriggerService(userId,processId);
        if (processTriggerWSDTO != null){
            response.setProcessTrigger(processTriggerWSDTO);
        }

        general.setOperation("getProcessTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessAITriggerWSModel getProcessAITriggers(long userId, String processId) {

        ProcessAITriggerWSModel response = new ProcessAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = processTriggerFramework.getProcessAITriggersService(userId,processId);
        if (processAITriggerWSDTOS != null){
            response.setProcessAITriggers(processAITriggerWSDTOS);
        }

        general.setOperation("getProcessAITriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessAITriggerWSModel getProcessAITrigger(long userId, String triggerId) {

        ProcessAITriggerWSModel response = new ProcessAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = new ArrayList<>();

        ProcessAITriggerWSDTO processAITriggerWSDTO = processTriggerFramework.getProcessAITriggerService(userId,triggerId);
        if (processAITriggerWSDTO != null){
            processAITriggerWSDTOS.add(processAITriggerWSDTO);
        }

        response.setProcessAITriggers(processAITriggerWSDTOS);
        general.setOperation("getProcessAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessAITriggerWSModel createProcessAITrigger(long userId, String processId, String trigger, String triggerDesc, String accountId, long typeId) {

        ProcessAITriggerWSModel response = new ProcessAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = new ArrayList<>();

        ProcessAITriggerWSDTO processAITriggerWSDTO = processTriggerFramework.createProcessAITriggerService(userId,processId,trigger,triggerDesc,accountId,typeId);
        if (processAITriggerWSDTO != null){
            processAITriggerWSDTOS.add(processAITriggerWSDTO);
        }

        response.setProcessAITriggers(processAITriggerWSDTOS);
        general.setOperation("createProcessAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessAITriggerWSModel updateProcessAITrigger(long userId, String triggerId, String trigger, String triggerDesc, String accountId) {

        ProcessAITriggerWSModel response = new ProcessAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = new ArrayList<>();

        ProcessAITriggerWSDTO processAITriggerWSDTO = processTriggerFramework.updateProcessAITriggerService(userId,triggerId,trigger,triggerDesc,accountId);
        if (processAITriggerWSDTO != null){
            processAITriggerWSDTOS.add(processAITriggerWSDTO);
        }

        response.setProcessAITriggers(processAITriggerWSDTOS);
        general.setOperation("updateProcessAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessAITriggerWSModel removeProcessAITrigger(long userId, String triggerId) {

        ProcessAITriggerWSModel response = new ProcessAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = new ArrayList<>();

        ProcessAITriggerWSDTO processAITriggerWSDTO = processTriggerFramework.removeProcessAITriggerService(userId,triggerId);
        if (processAITriggerWSDTO != null){
            processAITriggerWSDTOS.add(processAITriggerWSDTO);
        }

        response.setProcessAITriggers(processAITriggerWSDTOS);
        general.setOperation("removeProcessAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessEmailTriggerWSModel getProcessEmailTriggers(long userId, String processId) {

        ProcessEmailTriggerWSModel response = new ProcessEmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessEmailTriggerWSDTO> processEmailTriggerWSDTOS = processTriggerFramework.getProcessEmailTriggersService(userId,processId);
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

        ProcessEmailTriggerWSDTO processEmailTriggerWSDTO = processTriggerFramework.getProcessEmailTriggerService(userId,triggerId);
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

    public ProcessEmailTriggerWSModel createProcessEmailTrigger(long userId, String processId, String trigger, String triggerDesc, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender, long typeId) {

        ProcessEmailTriggerWSModel response = new ProcessEmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTriggerWSDTO> processEmailTriggerWSDTOS = new ArrayList<>();

        ProcessEmailTriggerWSDTO processEmailTriggerWSDTO = processTriggerFramework.createProcessEmailTriggerService(userId,processId,trigger,triggerDesc,accountId,emailSubject,emailTitle,emailBody,emailSender,typeId);
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

    public ProcessEmailTriggerWSModel updateProcessEmailTrigger(long userId, String triggerId, String trigger, String triggerDesc, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender) {

        ProcessEmailTriggerWSModel response = new ProcessEmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTriggerWSDTO> processEmailTriggerWSDTOS = new ArrayList<>();

        ProcessEmailTriggerWSDTO processEmailTriggerWSDTO = processTriggerFramework.updateProcessEmailTriggerService(userId,triggerId,trigger,triggerDesc,accountId,emailSubject,emailTitle,emailBody,emailSender);
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

        ProcessEmailTriggerWSDTO processEmailTriggerWSDTO = processTriggerFramework.removeProcessEmailTriggerService(userId,triggerId);
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


    public ProcessSipCallTriggerWSModel getProcessSipCallTriggers(long userId, String processId) {

        ProcessSipCallTriggerWSModel response = new ProcessSipCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessSipCallTriggerWSDTO> processSipCallTriggerWSDTOS = processTriggerFramework.getProcessSipCallTriggersService(userId,processId);
        if (processSipCallTriggerWSDTOS != null){
            response.setProcessSipCallTriggers(processSipCallTriggerWSDTOS);
        }

        general.setOperation("getProcessSipCallTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessSipCallTriggerWSModel getProcessSipCallTrigger(long userId, String triggerId) {

        ProcessSipCallTriggerWSModel response = new ProcessSipCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSipCallTriggerWSDTO> processSipCallTriggerWSDTOS = new ArrayList<>();

        ProcessSipCallTriggerWSDTO processSipCallTriggerWSDTO = processTriggerFramework.getProcessSipCallTriggerService(userId,triggerId);
        if (processSipCallTriggerWSDTO != null){
            processSipCallTriggerWSDTOS.add(processSipCallTriggerWSDTO);
        }

        response.setProcessSipCallTriggers(processSipCallTriggerWSDTOS);
        general.setOperation("getProcessSipCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSipCallTriggerWSModel createProcessSipCallTrigger(long userId, String processId, String trigger, String triggerDesc, String accountId, String callerId, long typeId) {

        ProcessSipCallTriggerWSModel response = new ProcessSipCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSipCallTriggerWSDTO> processSipCallTriggerWSDTOS = new ArrayList<>();

        ProcessSipCallTriggerWSDTO processSipCallTriggerWSDTO = processTriggerFramework.createProcessSipCallTriggerService(userId,processId,trigger,triggerDesc,accountId,callerId,typeId);
        if (processSipCallTriggerWSDTO != null){
            processSipCallTriggerWSDTOS.add(processSipCallTriggerWSDTO);
        }

        response.setProcessSipCallTriggers(processSipCallTriggerWSDTOS);
        general.setOperation("createProcessSipCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSipCallTriggerWSModel updateProcessSipCallTrigger(long userId, String triggerId, String trigger, String triggerDesc, String accountId, String callerId) {

        ProcessSipCallTriggerWSModel response = new ProcessSipCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSipCallTriggerWSDTO> processSipCallTriggerWSDTOS = new ArrayList<>();

        ProcessSipCallTriggerWSDTO processSipCallTriggerWSDTO = processTriggerFramework.updateProcessSipCallTriggerService(userId,triggerId,trigger,triggerDesc,accountId,callerId);
        if (processSipCallTriggerWSDTO != null){
            processSipCallTriggerWSDTOS.add(processSipCallTriggerWSDTO);
        }

        response.setProcessSipCallTriggers(processSipCallTriggerWSDTOS);
        general.setOperation("updateProcessSipCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSipCallTriggerWSModel removeProcessSipCallTrigger(long userId, String triggerId) {

        ProcessSipCallTriggerWSModel response = new ProcessSipCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSipCallTriggerWSDTO> processSipCallTriggerWSDTOS = new ArrayList<>();

        ProcessSipCallTriggerWSDTO processSipCallTriggerWSDTO = processTriggerFramework.removeProcessSipCallTriggerService(userId,triggerId);
        if (processSipCallTriggerWSDTO != null){
            processSipCallTriggerWSDTOS.add(processSipCallTriggerWSDTO);
        }

        response.setProcessSipCallTriggers(processSipCallTriggerWSDTOS);
        general.setOperation("removeProcessSipCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessSmsTriggerWSModel getProcessSmsTriggers(long userId, String processId) {

        ProcessSmsTriggerWSModel response = new ProcessSmsTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessSmsTriggerWSDTO> processSmsTriggerWSDTOS = processTriggerFramework.getProcessSmsTriggersService(userId,processId);
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

        ProcessSmsTriggerWSDTO processSmsTriggerWSDTO = processTriggerFramework.getProcessSmsTriggerService(userId,triggerId);
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

    public ProcessSmsTriggerWSModel createProcessSmsTrigger(long userId, String processId, String trigger, String triggerDesc, String accountId, String smsTitle, String smsBody, String senderId, long typeId) {

        ProcessSmsTriggerWSModel response = new ProcessSmsTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTriggerWSDTO> processSmsTriggerWSDTOS = new ArrayList<>();

        ProcessSmsTriggerWSDTO processSmsTriggerWSDTO = processTriggerFramework.createProcessSmsTriggerService(userId,processId,trigger,triggerDesc,accountId,smsTitle,smsBody,senderId,typeId);
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

    public ProcessSmsTriggerWSModel updateProcessSmsTrigger(long userId, String triggerId, String trigger, String triggerDesc, String accountId, String smsTitle, String smsBody, String senderId) {

        ProcessSmsTriggerWSModel response = new ProcessSmsTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTriggerWSDTO> processSmsTriggerWSDTOS = new ArrayList<>();

        ProcessSmsTriggerWSDTO processSmsTriggerWSDTO = processTriggerFramework.updateProcessSmsTriggerService(userId,triggerId,trigger,triggerDesc,accountId,smsTitle,smsBody,senderId);
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

        ProcessSmsTriggerWSDTO processSmsTriggerWSDTO = processTriggerFramework.removeProcessSmsTriggerService(userId,triggerId);
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



    public ProcessWappCallTriggerWSModel getProcessWappCallTriggers(long userId, String processId) {

        ProcessWappCallTriggerWSModel response = new ProcessWappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = processTriggerFramework.getProcessWappCallTriggersService(userId,processId);
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

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processTriggerFramework.getProcessWappCallTriggerService(userId,triggerId);
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

    public ProcessWappCallTriggerWSModel createProcessWappCallTrigger(long userId, String processId, String trigger, String triggerDesc, String accountId, long typeId) {

        ProcessWappCallTriggerWSModel response = new ProcessWappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = new ArrayList<>();

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processTriggerFramework.createProcessWappCallTriggerService(userId,processId,trigger,triggerDesc,accountId,typeId);
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

    public ProcessWappCallTriggerWSModel updateProcessWappCallTrigger(long userId, String triggerId, String trigger, String triggerDesc, String accountId) {

        ProcessWappCallTriggerWSModel response = new ProcessWappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = new ArrayList<>();

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processTriggerFramework.updateProcessWappCallTriggerService(userId,triggerId,trigger,triggerDesc,accountId);
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

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processTriggerFramework.removeProcessWappCallTriggerService(userId,triggerId);
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



    public ProcessWappMessageTriggerWSModel getProcessWappMessageTriggers(long userId, String processId) {

        ProcessWappMessageTriggerWSModel response = new ProcessWappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = processTriggerFramework.getProcessWappMessageTriggersService(userId,processId);
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

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processTriggerFramework.getProcessWappMessageTriggerService(userId,triggerId);
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

    public ProcessWappMessageTriggerWSModel createProcessWappMessageTrigger(long userId, String processId, String trigger, String triggerDesc, String accountId, String wappTitle, String wappBody, long typeId) {

        ProcessWappMessageTriggerWSModel response = new ProcessWappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = new ArrayList<>();

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processTriggerFramework.createProcessWappMessageTriggerService(userId,processId,trigger,triggerDesc,accountId,wappTitle,wappBody,typeId);
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

    public ProcessWappMessageTriggerWSModel updateProcessWappMessageTrigger(long userId, String triggerId, String trigger, String triggerDesc, String accountId, String wappTitle, String wappBody) {

        ProcessWappMessageTriggerWSModel response = new ProcessWappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = new ArrayList<>();

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processTriggerFramework.updateProcessWappMessageTriggerService(userId,triggerId,trigger,triggerDesc,accountId,wappTitle,wappBody);
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

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processTriggerFramework.removeProcessWappMessageTriggerService(userId,triggerId);
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
