package com.faas.core.base.middleware.process.details.flow;

import com.faas.core.base.framework.process.details.flow.ProcessFlowFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDataWSModel;
import com.faas.core.base.model.ws.process.details.remote.ProcessRemoteWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.remote.dto.ProcessRemoteWSDTO;
import com.faas.core.base.model.ws.process.details.flow.ProcessFlowWSModel;
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

    public ProcessFlowWSModel updateProcessFlow(long userId,String processId,String processFlow) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessFlowWSDTO processFlowWSDTO = processFlowFramework.updateProcessFlowService(userId,processId,processFlow);
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


    public ProcessDataWSModel getProcessFlowDatas(long userId, String processId) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessDataWSDTO> processDataWSDTOS = processFlowFramework.getProcessFlowDatasService(userId,processId);
        if (processDataWSDTOS != null){
            response.setProcessDatas(processDataWSDTOS);
        }

        general.setOperation("getProcessFlowDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessDataWSModel getProcessFlowData(long userId, String processId, String dataId) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataWSDTO processDataWSDTO = processFlowFramework.getProcessFlowDataService(userId,processId,dataId);
        if (processDataWSDTO != null){
            processDataWSDTOS.add(processDataWSDTO);
        }

        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("getProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessDataWSModel createProcessFlowData(long userId, String processId, long typeId, String value) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataWSDTO processDataWSDTO = processFlowFramework.createProcessFlowDataService(userId,processId,typeId,value);
        if (processDataWSDTO != null){
            processDataWSDTOS.add(processDataWSDTO);
        }

        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("createProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessDataWSModel updateProcessFlowData(long userId, String processId, String dataId, long typeId, String value) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataWSDTO processDataWSDTO = processFlowFramework.updateProcessFlowDataService(userId,processId,dataId,typeId,value);
        if (processDataWSDTO != null){
            processDataWSDTOS.add(processDataWSDTO);
        }

        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("updateProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessDataWSModel removeProcessFlowData(long userId, String processId, String dataId) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataWSDTO processDataWSDTO = processFlowFramework.removeProcessFlowDataService(userId,processId,dataId);
        if (processDataWSDTO != null){
            processDataWSDTOS.add(processDataWSDTO);
        }

        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("removeProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
