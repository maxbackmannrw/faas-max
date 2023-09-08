package com.faas.core.base.middleware.process.details.trigger;

import com.faas.core.base.framework.process.details.trigger.ProcessTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.TriggerWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.TriggerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessTriggerMiddleware {


    @Autowired
    ProcessTriggerFramework processTriggerFramework;


    public TriggerWSModel getProcessTriggers(long userId, String processId) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<TriggerWSDTO> triggerWSDTOS = processTriggerFramework.getProcessTriggersService(userId,processId);
        if (triggerWSDTOS != null){
            response.setTriggers(triggerWSDTOS);
        }

        general.setOperation("getProcessTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerWSModel getProcessTriggersByType(long userId, String processId, String baseType) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<TriggerWSDTO> triggerWSDTOS = processTriggerFramework.getProcessTriggersByTypeService(userId,processId,baseType);
        if (triggerWSDTOS != null){
            response.setTriggers(triggerWSDTOS);
        }

        general.setOperation("getProcessTriggersByType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerWSModel getTrigger(long userId,String triggerId) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        TriggerWSDTO triggerWSDTO = processTriggerFramework.getTriggerService(userId,triggerId);
        if (triggerWSDTO != null){
            triggerWSDTOS.add(triggerWSDTO);
        }

        response.setTriggers(triggerWSDTOS);
        general.setOperation("getTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerWSModel createAITrigger(long userId,String processId,String accountId,String trigger,long typeId) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        TriggerWSDTO triggerWSDTO = processTriggerFramework.createAITriggerService(userId,processId,accountId,trigger,typeId);
        if (triggerWSDTO != null){
            triggerWSDTOS.add(triggerWSDTO);
        }

        response.setTriggers(triggerWSDTOS);
        general.setOperation("createAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerWSModel updateAITrigger(long userId,String triggerId,String accountId,String trigger) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        TriggerWSDTO triggerWSDTO = processTriggerFramework.updateAITriggerService(userId,triggerId,accountId,trigger);
        if (triggerWSDTO != null){
            triggerWSDTOS.add(triggerWSDTO);
        }

        response.setTriggers(triggerWSDTOS);
        general.setOperation("updateAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public TriggerWSModel createEmailTrigger(long userId,String processId,String accountId,String trigger,String emailSubject, String emailTitle, String emailBody, String emailSender, long typeId) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        TriggerWSDTO triggerWSDTO = processTriggerFramework.createEmailTriggerService(userId,processId,accountId,trigger,emailSubject,emailTitle,emailBody,emailSender,typeId);
        if (triggerWSDTO != null){
            triggerWSDTOS.add(triggerWSDTO);
        }

        response.setTriggers(triggerWSDTOS);
        general.setOperation("createEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerWSModel updateEmailTrigger(long userId,String triggerId,String accountId,String trigger,String emailSubject, String emailTitle, String emailBody, String emailSender) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        TriggerWSDTO triggerWSDTO = processTriggerFramework.updateEmailTriggerService(userId,triggerId,accountId,trigger,emailSubject,emailTitle,emailBody,emailSender);
        if (triggerWSDTO != null){
            triggerWSDTOS.add(triggerWSDTO);
        }

        response.setTriggers(triggerWSDTOS);
        general.setOperation("updateEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerWSModel createSipTrigger(long userId,String processId,String accountId,String trigger,String callerId,long typeId) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        TriggerWSDTO triggerWSDTO = processTriggerFramework.createSipTriggerService(userId,processId,accountId,trigger,callerId,typeId);
        if (triggerWSDTO != null){
            triggerWSDTOS.add(triggerWSDTO);

        }

        response.setTriggers(triggerWSDTOS);
        general.setOperation("createSipTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerWSModel updateSipTrigger(long userId,String triggerId,String accountId,String trigger,String callerId) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        TriggerWSDTO triggerWSDTO = processTriggerFramework.updateSipTriggerService(userId,triggerId,accountId,trigger,callerId);
        if (triggerWSDTO != null){
            triggerWSDTOS.add(triggerWSDTO);
        }

        response.setTriggers(triggerWSDTOS);
        general.setOperation("updateSipTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerWSModel createSmsTrigger(long userId, String processId,String accountId,String trigger,String smsTitle, String smsBody, String senderId, long typeId) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        TriggerWSDTO triggerWSDTO = processTriggerFramework.createSmsTriggerService(userId,processId,accountId,trigger,smsTitle,smsBody,senderId,typeId);
        if (triggerWSDTO != null){
            triggerWSDTOS.add(triggerWSDTO);
        }

        response.setTriggers(triggerWSDTOS);
        general.setOperation("createSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerWSModel updateSmsTrigger(long userId,String triggerId,String accountId,String trigger,String smsTitle,String smsBody,String senderId) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        TriggerWSDTO triggerWSDTO = processTriggerFramework.updateSmsTriggerService(userId,triggerId,accountId,trigger,smsTitle,smsBody,senderId);
        if (triggerWSDTO != null){
            triggerWSDTOS.add(triggerWSDTO);
        }

        response.setTriggers(triggerWSDTOS);
        general.setOperation("updateSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public TriggerWSModel createWappCallTrigger(long userId,String processId,String accountId,String trigger,long typeId) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        TriggerWSDTO triggerWSDTO = processTriggerFramework.createWappCallTriggerService(userId,processId,accountId,trigger,typeId);
        if (triggerWSDTO != null){
            triggerWSDTOS.add(triggerWSDTO);
        }

        response.setTriggers(triggerWSDTOS);
        general.setOperation("updateWappTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public TriggerWSModel updateWappCallTrigger(long userId,String triggerId,String accountId,String trigger) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        TriggerWSDTO triggerWSDTO = processTriggerFramework.updateWappCallTriggerService(userId,triggerId,accountId,trigger);
        if (triggerWSDTO != null){
            triggerWSDTOS.add(triggerWSDTO);
        }

        response.setTriggers(triggerWSDTOS);
        general.setOperation("updateWappTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public TriggerWSModel createWappMessageTrigger(long userId,String processId,String accountId,String trigger,String wappTitle,String wappBody,long typeId) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        TriggerWSDTO triggerWSDTO = processTriggerFramework.createWappMessageTriggerService(userId,processId,accountId,trigger,wappTitle,wappBody,typeId);
        if (triggerWSDTO != null){
            triggerWSDTOS.add(triggerWSDTO);
        }

        response.setTriggers(triggerWSDTOS);
        general.setOperation("createWappTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerWSModel updateWappMessageTrigger(long userId,String triggerId,String accountId,String trigger,String wappTitle,String wappBody) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        TriggerWSDTO triggerWSDTO = processTriggerFramework.updateWappMessageTriggerService(userId,triggerId,accountId,trigger,wappTitle,wappBody);
        if (triggerWSDTO != null){
            triggerWSDTOS.add(triggerWSDTO);
        }

        response.setTriggers(triggerWSDTOS);
        general.setOperation("updateWappTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public TriggerWSModel removeTrigger(long userId,String triggerId) {

        TriggerWSModel response = new TriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        TriggerWSDTO triggerWSDTO = processTriggerFramework.removeTriggerService(userId,triggerId);
        if (triggerWSDTO != null){
            triggerWSDTOS.add(triggerWSDTO);
        }

        response.setTriggers(triggerWSDTOS);
        general.setOperation("removeTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
