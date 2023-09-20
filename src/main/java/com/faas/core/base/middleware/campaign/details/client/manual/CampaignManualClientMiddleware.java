package com.faas.core.base.middleware.campaign.details.client.manual;

import com.faas.core.base.framework.campaign.details.client.manual.CampaignManualClientFramework;
import com.faas.core.base.model.ws.campaign.details.client.manual.CampaignSessionWSModel;
import com.faas.core.base.model.ws.campaign.details.client.manual.dto.CampaignSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.client.manual.ManualClientRequest;
import com.faas.core.base.model.ws.client.session.content.SessionWSModel;
import com.faas.core.base.model.ws.client.session.content.dto.SessionWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignManualClientMiddleware {


    @Autowired
    CampaignManualClientFramework campaignManualClientFramework;


    public CampaignSessionWSModel searchCampaignManualClients(long userId,String campaignId,String city,String country,int reqPage,int reqSize) {

        CampaignSessionWSModel response = new CampaignSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignSessionWSDTO campaignSession =  campaignManualClientFramework.searchCampaignManualClientsService(userId,campaignId,city,country,reqPage,reqSize);
        if (campaignSession != null){
            response.setCampaignSession(campaignSession);
        }

        general.setOperation("searchCampaignManualClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignSessionWSModel getCampaignManualClients(long userId,String campaignId,int reqPage,int reqSize) {

        CampaignSessionWSModel response = new CampaignSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignSessionWSDTO campaignSession =  campaignManualClientFramework.getCampaignManualClientsService(userId,campaignId,reqPage,reqSize);
        if (campaignSession != null){
            response.setCampaignSession(campaignSession);
        }

        general.setOperation("getCampaignManualClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionWSModel getCampaignManualClient(long userId, long sessionId) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO>sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = campaignManualClientFramework.getCampaignManualClientService(userId,sessionId);
        if (sessionWSDTO != null){
            sessionWSDTOS.add(sessionWSDTO);
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("getCampaignManualClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SessionWSModel createCampaignManualClient(ManualClientRequest manualClientRequest) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SessionWSDTO> sessionWSDTOS = campaignManualClientFramework.createCampaignManualClientService(manualClientRequest);
        if (sessionWSDTOS != null){
            response.setSessions(sessionWSDTOS);
        }

        general.setOperation("createCampaignManualClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SessionWSModel updateCampaignManualClient(long userId,long sessionId,long agentId,String campaignId,String sessionState) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO>sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = campaignManualClientFramework.updateCampaignManualClientService(userId,sessionId,agentId,campaignId,sessionState);
        if (sessionWSDTO != null){
            sessionWSDTOS.add(sessionWSDTO);
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("updateCampaignManualClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionWSModel removeCampaignManualClient(long userId,long sessionId) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO>sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = campaignManualClientFramework.removeCampaignManualClientService(userId,sessionId);
        if (sessionWSDTO != null){
            sessionWSDTOS.add(sessionWSDTO);
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("removeCampaignManualClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





}
