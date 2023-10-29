package com.faas.core.base.framework.operation.details.automatic;

import com.faas.core.base.model.db.operation.details.flow.OperationFlowDBModel;
import com.faas.core.base.model.ws.operation.details.automatic.dto.AutomaticOperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.details.flow.OperationFlowRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.FlowHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutomaticOperationFramework {

    @Autowired
    FlowHelper flowHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OperationFlowRepository operationFlowRepository;

    @Autowired
    AppUtils appUtils;



    public List<AutomaticOperationWSDTO> getAutomaticOperationsService(long userId, int reqPage, int reqSize) {

        List<AutomaticOperationWSDTO> automaticOperationWSDTOS = new ArrayList<>();
        Page<OperationFlowDBModel> flowModelPage = operationFlowRepository.findAll(PageRequest.of(reqPage,reqSize));
        for (int i=0;i<flowModelPage.getContent().size();i++){
            automaticOperationWSDTOS.add(new AutomaticOperationWSDTO(flowModelPage.getContent().get(i)));
        }
        return automaticOperationWSDTOS;
    }


    public AutomaticOperationWSDTO getAutomaticOperationService(long userId, long flowId, long clientId) {


        return null;
    }



    public AutomaticOperationWSDTO createAutomaticOperationService(long userId, long clientId, long agentId, String campaignId) {

        return null;
    }


    public AutomaticOperationWSDTO updateAutomaticOperationService(long userId, long flowId, long clientId) {


        return null;
    }


    public AutomaticOperationWSDTO removeAutomaticOperationService(long userId, long flowId, long clientId) {


        return null;
    }


}
