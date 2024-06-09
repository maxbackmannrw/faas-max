package com.faas.core.base.middleware.process.details.channel.temp;

import com.faas.core.base.framework.process.details.channel.temp.ProcessSmsTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.ProcessSmsTempWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessSmsTempWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProcessSmsTempMiddleware {


    @Autowired
    ProcessSmsTempFramework processSmsTempFramework;


    public ProcessSmsTempWSModel getProcessSmsTemps(long userId, String processId) {

        ProcessSmsTempWSModel response = new ProcessSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = processSmsTempFramework.getProcessSmsTempsService(userId,processId);
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

        ProcessSmsTempWSDTO processSmsTempWSDTO = processSmsTempFramework.getProcessSmsTempService(userId,tempId);
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

        ProcessSmsTempWSDTO processSmsTempWSDTO = processSmsTempFramework.createProcessSmsTempService(userId,processId,smsTitle,smsBody,senderId,typeId);
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

        ProcessSmsTempWSDTO processSmsTempWSDTO = processSmsTempFramework.updateProcessSmsTempService(tempId,smsTitle,smsBody,senderId,typeId);
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

        ProcessSmsTempWSDTO processSmsTempWSDTO = processSmsTempFramework.removeProcessSmsTempService(tempId);
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


}
