package com.faas.core.base.middleware.process.details.channel.content;

import com.faas.core.base.framework.process.details.channel.content.ProcessChannelFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.content.*;
import com.faas.core.base.model.ws.process.details.channel.content.dto.*;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProcessChannelMiddleware {


    @Autowired
    ProcessChannelFramework processChannelFramework;


    public ProcessChannelWSModel getProcessChannels(long userId, String processId) {

        ProcessChannelWSModel response = new ProcessChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessChannelWSDTO processChannelWSDTO = processChannelFramework.getProcessChannelsService(processId);
        if (processChannelWSDTO != null){
            response.setProcessChannels(processChannelWSDTO);
        }

        general.setOperation("getProcessChannels");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSipChannelWSModel getProcessSipChannel(long userId, String processId) {

        ProcessSipChannelWSModel response = new ProcessSipChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessSipChannelWSDTO processSipChannelWSDTO = processChannelFramework.getProcessSipChannelService(processId);
        if (processSipChannelWSDTO != null){
            response.setProcessSipChannel(processSipChannelWSDTO);
        }

        general.setOperation("getProcessSipChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSipChannelWSModel createProcessSipChannel(long userId,String processId, String callerId,String channelState) {

        ProcessSipChannelWSModel response = new ProcessSipChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessSipChannelWSDTO processSipChannelWSDTO = processChannelFramework.createProcessSipChannelService(processId,callerId,channelState);
        if (processSipChannelWSDTO != null){
            response.setProcessSipChannel(processSipChannelWSDTO);
        }

        general.setOperation("createProcessSipChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSipChannelWSModel removeProcessSipChannel(long userId, String processId) {

        ProcessSipChannelWSModel response = new ProcessSipChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessSipChannelWSDTO processSipChannelWSDTO = processChannelFramework.removeProcessSipChannelService(processId);
        if (processSipChannelWSDTO != null){
            response.setProcessSipChannel(processSipChannelWSDTO);
        }

        general.setOperation("removeProcessSipChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessSmsChannelWSModel getProcessSmsChannel(long userId, String processId) {

        ProcessSmsChannelWSModel response = new ProcessSmsChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessSmsChannelWSDTO processSmsChannelWSDTO = processChannelFramework.getProcessSmsChannelService(processId);
        if (processSmsChannelWSDTO != null){
            response.setProcessSmsChannel(processSmsChannelWSDTO);
        }

        general.setOperation("getProcessSmsAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSmsChannelWSModel createProcessSmsChannel(long userId,String processId, String accountId,String channelState) {

        ProcessSmsChannelWSModel response = new ProcessSmsChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessSmsChannelWSDTO processSmsChannelWSDTO = processChannelFramework.createProcessSmsChannelService(processId,accountId,channelState);
        if (processSmsChannelWSDTO != null){
            response.setProcessSmsChannel(processSmsChannelWSDTO);
        }

        general.setOperation("createProcessSmsChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessSmsChannelWSModel removeProcessSmsChannel(long userId, String processId) {

        ProcessSmsChannelWSModel response = new ProcessSmsChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessSmsChannelWSDTO processSmsChannelWSDTO = processChannelFramework.removeProcessSmsChannelService(processId);
        if (processSmsChannelWSDTO != null){
            response.setProcessSmsChannel(processSmsChannelWSDTO);
        }

        general.setOperation("removeProcessSmsChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessWappChannelWSModel getProcessWappChannel(long userId, String processId) {

        ProcessWappChannelWSModel response = new ProcessWappChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessWappChannelWSDTO processWappChannelWSDTO = processChannelFramework.getProcessWappChannelService(processId);
        if (processWappChannelWSDTO != null){
            response.setProcessWappChannel(processWappChannelWSDTO);
        }

        general.setOperation("getProcessWappChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWappChannelWSModel createProcessWappChannel(long userId,String processId,String callState,String messageState) {

        ProcessWappChannelWSModel response = new ProcessWappChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessWappChannelWSDTO processWappChannelWSDTO = processChannelFramework.createProcessWappChannelService(userId,processId,callState,messageState);
        if (processWappChannelWSDTO != null){
            response.setProcessWappChannel(processWappChannelWSDTO);
        }

        general.setOperation("createProcessWappChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWappChannelWSModel removeProcessWappChannel(long userId, String processId) {

        ProcessWappChannelWSModel response = new ProcessWappChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessWappChannelWSDTO processWappChannelWSDTO = processChannelFramework.removeProcessWappChannelService(processId);
        if (processWappChannelWSDTO != null){
            response.setProcessWappChannel(processWappChannelWSDTO);
        }

        general.setOperation("removeProcessWappChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessEmailChannelWSModel getProcessEmailChannel(long userId, String processId) {

        ProcessEmailChannelWSModel response = new ProcessEmailChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessEmailChannelWSDTO processEmailChannelWSDTO = processChannelFramework.getProcessEmailChannelService(processId);
        if (processEmailChannelWSDTO != null){
            response.setProcessEmailChannel(processEmailChannelWSDTO);
        }

        general.setOperation("getProcessEmailChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessEmailChannelWSModel createProcessEmailChannel(long userId,String processId, String accountId,String channelState) {

        ProcessEmailChannelWSModel response = new ProcessEmailChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessEmailChannelWSDTO processEmailChannelWSDTO = processChannelFramework.createProcessEmailChannelService(processId,accountId,channelState);
        if (processEmailChannelWSDTO != null){
            response.setProcessEmailChannel(processEmailChannelWSDTO);
        }

        general.setOperation("createProcessEmailChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessEmailChannelWSModel removeProcessEmailChannel(long userId, String processId) {

        ProcessEmailChannelWSModel response = new ProcessEmailChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessEmailChannelWSDTO processEmailChannelWSDTO = processChannelFramework.removeProcessEmailChannelService(processId);
        if (processEmailChannelWSDTO != null){
            response.setProcessEmailChannel(processEmailChannelWSDTO);
        }

        general.setOperation("removeProcessEmailChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessPushChannelWSModel getProcessPushChannel(long userId, String processId) {

        ProcessPushChannelWSModel response = new ProcessPushChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessPushChannelWSDTO processPushChannelWSDTO = processChannelFramework.getProcessPushChannelService(processId);
        if (processPushChannelWSDTO != null){
            response.setProcessPushChannel(processPushChannelWSDTO);
        }

        general.setOperation("getProcessPushChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessPushChannelWSModel createProcessPushChannel(long userId,String processId, String accountId,String channelState) {

        ProcessPushChannelWSModel response = new ProcessPushChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessPushChannelWSDTO processPushChannelWSDTO = processChannelFramework.createProcessPushChannelService(processId,accountId,channelState);
        if (processPushChannelWSDTO != null){
            response.setProcessPushChannel(processPushChannelWSDTO);
        }

        general.setOperation("createProcessPushChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessPushChannelWSModel removeProcessPushChannel(long userId, String processId) {

        ProcessPushChannelWSModel response = new ProcessPushChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessPushChannelWSDTO processPushChannelWSDTO = processChannelFramework.removeProcessPushChannelService(processId);
        if (processPushChannelWSDTO != null){
            response.setProcessPushChannel(processPushChannelWSDTO);
        }

        general.setOperation("removeProcessPushChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
