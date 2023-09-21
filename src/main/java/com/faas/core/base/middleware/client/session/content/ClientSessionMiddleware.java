package com.faas.core.base.middleware.client.session.content;

import com.faas.core.base.framework.client.session.content.ClientSessionFramework;
import com.faas.core.base.model.ws.campaign.details.client.manual.CampaignManualClientRequest;
import com.faas.core.base.model.ws.client.session.content.SessionWSModel;
import com.faas.core.base.model.ws.client.session.content.dto.SessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientSessionMiddleware {


    @Autowired
    ClientSessionFramework clientSessionFramework;


    public SessionWSModel getAllSessions(long userId, int reqPage, int reqSize) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SessionWSDTO> sessionWSDTOS = clientSessionFramework.getAllSessionsService(userId,reqPage,reqSize);
        if (sessionWSDTOS != null){
            response.setSessions(sessionWSDTOS);
        }

        general.setOperation("getAllSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionWSModel getSessionsByState(long userId,String sessionState, int reqPage, int reqSize) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SessionWSDTO> sessionWSDTOS = clientSessionFramework.getSessionsByStateService(userId,sessionState,reqPage,reqSize);
        if (sessionWSDTOS != null){
            response.setSessions(sessionWSDTOS);
        }

        general.setOperation("getAllSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionWSModel getSession(long userId,long sessionId,long clientId) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = clientSessionFramework.getSessionService(userId,sessionId,clientId);
        if (sessionWSDTO != null){
            sessionWSDTOS.add(sessionWSDTO);
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("getSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionWSModel createSession(long userId,long clientId,String campaign) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = clientSessionFramework.createSessionService(userId,clientId,campaign);
        if (sessionWSDTO != null){
            sessionWSDTOS.add(sessionWSDTO);
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("createSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public SessionWSModel createSessions(CampaignManualClientRequest campaignManualClientRequest) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = clientSessionFramework.createSessionsService(campaignManualClientRequest);
        if (sessionWSDTO != null){
            sessionWSDTOS.add(sessionWSDTO);
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("createSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionWSModel updateSession(long userId,long sessionId,long clientId) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = clientSessionFramework.updateSessionService(userId,sessionId,clientId);
        if (sessionWSDTO != null){
            sessionWSDTOS.add(sessionWSDTO);
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("updateSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public SessionWSModel removeSession(long userId,long sessionId,long clientId) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = clientSessionFramework.removeSessionService(userId,sessionId,clientId);
        if (sessionWSDTO != null){
            sessionWSDTOS.add(sessionWSDTO);
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("removeSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
