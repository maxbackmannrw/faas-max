package com.faas.core.base.framework.manager.automatic.content;

import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.flow.OperationFlowDBModel;
import com.faas.core.base.model.ws.manager.automatic.dto.AutomaticOperationListWSDTO;
import com.faas.core.base.model.ws.manager.automatic.dto.AutomaticOperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.flow.OperationFlowRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.FlowHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class AutomaticManagerFramework {

    @Autowired
    FlowHelper flowHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationFlowRepository operationFlowRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;


    public AutomaticOperationListWSDTO getAutomaticOperationsService(long userId, String sessionState, int reqPage, int reqSize) {

        Page<SessionDBModel> sessionModelPage = sessionRepository.findAllBySessionTypeAndSessionState(AppConstant.AUTOMATIC_CAMPAIGN, sessionState,PageRequest.of(reqPage,reqSize));
        if (sessionModelPage != null){
            return flowHelper.getAutomaticOperationListWSDTO(sessionModelPage);
        }
        return null;
    }


    public AutomaticOperationWSDTO getAutomaticOperationService(long userId,long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        List<OperationFlowDBModel> operationFlowDBModels = operationFlowRepository.findBySessionId(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty() && !operationFlowDBModels.isEmpty()){
            return new AutomaticOperationWSDTO(operationDBModels.get(0),sessionDBModel.get(),operationFlowDBModels.get(0));
        }
        return null;
    }


    public AutomaticOperationWSDTO createAutomaticOperationService(long userId,long clientId,long agentId,String campaignId) {

        return null;
    }


    public AutomaticOperationWSDTO updateAutomaticOperationService(long userId,long sessionId) {


        return null;
    }


    public AutomaticOperationWSDTO removeAutomaticOperationService(long userId,long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        List<OperationFlowDBModel> operationFlowDBModels = operationFlowRepository.findBySessionId(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty() && !operationFlowDBModels.isEmpty()){
            sessionRepository.delete(sessionDBModel.get());
            operationRepository.delete(operationDBModels.get(0));
            operationFlowRepository.delete(operationFlowDBModels.get(0));
            return new AutomaticOperationWSDTO(operationDBModels.get(0),sessionDBModel.get(),operationFlowDBModels.get(0));
        }
        return null;
    }


}
