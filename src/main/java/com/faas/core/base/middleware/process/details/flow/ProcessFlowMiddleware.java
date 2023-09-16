package com.faas.core.base.middleware.process.details.flow;

import com.faas.core.base.framework.process.details.flow.ProcessFlowFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.flow.FlowDataWSModel;
import com.faas.core.base.model.ws.process.details.flow.FlowUrlWSModel;
import com.faas.core.base.model.ws.process.details.flow.ProcessFlowWSModel;
import com.faas.core.base.model.ws.process.details.flow.dto.FlowDataWSDTO;
import com.faas.core.base.model.ws.process.details.flow.dto.FlowUrlWSDTO;
import com.faas.core.base.model.ws.process.details.flow.dto.ProcessFlowWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessTriggerWSDTO;
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


    public ProcessFlowWSModel createProcessFlow(long userId, String processId,String processFlow,String flowType) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessFlowWSDTO processFlowWSDTO = processFlowFramework.createProcessFlowService(userId,processId,processFlow,flowType);
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


    public ProcessFlowWSModel removeProcessFlow(long userId, String processId) {

        ProcessFlowWSModel response = new ProcessFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessFlowWSDTO processFlowWSDTO = processFlowFramework.removeProcessFlowService(userId,processId);
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



    public FlowDataWSModel getProcessFlowDatas(long userId, String processId) {

        FlowDataWSModel response = new FlowDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<FlowDataWSDTO> flowDataWSDTOS = processFlowFramework.getProcessFlowDatasService(userId,processId);
        if (flowDataWSDTOS != null){
            response.setFlowDatas(flowDataWSDTOS);
        }

        general.setOperation("getProcessFlowDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public FlowDataWSModel getProcessFlowData(long userId,String processId,String dataId) {

        FlowDataWSModel response = new FlowDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowDataWSDTO>flowDataWSDTOS = new ArrayList<>();

        FlowDataWSDTO flowDataWSDTO = processFlowFramework.getProcessFlowDataService(userId,processId,dataId);
        if (flowDataWSDTO != null){
            flowDataWSDTOS.add(flowDataWSDTO);
        }

        response.setFlowDatas(flowDataWSDTOS);
        general.setOperation("getProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public FlowDataWSModel createProcessFlowData(long userId,String processId,long dataTypeId,String value) {

        FlowDataWSModel response = new FlowDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowDataWSDTO>flowDataWSDTOS = new ArrayList<>();

        FlowDataWSDTO flowDataWSDTO = processFlowFramework.createProcessFlowDataService(userId,processId,dataTypeId,value);
        if (flowDataWSDTO != null){
            flowDataWSDTOS.add(flowDataWSDTO);
        }

        response.setFlowDatas(flowDataWSDTOS);
        general.setOperation("createProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public FlowDataWSModel updateProcessFlowData(long userId, String processId,String dataId,long dataTypeId,String value) {

        FlowDataWSModel response = new FlowDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowDataWSDTO>flowDataWSDTOS = new ArrayList<>();

        FlowDataWSDTO flowDataWSDTO = processFlowFramework.updateProcessFlowDataService(userId,processId,dataId,dataTypeId,value);
        if (flowDataWSDTO != null){
            flowDataWSDTOS.add(flowDataWSDTO);
        }

        response.setFlowDatas(flowDataWSDTOS);
        general.setOperation("updateProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public FlowDataWSModel removeProcessFlowData(long userId, String processId,String dataId) {

        FlowDataWSModel response = new FlowDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowDataWSDTO>flowDataWSDTOS = new ArrayList<>();

        FlowDataWSDTO flowDataWSDTO = processFlowFramework.removeProcessFlowDataService(userId,processId,dataId);
        if (flowDataWSDTO != null){
            flowDataWSDTOS.add(flowDataWSDTO);
        }

        response.setFlowDatas(flowDataWSDTOS);
        general.setOperation("removeProcessFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public FlowUrlWSModel getProcessFlowUrls(long userId, String processId) {

        FlowUrlWSModel response = new FlowUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<FlowUrlWSDTO> flowUrlWSDTOS = processFlowFramework.getProcessFlowUrlsService(userId,processId);
        if (flowUrlWSDTOS != null){
            response.setFlowUrls(flowUrlWSDTOS);
        }

        general.setOperation("getProcessFlowUrls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public FlowUrlWSModel getProcessFlowUrl(long userId, String processId,String urlId) {

        FlowUrlWSModel response = new FlowUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowUrlWSDTO>flowUrlWSDTOS = new ArrayList<>();

        FlowUrlWSDTO flowUrlWSDTO = processFlowFramework.getProcessFlowUrlService(userId,processId,urlId);
        if (flowUrlWSDTO != null){
            flowUrlWSDTOS.add(flowUrlWSDTO);
        }

        response.setFlowUrls(flowUrlWSDTOS);
        general.setOperation("getProcessFlowUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public FlowUrlWSModel createProcessFlowUrl(long userId, String processId,String urlType,String url) {

        FlowUrlWSModel response = new FlowUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowUrlWSDTO>flowUrlWSDTOS = new ArrayList<>();

        FlowUrlWSDTO flowUrlWSDTO =  processFlowFramework.createProcessFlowUrlService(userId,processId,urlType,url);
        if (flowUrlWSDTO != null){
            flowUrlWSDTOS.add(flowUrlWSDTO);
        }

        response.setFlowUrls(flowUrlWSDTOS);
        general.setOperation("createProcessFlowUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public FlowUrlWSModel updateProcessFlowUrl(long userId,String processId,String urlId,String urlType,String url) {

        FlowUrlWSModel response = new FlowUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowUrlWSDTO>flowUrlWSDTOS = new ArrayList<>();

        FlowUrlWSDTO flowUrlWSDTO =  processFlowFramework.updateProcessFlowUrlService(userId,processId,urlId,urlType,url);
        if (flowUrlWSDTO != null){
            flowUrlWSDTOS.add(flowUrlWSDTO);
        }

        response.setFlowUrls(flowUrlWSDTOS);
        general.setOperation("updateProcessFlowUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public FlowUrlWSModel removeProcessFlowUrl(long userId, String processId,String urlId) {

        FlowUrlWSModel response = new FlowUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowUrlWSDTO>flowUrlWSDTOS = new ArrayList<>();

        FlowUrlWSDTO flowUrlWSDTO =  processFlowFramework.removeProcessFlowUrlService(userId,processId,urlId);
        if (flowUrlWSDTO != null){
            flowUrlWSDTOS.add(flowUrlWSDTO);
        }

        response.setFlowUrls(flowUrlWSDTOS);
        general.setOperation("removeProcessFlowUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
