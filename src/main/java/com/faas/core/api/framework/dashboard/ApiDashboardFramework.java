package com.faas.core.api.framework.dashboard;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardContentWSDTO;
import com.faas.core.api.model.ws.general.dto.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiValidateOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.campaign.details.agent.CampaignAgentDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.helpers.campaign.CampaignHelper;
import com.faas.core.misc.helpers.operation.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiDashboardFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    CampaignHelper campaignHelper;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    UserRepository userRepository;


    public ApiDashboardContentWSDTO apiGetDashboardContentsService(long agentId, int reqPage, int reqSize) {

        ApiDashboardContentWSDTO dashboardWSDTO = new ApiDashboardContentWSDTO();
        dashboardWSDTO.setManualOperation(operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationCategoryAndOperationState(agentId, AppConstant.MANUAL_OPERATION,AppConstant.READY_STATE, PageRequest.of(reqPage, reqSize))));
        dashboardWSDTO.setInquiryOperation(operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationCategoryAndOperationStateAndInquiryState(agentId, AppConstant.INQUIRY_OPERATION, AppConstant.READY_STATE, AppConstant.ACTIVE_STATE, PageRequest.of(reqPage, reqSize))));
        dashboardWSDTO.setActiveOperation(operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationState(agentId, AppConstant.ACTIVE_STATE, PageRequest.of(reqPage, reqSize))));
        dashboardWSDTO.setActiveCampaigns(apiGetDashboardCampaignsService(agentId,AppConstant.ACTIVE_CAMPAIGN));

        return dashboardWSDTO;
    }

    public ApiOperationListWSDTO apiGetDashboardOperationsService(long agentId,String operationCategory,String operationState,int reqPage,int reqSize) {

        return operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndOperationCategoryAndOperationState(agentId, operationCategory,operationState, PageRequest.of(reqPage, reqSize)));
    }

    public ApiOperationWSDTO apiGetDashboardOperationService(long agentId,String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            return operationHelper.getApiOperationWSDTO(operationDBModels.get(0));
        }
        return null;
    }

    public ApiValidateOperationWSDTO apiValidateDashboardOperationService(long agentId, String operationId) {

        Optional<UserDBModel> agentDBModel = userRepository.findById(agentId);
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (agentDBModel.isPresent() && !operationDBModels.isEmpty()) {
            agentDBModel.get().setPassword("");
            return operationHelper.validateOperationHelper(agentDBModel.get(), operationDBModels.get(0));
        }
        return null;
    }

    public List<ApiCampaignWSDTO> apiGetDashboardCampaignsService(long agentId,String campaignState) {

        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel campaignAgentDBModel : campaignAgentDBModels) {
            List<CampaignDBModel> campaignDBModels = campaignRepository.findByIdAndCampaignState(campaignAgentDBModel.getCampaignId(),campaignState);
            if (!campaignDBModels.isEmpty()) {
                campaignWSDTOS.add(campaignHelper.getApiCampaignWSDTO(agentId,campaignDBModels.get(0)));
            }
        }
        return campaignWSDTOS;
    }

    public List<ApiSummaryWSDTO> apiGetDashboardSummariesService(long agentId) {

        List<ApiSummaryWSDTO> apiDashboardSummary = new ArrayList<>();
        apiDashboardSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_TOTAL_CAMPAIGN_SUMMARY, String.valueOf(campaignAgentRepository.countByAgentIdAndAgentState(agentId,AppConstant.ACTIVE_STATE))));
        apiDashboardSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATION_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId, AppConstant.READY_STATE))));
        apiDashboardSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATION_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId, AppConstant.ACTIVE_STATE))));

        return apiDashboardSummary;
    }



}
