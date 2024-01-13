package com.faas.core.api.framework.operation.content;

import com.faas.core.api.model.ws.operation.content.dto.ApiAgentOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
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
public class ApiOperationFramework {

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


    public ApiAgentOperationWSDTO apiGetAgentOperationsService(long agentId, int reqPage, int reqSize) {

        ApiAgentOperationWSDTO agentOperationWSDTO = new ApiAgentOperationWSDTO();
        agentOperationWSDTO.setReadyManualOperation(operationHelper.createApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationTypeAndOperationState(agentId,AppConstant.MANUAL_OPERATION, AppConstant.READY_STATE, PageRequest.of(reqPage,reqSize))));
        agentOperationWSDTO.setReadyInquiryOperation(operationHelper.createApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationTypeAndOperationState(agentId,AppConstant.INQUIRY_OPERATION, AppConstant.READY_STATE, PageRequest.of(reqPage,reqSize))));

        return agentOperationWSDTO;
    }


    public ApiOperationListWSDTO apiGetCampaignOperationsService(long agentId, String campaignId, String operationState, int reqPage, int reqSize) {

        Page<OperationDBModel> campaignOperation = operationRepository.findAllByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,operationState,PageRequest.of(reqPage,reqSize));
        if (campaignOperation != null){
            return operationHelper.createApiOperationListWSDTO(campaignOperation);
        }
        return null;
    }


    public ApiOperationListWSDTO apiGetOperationsService(long agentId,String operationType,String operationState,int reqPage,int reqSize) {

        Page<OperationDBModel> operationPage = operationRepository.findAllByAgentIdAndOperationTypeAndOperationState(agentId,operationType,operationState,PageRequest.of(reqPage,reqSize));
        if (operationPage != null){
            return operationHelper.createApiOperationListWSDTO(operationPage);
        }
        return null;
    }

    public ApiOperationWSDTO apiGetOperationService(long agentId, String operationId) {

        Optional<OperationDBModel> operationDBModel = operationRepository.findById(operationId);
        if (operationDBModel.isPresent()){
            return operationHelper.mapApiOperationWSDTO(operationDBModel.get());
        }
        return null;
    }

    public ApiOperationWSDTO apiUpdateOperationService(long agentId,String operationId,String operationState) {

        return null;
    }

    public ApiOperationWSDTO apiRemoveOperationService(long agentId,String operationId) {

        return null;
    }



}
