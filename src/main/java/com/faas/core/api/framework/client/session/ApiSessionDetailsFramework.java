package com.faas.core.api.framework.client.session;

import com.faas.core.api.model.ws.client.session.dto.ApiSessionDetailsWSDTO;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ApiSessionDetailsFramework {


    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public ApiSessionDetailsWSDTO apiGetSessionDetailsService(long agentId, long sessionId){

        Optional<SessionDBModel> sessionDBModel =sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()){
            return sessionHelper.mapApiSessionDetailsWSDTO(sessionDBModel.get());
        }
        return null;
    }



}
