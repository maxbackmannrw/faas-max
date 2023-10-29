package com.faas.core.base.middleware.operation.details.flow.content;

import com.faas.core.base.framework.operation.details.flow.content.OperationFlowFramework;
import com.faas.core.base.model.ws.operation.flow.OperationFlowCampaignWSModel;
import com.faas.core.base.model.ws.operation.flow.OperationFlowWSModel;
import com.faas.core.base.model.ws.operation.flow.dto.OperationFlowCampaignWSDTO;
import com.faas.core.base.model.ws.operation.flow.dto.OperationFlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class OperationFlowMiddleware {


    @Autowired
    OperationFlowFramework operationFlowFramework;


    public OperationFlowCampaignWSModel getOperationFlowCampaigns(long userId, int reqPage, int reqSize) {

        OperationFlowCampaignWSModel response = new OperationFlowCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<OperationFlowCampaignWSDTO> operationFlowCampaignWSDTOS = operationFlowFramework.getFlowCampaignsService(userId,reqPage,reqSize);
        if (operationFlowCampaignWSDTOS != null){
            response.setFlowCampaigns(operationFlowCampaignWSDTOS);
        }

        general.setOperation("getOperationFlowCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationFlowCampaignWSModel getOperationFlowCampaign(long userId, String campaignId, int reqPage, int reqSize) {

        OperationFlowCampaignWSModel response = new OperationFlowCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationFlowCampaignWSDTO> operationFlowCampaignWSDTOS = new ArrayList<>();

        OperationFlowCampaignWSDTO operationFlowCampaignWSDTO = operationFlowFramework.getFlowCampaignService(userId,campaignId,reqPage,reqSize);
        if (operationFlowCampaignWSDTO != null){
            operationFlowCampaignWSDTOS.add(operationFlowCampaignWSDTO);
        }

        response.setFlowCampaigns(operationFlowCampaignWSDTOS);
        general.setOperation("getOperationFlowCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationFlowWSModel getAllOperationFlows(long userId, int reqPage, int reqSize) {

        OperationFlowWSModel response = new OperationFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<OperationFlowWSDTO> operationFlowWSDTOS = operationFlowFramework.getAllFlowsService(userId,reqPage,reqSize);
        if (operationFlowWSDTOS != null){
            response.setOperationFlows(operationFlowWSDTOS);
        }

        general.setOperation("getAllOperationFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationFlowWSModel getOperationFlowsByState(long userId, String flowState, int reqPage, int reqSize) {

        OperationFlowWSModel response = new OperationFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<OperationFlowWSDTO> operationFlowWSDTOS = operationFlowFramework.getFlowsByStateService(userId,flowState,reqPage,reqSize);
        if (operationFlowWSDTOS != null){
            response.setOperationFlows(operationFlowWSDTOS);
        }

        general.setOperation("getOperationFlowsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationFlowWSModel getOperationFlow(long userId, long flowId, long clientId) {

        OperationFlowWSModel response = new OperationFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationFlowWSDTO> operationFlowWSDTOS = new ArrayList<>();

        OperationFlowWSDTO operationFlowWSDTO = operationFlowFramework.getFlowService(userId,flowId,clientId);
        if (operationFlowWSDTO != null){
            operationFlowWSDTOS.add(operationFlowWSDTO);
        }

        response.setOperationFlows(operationFlowWSDTOS);
        general.setOperation("getOperationFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationFlowWSModel createOperationFlow(long userId, long clientId, long agentId, String campaignId) {

        OperationFlowWSModel response = new OperationFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationFlowWSDTO> operationFlowWSDTOS = new ArrayList<>();

        OperationFlowWSDTO operationFlowWSDTO = operationFlowFramework.createFlowService(userId,clientId,agentId,campaignId);
        if (operationFlowWSDTO != null){
            operationFlowWSDTOS.add(operationFlowWSDTO);
        }

        response.setOperationFlows(operationFlowWSDTOS);
        general.setOperation("createOperationFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationFlowWSModel updateOperationFlow(long userId, long flowId, long clientId) {

        OperationFlowWSModel response = new OperationFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationFlowWSDTO> operationFlowWSDTOS = new ArrayList<>();

        OperationFlowWSDTO operationFlowWSDTO = operationFlowFramework.updateFlowService(userId,flowId,clientId);
        if (operationFlowWSDTO != null){
            operationFlowWSDTOS.add(operationFlowWSDTO);
        }

        response.setOperationFlows(operationFlowWSDTOS);
        general.setOperation("updateOperationFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationFlowWSModel removeOperationFlow(long userId, long flowId, long clientId) {

        OperationFlowWSModel response = new OperationFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationFlowWSDTO> operationFlowWSDTOS = new ArrayList<>();

        OperationFlowWSDTO operationFlowWSDTO = operationFlowFramework.removeFlowService(userId,flowId,clientId);
        if (operationFlowWSDTO != null){
            operationFlowWSDTOS.add(operationFlowWSDTO);
        }

        response.setOperationFlows(operationFlowWSDTOS);
        general.setOperation("removeOperationFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
