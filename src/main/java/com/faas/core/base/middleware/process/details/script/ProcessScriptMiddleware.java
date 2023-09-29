package com.faas.core.base.middleware.process.details.script;

import com.faas.core.base.framework.process.details.script.ProcessScriptFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.script.ProcessScriptWSModel;
import com.faas.core.base.model.ws.process.details.script.dto.ProcessScriptWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessScriptMiddleware {


    @Autowired
    ProcessScriptFramework processScriptFramework;


    public ProcessScriptWSModel getProcessScripts(long userId, String processId) {

        ProcessScriptWSModel response = new ProcessScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessScriptWSDTO> processScriptWSDTOS = processScriptFramework.getProcessScriptsService(processId);
        if (processScriptWSDTOS != null){
            response.setProcessScripts(processScriptWSDTOS);
        }

        general.setOperation("getProcessScripts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScriptWSModel getProcessScript(long userId, String processId, String scriptId) {

        ProcessScriptWSModel response = new ProcessScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScriptWSDTO> processScriptWSDTOS = new ArrayList<>();

        ProcessScriptWSDTO processScriptWSDTO = processScriptFramework.getProcessScriptService(processId,scriptId);
        if (processScriptWSDTO != null){
            processScriptWSDTOS.add(processScriptWSDTO);
        }

        response.setProcessScripts(processScriptWSDTOS);
        general.setOperation("getProcessScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScriptWSModel createProcessScript(long userId,String processId,String scriptTitle,String scriptBody,int scriptOrder) {

        ProcessScriptWSModel response = new ProcessScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScriptWSDTO> processScriptWSDTOS = new ArrayList<>();

        ProcessScriptWSDTO processScriptWSDTO = processScriptFramework.createProcessScriptService(processId,scriptTitle,scriptBody,scriptOrder);
        if (processScriptWSDTO != null){
            processScriptWSDTOS.add(processScriptWSDTO);
        }

        response.setProcessScripts(processScriptWSDTOS);
        general.setOperation("createProcessScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessScriptWSModel updateProcessScript(long userId,String processId, String scriptId, String scriptTitle, String scriptBody, int scriptOrder) {

        ProcessScriptWSModel response = new ProcessScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScriptWSDTO> processScriptWSDTOS = new ArrayList<>();

        ProcessScriptWSDTO processScriptWSDTO = processScriptFramework.updateProcessScriptService(processId,scriptId,scriptTitle,scriptBody,scriptOrder);
        if (processScriptWSDTO != null){
            processScriptWSDTOS.add(processScriptWSDTO);
        }

        response.setProcessScripts(processScriptWSDTOS);
        general.setOperation("updateProcessScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScriptWSModel removeProcessScript(long userId, String processId, String scriptId) {

        ProcessScriptWSModel response = new ProcessScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScriptWSDTO> processScriptWSDTOS = new ArrayList<>();

        ProcessScriptWSDTO processScriptWSDTO = processScriptFramework.removeProcessScriptService(processId,scriptId);
        if (processScriptWSDTO != null){
            processScriptWSDTOS.add(processScriptWSDTO);
        }

        response.setProcessScripts(processScriptWSDTOS);
        general.setOperation("removeProcessScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
