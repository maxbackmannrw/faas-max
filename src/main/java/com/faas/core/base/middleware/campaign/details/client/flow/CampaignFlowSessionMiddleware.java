package com.faas.core.base.middleware.campaign.details.client.flow;

import com.faas.core.base.framework.campaign.details.client.flow.CampaignFlowSessionFramework;
import com.faas.core.base.model.ws.campaign.details.client.flow.CampaignFlowSessionWSModel;
import com.faas.core.base.model.ws.campaign.details.client.flow.dto.CampaignFlowSessionWSDTO;
import com.faas.core.base.model.ws.campaign.details.client.flow.CampaignFlowSessionRequest;
import com.faas.core.base.model.ws.client.flow.ClientFlowWSModel;
import com.faas.core.base.model.ws.client.flow.dto.ClientFlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
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

    public ClientFlowWSModel getCampaignFlowSession(long userId, long flowId, long clientId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = campaignFlowSessionFramework.getCampaignFlowSessionService(userId,flowId,clientId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("getCampaignFlowSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientFlowWSModel createCampaignFlowSession(CampaignFlowSessionRequest campaignFlowSessionRequest) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientFlowWSDTO> clientFlowWSDTOS = campaignFlowSessionFramework.createCampaignFlowSessionService(campaignFlowSessionRequest);
        if (clientFlowWSDTOS != null){
            response.setClientFlows(clientFlowWSDTOS);
        }

        general.setOperation("createCampaignFlowSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientFlowWSModel updateCampaignFlowSession(long userId, long flowId, long clientId, String flowState) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = campaignFlowSessionFramework.updateCampaignFlowSessionService(userId,flowId,clientId,flowState);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("updateCampaignFlowSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientFlowWSModel removeCampaignFlowSession(long userId, long flowId, long clientId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = campaignFlowSessionFramework.removeCampaignFlowSessionService(userId,flowId,clientId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("removeCampaignFlowSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
