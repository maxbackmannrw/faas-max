package com.faas.core.base.middleware.process.details.flow;

import com.faas.core.base.framework.process.details.flow.ProcessFlowFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDataWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessRemoteWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessRemoteWSDTO;
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



    public ProcessRemoteWSModel getProcessFlowRemotes(long userId, String processId) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessRemoteWSDTO> processRemoteWSDTOS = processFlowFramework.getProcessFlowRemotesService(userId,processId);
        if (processRemoteWSDTOS != null){
            response.setProcessRemotes(processRemoteWSDTOS);
        }

        general.setOperation("getProcessFlowRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessRemoteWSModel getProcessFlowRemote(long userId, String processId, String flowRemoteId) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();

        ProcessRemoteWSDTO processRemoteWSDTO = processFlowFramework.getProcessFlowRemoteService(userId,processId,flowRemoteId);
        if (processRemoteWSDTO != null){
            processRemoteWSDTOS.add(processRemoteWSDTO);
        }

        response.setProcessRemotes(processRemoteWSDTOS);
        general.setOperation("getProcessFlowRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessRemoteWSModel createProcessFlowRemote(long userId,String processId,String remoteId) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();

        ProcessRemoteWSDTO processRemoteWSDTO = processFlowFramework.createProcessFlowRemoteService(userId,processId,remoteId);
        if (processRemoteWSDTO != null){
            processRemoteWSDTOS.add(processRemoteWSDTO);
        }

        response.setProcessRemotes(processRemoteWSDTOS);
        general.setOperation("createProcessFlowRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessRemoteWSModel updateProcessFlowRemote(long userId,String processId,String flowRemoteId,String remoteState) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();

        ProcessRemoteWSDTO processRemoteWSDTO = processFlowFramework.updateProcessFlowRemoteService(userId,processId,flowRemoteId,remoteState);
        if (processRemoteWSDTO != null){
            processRemoteWSDTOS.add(processRemoteWSDTO);
        }

        response.setProcessRemotes(processRemoteWSDTOS);
        general.setOperation("updateProcessFlowRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessRemoteWSModel removeProcessFlowRemote(long userId,String processId,String flowRemoteId) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();

        ProcessRemoteWSDTO processRemoteWSDTO = processFlowFramework.removeProcessFlowRemoteService(userId,processId,flowRemoteId);
        if (processRemoteWSDTO != null){
            processRemoteWSDTOS.add(processRemoteWSDTO);
        }

        response.setProcessRemotes(processRemoteWSDTOS);
        general.setOperation("removeProcessFlowRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
