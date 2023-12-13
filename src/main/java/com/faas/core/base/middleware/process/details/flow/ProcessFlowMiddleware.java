package com.faas.core.base.middleware.process.details.flow;

import com.faas.core.base.framework.process.details.flow.ProcessFlowFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.flow.ProcessFlowDataWSModel;
import com.faas.core.base.model.ws.process.details.flow.ProcessFlowWSModel;
import com.faas.core.base.model.ws.process.details.flow.dto.ProcessFlowDataWSDTO;
import com.faas.core.base.model.ws.process.details.flow.dto.ProcessFlowWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessFlowMiddleware {


    @Autowired
    ProcessFlowFramework processFlowFramework;


    public ProcessFlowWSModel getProcessFlow(long userId, String processId) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessFlowWSDTO processFlowWSDTO = processFlowFramework.getProcessFlowService(userId,processId);
        if (processFlowWSDTO != null){
            response.setProcessFlow(processFlowWSDTO);
        }

        general.setOperation("getProcessFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessFlowWSModel updateProcessFlow(long userId,String processId,String processFlow,String flowDesc) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessFlowWSDTO processFlowWSDTO = processFlowFramework.updateProcessFlowService(userId,processId,processFlow,flowDesc);
        if (processFlowWSDTO != null){
            response.setProcessFlow(processFlowWSDTO);
        }

        general.setOperation("updateProcessFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessFlowWSModel removeProcessFlow(long userId, String processId) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessFlowWSDTO processFlowWSDTO = processFlowFramework.removeProcessFlowService(userId,processId);
        if (processFlowWSDTO != null){
            response.setProcessFlow(processFlowWSDTO);
        }

        general.setOperation("removeProcessFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessFlowDataWSModel getProcessFlowDatas(long userId, String processId) {

        ProcessFlowDataWSModel response = new ProcessFlowDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessFlowDataWSDTO> processFlowDataWSDTOS = processFlowFramework.getProcessFlowDatasService(userId,processId);
        if (processFlowDataWSDTOS != null){
            response.setFlowDatas(processFlowDataWSDTOS);
        }

        general.setOperation("getProcessFlowDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessFlowDataWSModel getProcessFlowData(long userId, String processId, String dataId) {

        ProcessFlowDataWSModel response = new ProcessFlowDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessFlowDataWSDTO> processFlowDataWSDTOS = new ArrayList<>();

        ProcessFlowDataWSDTO processFlowDataWSDTO = processFlowFramework.getProcessFlowDataService(userId,processId,dataId);
        if (processFlowDataWSDTO != null){
            processFlowDataWSDTOS.add(processFlowDataWSDTO);
        }

        response.setFlowDatas(processFlowDataWSDTOS);
        general.setOperation("getProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessFlowDataWSModel createProcessFlowData(long userId, String processId, long typeId, String value) {

        ProcessFlowDataWSModel response = new ProcessFlowDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessFlowDataWSDTO> processFlowDataWSDTOS = new ArrayList<>();

        ProcessFlowDataWSDTO processFlowDataWSDTO = processFlowFramework.createProcessFlowDataService(userId,processId,typeId,value);
        if (processFlowDataWSDTO != null){
            processFlowDataWSDTOS.add(processFlowDataWSDTO);
        }

        response.setFlowDatas(processFlowDataWSDTOS);
        general.setOperation("createProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessFlowDataWSModel updateProcessFlowData(long userId, String processId, String dataId, long typeId, String value) {

        ProcessFlowDataWSModel response = new ProcessFlowDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessFlowDataWSDTO> processFlowDataWSDTOS = new ArrayList<>();

        ProcessFlowDataWSDTO processFlowDataWSDTO = processFlowFramework.updateProcessFlowDataService(userId,processId,dataId,typeId,value);
        if (processFlowDataWSDTO != null){
            processFlowDataWSDTOS.add(processFlowDataWSDTO);
        }

        response.setFlowDatas(processFlowDataWSDTOS);
        general.setOperation("updateProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessFlowDataWSModel removeProcessFlowData(long userId, String processId, String dataId) {

        ProcessFlowDataWSModel response = new ProcessFlowDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessFlowDataWSDTO> processFlowDataWSDTOS = new ArrayList<>();

        ProcessFlowDataWSDTO processFlowDataWSDTO = processFlowFramework.removeProcessFlowDataService(userId,processId,dataId);
        if (processFlowDataWSDTO != null){
            processFlowDataWSDTOS.add(processFlowDataWSDTO);
        }

        response.setFlowDatas(processFlowDataWSDTOS);
        general.setOperation("removeProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
