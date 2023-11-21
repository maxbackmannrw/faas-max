package com.faas.core.base.framework.operation.automatic.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.flow.OperationFlowDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.operation.automatic.content.dto.AutomaticManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationCampaignWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.flow.OperationFlowRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.AutomaticHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class AutomaticManagerFramework {

    @Autowired
    AutomaticHelper automaticHelper;

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


    public AutomaticManagerWSDTO getAutomaticManagerService(long userId, int reqPage, int reqSize) {


        return null;
    }


    public OperationListWSDTO getAutomaticOperationsService(long userId, String sessionState, int reqPage, int reqSize) {

        Page<SessionDBModel> sessionModelPage = sessionRepository.findAllBySessionTypeAndSessionState(AppConstant.AUTOMATIC_CAMPAIGN, sessionState,PageRequest.of(reqPage,reqSize));
        if (sessionModelPage != null){
        }
        return null;
    }


    public OperationWSDTO getAutomaticOperationService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        List<OperationFlowDBModel> operationFlowDBModels = operationFlowRepository.findBySessionId(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty() && !operationFlowDBModels.isEmpty()){
        }
        return null;
    }


    public OperationWSDTO createAutomaticOperationService(long userId,long clientId,long agentId,String campaignId) {

        return null;
    }


    public OperationWSDTO updateAutomaticOperationService(long userId,long sessionId) {


        return null;
    }


    public OperationWSDTO removeAutomaticOperationService(long userId,long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        List<OperationFlowDBModel> operationFlowDBModels = operationFlowRepository.findBySessionId(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty() && !operationFlowDBModels.isEmpty()){
            sessionRepository.delete(sessionDBModel.get());
            operationRepository.delete(operationDBModels.get(0));
            operationFlowRepository.delete(operationFlowDBModels.get(0));
        }
        return null;
    }


    public List<OperationCampaignWSDTO> getAutomaticCampaignsService(long userId) {

        List<OperationCampaignWSDTO>campaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.AUTOMATIC_CAMPAIGN);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            OperationCampaignWSDTO campaignWSDTO = new OperationCampaignWSDTO();
            campaignWSDTO.setCampaign(campaignDBModel);
            campaignWSDTOS.add(campaignWSDTO);
        }
        return campaignWSDTOS;
    }

    public OperationCampaignWSDTO getAutomaticCampaignService(long userId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            OperationCampaignWSDTO campaignWSDTO = new OperationCampaignWSDTO();
            campaignWSDTO.setCampaign(campaignDBModel.get());
            return campaignWSDTO;
        }
        return null;
    }


}
