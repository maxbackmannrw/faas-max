package com.faas.core.api.framework.operation.content;

import com.faas.core.api.model.ws.general.dto.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiAgentOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiValidateOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.helpers.operation.content.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OperationRepository operationRepository;


    public ApiAgentOperationWSDTO apiGetAgentOperationsService(long agentId, int reqPage, int reqSize) {

        ApiAgentOperationWSDTO agentOperationWSDTO = new ApiAgentOperationWSDTO();
        agentOperationWSDTO.setActiveOperation(operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationState(agentId,AppConstant.ACTIVE_STATE, PageRequest.of(reqPage,reqSize))));
        agentOperationWSDTO.setInquiryOperation(operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationCategoryAndOperationState(agentId, AppConstant.INQUIRY_OPERATION,AppConstant.READY_STATE, PageRequest.of(reqPage,reqSize))));
        agentOperationWSDTO.setManualOperation(operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationCategoryAndOperationState(agentId, AppConstant.MANUAL_OPERATION,AppConstant.READY_STATE, PageRequest.of(reqPage,reqSize))));

        return agentOperationWSDTO;
    }

    public ApiOperationListWSDTO apiGetOperationListService(long agentId, String operationState, String operationCategory, int reqPage, int reqSize) {

        if (operationCategory.equalsIgnoreCase(AppConstant.NONE)){
            return operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationState(agentId,operationState,PageRequest.of(reqPage,reqSize)));
        }else {
            return operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationCategoryAndOperationState(agentId, operationCategory,operationState,PageRequest.of(reqPage,reqSize)));
        }
    }

    public ApiOperationWSDTO apiGetOperationService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()) {
            return operationHelper.getApiOperationWSDTO(operationDBModels.get(0));
        }
        return null;
    }

    public ApiOperationWSDTO apiUpdateOperationService(long agentId, String operationId, String operationState) {

        return null;
    }

    public ApiOperationWSDTO apiRemoveOperationService(long agentId, String operationId) {

        return null;
    }

    public ApiValidateOperationWSDTO apiValidateOperationService(long agentId, String operationId) {

        Optional<UserDBModel> userDBModel = userRepository.findById(agentId);
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (userDBModel.isPresent() && !operationDBModels.isEmpty()) {
            userDBModel.get().setPassword("");
            return operationHelper.validateOperationHelper(userDBModel.get(), operationDBModels.get(0));
        }
        return null;
    }

    public List<ApiSummaryWSDTO> apiGetOperationsSummaryService(long agentId) {

        List<ApiSummaryWSDTO> agentOperationSummary = new ArrayList<>();
        agentOperationSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATION_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId, AppConstant.ACTIVE_STATE))));
        agentOperationSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATION_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId, AppConstant.READY_STATE))));
        agentOperationSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_TOTAL_OPERATION_SUMMARY, String.valueOf(operationRepository.countByAgentId(agentId))));

        return agentOperationSummary;
    }


}
