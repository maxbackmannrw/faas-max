package com.faas.core.api.framework.dashboard;

import com.faas.core.data.ws.api.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.data.ws.api.dashboard.dto.ApiDashboardWSDTO;
import com.faas.core.data.ws.api.general.ApiSummaryWSDTO;
import com.faas.core.data.ws.api.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.data.ws.api.operation.content.dto.ApiOperationValidateWSDTO;
import com.faas.core.data.ws.api.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.data.db.campaign.details.agent.CampaignAgentDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.operation.OperationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiDashboardFramework {

    @Autowired
    OperationHelpers operationHelpers;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppUtils appUtils;


    public ApiDashboardWSDTO apiGetDashboardService(long agentId, int reqPage, int reqSize) {

        ApiDashboardWSDTO dashboardWSDTO = new ApiDashboardWSDTO();
        dashboardWSDTO.setActiveOperation(operationHelpers.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationState(agentId, AppConstant.ACTIVE_STATE, PageRequest.of(reqPage, reqSize))));
        dashboardWSDTO.setDashboardCampaigns(apiGetDashboardCampaignsService(agentId));

        return dashboardWSDTO;
    }


    public ApiOperationListWSDTO apiGetDashboardOperationsService(long agentId, String operationType, String operationState, String operationInquiryState, String operationFlowState, int reqPage, int reqSize) {

        if (operationType.equalsIgnoreCase(AppConstant.ALL_OPERATIONS)) {
            return operationHelpers.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationState(agentId, operationState, PageRequest.of(reqPage, reqSize)));
        } else {
        }
        return null;
    }


    public ApiOperationWSDTO apiGetDashboardOperationService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            return operationHelpers.getApiOperationWSDTO(operationDBModels.get(0));
        }
        return null;
    }


    public ApiOperationValidateWSDTO apiDashboardOperationValidateService(long agentId, String operationId) {

        Optional<UserDBModel> userDBModel = userRepository.findById(agentId);
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (userDBModel.isPresent() && !operationDBModels.isEmpty()) {
            userDBModel.get().setPassword("");
            return operationHelpers.operationValidateHelper(userDBModel.get(), operationDBModels.get(0));
        }
        return null;
    }


    public List<ApiCampaignWSDTO> apiGetDashboardCampaignsService(long agentId) {

        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel campaignAgentDBModel : campaignAgentDBModels) {

        }
        return campaignWSDTOS;
    }


    public List<ApiSummaryWSDTO> apiGetDashboardSummaryService(long agentId) {

        List<ApiSummaryWSDTO> apiDashboardSummary = new ArrayList<>();
        apiDashboardSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ALL_CAMPAIGNS_SUMMARY, String.valueOf(campaignAgentRepository.countByAgentId(agentId))));
        apiDashboardSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId, AppConstant.READY_STATE))));
        apiDashboardSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId, AppConstant.ACTIVE_STATE))));

        return apiDashboardSummary;
    }


}
