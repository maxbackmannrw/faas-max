package com.faas.core.base.middleware.process.details.trigger.temp.email;

import com.faas.core.base.framework.process.details.trigger.temp.email.EmailTriggerTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.email.EmailTriggerTempWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.email.dto.EmailTriggerTempWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class EmailTriggerTempMiddleware {


    @Autowired
    EmailTriggerTempFramework emailTriggerTempFramework;


    public EmailTriggerTempWSModel getEmailTriggerTemps(long userId, String processId) {

        EmailTriggerTempWSModel response = new EmailTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<EmailTriggerTempWSDTO> emailTriggerTempWSDTOS = emailTriggerTempFramework.getEmailTriggerTempsService(userId,processId);
        if (emailTriggerTempWSDTOS != null){
            response.setEmailTriggerTemps(emailTriggerTempWSDTOS);
        }

        general.setOperation("getEmailTriggerTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public EmailTriggerTempWSModel getEmailTriggerTemp(long userId, String tempId) {

        EmailTriggerTempWSModel response = new EmailTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTriggerTempWSDTO> emailTriggerTempWSDTOS = new ArrayList<>();

        EmailTriggerTempWSDTO emailTriggerTempWSDTO = emailTriggerTempFramework.getEmailTriggerTempService(userId,tempId);
        if (emailTriggerTempWSDTO != null){
            emailTriggerTempWSDTOS.add(emailTriggerTempWSDTO);
        }

        response.setEmailTriggerTemps(emailTriggerTempWSDTOS);
        general.setOperation("getEmailTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public EmailTriggerTempWSModel createEmailTriggerTemp(long userId, String processId, String trigger, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender, long typeId) {

        EmailTriggerTempWSModel response = new EmailTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTriggerTempWSDTO> emailTriggerTempWSDTOS = new ArrayList<>();

        EmailTriggerTempWSDTO emailTriggerTempWSDTO = emailTriggerTempFramework.createEmailTriggerTempService(userId,processId,trigger,accountId,emailSubject,emailTitle,emailBody,emailSender,typeId);
        if (emailTriggerTempWSDTO != null){
            emailTriggerTempWSDTOS.add(emailTriggerTempWSDTO);
        }

        response.setEmailTriggerTemps(emailTriggerTempWSDTOS);
        general.setOperation("createEmailTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public EmailTriggerTempWSModel updateEmailTriggerTemp(long userId, String tempId, String trigger, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender) {

        EmailTriggerTempWSModel response = new EmailTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTriggerTempWSDTO> emailTriggerTempWSDTOS = new ArrayList<>();

        EmailTriggerTempWSDTO emailTriggerTempWSDTO = emailTriggerTempFramework.updateEmailTriggerTempService(userId,tempId,trigger,accountId,emailSubject,emailTitle,emailBody,emailSender);
        if (emailTriggerTempWSDTO != null){
            emailTriggerTempWSDTOS.add(emailTriggerTempWSDTO);
        }

        response.setEmailTriggerTemps(emailTriggerTempWSDTOS);
        general.setOperation("updateEmailTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public EmailTriggerTempWSModel removeEmailTriggerTemp(long userId, String tempId) {

        EmailTriggerTempWSModel response = new EmailTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTriggerTempWSDTO> emailTriggerTempWSDTOS = new ArrayList<>();

        EmailTriggerTempWSDTO emailTriggerTempWSDTO = emailTriggerTempFramework.removeEmailTriggerTempService(userId,tempId);
        if (emailTriggerTempWSDTO != null){
            emailTriggerTempWSDTOS.add(emailTriggerTempWSDTO);
        }

        response.setEmailTriggerTemps(emailTriggerTempWSDTOS);
        general.setOperation("removeEmailTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
