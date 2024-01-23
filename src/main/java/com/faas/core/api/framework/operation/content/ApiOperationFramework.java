package com.faas.core.api.framework.operation.content;

import com.faas.core.api.model.ws.operation.content.dto.ApiAgentOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationValidateWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    UserRepository userRepository;

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
        agentOperationWSDTO.setReadyManualOperation(operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationTypeAndOperationState(agentId,AppConstant.MANUAL_OPERATION, AppConstant.READY_STATE, PageRequest.of(reqPage,reqSize))));
        agentOperationWSDTO.setActiveManualOperation(operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationTypeAndOperationState(agentId,AppConstant.MANUAL_OPERATION, AppConstant.ACTIVE_STATE, PageRequest.of(reqPage,reqSize))));
        agentOperationWSDTO.setReadyInquiryOperation(operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationTypeAndOperationStateAndOperationInquiryState(agentId,AppConstant.INQUIRY_OPERATION, AppConstant.READY_STATE,AppConstant.NEW_STATE, PageRequest.of(reqPage,reqSize))));
        agentOperationWSDTO.setActiveInquiryOperation(operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationTypeAndOperationState(agentId,AppConstant.INQUIRY_OPERATION, AppConstant.ACTIVE_STATE, PageRequest.of(reqPage,reqSize))));

        return agentOperationWSDTO;
    }


    public ApiOperationListWSDTO apiGetOperationsService(long agentId,String operationType,String operationState,String operationInquiryState,String operationFlowState,int reqPage,int reqSize) {

        return operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationTypeAndOperationStateAndOperationInquiryStateAndOperationFlowState(agentId,operationType,operationState,operationInquiryState,operationFlowState,PageRequest.of(reqPage,reqSize)));
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


    public ApiOperationValidateWSDTO apiOperationValidateService(long agentId,String operationId) {

        Optional<UserDBModel> userDBModel = userRepository.findById(agentId);
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (userDBModel.isPresent() && !operationDBModels.isEmpty()){
            userDBModel.get().setPassword("");
            return operationHelper.operationValidateHelper(userDBModel.get(),operationDBModels.get(0));
        }
        return null;
    }


}
