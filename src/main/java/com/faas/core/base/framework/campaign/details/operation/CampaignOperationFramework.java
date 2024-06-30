package com.faas.core.base.framework.campaign.details.operation;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.operation.CampaignOperationRequest;
import com.faas.core.base.model.ws.campaign.details.operation.dto.CampaignOperationRequestDTO;
import com.faas.core.base.model.ws.campaign.details.operation.dto.CampaignOperationWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.activity.ActivityHelpers;
import com.faas.core.utility.helpers.operation.OperationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CampaignOperationFramework {


    @Autowired
    ActivityHelpers activityHelpers;

    @Autowired
    OperationHelpers operationHelpers;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignOperationWSDTO searchCampaignOperationsService(long userId, String campaignId, String city, String country, int reqPage, int reqSize) {


        return null;
    }


    public CampaignOperationWSDTO getCampaignOperationsService(long userId, String campaignId, int reqPage, int reqSize) {


        return null;
    }


     public OperationWSDTO getCampaignOperationService(long userId,long sessionId,String campaignId) {


        return null;
    }


    public List<OperationWSDTO> createCampaignOperationService(CampaignOperationRequest operationRequest) {

        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i = 0; i< operationRequest.getOperationRequests().size(); i++){
            OperationWSDTO operationWSDTO = createCampaignOperation(operationRequest.getOperationRequests().get(i));
            if (operationWSDTO != null){
                operationWSDTOS.add(operationWSDTO);
            }
        }
        return operationWSDTOS;
    }


    public OperationWSDTO createCampaignOperation(CampaignOperationRequestDTO operationRequestDTO) {

        List<ClientDBModel> clientDBModels = clientRepository.findByIdAndClientState(operationRequestDTO.getClientId(),AppConstant.READY_CLIENT);
        Optional<UserDBModel> agentDBModel = userRepository.findById(operationRequestDTO.getAgentId());
        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(operationRequestDTO.getCampaignId());
        if (!clientDBModels.isEmpty() && agentDBModel.isPresent() && campaignDBModel.isPresent()){

            clientDBModels.get(0).setClientState(AppConstant.BUSY_CLIENT);
            clientDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            ClientDBModel clientDBModel = clientRepository.save(clientDBModels.get(0));



        }
        return null;
    }


    public OperationWSDTO updateCampaignOperationService(long userId,long sessionId,long agentId, String operationState) {


        return null;
    }


    public OperationWSDTO removeCampaignOperationService(long userId,long sessionId,String campaignId) {


        return null;
    }


}