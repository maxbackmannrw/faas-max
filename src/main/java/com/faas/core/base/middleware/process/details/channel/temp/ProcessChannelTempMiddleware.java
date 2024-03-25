package com.faas.core.base.middleware.process.details.channel.temp;

import com.faas.core.base.framework.process.details.channel.temp.ProcessChannelTempFramework;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.*;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.*;
import com.faas.core.base.repo.process.details.channel.temp.ProcessEmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessPushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessSmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.helpers.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProcessChannelTempMiddleware {

    @Autowired
    ProcessChannelTempFramework processChannelTempFramework;

    @Autowired
    ProcessHelper processHelper;

    @Autowired
    ProcessSmsMessageTempRepository processSmsMessageTempRepository;

    @Autowired
    ProcessWappMessageTempRepository processWappMessageTempRepository;

    @Autowired
    ProcessEmailTempRepository processEmailTempRepository;

    @Autowired
    ProcessPushTempRepository processPushTempRepository;


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


    public ProcessSmsTempWSModel getProcessSmsMessageTemps(long userId, String processId) {

        ProcessSmsTempWSModel response = new ProcessSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = new ArrayList<>();

        List<ProcessSmsTempDBModel> processSmsTempDBModels = processSmsMessageTempRepository.findByProcessId(processId);
        for (ProcessSmsTempDBModel processSmsTempDBModel : processSmsTempDBModels) {
            processSmsTempWSDTOS.add(processChannelTempFramework.fillSmsMessageTempWSDTO(processSmsTempDBModel));
        }

        response.setSmsMessageTemps(processSmsTempWSDTOS);
        general.setOperation("getProcessSmsMessageTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessSmsTempWSModel getSmsMessageTemp(long userId, String tempId) {

        ProcessSmsTempWSModel response = new ProcessSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = new ArrayList<>();

        Optional<ProcessSmsTempDBModel> smsMessageTempDBModel = processSmsMessageTempRepository.findById(tempId);
        if (smsMessageTempDBModel.isPresent()) {
            processSmsTempWSDTOS.add(processChannelTempFramework.fillSmsMessageTempWSDTO(smsMessageTempDBModel.get()));
        }

        response.setSmsMessageTemps(processSmsTempWSDTOS);
        general.setOperation("getSmsMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessSmsTempWSModel createSmsMessageTemp(long userId, String processId, String smsTitle, String smsBody, String senderId, long typeId) {

        ProcessSmsTempWSModel response = new ProcessSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = new ArrayList<>();

        ProcessSmsTempDBModel processSmsTempDBModel = processChannelTempFramework.createSmsMessageTempService(processId,smsTitle,smsBody,senderId,typeId);
        if (processSmsTempDBModel != null) {
            processSmsTempWSDTOS.add(processChannelTempFramework.fillSmsMessageTempWSDTO(processSmsTempDBModel));
        }

        response.setSmsMessageTemps(processSmsTempWSDTOS);
        general.setOperation("createSmsMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessSmsTempWSModel updateSmsMessageTemp(long userId, String tempId, String smsTitle, String smsBody, String senderId, long typeId) {

        ProcessSmsTempWSModel response = new ProcessSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = new ArrayList<>();

        ProcessSmsTempDBModel processSmsTempDBModel = processChannelTempFramework.updateSmsMessageTempService(tempId,smsTitle,smsBody,senderId,typeId);
        if (processSmsTempDBModel != null) {
            processSmsTempWSDTOS.add(processChannelTempFramework.fillSmsMessageTempWSDTO(processSmsTempDBModel));
        }

        response.setSmsMessageTemps(processSmsTempWSDTOS);
        general.setOperation("updateSmsMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessSmsTempWSModel removeSmsMessageTemp(long userId, String tempId) {

        ProcessSmsTempWSModel response = new ProcessSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = new ArrayList<>();

        ProcessSmsTempDBModel processSmsTempDBModel = processChannelTempFramework.removeSmsMessageTempService(tempId);
        if (processSmsTempDBModel != null) {
            processSmsTempWSDTOS.add(processChannelTempFramework.fillSmsMessageTempWSDTO(processSmsTempDBModel));
        }

        response.setSmsMessageTemps(processSmsTempWSDTOS);
        general.setOperation("removeSmsMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessWappMessageTempWSModel getProcessWappMessageTemps(long userId, String processId) {

        ProcessWappMessageTempWSModel response = new ProcessWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        List<ProcessWappMessageTempDBModel> processWappMessageTempDBModels = processWappMessageTempRepository.findByProcessId(processId);
        for (ProcessWappMessageTempDBModel processWappMessageTempDBModel : processWappMessageTempDBModels) {
            wappMessageWSDTOS.add(processChannelTempFramework.fillWappMessageTempWSDTO(processWappMessageTempDBModel));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("getProcessWappMessageTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessWappMessageTempWSModel getWappMessageTemp(long userId, String tempId) {

        ProcessWappMessageTempWSModel response = new ProcessWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        Optional<ProcessWappMessageTempDBModel> wappMessageTempDBModel = processWappMessageTempRepository.findById(tempId);
        if (wappMessageTempDBModel.isPresent()) {
            wappMessageWSDTOS.add(processChannelTempFramework.fillWappMessageTempWSDTO(wappMessageTempDBModel.get()));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("getWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessWappMessageTempWSModel createWappMessageTemp(long userId, String processId, String wappTitle, String wappBody, long typeId) {

        ProcessWappMessageTempWSModel response = new ProcessWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        ProcessWappMessageTempDBModel processWappMessageTempDBModel = processChannelTempFramework.createWappMessageTempService(processId,wappTitle,wappBody,typeId);
        if (processWappMessageTempDBModel != null) {
            wappMessageWSDTOS.add(processChannelTempFramework.fillWappMessageTempWSDTO(processWappMessageTempDBModel));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("createWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessWappMessageTempWSModel updateWappMessageTemp(long userId, String tempId, String wappTitle, String wappBody, long typeId) {

        ProcessWappMessageTempWSModel response = new ProcessWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        ProcessWappMessageTempDBModel processWappMessageTempDBModel = processChannelTempFramework.updateWappMessageTempService(tempId,wappTitle,wappBody,typeId);
        if (processWappMessageTempDBModel != null) {
            wappMessageWSDTOS.add(processChannelTempFramework.fillWappMessageTempWSDTO(processWappMessageTempDBModel));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("updateWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessWappMessageTempWSModel removeWappMessageTemp(long userId, String tempId) {

        ProcessWappMessageTempWSModel response = new ProcessWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        ProcessWappMessageTempDBModel processWappMessageTempDBModel = processChannelTempFramework.removeWappMessageTempService(tempId);
        if (processWappMessageTempDBModel != null) {
            wappMessageWSDTOS.add(processChannelTempFramework.fillWappMessageTempWSDTO(processWappMessageTempDBModel));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("removeWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessEmailTempWSModel getProcessEmailTemps(long userId, String processId) {

        ProcessEmailTempWSModel response = new ProcessEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();

        List<ProcessEmailTempDBModel> processEmailTempDBModels = processEmailTempRepository.findByProcessId(processId);
        for (ProcessEmailTempDBModel processEmailTempDBModel : processEmailTempDBModels) {
            processEmailTempWSDTOS.add(processChannelTempFramework.fillEmailTempWSDTO(processEmailTempDBModel));
        }

        response.setEmailTemps(processEmailTempWSDTOS);
        general.setOperation("getProcessEmailTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessEmailTempWSModel getEmailTemp(long userId, String tempId) {

        ProcessEmailTempWSModel response = new ProcessEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();

        Optional<ProcessEmailTempDBModel> emailTempDBModel = processEmailTempRepository.findById(tempId);
        if (emailTempDBModel.isPresent()) {
            processEmailTempWSDTOS.add(processChannelTempFramework.fillEmailTempWSDTO(emailTempDBModel.get()));
        }

        response.setEmailTemps(processEmailTempWSDTOS);
        general.setOperation("getEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessEmailTempWSModel createEmailTemp(long userId, String processId, String emailSubject, String emailBody, String emailFooter, String emailSender, long typeId) {

        ProcessEmailTempWSModel response = new ProcessEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();

        ProcessEmailTempDBModel processEmailTempDBModel = processChannelTempFramework.createEmailTempService(processId,emailSubject,emailBody,emailFooter,emailSender,typeId);
        if (processEmailTempDBModel != null) {
            processEmailTempWSDTOS.add(processChannelTempFramework.fillEmailTempWSDTO(processEmailTempDBModel));
        }

        response.setEmailTemps(processEmailTempWSDTOS);
        general.setOperation("createEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessEmailTempWSModel updateEmailTemp(long userId, String tempId, String emailSubject, String emailBody, String emailFooter, String emailSender, long typeId) {

        ProcessEmailTempWSModel response = new ProcessEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();

        ProcessEmailTempDBModel processEmailTempDBModel = processChannelTempFramework.updateEmailTempService(tempId,emailSubject,emailBody,emailFooter,emailSender,typeId);
        if (processEmailTempDBModel != null) {
            processEmailTempWSDTOS.add(processChannelTempFramework.fillEmailTempWSDTO(processEmailTempDBModel));
        }

        response.setEmailTemps(processEmailTempWSDTOS);
        general.setOperation("updateEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessEmailTempWSModel removeEmailTemp(long userId, String tempId) {

        ProcessEmailTempWSModel response = new ProcessEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();

        ProcessEmailTempDBModel processEmailTempDBModel = processChannelTempFramework.removeEmailTempService(tempId);
        if (processEmailTempDBModel != null) {
            processEmailTempWSDTOS.add(processChannelTempFramework.fillEmailTempWSDTO(processEmailTempDBModel));
        }

        response.setEmailTemps(processEmailTempWSDTOS);
        general.setOperation("removeEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessPushTempWSModel getProcessPushTemps(long userId, String processId) {

        ProcessPushTempWSModel response = new ProcessPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();

        List<ProcessPushTempDBModel> processPushTempDBModels = processPushTempRepository.findByProcessId(processId);
        for (ProcessPushTempDBModel processPushTempDBModel : processPushTempDBModels) {
            processPushTempWSDTOS.add(processChannelTempFramework.fillPushTempWSDTO(processPushTempDBModel));
        }

        response.setPushTemps(processPushTempWSDTOS);
        general.setOperation("getProcessPushTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessPushTempWSModel getPushTemp(long userId, String tempId) {

        ProcessPushTempWSModel response = new ProcessPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();

        Optional<ProcessPushTempDBModel> pushTempDBModel = processPushTempRepository.findById(tempId);
        if (pushTempDBModel.isPresent()) {
            processPushTempWSDTOS.add(processChannelTempFramework.fillPushTempWSDTO(pushTempDBModel.get()));
        }

        response.setPushTemps(processPushTempWSDTOS);
        general.setOperation("getPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessPushTempWSModel createPushTemp(long userId, String processId, String pushHeader, String pushBody, String pushFooter, String pushSender, long typeId) {

        ProcessPushTempWSModel response = new ProcessPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();

        ProcessPushTempDBModel processPushTempDBModel = processChannelTempFramework.createPushTempService(processId,pushHeader,pushBody,pushFooter,pushSender,typeId);
        if (processPushTempDBModel != null) {
            processPushTempWSDTOS.add(processChannelTempFramework.fillPushTempWSDTO(processPushTempDBModel));
        }

        response.setPushTemps(processPushTempWSDTOS);
        general.setOperation("createPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessPushTempWSModel updatePushTemp(long userId, String tempId, String pushHeader, String pushBody, String pushFooter, String pushSender, long typeId) {

        ProcessPushTempWSModel response = new ProcessPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();

        ProcessPushTempDBModel processPushTempDBModel = processChannelTempFramework.updatePushTempService(tempId,pushHeader,pushBody,pushFooter,pushSender,typeId);
        if (processPushTempDBModel != null) {
            processPushTempWSDTOS.add(processChannelTempFramework.fillPushTempWSDTO(processPushTempDBModel));
        }

        response.setPushTemps(processPushTempWSDTOS);
        general.setOperation("updatePushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessPushTempWSModel removePushTemp(long userId, String tempId) {

        ProcessPushTempWSModel response = new ProcessPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();

        ProcessPushTempDBModel processPushTempDBModel = processChannelTempFramework.removePushTempService(tempId);
        if (processPushTempDBModel != null) {
            processPushTempWSDTOS.add(processChannelTempFramework.fillPushTempWSDTO(processPushTempDBModel));
        }

        response.setPushTemps(processPushTempWSDTOS);
        general.setOperation("removePushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
