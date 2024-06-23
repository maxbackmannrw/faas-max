package com.faas.core.base.middleware.process.details.channel.temp.details;

import com.faas.core.base.framework.process.details.channel.temp.details.ProcessPushTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.ProcessPushTempWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessPushTempWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProcessPushTempMiddleware {


    @Autowired
    ProcessPushTempFramework processPushTempFramework;


    public ProcessPushTempWSModel getProcessPushTemps(long userId, String processId) {

        ProcessPushTempWSModel response = new ProcessPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessPushTempWSDTO> processPushTempWSDTOS = processPushTempFramework.getProcessPushTempsService(userId,processId);
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

        ProcessPushTempWSDTO processPushTempWSDTO = processPushTempFramework.getProcessPushTempService(userId,tempId);
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

    public ProcessPushTempWSModel createProcessPushTemp(long userId, String processId, String pushHeader, String pushBody, String pushSender, long typeId) {

        ProcessPushTempWSModel response = new ProcessPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();

        ProcessPushTempWSDTO processPushTempWSDTO = processPushTempFramework.createProcessPushTempService(processId,pushHeader,pushBody,pushSender,typeId);
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

    public ProcessPushTempWSModel updateProcessPushTemp(long userId, String tempId, String pushHeader, String pushBody, String pushSender, long typeId) {

        ProcessPushTempWSModel response = new ProcessPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();

        ProcessPushTempWSDTO processPushTempWSDTO = processPushTempFramework.updateProcessPushTempService(tempId,pushHeader,pushBody,pushSender,typeId);
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

        ProcessPushTempWSDTO processPushTempWSDTO = processPushTempFramework.removeProcessPushTempService(tempId);
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
