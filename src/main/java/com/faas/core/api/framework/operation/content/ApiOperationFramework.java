package com.faas.core.api.framework.operation.content;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiAgentOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationValidateWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.operation.OperationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationFramework {

    @Autowired
    OperationHelpers operationHelpers;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentOperationWSDTO apiGetAgentOperationsService(long agentId, int reqPage, int reqSize) {

        ApiAgentOperationWSDTO agentOperationWSDTO = new ApiAgentOperationWSDTO();
        agentOperationWSDTO.setReadyManualOperation(operationHelpers.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationTypeAndOperationState(agentId,AppConstant.MANUAL_OPERATION, AppConstant.READY_STATE, PageRequest.of(reqPage,reqSize))));
        agentOperationWSDTO.setActiveManualOperation(operationHelpers.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationTypeAndOperationState(agentId,AppConstant.MANUAL_OPERATION, AppConstant.ACTIVE_STATE, PageRequest.of(reqPage,reqSize))));
        agentOperationWSDTO.setActiveInquiryOperation(operationHelpers.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationTypeAndOperationState(agentId,AppConstant.INQUIRY_OPERATION, AppConstant.ACTIVE_STATE, PageRequest.of(reqPage,reqSize))));

        return agentOperationWSDTO;
    }


    public ApiOperationListWSDTO apiGetOperationsService(long agentId,String operationType,String operationState,String operationInquiryState,String operationFlowState,int reqPage,int reqSize) {

        return null;
    }

    public ApiOperationWSDTO apiGetOperationService(long agentId, String operationId) {

        Optional<OperationDBModel> operationDBModel = operationRepository.findById(operationId);
        if (operationDBModel.isPresent()){
            return operationHelpers.getApiOperationWSDTO(operationDBModel.get());
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
            return operationHelpers.operationValidateHelper(userDBModel.get(),operationDBModels.get(0));
        }
        return null;
    }



    public List<ApiSummaryWSDTO> apiGetOperationSummaryService(long agentId) {
        return operationHelpers.apiGetOperationSummaryHelper(agentId);
    }


}
