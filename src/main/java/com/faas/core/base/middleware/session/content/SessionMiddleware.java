package com.faas.core.base.middleware.session.content;

import com.faas.core.base.framework.session.content.SessionFramework;
import com.faas.core.base.model.ws.session.content.SessionWSModel;
import com.faas.core.base.model.ws.session.content.dto.SessionWSDTO;
import com.faas.core.base.model.ws.session.details.SessionRequest;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SessionMiddleware {


    @Autowired
    SessionFramework sessionFramework;


    public SessionWSModel getAllSessions(long userId, int reqPage, int reqSize) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SessionWSDTO> sessionWSDTOS = sessionFramework.getAllSessionsService(userId,reqPage,reqSize);
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

        List<SessionWSDTO> sessionWSDTOS = sessionFramework.getSessionsByStateService(userId,sessionState,reqPage,reqSize);
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

        SessionWSDTO sessionWSDTO = sessionFramework.getSessionService(userId,sessionId,clientId);
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


    public SessionWSModel createSession(long userId,long clientId,long agentId,String campaignId) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();

        SessionWSDTO sessionWSDTO = sessionFramework.createSessionService(userId,clientId,agentId,campaignId);
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



    public SessionWSModel createSessions(SessionRequest sessionRequest) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SessionWSDTO> sessionWSDTOS = sessionFramework.createSessionsService(sessionRequest.getSessionRequests());
        if (sessionWSDTOS != null){
            response.setSessions(sessionWSDTOS);
        }

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

        SessionWSDTO sessionWSDTO = sessionFramework.updateSessionService(userId,sessionId,clientId);
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

        SessionWSDTO sessionWSDTO = sessionFramework.removeSessionService(userId,sessionId,clientId);
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
