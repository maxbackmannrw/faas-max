package com.faas.core.base.middleware.process.details.flow;

import com.faas.core.base.framework.process.details.flow.ProcessFlowFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.flow.ProcessFlowWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessTriggerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProcessFlowMiddleware {


    @Autowired
    ProcessFlowFramework processFlowFramework;


    public ProcessFlowWSModel getProcessFlow(long userId, String processId) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = processFlowFramework.getProcessFlowService(userId,processId);
        if (processTriggerWSDTOS != null){
        }

        general.setOperation("getProcessFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessFlowWSModel getProcessFlowDatas(long userId, String processId) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = processFlowFramework.getProcessFlowService(userId,processId);
        if (processTriggerWSDTOS != null){
        }

        general.setOperation("getProcessFlowDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessFlowWSModel getProcessFlowData(long userId, String processId) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = processFlowFramework.getProcessFlowService(userId,processId);
        if (processTriggerWSDTOS != null){
        }

        general.setOperation("getProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessFlowWSModel createProcessFlowData(long userId, String processId) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = processFlowFramework.getProcessFlowService(userId,processId);
        if (processTriggerWSDTOS != null){

        }

        general.setOperation("createProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessFlowWSModel updateProcessFlowData(long userId, String processId) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = processFlowFramework.getProcessFlowService(userId,processId);
        if (processTriggerWSDTOS != null){
        }

        general.setOperation("updateProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessFlowWSModel removeProcessFlowData(long userId, String processId) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = processFlowFramework.getProcessFlowService(userId,processId);
        if (processTriggerWSDTOS != null){
        }

        general.setOperation("removeProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessFlowWSModel getProcessFlowUrls(long userId, String processId) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = processFlowFramework.getProcessFlowService(userId,processId);
        if (processTriggerWSDTOS != null){
        }

        general.setOperation("getProcessFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessFlowWSModel getProcessFlowUrl(long userId, String processId) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = processFlowFramework.getProcessFlowService(userId,processId);
        if (processTriggerWSDTOS != null){
        }

        general.setOperation("getProcessFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessFlowWSModel createProcessFlowUrl(long userId, String processId) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = processFlowFramework.getProcessFlowService(userId,processId);
        if (processTriggerWSDTOS != null){
        }

        general.setOperation("getProcessFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessFlowWSModel updateProcessFlowUrl(long userId, String processId) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = processFlowFramework.getProcessFlowService(userId,processId);
        if (processTriggerWSDTOS != null){
        }

        general.setOperation("getProcessFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessFlowWSModel removeProcessFlowUrl(long userId, String processId) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = processFlowFramework.getProcessFlowService(userId,processId);
        if (processTriggerWSDTOS != null){
        }

        general.setOperation("getProcessFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
