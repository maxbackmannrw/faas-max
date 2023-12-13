package com.faas.core.base.middleware.process.details.channel.temp;

import com.faas.core.base.framework.process.details.channel.temp.ProcessTempFramework;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.*;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.helpers.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProcessTempMiddleware {

    @Autowired
    ProcessTempFramework processTempFramework;

    @Autowired
    ProcessHelper processHelper;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;


    public ProcessTempWSModel getProcessTemps(long userId, String processId) {

        ProcessTempWSModel response = new ProcessTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessTempWSDTO processTempWSDTO = processHelper.createProcessTempWSDTO(processId);
        if (processTempWSDTO != null){
            response.setProcessTemps(processTempWSDTO);
        }

        general.setOperation("getProcessTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SmsMessageTempWSModel getProcessSmsMessageTemps(long userId, String processId) {

        SmsMessageTempWSModel response = new SmsMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsMessageTempWSDTO> smsMessageTempWSDTOS = new ArrayList<>();

        List<ProcessSmsMessageTempDBModel> processSmsMessageTempDBModels = smsMessageTempRepository.findByProcessId(processId);
        for (ProcessSmsMessageTempDBModel processSmsMessageTempDBModel : processSmsMessageTempDBModels) {
            smsMessageTempWSDTOS.add(processTempFramework.fillSmsMessageTempWSDTO(processSmsMessageTempDBModel));
        }

        response.setSmsMessageTemps(smsMessageTempWSDTOS);
        general.setOperation("getProcessSmsMessageTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SmsMessageTempWSModel getSmsMessageTemp(long userId, String tempId) {

        SmsMessageTempWSModel response = new SmsMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsMessageTempWSDTO> smsMessageTempWSDTOS = new ArrayList<>();

        Optional<ProcessSmsMessageTempDBModel> smsMessageTempDBModel = smsMessageTempRepository.findById(tempId);
        if (smsMessageTempDBModel.isPresent()) {
            smsMessageTempWSDTOS.add(processTempFramework.fillSmsMessageTempWSDTO(smsMessageTempDBModel.get()));
        }

        response.setSmsMessageTemps(smsMessageTempWSDTOS);
        general.setOperation("getSmsMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SmsMessageTempWSModel createSmsMessageTemp(long userId,String processId,String smsTitle,String smsBody, String senderId, long typeId) {

        SmsMessageTempWSModel response = new SmsMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsMessageTempWSDTO> smsMessageTempWSDTOS = new ArrayList<>();

        ProcessSmsMessageTempDBModel processSmsMessageTempDBModel = processTempFramework.createSmsMessageTempService(processId,smsTitle,smsBody,senderId,typeId);
        if (processSmsMessageTempDBModel != null) {
            smsMessageTempWSDTOS.add(processTempFramework.fillSmsMessageTempWSDTO(processSmsMessageTempDBModel));
        }

        response.setSmsMessageTemps(smsMessageTempWSDTOS);
        general.setOperation("createSmsMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SmsMessageTempWSModel updateSmsMessageTemp(long userId,String tempId, String smsTitle, String smsBody, String senderId, long typeId) {

        SmsMessageTempWSModel response = new SmsMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsMessageTempWSDTO> smsMessageTempWSDTOS = new ArrayList<>();

        ProcessSmsMessageTempDBModel processSmsMessageTempDBModel = processTempFramework.updateSmsMessageTempService(tempId,smsTitle,smsBody,senderId,typeId);
        if (processSmsMessageTempDBModel != null) {
            smsMessageTempWSDTOS.add(processTempFramework.fillSmsMessageTempWSDTO(processSmsMessageTempDBModel));
        }

        response.setSmsMessageTemps(smsMessageTempWSDTOS);
        general.setOperation("updateSmsMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SmsMessageTempWSModel removeSmsMessageTemp(long userId, String tempId) {

        SmsMessageTempWSModel response = new SmsMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsMessageTempWSDTO> smsMessageTempWSDTOS = new ArrayList<>();

        ProcessSmsMessageTempDBModel processSmsMessageTempDBModel = processTempFramework.removeSmsMessageTempService(tempId);
        if (processSmsMessageTempDBModel != null) {
            smsMessageTempWSDTOS.add(processTempFramework.fillSmsMessageTempWSDTO(processSmsMessageTempDBModel));
        }

        response.setSmsMessageTemps(smsMessageTempWSDTOS);
        general.setOperation("removeSmsMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public WappMessageTempWSModel getProcessWappMessageTemps(long userId, String processId) {

        WappMessageTempWSModel response = new WappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        List<ProcessWappMessageTempDBModel> processWappMessageTempDBModels = wappMessageTempRepository.findByProcessId(processId);
        for (ProcessWappMessageTempDBModel processWappMessageTempDBModel : processWappMessageTempDBModels) {
            wappMessageWSDTOS.add(processTempFramework.fillWappMessageTempWSDTO(processWappMessageTempDBModel));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("getProcessWappMessageTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public WappMessageTempWSModel getWappMessageTemp(long userId, String tempId) {

        WappMessageTempWSModel response = new WappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        Optional<ProcessWappMessageTempDBModel> wappMessageTempDBModel = wappMessageTempRepository.findById(tempId);
        if (wappMessageTempDBModel.isPresent()) {
            wappMessageWSDTOS.add(processTempFramework.fillWappMessageTempWSDTO(wappMessageTempDBModel.get()));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("getWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public WappMessageTempWSModel createWappMessageTemp(long userId,String processId,String wappTitle,String wappBody,long typeId) {

        WappMessageTempWSModel response = new WappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        ProcessWappMessageTempDBModel processWappMessageTempDBModel = processTempFramework.createWappMessageTempService(processId,wappTitle,wappBody,typeId);
        if (processWappMessageTempDBModel != null) {
            wappMessageWSDTOS.add(processTempFramework.fillWappMessageTempWSDTO(processWappMessageTempDBModel));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("createWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public WappMessageTempWSModel updateWappMessageTemp(long userId,String tempId, String wappTitle,String wappBody, long typeId) {

        WappMessageTempWSModel response = new WappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        ProcessWappMessageTempDBModel processWappMessageTempDBModel = processTempFramework.updateWappMessageTempService(tempId,wappTitle,wappBody,typeId);
        if (processWappMessageTempDBModel != null) {
            wappMessageWSDTOS.add(processTempFramework.fillWappMessageTempWSDTO(processWappMessageTempDBModel));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("updateWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public WappMessageTempWSModel removeWappMessageTemp(long userId, String tempId) {

        WappMessageTempWSModel response = new WappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        ProcessWappMessageTempDBModel processWappMessageTempDBModel = processTempFramework.removeWappMessageTempService(tempId);
        if (processWappMessageTempDBModel != null) {
            wappMessageWSDTOS.add(processTempFramework.fillWappMessageTempWSDTO(processWappMessageTempDBModel));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("removeWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public EmailTempWSModel getProcessEmailTemps(long userId, String processId) {

        EmailTempWSModel response = new EmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTempWSDTO> emailTempWSDTOS = new ArrayList<>();

        List<ProcessEmailTempDBModel> processEmailTempDBModels = emailTempRepository.findByProcessId(processId);
        for (ProcessEmailTempDBModel processEmailTempDBModel : processEmailTempDBModels) {
            emailTempWSDTOS.add(processTempFramework.fillEmailTempWSDTO(processEmailTempDBModel));
        }

        response.setEmailTemps(emailTempWSDTOS);
        general.setOperation("getProcessEmailTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public EmailTempWSModel getEmailTemp(long userId, String tempId) {

        EmailTempWSModel response = new EmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTempWSDTO> emailTempWSDTOS = new ArrayList<>();

        Optional<ProcessEmailTempDBModel> emailTempDBModel = emailTempRepository.findById(tempId);
        if (emailTempDBModel.isPresent()) {
            emailTempWSDTOS.add(processTempFramework.fillEmailTempWSDTO(emailTempDBModel.get()));
        }

        response.setEmailTemps(emailTempWSDTOS);
        general.setOperation("getEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public EmailTempWSModel createEmailTemp(long userId,String processId,String emailSubject, String emailBody, String emailFooter,String emailSender, long typeId) {

        EmailTempWSModel response = new EmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTempWSDTO> emailTempWSDTOS = new ArrayList<>();

        ProcessEmailTempDBModel processEmailTempDBModel = processTempFramework.createEmailTempService(processId,emailSubject,emailBody,emailFooter,emailSender,typeId);
        if (processEmailTempDBModel != null) {
            emailTempWSDTOS.add(processTempFramework.fillEmailTempWSDTO(processEmailTempDBModel));
        }

        response.setEmailTemps(emailTempWSDTOS);
        general.setOperation("createEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public EmailTempWSModel updateEmailTemp(long userId,String tempId,String emailSubject, String emailBody, String emailFooter,String emailSender, long typeId) {

        EmailTempWSModel response = new EmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTempWSDTO> emailTempWSDTOS = new ArrayList<>();

        ProcessEmailTempDBModel processEmailTempDBModel = processTempFramework.updateEmailTempService(tempId,emailSubject,emailBody,emailFooter,emailSender,typeId);
        if (processEmailTempDBModel != null) {
            emailTempWSDTOS.add(processTempFramework.fillEmailTempWSDTO(processEmailTempDBModel));
        }

        response.setEmailTemps(emailTempWSDTOS);
        general.setOperation("updateEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public EmailTempWSModel removeEmailTemp(long userId, String tempId) {

        EmailTempWSModel response = new EmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTempWSDTO> emailTempWSDTOS = new ArrayList<>();

        ProcessEmailTempDBModel processEmailTempDBModel = processTempFramework.removeEmailTempService(tempId);
        if (processEmailTempDBModel != null) {
            emailTempWSDTOS.add(processTempFramework.fillEmailTempWSDTO(processEmailTempDBModel));
        }

        response.setEmailTemps(emailTempWSDTOS);
        general.setOperation("removeEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public PushTempWSModel getProcessPushTemps(long userId, String processId) {

        PushTempWSModel response = new PushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTempWSDTO> pushTempWSDTOS = new ArrayList<>();

        List<ProcessPushTempDBModel> processPushTempDBModels = pushTempRepository.findByProcessId(processId);
        for (ProcessPushTempDBModel processPushTempDBModel : processPushTempDBModels) {
            pushTempWSDTOS.add(processTempFramework.fillPushTempWSDTO(processPushTempDBModel));
        }

        response.setPushTemps(pushTempWSDTOS);
        general.setOperation("getProcessPushTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public PushTempWSModel getPushTemp(long userId, String tempId) {

        PushTempWSModel response = new PushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTempWSDTO> pushTempWSDTOS = new ArrayList<>();

        Optional<ProcessPushTempDBModel> pushTempDBModel = pushTempRepository.findById(tempId);
        if (pushTempDBModel.isPresent()) {
            pushTempWSDTOS.add(processTempFramework.fillPushTempWSDTO(pushTempDBModel.get()));
        }

        response.setPushTemps(pushTempWSDTOS);
        general.setOperation("getPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public PushTempWSModel createPushTemp(long userId,String processId,String pushHeader, String pushBody, String pushFooter, String pushSender, long typeId) {

        PushTempWSModel response = new PushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTempWSDTO> pushTempWSDTOS = new ArrayList<>();

        ProcessPushTempDBModel processPushTempDBModel = processTempFramework.createPushTempService(processId,pushHeader,pushBody,pushFooter,pushSender,typeId);
        if (processPushTempDBModel != null) {
            pushTempWSDTOS.add(processTempFramework.fillPushTempWSDTO(processPushTempDBModel));
        }

        response.setPushTemps(pushTempWSDTOS);
        general.setOperation("createPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public PushTempWSModel updatePushTemp(long userId,String tempId,String pushHeader, String pushBody, String pushFooter, String pushSender, long typeId) {

        PushTempWSModel response = new PushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTempWSDTO> pushTempWSDTOS = new ArrayList<>();

        ProcessPushTempDBModel processPushTempDBModel = processTempFramework.updatePushTempService(tempId,pushHeader,pushBody,pushFooter,pushSender,typeId);
        if (processPushTempDBModel != null) {
            pushTempWSDTOS.add(processTempFramework.fillPushTempWSDTO(processPushTempDBModel));
        }

        response.setPushTemps(pushTempWSDTOS);
        general.setOperation("updatePushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public PushTempWSModel removePushTemp(long userId, String tempId) {

        PushTempWSModel response = new PushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTempWSDTO> pushTempWSDTOS = new ArrayList<>();

        ProcessPushTempDBModel processPushTempDBModel = processTempFramework.removePushTempService(tempId);
        if (processPushTempDBModel != null) {
            pushTempWSDTOS.add(processTempFramework.fillPushTempWSDTO(processPushTempDBModel));
        }

        response.setPushTemps(pushTempWSDTOS);
        general.setOperation("removePushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
