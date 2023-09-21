package com.faas.core.base.middleware.campaign.details.client.flow;

import com.faas.core.base.framework.campaign.details.client.flow.CampaignFlowClientFramework;
import com.faas.core.base.model.ws.campaign.details.client.flow.CampaignFlowWSModel;
import com.faas.core.base.model.ws.campaign.details.client.flow.dto.CampaignFlowWSDTO;
import com.faas.core.base.model.ws.campaign.details.client.flow.CampaignFlowClientRequest;
import com.faas.core.base.model.ws.client.flow.ClientFlowWSModel;
import com.faas.core.base.model.ws.client.flow.dto.ClientFlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignFlowClientMiddleware {


    @Autowired
    CampaignFlowClientFramework campaignFlowClientFramework;


    public CampaignFlowWSModel searchCampaignFlowClients(long userId,String campaignId,String clientCity,String clientCountry,int reqPage,int reqSize) {

        CampaignFlowWSModel response = new CampaignFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignFlowWSDTO campaignFlowWSDTO = campaignFlowClientFramework.searchCampaignFlowClientsService(userId,campaignId,clientCity,clientCountry,reqPage,reqSize);
        if (campaignFlowWSDTO != null){
            response.setCampaignFlow(campaignFlowWSDTO);
        }

        general.setOperation("searchCampaignFlowClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignFlowWSModel getCampaignFlowClients(long userId, String campaignId, int reqPage, int reqSize) {

        CampaignFlowWSModel response = new CampaignFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignFlowWSDTO campaignFlowWSDTO = campaignFlowClientFramework.getCampaignFlowClientsService(userId,campaignId,reqPage,reqSize);
        if (campaignFlowWSDTO != null){
            response.setCampaignFlow(campaignFlowWSDTO);
        }

        general.setOperation("getCampaignFlowClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel getCampaignFlowClient(long userId, long flowId, long clientId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = campaignFlowClientFramework.getCampaignFlowClientService(userId,flowId,clientId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("getCampaignFlowClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel createCampaignFlowClient(CampaignFlowClientRequest campaignFlowClientRequest) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientFlowWSDTO> clientFlowWSDTOS = campaignFlowClientFramework.createCampaignFlowClientService(campaignFlowClientRequest);
        if (clientFlowWSDTOS != null){
            response.setClientFlows(clientFlowWSDTOS);
        }

        general.setOperation("createCampaignFlowClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel updateCampaignFlowClient(long userId, long flowId, long clientId, String flowState) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = campaignFlowClientFramework.updateCampaignFlowClientService(userId,flowId,clientId,flowState);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("updateCampaignFlowClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel removeCampaignFlowClient(long userId, long flowId, long clientId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = campaignFlowClientFramework.removeCampaignFlowClientService(userId,flowId,clientId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("removeCampaignFlowClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
