package com.faas.core.base.middleware.campaign.details.client.flow;

import com.faas.core.base.framework.campaign.details.client.flow.CampaignFlowSessionFramework;
import com.faas.core.base.model.ws.campaign.details.client.flow.CampaignFlowSessionWSModel;
import com.faas.core.base.model.ws.campaign.details.client.flow.dto.CampaignFlowSessionWSDTO;
import com.faas.core.base.model.ws.campaign.details.client.flow.CampaignFlowSessionRequest;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.automatic.content.OperationFlowSessionWSModel;
import com.faas.core.base.model.ws.operation.automatic.content.dto.OperationFlowSessionWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignFlowSessionMiddleware {


    @Autowired
    CampaignFlowSessionFramework campaignFlowSessionFramework;


    public CampaignFlowSessionWSModel searchCampaignFlowSessions(long userId, String campaignId, String city, String country, int reqPage, int reqSize) {

        CampaignFlowSessionWSModel response = new CampaignFlowSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignFlowSessionWSDTO campaignFlowSessionWSDTO = campaignFlowSessionFramework.searchCampaignFlowSessionsService(userId,campaignId,city,country,reqPage,reqSize);
        if (campaignFlowSessionWSDTO != null){
            response.setCampaignFlow(campaignFlowSessionWSDTO);
        }

        general.setOperation("searchCampaignFlowSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignFlowSessionWSModel getCampaignFlowSessions(long userId, String campaignId, int reqPage, int reqSize) {

        CampaignFlowSessionWSModel response = new CampaignFlowSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignFlowSessionWSDTO campaignFlowSessionWSDTO = campaignFlowSessionFramework.getCampaignFlowSessionsService(userId,campaignId,reqPage,reqSize);
        if (campaignFlowSessionWSDTO != null){
            response.setCampaignFlow(campaignFlowSessionWSDTO);
        }

        general.setOperation("getCampaignFlowSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationFlowSessionWSModel getCampaignFlowSession(long userId, long sessionId) {

        OperationFlowSessionWSModel response = new OperationFlowSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationFlowSessionWSDTO> operationFlowSessionWSDTOS = new ArrayList<>();

        OperationFlowSessionWSDTO operationFlowSessionWSDTO = campaignFlowSessionFramework.getCampaignFlowSessionService(userId,sessionId);
        if (operationFlowSessionWSDTO != null){
            operationFlowSessionWSDTOS.add(operationFlowSessionWSDTO);
        }

        response.setFlowSessions(operationFlowSessionWSDTOS);
        general.setOperation("getCampaignFlowSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationFlowSessionWSModel createCampaignFlowSession(CampaignFlowSessionRequest flowSessionRequest) {

        OperationFlowSessionWSModel response = new OperationFlowSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<OperationFlowSessionWSDTO> operationFlowSessionWSDTOS = campaignFlowSessionFramework.createCampaignFlowSessionService(flowSessionRequest);
        if (operationFlowSessionWSDTOS != null){
            response.setFlowSessions(operationFlowSessionWSDTOS);
        }

        general.setOperation("createCampaignFlowSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationFlowSessionWSModel updateCampaignFlowSession(long userId, long sessionId, long agentId, String campaignId, String flowState) {

        OperationFlowSessionWSModel response = new OperationFlowSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationFlowSessionWSDTO> operationFlowSessionWSDTOS = new ArrayList<>();

        OperationFlowSessionWSDTO operationFlowSessionWSDTO = campaignFlowSessionFramework.updateCampaignFlowSessionService(userId,sessionId,agentId,campaignId,flowState);
        if (operationFlowSessionWSDTO != null){
            operationFlowSessionWSDTOS.add(operationFlowSessionWSDTO);
        }

        response.setFlowSessions(operationFlowSessionWSDTOS);
        general.setOperation("updateCampaignFlowSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationFlowSessionWSModel removeCampaignFlowSession(long userId, long sessionId) {

        OperationFlowSessionWSModel response = new OperationFlowSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationFlowSessionWSDTO> operationFlowSessionWSDTOS = new ArrayList<>();

        OperationFlowSessionWSDTO operationFlowSessionWSDTO = campaignFlowSessionFramework.removeCampaignFlowSessionService(userId,sessionId);
        if (operationFlowSessionWSDTO != null){
            operationFlowSessionWSDTOS.add(operationFlowSessionWSDTO);
        }

        response.setFlowSessions(operationFlowSessionWSDTOS);
        general.setOperation("removeCampaignFlowSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
