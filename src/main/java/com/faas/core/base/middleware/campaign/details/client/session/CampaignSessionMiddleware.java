package com.faas.core.base.middleware.campaign.details.client.session;

import com.faas.core.base.framework.campaign.details.client.session.CampaignSessionFramework;
import com.faas.core.base.model.ws.campaign.details.client.session.CampaignSessionWSModel;
import com.faas.core.base.model.ws.campaign.details.client.session.dto.CampaignSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.session.content.SessionRequest;
import com.faas.core.base.model.ws.session.content.SessionWSModel;
import com.faas.core.base.model.ws.session.content.dto.SessionWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignSessionMiddleware {


    @Autowired
    CampaignSessionFramework campaignSessionFramework;


    public CampaignSessionWSModel searchCampaignSessions(long userId,String campaignId,String city,String country,int reqPage,int reqSize) {

        CampaignSessionWSModel response = new CampaignSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignSessionWSDTO campaignSession =  campaignSessionFramework.searchCampaignSessionsService(userId,campaignId,city,country,reqPage,reqSize);
        if (campaignSession != null){
            response.setCampaignSession(campaignSession);
        }

        general.setOperation("searchCampaignSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignSessionWSModel getCampaignSessions(long userId,String campaignId,int reqPage,int reqSize) {

        CampaignSessionWSModel response = new CampaignSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignSessionWSDTO campaignSession =  campaignSessionFramework.getCampaignSessionsService(userId,campaignId,reqPage,reqSize);
        if (campaignSession != null){
            response.setCampaignSession(campaignSession);
        }

        general.setOperation("getCampaignSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionWSModel getCampaignSession(long userId, long sessionId, long clientId) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO>sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = campaignSessionFramework.getCampaignSessionService(userId,sessionId,clientId);
        if (sessionWSDTO != null){
            sessionWSDTOS.add(sessionWSDTO);
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("getCampaignSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionWSModel createCampaignSession(SessionRequest sessionRequest) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SessionWSDTO> sessionWSDTOS = campaignSessionFramework.createCampaignSessionService(sessionRequest);
        if (sessionWSDTOS != null){
            response.setSessions(sessionWSDTOS);
        }

        general.setOperation("createCampaignSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public SessionWSModel updateCampaignSession(long userId,long sessionId,long clientId,long agentId,String campaignId,String sessionState) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO>sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = campaignSessionFramework.updateCampaignSessionService(userId,sessionId,clientId,agentId,campaignId,sessionState);
        if (sessionWSDTO != null){
            sessionWSDTOS.add(sessionWSDTO);
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("updateCampaignSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionWSModel removeCampaignSession(long userId,long sessionId,long clientId) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO>sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = campaignSessionFramework.removeCampaignSessionService(userId,sessionId,clientId);
        if (sessionWSDTO != null){
            sessionWSDTOS.add(sessionWSDTO);
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("removeCampaignSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





}
