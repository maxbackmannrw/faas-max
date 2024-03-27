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
import com.faas.core.base.repo.process.details.channel.temp.ProcessSmsTempRepository;
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
    ProcessSmsTempRepository processSmsTempRepository;

    @Autowired
    ProcessWappMessageTempRepository processWappMessageTempRepository;

    @Autowired
    ProcessEmailTempRepository processEmailTempRepository;

    @Autowired
    ProcessPushTempRepository processPushTempRepository;


    public ProcessTempWSModel getProcessTemp(long userId, String processId) {

        ProcessTempWSModel response = new ProcessTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessTempWSDTO processTempWSDTO = processChannelTempFramework.getProcessTempService(userId,processId);
        if (processTempWSDTO != null){
            response.setProcessTemp(processTempWSDTO);
        }

        general.setOperation("getProcessTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessSmsTempWSModel getProcessSmsTemps(long userId, String processId) {

        ProcessSmsTempWSModel response = new ProcessSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = processChannelTempFramework.getProcessSmsTempsService(userId,processId);
        if (processSmsTempWSDTOS != null){
            response.setProcessSmsTemps(processSmsTempWSDTOS);
        }

        response.setProcessSmsTemps(processSmsTempWSDTOS);
        general.setOperation("getProcessSmsTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSmsTempWSModel getProcessSmsTemp(long userId, String tempId) {

        ProcessSmsTempWSModel response = new ProcessSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = new ArrayList<>();

        ProcessSmsTempWSDTO processSmsTempWSDTO = processChannelTempFramework.getProcessSmsTempService(userId,tempId);
        if (processSmsTempWSDTO != null){
            processSmsTempWSDTOS.add(processSmsTempWSDTO);
        }

        response.setProcessSmsTemps(processSmsTempWSDTOS);
        general.setOperation("getProcessSmsTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSmsTempWSModel createProcessSmsTemp(long userId, String processId, String smsTitle, String smsBody, String senderId, long typeId) {

        ProcessSmsTempWSModel response = new ProcessSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = new ArrayList<>();

        ProcessSmsTempWSDTO processSmsTempWSDTO = processChannelTempFramework.createProcessSmsTempService(processId,smsTitle,smsBody,senderId,typeId);
        if (processSmsTempWSDTO != null) {
            processSmsTempWSDTOS.add(processSmsTempWSDTO);
        }

        response.setProcessSmsTemps(processSmsTempWSDTOS);
        general.setOperation("createProcessSmsTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSmsTempWSModel updateProcessSmsTemp(long userId, String tempId, String smsTitle, String smsBody, String senderId, long typeId) {

        ProcessSmsTempWSModel response = new ProcessSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = new ArrayList<>();

        ProcessSmsTempWSDTO processSmsTempWSDTO = processChannelTempFramework.updateProcessSmsTempService(tempId,smsTitle,smsBody,senderId,typeId);
        if (processSmsTempWSDTO != null) {
            processSmsTempWSDTOS.add(processSmsTempWSDTO);
        }

        response.setProcessSmsTemps(processSmsTempWSDTOS);
        general.setOperation("updateProcessSmsTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSmsTempWSModel removeProcessSmsTemp(long userId, String tempId) {

        ProcessSmsTempWSModel response = new ProcessSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = new ArrayList<>();

        ProcessSmsTempWSDTO processSmsTempWSDTO = processChannelTempFramework.removeProcessSmsTempService(tempId);
        if (processSmsTempWSDTO != null) {
            processSmsTempWSDTOS.add(processSmsTempWSDTO);
        }

        response.setProcessSmsTemps(processSmsTempWSDTOS);
        general.setOperation("removeProcessSmsTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessWappMessageTempWSModel getProcessWappMessageTemps(long userId, String processId) {

        ProcessWappMessageTempWSModel response = new ProcessWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessWappMessageTempWSDTO> processWappMessageTempWSDTOS =processChannelTempFramework.getProcessWappMessageTempsService(userId,processId);
        if (processWappMessageTempWSDTOS != null){
            response.setProcessWappMessageTemps(processWappMessageTempWSDTOS);
        }

        general.setOperation("getProcessWappMessageTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWappMessageTempWSModel getProcessWappMessageTemp(long userId, String tempId) {

        ProcessWappMessageTempWSModel response = new ProcessWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTempWSDTO> processWappMessageTempWSDTOS = new ArrayList<>();

        ProcessWappMessageTempWSDTO processWappMessageTempWSDTO =processChannelTempFramework.getProcessWappMessageTempService(userId,tempId);
        if (processWappMessageTempWSDTO != null){
            processWappMessageTempWSDTOS.add(processWappMessageTempWSDTO);
        }

        response.setProcessWappMessageTemps(processWappMessageTempWSDTOS);
        general.setOperation("getProcessWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWappMessageTempWSModel createProcessWappMessageTemp(long userId, String processId, String wappTitle, String wappBody, long typeId) {

        ProcessWappMessageTempWSModel response = new ProcessWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTempWSDTO> processWappMessageTempWSDTOS = new ArrayList<>();

        ProcessWappMessageTempWSDTO processWappMessageTempWSDTO = processChannelTempFramework.createProcessWappMessageTempService(processId,wappTitle,wappBody,typeId);
        if (processWappMessageTempWSDTO != null) {
            processWappMessageTempWSDTOS.add(processWappMessageTempWSDTO);
        }

        response.setProcessWappMessageTemps(processWappMessageTempWSDTOS);
        general.setOperation("createProcessWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWappMessageTempWSModel updateProcessWappMessageTemp(long userId, String tempId, String wappTitle, String wappBody, long typeId) {

        ProcessWappMessageTempWSModel response = new ProcessWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTempWSDTO> processWappMessageTempWSDTOS = new ArrayList<>();

        ProcessWappMessageTempWSDTO processWappMessageTempWSDTO = processChannelTempFramework.updateProcessWappMessageTempService(tempId,wappTitle,wappBody,typeId);
        if (processWappMessageTempWSDTO != null) {
            processWappMessageTempWSDTOS.add(processWappMessageTempWSDTO);
        }

        response.setProcessWappMessageTemps(processWappMessageTempWSDTOS);
        general.setOperation("updateProcessWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWappMessageTempWSModel removeProcessWappMessageTemp(long userId, String tempId) {

        ProcessWappMessageTempWSModel response = new ProcessWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWappMessageTempWSDTO> processWappMessageTempWSDTOS = new ArrayList<>();

        ProcessWappMessageTempWSDTO processWappMessageTempWSDTO = processChannelTempFramework.removeProcessWappMessageTempService(tempId);
        if (processWappMessageTempWSDTO != null) {
            processWappMessageTempWSDTOS.add(processWappMessageTempWSDTO);
        }

        response.setProcessWappMessageTemps(processWappMessageTempWSDTOS);
        general.setOperation("removeProcessWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessEmailTempWSModel getProcessEmailTemps(long userId, String processId) {

        ProcessEmailTempWSModel response = new ProcessEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = processChannelTempFramework.getProcessEmailTempsService(userId,processId);
        if (processEmailTempWSDTOS != null) {
            response.setProcessEmailTemps(processEmailTempWSDTOS);
        }

        general.setOperation("getProcessEmailTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessEmailTempWSModel getProcessEmailTemp(long userId, String tempId) {

        ProcessEmailTempWSModel response = new ProcessEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();

        ProcessEmailTempWSDTO processEmailTempWSDTO = processChannelTempFramework.getProcessEmailTempService(userId,tempId);
        if (processEmailTempWSDTO != null) {
            processEmailTempWSDTOS.add(processEmailTempWSDTO);
        }

        response.setProcessEmailTemps(processEmailTempWSDTOS);
        general.setOperation("getProcessEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessEmailTempWSModel createProcessEmailTemp(long userId, String processId, String emailSubject, String emailBody, String emailFooter, String emailSender, long typeId) {

        ProcessEmailTempWSModel response = new ProcessEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();

        ProcessEmailTempWSDTO processEmailTempWSDTO = processChannelTempFramework.createProcessEmailTempService(processId,emailSubject,emailBody,emailFooter,emailSender,typeId);
        if (processEmailTempWSDTO != null) {
            processEmailTempWSDTOS.add(processEmailTempWSDTO);
        }

        response.setProcessEmailTemps(processEmailTempWSDTOS);
        general.setOperation("createProcessEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessEmailTempWSModel updateProcessEmailTemp(long userId, String tempId, String emailSubject, String emailBody, String emailFooter, String emailSender, long typeId) {

        ProcessEmailTempWSModel response = new ProcessEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();

        ProcessEmailTempWSDTO processEmailTempWSDTO = processChannelTempFramework.updateProcessEmailTempService(tempId,emailSubject,emailBody,emailFooter,emailSender,typeId);
        if (processEmailTempWSDTO != null) {
            processEmailTempWSDTOS.add(processEmailTempWSDTO);
        }

        response.setProcessEmailTemps(processEmailTempWSDTOS);
        general.setOperation("updateProcessEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessEmailTempWSModel removeProcessEmailTemp(long userId, String tempId) {

        ProcessEmailTempWSModel response = new ProcessEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();

        ProcessEmailTempWSDTO processEmailTempWSDTO = processChannelTempFramework.removeProcessEmailTempService(tempId);
        if (processEmailTempWSDTO != null) {
            processEmailTempWSDTOS.add(processEmailTempWSDTO);
        }

        response.setProcessEmailTemps(processEmailTempWSDTOS);
        general.setOperation("removeProcessEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessPushTempWSModel getProcessPushTemps(long userId, String processId) {

        ProcessPushTempWSModel response = new ProcessPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessPushTempWSDTO> processPushTempWSDTOS = processChannelTempFramework.getProcessPushTempsService(userId,processId);
        if (processPushTempWSDTOS != null) {
            response.setProcessPushTemps(processPushTempWSDTOS);
        }

        general.setOperation("getProcessPushTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessPushTempWSModel getProcessPushTemp(long userId, String tempId) {

        ProcessPushTempWSModel response = new ProcessPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();

        ProcessPushTempWSDTO processPushTempWSDTO = processChannelTempFramework.getProcessPushTempService(userId,tempId);
        if (processPushTempWSDTO != null) {
            processPushTempWSDTOS.add(processPushTempWSDTO);
        }

        response.setProcessPushTemps(processPushTempWSDTOS);
        general.setOperation("getProcessPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessPushTempWSModel createProcessPushTemp(long userId, String processId, String pushHeader, String pushBody, String pushFooter, String pushSender, long typeId) {

        ProcessPushTempWSModel response = new ProcessPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();

        ProcessPushTempWSDTO processPushTempWSDTO = processChannelTempFramework.createProcessPushTempService(processId,pushHeader,pushBody,pushFooter,pushSender,typeId);
        if (processPushTempWSDTO != null) {
            processPushTempWSDTOS.add(processPushTempWSDTO);
        }

        response.setProcessPushTemps(processPushTempWSDTOS);
        general.setOperation("createProcessPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessPushTempWSModel updateProcessPushTemp(long userId, String tempId, String pushHeader, String pushBody, String pushFooter, String pushSender, long typeId) {

        ProcessPushTempWSModel response = new ProcessPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();

        ProcessPushTempWSDTO processPushTempWSDTO = processChannelTempFramework.updateProcessPushTempService(tempId,pushHeader,pushBody,pushFooter,pushSender,typeId);
        if (processPushTempWSDTO != null) {
            processPushTempWSDTOS.add(processPushTempWSDTO);
        }

        response.setProcessPushTemps(processPushTempWSDTOS);
        general.setOperation("updateProcessPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessPushTempWSModel removeProcessPushTemp(long userId, String tempId) {

        ProcessPushTempWSModel response = new ProcessPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();

        ProcessPushTempWSDTO processPushTempWSDTO = processChannelTempFramework.removePushTempService(tempId);
        if (processPushTempWSDTO != null) {
            processPushTempWSDTOS.add(processPushTempWSDTO);
        }

        response.setProcessPushTemps(processPushTempWSDTOS);
        general.setOperation("removeProcessPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
