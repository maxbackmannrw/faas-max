package com.faas.core.base.middleware.process.details.channel.temp.details;

import com.faas.core.base.framework.process.details.channel.temp.details.ProcessEmailTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.ProcessEmailTempWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessEmailTempWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProcessEmailTempMiddleware {

    @Autowired
    ProcessEmailTempFramework processEmailTempFramework;


    public ProcessEmailTempWSModel getProcessEmailTemps(long userId, String processId) {

        ProcessEmailTempWSModel response = new ProcessEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = processEmailTempFramework.getProcessEmailTempsService(userId,processId);
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

        ProcessEmailTempWSDTO processEmailTempWSDTO = processEmailTempFramework.getProcessEmailTempService(userId,tempId);
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

    public ProcessEmailTempWSModel createProcessEmailTemp(long userId, String processId, String emailSubject, String emailBody, String emailSender, long typeId) {

        ProcessEmailTempWSModel response = new ProcessEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();

        ProcessEmailTempWSDTO processEmailTempWSDTO = processEmailTempFramework.createProcessEmailTempService(processId,emailSubject,emailBody,emailSender,typeId);
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

    public ProcessEmailTempWSModel updateProcessEmailTemp(long userId, String tempId, String emailSubject, String emailBody, String emailSender, long typeId) {

        ProcessEmailTempWSModel response = new ProcessEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();

        ProcessEmailTempWSDTO processEmailTempWSDTO = processEmailTempFramework.updateProcessEmailTempService(tempId,emailSubject,emailBody,emailSender,typeId);
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

        ProcessEmailTempWSDTO processEmailTempWSDTO = processEmailTempFramework.removeProcessEmailTempService(tempId);
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


}
