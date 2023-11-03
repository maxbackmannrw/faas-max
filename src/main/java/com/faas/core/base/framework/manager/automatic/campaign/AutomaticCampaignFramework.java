package com.faas.core.base.framework.manager.automatic.campaign;

import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.ws.manager.automatic.operation.dto.AutomaticOperationListWSDTO;
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


@Component
public class AutomaticCampaignFramework {

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


}
