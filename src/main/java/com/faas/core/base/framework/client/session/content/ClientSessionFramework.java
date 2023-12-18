package com.faas.core.base.framework.client.session.content;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.campaign.details.client.manual.CampaignManualSessionRequest;
import com.faas.core.base.model.ws.client.session.content.dto.SessionWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ClientSessionFramework {

    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public SessionWSDTO filSessionWSDTO(SessionDBModel sessionDBModel) {

        SessionWSDTO sessionWSDTO =  new SessionWSDTO();
        sessionWSDTO.setSession(sessionDBModel);
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionDBModel.getClientId());

        if (clientDBModel.isPresent()){
            sessionWSDTO.setClient(clientDBModel.get());

        }
        return sessionWSDTO;
    }


    public List<SessionWSDTO> getAllSessionsService(long userId, int reqPage, int reqSize) {

        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();
        Page<SessionDBModel> sessionModelPage = sessionRepository.findAllByStatus(1, PageRequest.of(reqPage,reqSize));
        for (int i=0;i<sessionModelPage.getContent().size();i++){
            sessionWSDTOS.add(filSessionWSDTO(sessionModelPage.getContent().get(i)));
        }
        return sessionWSDTOS;
    }


    public List<SessionWSDTO> getSessionsByStateService(long userId,String sessionState, int reqPage, int reqSize) {

        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();
        Page<SessionDBModel> sessionModelPage = sessionRepository.findAllBySessionState(sessionState, PageRequest.of(reqPage,reqSize));
        for (int i=0;i<sessionModelPage.getContent().size();i++){
            sessionWSDTOS.add(filSessionWSDTO(sessionModelPage.getContent().get(i)));
        }
        return sessionWSDTOS;
    }


    public SessionWSDTO getSessionService(long userId,long sessionId,long clientId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        if (sessionDBModels.size()>0){
            return filSessionWSDTO(sessionDBModels.get(0));
        }
        return null;
    }


    public SessionWSDTO createSessionService(long userId,long clientId,String campaign) {
        return null;
    }


    public SessionWSDTO createSessionsService(CampaignManualSessionRequest campaignManualSessionRequest) {
        return null;
    }


    public SessionWSDTO updateSessionService(long userId,long sessionId,long clientId) {
        return null;
    }


    public SessionWSDTO removeSessionService(long userId,long sessionId,long clientId) {
        return null;
    }


}
