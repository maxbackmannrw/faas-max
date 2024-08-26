package com.faas.core.base.middleware.campaign.manager.client;

import com.faas.core.base.framework.campaign.manager.client.CampaignManagerClientFramework;
import com.faas.core.base.model.ws.campaign.manager.client.CampaignClientWSModel;
import com.faas.core.base.model.ws.campaign.manager.client.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.client.content.ClientWSModel;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignManagerClientMiddleware {


    @Autowired
    CampaignManagerClientFramework campaignManagerClientFramework;


    public CampaignClientWSModel searchCampaignClients(long userId,String city, String country, String clientState, int reqPage, int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignManagerClientFramework.searchCampaignClientsService(city,country,clientState,reqPage,reqSize);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("searchCampaignClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientWSModel getCampaignClient(long userId,long clientId,String campaignId) {

        ClientWSModel response = new ClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientWSDTO>clientWSDTOS = new ArrayList<>();

        ClientWSDTO clientWSDTO = campaignManagerClientFramework.getCampaignClientService(userId,clientId,campaignId);
        if (clientWSDTO != null){
            clientWSDTOS.add(clientWSDTO);
        }

        response.setClients(clientWSDTOS);
        general.setOperation("getCampaignClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
