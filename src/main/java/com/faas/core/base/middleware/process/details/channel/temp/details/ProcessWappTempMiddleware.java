package com.faas.core.base.middleware.process.details.channel.temp.details;

import com.faas.core.base.framework.process.details.channel.temp.details.ProcessWappTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.details.ProcessWappMessageTempWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.details.dto.ProcessWappMessageTempWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProcessWappTempMiddleware {


    @Autowired
    ProcessWappTempFramework processWappTempFramework;


    public ProcessWappMessageTempWSModel getProcessWappMessageTemps(long userId, String processId) {

        ProcessWappMessageTempWSModel response = new ProcessWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessWappMessageTempWSDTO> processWappMessageTempWSDTOS = processWappTempFramework.getProcessWappMessageTempsService(userId,processId);
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

        ProcessWappMessageTempWSDTO processWappMessageTempWSDTO = processWappTempFramework.getProcessWappMessageTempService(userId,tempId);
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

        ProcessWappMessageTempWSDTO processWappMessageTempWSDTO = processWappTempFramework.createProcessWappMessageTempService(processId,wappTitle,wappBody,typeId);
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

        ProcessWappMessageTempWSDTO processWappMessageTempWSDTO = processWappTempFramework.updateProcessWappMessageTempService(tempId,wappTitle,wappBody,typeId);
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

        ProcessWappMessageTempWSDTO processWappMessageTempWSDTO = processWappTempFramework.removeProcessWappMessageTempService(tempId);
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


}
