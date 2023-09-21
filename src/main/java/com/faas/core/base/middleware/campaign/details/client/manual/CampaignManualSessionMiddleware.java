package com.faas.core.base.middleware.campaign.details.client.manual;

import com.faas.core.base.framework.campaign.details.client.manual.CampaignManualSessionFramework;
import com.faas.core.base.model.ws.campaign.details.client.manual.CampaignManualSessionWSModel;
import com.faas.core.base.model.ws.campaign.details.client.manual.dto.CampaignManualSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.client.manual.CampaignManualSessionRequest;
import com.faas.core.base.model.ws.client.session.content.SessionWSModel;
import com.faas.core.base.model.ws.client.session.content.dto.SessionWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignManualSessionMiddleware {


    @Autowired
    CampaignManualSessionFramework campaignManualSessionFramework;


    public CampaignManualSessionWSModel searchCampaignManualSessions(long userId, String campaignId, String city, String country, int reqPage, int reqSize) {

        CampaignManualSessionWSModel response = new CampaignManualSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignManualSessionWSDTO campaignSession =  campaignManualSessionFramework.searchCampaignManualSessionsService(userId,campaignId,city,country,reqPage,reqSize);
        if (campaignSession != null){
            response.setCampaignSession(campaignSession);
        }

        general.setOperation("searchCampaignManualSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignManualSessionWSModel getCampaignManualSessions(long userId, String campaignId, int reqPage, int reqSize) {

        CampaignManualSessionWSModel response = new CampaignManualSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignManualSessionWSDTO campaignSession =  campaignManualSessionFramework.getCampaignManualSessionsService(userId,campaignId,reqPage,reqSize);
        if (campaignSession != null){
            response.setCampaignSession(campaignSession);
        }

        general.setOperation("getCampaignManualSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionWSModel getCampaignManualSession(long userId, long sessionId) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO>sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = campaignManualSessionFramework.getCampaignManualSessionService(userId,sessionId);
        if (sessionWSDTO != null){
            sessionWSDTOS.add(sessionWSDTO);
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("getCampaignManualSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SessionWSModel createCampaignManualSession(CampaignManualSessionRequest sessionRequest) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SessionWSDTO> sessionWSDTOS = campaignManualSessionFramework.createCampaignManualSessionService(sessionRequest);
        if (sessionWSDTOS != null){
            response.setSessions(sessionWSDTOS);
        }

        general.setOperation("createCampaignManualSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SessionWSModel updateCampaignManualSession(long userId,long sessionId,long agentId,String campaignId,String sessionState) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO>sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = campaignManualSessionFramework.updateCampaignManualSessionService(userId,sessionId,agentId,campaignId,sessionState);
        if (sessionWSDTO != null){
            sessionWSDTOS.add(sessionWSDTO);
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("updateCampaignManualSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionWSModel removeCampaignManualSession(long userId,long sessionId) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO>sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = campaignManualSessionFramework.removeCampaignManualSessionService(userId,sessionId);
        if (sessionWSDTO != null){
            sessionWSDTOS.add(sessionWSDTO);
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("removeCampaignManualSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





}
