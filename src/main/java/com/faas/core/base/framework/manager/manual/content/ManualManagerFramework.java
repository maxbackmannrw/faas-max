package com.faas.core.base.framework.manager.manual.content;

import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.ws.manager.manual.dto.ManualOperationListWSDTO;
import com.faas.core.base.model.ws.manager.manual.dto.ManualOperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ManualManagerFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

    @Autowired
    AppUtils appUtils;


    public ManualOperationListWSDTO getManualOperationsService(long userId, String sessionState, int reqPage, int reqSize) {

        Page<SessionDBModel> sessionModelPage = sessionRepository.findAllBySessionTypeAndSessionState(AppConstant.MANUAL_CAMPAIGN, sessionState,PageRequest.of(reqPage,reqSize));
        if (sessionModelPage != null){
            return operationHelper.getManualOperationListWSDTO(sessionModelPage);
        }
        return null;
    }


    public ManualOperationWSDTO getManualOperationService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty()){
            return new ManualOperationWSDTO(operationDBModels.get(0), sessionDBModel.get());
        }
        return null;
    }


    public ManualOperationWSDTO createManualOperationService(long userId,long clientId,long agentId,String campaignId) {


        return null;
    }


    public ManualOperationWSDTO updateManualOperationService(long userId, long sessionId) {


        return null;
    }

    public ManualOperationWSDTO removeManualOperationService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty()){
            sessionRepository.delete(sessionDBModel.get());
            operationRepository.delete(operationDBModels.get(0));
            return new ManualOperationWSDTO(operationDBModels.get(0), sessionDBModel.get());
        }
        return null;
    }

}
