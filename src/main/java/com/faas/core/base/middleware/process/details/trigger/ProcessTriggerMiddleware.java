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


    public ProcessTriggerWSModel getProcessTriggers(long userId, String processId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.getProcessTriggersService(userId,processId);
        if (processTriggerWSDTO != null){
            response.setProcessTrigger(processTriggerWSDTO);
        }

        general.setOperation("getProcessTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public AiTriggerWSModel getAITriggers(long userId, String processId) {

        AiTriggerWSModel response = new AiTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<AiTriggerWSDTO> aiTriggerWSDTOS = processTriggerFramework.getAITriggersService(userId,processId);
        if (aiTriggerWSDTOS != null){
            response.setAiTriggers(aiTriggerWSDTOS);
        }

        general.setOperation("getAITriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AiTriggerWSModel getAITrigger(long userId, String triggerId) {

        AiTriggerWSModel response = new AiTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AiTriggerWSDTO> aiTriggerWSDTOS = new ArrayList<>();

        AiTriggerWSDTO aiTriggerWSDTO = processTriggerFramework.getAITriggerService(userId,triggerId);
        if (aiTriggerWSDTO != null){
            aiTriggerWSDTOS.add(aiTriggerWSDTO);
        }

        response.setAiTriggers(aiTriggerWSDTOS);
        general.setOperation("getAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AiTriggerWSModel createAITrigger(long userId,String processId,String triggerDesc,String accountId,long typeId) {

        AiTriggerWSModel response = new AiTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AiTriggerWSDTO> aiTriggerWSDTOS = new ArrayList<>();

        AiTriggerWSDTO aiTriggerWSDTO = processTriggerFramework.createAITriggerService(userId,processId,triggerDesc,accountId,typeId);
        if (aiTriggerWSDTO != null){
            aiTriggerWSDTOS.add(aiTriggerWSDTO);
        }

        response.setAiTriggers(aiTriggerWSDTOS);
        general.setOperation("createAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AiTriggerWSModel updateAITrigger(long userId, String triggerId, String triggerDesc,String accountId) {

        AiTriggerWSModel response = new AiTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AiTriggerWSDTO> aiTriggerWSDTOS = new ArrayList<>();

        AiTriggerWSDTO aiTriggerWSDTO = processTriggerFramework.updateAITriggerService(userId,triggerId,triggerDesc,accountId);
        if (aiTriggerWSDTO != null){
            aiTriggerWSDTOS.add(aiTriggerWSDTO);
        }

        response.setAiTriggers(aiTriggerWSDTOS);
        general.setOperation("updateAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AiTriggerWSModel removeAITrigger(long userId, String triggerId) {

        AiTriggerWSModel response = new AiTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AiTriggerWSDTO> aiTriggerWSDTOS = new ArrayList<>();

        AiTriggerWSDTO aiTriggerWSDTO = processTriggerFramework.removeAITriggerService(userId,triggerId);
        if (aiTriggerWSDTO != null){
            aiTriggerWSDTOS.add(aiTriggerWSDTO);
        }

        response.setAiTriggers(aiTriggerWSDTOS);
        general.setOperation("removeAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public EmailTriggerWSModel getEmailTriggers(long userId, String processId) {

        EmailTriggerWSModel response = new EmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<EmailTriggerWSDTO> emailTriggerWSDTOS = processTriggerFramework.getEmailTriggersService(userId,processId);
        if (emailTriggerWSDTOS != null){
            response.setEmailTriggers(emailTriggerWSDTOS);
        }

        general.setOperation("getEmailTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public EmailTriggerWSModel getEmailTrigger(long userId,String triggerId) {

        EmailTriggerWSModel response = new EmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTriggerWSDTO> emailTriggerWSDTOS = new ArrayList<>();

        EmailTriggerWSDTO emailTriggerWSDTO = processTriggerFramework.getEmailTriggerService(userId,triggerId);
        if (emailTriggerWSDTO != null){
            emailTriggerWSDTOS.add(emailTriggerWSDTO);
        }

        response.setEmailTriggers(emailTriggerWSDTOS);
        general.setOperation("getEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public EmailTriggerWSModel createEmailTrigger(long userId,String processId,String triggerDesc,String accountId,String emailSubject,String emailTitle,String emailBody,String emailSender,long typeId) {

        EmailTriggerWSModel response = new EmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTriggerWSDTO> emailTriggerWSDTOS = new ArrayList<>();

        EmailTriggerWSDTO emailTriggerWSDTO = processTriggerFramework.createEmailTriggerService(userId,processId,triggerDesc,accountId,emailSubject,emailTitle,emailBody,emailSender,typeId);
        if (emailTriggerWSDTO != null){
            emailTriggerWSDTOS.add(emailTriggerWSDTO);
        }

        response.setEmailTriggers(emailTriggerWSDTOS);
        general.setOperation("createEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public EmailTriggerWSModel updateEmailTrigger(long userId,String triggerId, String triggerDesc,String accountId,String emailSubject,String emailTitle,String emailBody,String emailSender) {

        EmailTriggerWSModel response = new EmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTriggerWSDTO> emailTriggerWSDTOS = new ArrayList<>();

        EmailTriggerWSDTO emailTriggerWSDTO = processTriggerFramework.updateEmailTriggerService(userId,triggerId,triggerDesc,accountId,emailSubject,emailTitle,emailBody,emailSender);
        if (emailTriggerWSDTO != null){
            emailTriggerWSDTOS.add(emailTriggerWSDTO);
        }

        response.setEmailTriggers(emailTriggerWSDTOS);
        general.setOperation("updateEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public EmailTriggerWSModel removeEmailTrigger(long userId, String triggerId) {

        EmailTriggerWSModel response = new EmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTriggerWSDTO> emailTriggerWSDTOS = new ArrayList<>();

        EmailTriggerWSDTO emailTriggerWSDTO = processTriggerFramework.removeEmailTriggerService(userId,triggerId);
        if (emailTriggerWSDTO != null){
            emailTriggerWSDTOS.add(emailTriggerWSDTO);
        }

        response.setEmailTriggers(emailTriggerWSDTOS);
        general.setOperation("removeEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public SipCallTriggerWSModel getSipCallTriggers(long userId,String processId) {

        SipCallTriggerWSModel response = new SipCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SipCallTriggerWSDTO> sipCallTriggerWSDTOS = processTriggerFramework.getSipCallTriggersService(userId,processId);
        if (sipCallTriggerWSDTOS != null){
            response.setSipCallTriggers(sipCallTriggerWSDTOS);
        }

        general.setOperation("getSipCallTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SipCallTriggerWSModel getSipCallTrigger(long userId,String triggerId) {

        SipCallTriggerWSModel response = new SipCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SipCallTriggerWSDTO> sipCallTriggerWSDTOS = new ArrayList<>();

        SipCallTriggerWSDTO sipCallTriggerWSDTO = processTriggerFramework.getSipCallTriggerService(userId,triggerId);
        if (sipCallTriggerWSDTO != null){
            sipCallTriggerWSDTOS.add(sipCallTriggerWSDTO);
        }

        response.setSipCallTriggers(sipCallTriggerWSDTOS);
        general.setOperation("getSipCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SipCallTriggerWSModel createSipCallTrigger(long userId,String processId,String triggerDesc,String accountId,String callerId,long typeId) {

        SipCallTriggerWSModel response = new SipCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SipCallTriggerWSDTO> sipCallTriggerWSDTOS = new ArrayList<>();

        SipCallTriggerWSDTO sipCallTriggerWSDTO = processTriggerFramework.createSipCallTriggerService(userId,processId,triggerDesc,accountId,callerId,typeId);
        if (sipCallTriggerWSDTO != null){
            sipCallTriggerWSDTOS.add(sipCallTriggerWSDTO);
        }

        response.setSipCallTriggers(sipCallTriggerWSDTOS);
        general.setOperation("createSipTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SipCallTriggerWSModel updateSipCallTrigger(long userId,String triggerId,String triggerDesc,String accountId,String callerId) {

        SipCallTriggerWSModel response = new SipCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SipCallTriggerWSDTO> sipCallTriggerWSDTOS = new ArrayList<>();

        SipCallTriggerWSDTO sipCallTriggerWSDTO = processTriggerFramework.updateSipCallTriggerService(userId,triggerId,triggerDesc,accountId,callerId);
        if (sipCallTriggerWSDTO != null){
            sipCallTriggerWSDTOS.add(sipCallTriggerWSDTO);
        }

        response.setSipCallTriggers(sipCallTriggerWSDTOS);
        general.setOperation("updateSipCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SipCallTriggerWSModel removeSipCallTrigger(long userId,String triggerId) {

        SipCallTriggerWSModel response = new SipCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SipCallTriggerWSDTO> sipCallTriggerWSDTOS = new ArrayList<>();

        SipCallTriggerWSDTO sipCallTriggerWSDTO = processTriggerFramework.removeSipCallTriggerService(userId,triggerId);
        if (sipCallTriggerWSDTO != null){
            sipCallTriggerWSDTOS.add(sipCallTriggerWSDTO);
        }

        response.setSipCallTriggers(sipCallTriggerWSDTOS);
        general.setOperation("removeSipCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public SmsMessageTriggerWSModel getSmsMessageTriggers(long userId,String processId) {

        SmsMessageTriggerWSModel response = new SmsMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SmsMessageTriggerWSDTO> smsMessageTriggerWSDTOS = processTriggerFramework.getSmsMessageTriggersService(userId,processId);
        if (smsMessageTriggerWSDTOS != null){
            response.setSmsMessageTriggers(smsMessageTriggerWSDTOS);
        }

        general.setOperation("getSmsMessageTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SmsMessageTriggerWSModel getSmsMessageTrigger(long userId, String triggerId) {

        SmsMessageTriggerWSModel response = new SmsMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsMessageTriggerWSDTO> smsMessageTriggerWSDTOS = new ArrayList<>();

        SmsMessageTriggerWSDTO smsMessageTriggerWSDTO = processTriggerFramework.getSmsMessageTriggerService(userId,triggerId);
        if (smsMessageTriggerWSDTO != null){
            smsMessageTriggerWSDTOS.add(smsMessageTriggerWSDTO);
        }

        response.setSmsMessageTriggers(smsMessageTriggerWSDTOS);
        general.setOperation("getSmsMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SmsMessageTriggerWSModel createSmsMessageTrigger(long userId,String processId,String triggerDesc,String accountId,String smsTitle,String smsBody,String senderId,long typeId) {

        SmsMessageTriggerWSModel response = new SmsMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsMessageTriggerWSDTO> smsMessageTriggerWSDTOS = new ArrayList<>();

        SmsMessageTriggerWSDTO smsMessageTriggerWSDTO = processTriggerFramework.createSmsMessageTriggerService(userId,processId,triggerDesc,accountId,smsTitle,smsBody,senderId,typeId);
        if (smsMessageTriggerWSDTO != null){
            smsMessageTriggerWSDTOS.add(smsMessageTriggerWSDTO);
        }

        response.setSmsMessageTriggers(smsMessageTriggerWSDTOS);
        general.setOperation("createSmsMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SmsMessageTriggerWSModel updateSmsMessageTrigger(long userId,String triggerId,String triggerDesc,String accountId,String smsTitle,String smsBody,String senderId) {

        SmsMessageTriggerWSModel response = new SmsMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsMessageTriggerWSDTO> smsMessageTriggerWSDTOS = new ArrayList<>();

        SmsMessageTriggerWSDTO smsMessageTriggerWSDTO = processTriggerFramework.updateSmsMessageTriggerService(userId,triggerId,triggerDesc,accountId,smsTitle,smsBody,senderId);
        if (smsMessageTriggerWSDTO != null){
            smsMessageTriggerWSDTOS.add(smsMessageTriggerWSDTO);
        }

        response.setSmsMessageTriggers(smsMessageTriggerWSDTOS);
        general.setOperation("updateSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SmsMessageTriggerWSModel removeSmsMessageTrigger(long userId,String triggerId) {

        SmsMessageTriggerWSModel response = new SmsMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsMessageTriggerWSDTO> smsMessageTriggerWSDTOS = new ArrayList<>();

        SmsMessageTriggerWSDTO smsMessageTriggerWSDTO = processTriggerFramework.removeSmsMessageTriggerService(userId,triggerId);
        if (smsMessageTriggerWSDTO != null){
            smsMessageTriggerWSDTOS.add(smsMessageTriggerWSDTO);
        }

        response.setSmsMessageTriggers(smsMessageTriggerWSDTOS);
        general.setOperation("removeSmsMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public WappCallTriggerWSModel getWappCallTriggers(long userId, String processId) {

        WappCallTriggerWSModel response = new WappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<WappCallTriggerWSDTO> wappCallTriggerWSDTOS = processTriggerFramework.getWappCallTriggersService(userId,processId);
        if (wappCallTriggerWSDTOS != null){
            response.setWappCallTriggers(wappCallTriggerWSDTOS);
        }

        general.setOperation("getWappCallTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappCallTriggerWSModel getWappCallTrigger(long userId,String triggerId) {

        WappCallTriggerWSModel response = new WappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappCallTriggerWSDTO> wappCallTriggerWSDTOS = new ArrayList<>();

        WappCallTriggerWSDTO wappCallTriggerWSDTO = processTriggerFramework.getWappCallTriggerService(userId,triggerId);
        if (wappCallTriggerWSDTO != null){
            wappCallTriggerWSDTOS.add(wappCallTriggerWSDTO);
        }

        response.setWappCallTriggers(wappCallTriggerWSDTOS);
        general.setOperation("getWappCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappCallTriggerWSModel createWappCallTrigger(long userId,String processId,String triggerDesc,String accountId,long typeId) {

        WappCallTriggerWSModel response = new WappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappCallTriggerWSDTO> wappCallTriggerWSDTOS = new ArrayList<>();

        WappCallTriggerWSDTO wappCallTriggerWSDTO = processTriggerFramework.createWappCallTriggerService(userId,processId,triggerDesc,accountId,typeId);
        if (wappCallTriggerWSDTO != null){
            wappCallTriggerWSDTOS.add(wappCallTriggerWSDTO);
        }

        response.setWappCallTriggers(wappCallTriggerWSDTOS);
        general.setOperation("createWappCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappCallTriggerWSModel updateWappCallTrigger(long userId,String triggerId,String triggerDesc,String accountId) {

        WappCallTriggerWSModel response = new WappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappCallTriggerWSDTO> wappCallTriggerWSDTOS = new ArrayList<>();

        WappCallTriggerWSDTO wappCallTriggerWSDTO = processTriggerFramework.updateWappCallTriggerService(userId,triggerId,triggerDesc,accountId);
        if (wappCallTriggerWSDTO != null){
            wappCallTriggerWSDTOS.add(wappCallTriggerWSDTO);
        }

        response.setWappCallTriggers(wappCallTriggerWSDTOS);
        general.setOperation("updateWappCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappCallTriggerWSModel removeWappCallTrigger(long userId, String triggerId) {

        WappCallTriggerWSModel response = new WappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappCallTriggerWSDTO> wappCallTriggerWSDTOS = new ArrayList<>();

        WappCallTriggerWSDTO wappCallTriggerWSDTO = processTriggerFramework.removeWappCallTriggerService(userId,triggerId);
        if (wappCallTriggerWSDTO != null){
            wappCallTriggerWSDTOS.add(wappCallTriggerWSDTO);
        }

        response.setWappCallTriggers(wappCallTriggerWSDTOS);
        general.setOperation("removeWappCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public WappMessageTriggerWSModel getWappMessageTriggers(long userId,String processId) {

        WappMessageTriggerWSModel response = new WappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<WappMessageTriggerWSDTO> wappMessageTriggerWSDTOS = processTriggerFramework.getWappMessageTriggersService(userId,processId);
        if (wappMessageTriggerWSDTOS != null){
            response.setWappMessageTriggers(wappMessageTriggerWSDTOS);
        }

        general.setOperation("getWappMessageTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappMessageTriggerWSModel getWappMessageTrigger(long userId,String triggerId) {

        WappMessageTriggerWSModel response = new WappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTriggerWSDTO> wappMessageTriggerWSDTOS = new ArrayList<>();

        WappMessageTriggerWSDTO wappMessageTriggerWSDTO = processTriggerFramework.getWappMessageTriggerService(userId,triggerId);
        if (wappMessageTriggerWSDTO != null){
            wappMessageTriggerWSDTOS.add(wappMessageTriggerWSDTO);
        }

        response.setWappMessageTriggers(wappMessageTriggerWSDTOS);
        general.setOperation("getWappMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappMessageTriggerWSModel createWappMessageTrigger(long userId,String processId,String triggerDesc,String accountId,String wappTitle,String wappBody,long typeId) {

        WappMessageTriggerWSModel response = new WappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTriggerWSDTO> wappMessageTriggerWSDTOS = new ArrayList<>();

        WappMessageTriggerWSDTO wappMessageTriggerWSDTO = processTriggerFramework.createWappMessageTriggerService(userId,processId,triggerDesc,accountId,wappTitle,wappBody,typeId);
        if (wappMessageTriggerWSDTO != null){
            wappMessageTriggerWSDTOS.add(wappMessageTriggerWSDTO);
        }

        response.setWappMessageTriggers(wappMessageTriggerWSDTOS);
        general.setOperation("createWappMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public WappMessageTriggerWSModel updateWappMessageTrigger(long userId, String triggerId,String triggerDesc,String accountId,String wappTitle,String wappBody) {

        WappMessageTriggerWSModel response = new WappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTriggerWSDTO> wappMessageTriggerWSDTOS = new ArrayList<>();

        WappMessageTriggerWSDTO wappMessageTriggerWSDTO = processTriggerFramework.updateWappMessageTriggerService(userId,triggerId,triggerDesc,accountId,wappTitle,wappBody);
        if (wappMessageTriggerWSDTO != null){
            wappMessageTriggerWSDTOS.add(wappMessageTriggerWSDTO);
        }

        response.setWappMessageTriggers(wappMessageTriggerWSDTOS);
        general.setOperation("updateWappMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappMessageTriggerWSModel removeWappMessageTrigger(long userId, String triggerId) {

        WappMessageTriggerWSModel response = new WappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTriggerWSDTO> wappMessageTriggerWSDTOS = new ArrayList<>();

        WappMessageTriggerWSDTO wappMessageTriggerWSDTO = processTriggerFramework.removeWappMessageTriggerService(userId,triggerId);
        if (wappMessageTriggerWSDTO != null){
            wappMessageTriggerWSDTOS.add(wappMessageTriggerWSDTO);
        }

        response.setWappMessageTriggers(wappMessageTriggerWSDTOS);
        general.setOperation("removeWappMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
