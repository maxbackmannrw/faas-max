package com.faas.core.api.framework.operation.content;

import com.faas.core.api.model.ws.operation.content.dto.ApiAgentOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationFramework {


    @Autowired
    ActivityHelper activityHelper;

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationListWSDTO apiGetOperationsService(long agentId, String operationState, int reqPage, int reqSize) {

        Page<OperationDBModel> operationPage = operationRepository.findAllByAgentIdAndOperationState(agentId, operationState, PageRequest.of(reqPage,reqSize));
        if (operationPage != null){
        }
        return null;
    }


    public ApiAgentOperationWSDTO apiGetAgentOperationsService(long agentId, int reqPage, int reqSize) {

        ApiAgentOperationWSDTO agentOperationWSDTO = new ApiAgentOperationWSDTO();
        Page<OperationDBModel> readyOperationPage = operationRepository.findAllByAgentIdAndOperationState(agentId, AppConstant.READY_STATE, PageRequest.of(reqPage,reqSize));
        if (readyOperationPage != null){
        }
        Page<OperationDBModel> activeOperationPage = operationRepository.findAllByAgentIdAndOperationState(agentId, AppConstant.ACTIVE_STATE, PageRequest.of(reqPage,reqSize));
        if (activeOperationPage != null){
        }
        return agentOperationWSDTO;
    }


    public ApiOperationListWSDTO apiGetCampaignOperationsService(long agentId, String campaignId, String operationState, int reqPage, int reqSize) {

        Page<OperationDBModel> campaignOperationPage = operationRepository.findAllByAgentIdAndCampaignIdAndOperationState(agentId, campaignId, operationState, PageRequest.of(reqPage,reqSize));
        if (campaignOperationPage != null){
        }
        return null;
    }



    public ApiOperationWSDTO apiGetOperationService(long agentId, long sessionId) {

        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        if (!operationDBModels.isEmpty()) {
        }
        return null;
    }


    public ApiOperationWSDTO apiUpdateOperationService(long agentId, long sessionId, long clientId, String campaignId) {

        return null;
    }


    public ApiOperationWSDTO apiRemoveOperationService(long agentId, long sessionId, long clientId, String campaignId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientIdAndAgentIdAndCampaignId(sessionId, clientId, agentId, campaignId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientIdAndAgentId(sessionId, clientId, agentId);
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);

        return null;
    }


}
