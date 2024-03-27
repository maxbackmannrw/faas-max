package com.faas.core.base.middleware.process.details.channel.trigger;

import com.faas.core.base.framework.process.details.channel.trigger.ProcessChannelTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.trigger.*;
import com.faas.core.base.model.ws.process.details.channel.trigger.dto.*;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessChannelTriggerMiddleware {


    @Autowired
    ProcessChannelTriggerFramework processChannelTriggerFramework;


    public ProcessTriggerWSModel getProcessTrigger(long userId, String processId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessTriggerWSDTO processTriggerWSDTO = processChannelTriggerFramework.getProcessTriggerService(userId,processId);
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

        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = processChannelTriggerFramework.getProcessAITriggersService(userId,processId);
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

        ProcessAITriggerWSDTO processAITriggerWSDTO = processChannelTriggerFramework.getProcessAITriggerService(userId,triggerId);
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

        ProcessAITriggerWSDTO processAITriggerWSDTO = processChannelTriggerFramework.createProcessAITriggerService(userId,processId,trigger,triggerDesc,accountId,typeId);
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

        ProcessAITriggerWSDTO processAITriggerWSDTO = processChannelTriggerFramework.updateProcessAITriggerService(userId,triggerId,trigger,triggerDesc,accountId);
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

        ProcessAITriggerWSDTO processAITriggerWSDTO = processChannelTriggerFramework.removeProcessAITriggerService(userId,triggerId);
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

        List<ProcessEmailTriggerWSDTO> processEmailTriggerWSDTOS = processChannelTriggerFramework.getProcessEmailTriggersService(userId,processId);
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

        ProcessEmailTriggerWSDTO processEmailTriggerWSDTO = processChannelTriggerFramework.getProcessEmailTriggerService(userId,triggerId);
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

        ProcessEmailTriggerWSDTO processEmailTriggerWSDTO = processChannelTriggerFramework.createProcessEmailTriggerService(userId,processId,trigger,triggerDesc,accountId,emailSubject,emailTitle,emailBody,emailSender,typeId);
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

        ProcessEmailTriggerWSDTO processEmailTriggerWSDTO = processChannelTriggerFramework.updateProcessEmailTriggerService(userId,triggerId,trigger,triggerDesc,accountId,emailSubject,emailTitle,emailBody,emailSender);
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

        ProcessEmailTriggerWSDTO processEmailTriggerWSDTO = processChannelTriggerFramework.removeProcessEmailTriggerService(userId,triggerId);
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


    public ProcessSipTriggerWSModel getProcessSipTriggers(long userId, String processId) {

        ProcessSipTriggerWSModel response = new ProcessSipTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessSipTriggerWSDTO> processSipTriggerWSDTOS = processChannelTriggerFramework.getProcessSipTriggersService(userId,processId);
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

        ProcessSipTriggerWSDTO processSipTriggerWSDTO = processChannelTriggerFramework.getProcessSipTriggerService(userId,triggerId);
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

    public ProcessSipTriggerWSModel createProcessSipTrigger(long userId, String processId, String trigger, String triggerDesc, String accountId, String callerId, long typeId) {

        ProcessSipTriggerWSModel response = new ProcessSipTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSipTriggerWSDTO> processSipTriggerWSDTOS = new ArrayList<>();

        ProcessSipTriggerWSDTO processSipTriggerWSDTO = processChannelTriggerFramework.createProcessSipTriggerService(userId,processId,trigger,triggerDesc,accountId,callerId,typeId);
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

    public ProcessSipTriggerWSModel updateProcessSipTrigger(long userId, String triggerId, String trigger, String triggerDesc, String accountId, String callerId) {

        ProcessSipTriggerWSModel response = new ProcessSipTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSipTriggerWSDTO> processSipTriggerWSDTOS = new ArrayList<>();

        ProcessSipTriggerWSDTO processSipTriggerWSDTO = processChannelTriggerFramework.updateProcessSipTriggerService(userId,triggerId,trigger,triggerDesc,accountId,callerId);
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

        ProcessSipTriggerWSDTO processSipTriggerWSDTO = processChannelTriggerFramework.removeProcessSipTriggerService(userId,triggerId);
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



    public ProcessSmsTriggerWSModel getProcessSmsTriggers(long userId, String processId) {

        ProcessSmsTriggerWSModel response = new ProcessSmsTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessSmsTriggerWSDTO> processSmsTriggerWSDTOS = processChannelTriggerFramework.getProcessSmsTriggersService(userId,processId);
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

        ProcessSmsTriggerWSDTO processSmsTriggerWSDTO = processChannelTriggerFramework.getProcessSmsTriggerService(userId,triggerId);
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

        ProcessSmsTriggerWSDTO processSmsTriggerWSDTO = processChannelTriggerFramework.createProcessSmsTriggerService(userId,processId,trigger,triggerDesc,accountId,smsTitle,smsBody,senderId,typeId);
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

        ProcessSmsTriggerWSDTO processSmsTriggerWSDTO = processChannelTriggerFramework.updateProcessSmsTriggerService(userId,triggerId,trigger,triggerDesc,accountId,smsTitle,smsBody,senderId);
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

        ProcessSmsTriggerWSDTO processSmsTriggerWSDTO = processChannelTriggerFramework.removeProcessSmsTriggerService(userId,triggerId);
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

        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = processChannelTriggerFramework.getProcessWappCallTriggersService(userId,processId);
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

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processChannelTriggerFramework.getProcessWappCallTriggerService(userId,triggerId);
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

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processChannelTriggerFramework.createProcessWappCallTriggerService(userId,processId,trigger,triggerDesc,accountId,typeId);
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

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processChannelTriggerFramework.updateProcessWappCallTriggerService(userId,triggerId,trigger,triggerDesc,accountId);
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

        ProcessWappCallTriggerWSDTO processWappCallTriggerWSDTO = processChannelTriggerFramework.removeProcessWappCallTriggerService(userId,triggerId);
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

        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = processChannelTriggerFramework.getProcessWappMessageTriggersService(userId,processId);
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

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processChannelTriggerFramework.getProcessWappMessageTriggerService(userId,triggerId);
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

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processChannelTriggerFramework.createProcessWappMessageTriggerService(userId,processId,trigger,triggerDesc,accountId,wappTitle,wappBody,typeId);
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

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processChannelTriggerFramework.updateProcessWappMessageTriggerService(userId,triggerId,trigger,triggerDesc,accountId,wappTitle,wappBody);
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

        ProcessWappMessageTriggerWSDTO processWappMessageTriggerWSDTO = processChannelTriggerFramework.removeProcessWappMessageTriggerService(userId,triggerId);
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
