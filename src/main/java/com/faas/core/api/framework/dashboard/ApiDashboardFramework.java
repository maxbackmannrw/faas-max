package com.faas.core.api.framework.dashboard;

import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardCampaignWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardOperationWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiValidateOperationWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.CampaignHelper;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppUtils appUtils;


    public ApiDashboardWSDTO apiGetDashboardService(long agentId,int reqPage,int reqSize){

        ApiDashboardWSDTO dashboardWSDTO = new ApiDashboardWSDTO();
        dashboardWSDTO.setReadyManualOperation(operationHelper.createApiDashboardOperationWSDTO(operationRepository.findAllByAgentIdAndOperationTypeAndOperationState(agentId,AppConstant.MANUAL_OPERATION,AppConstant.READY_STATE, PageRequest.of(reqPage,reqSize))));
        dashboardWSDTO.setReadyInquiryOperation(operationHelper.createApiDashboardOperationWSDTO(operationRepository.findAllByAgentIdAndOperationTypeAndOperationStateAndOperationInquiryState(agentId,AppConstant.INQUIRY_OPERATION,AppConstant.READY_STATE,AppConstant.NEW_INQUIRY, PageRequest.of(reqPage,reqSize))));
        dashboardWSDTO.setActiveOperation(operationHelper.createApiDashboardOperationWSDTO(operationRepository.findAllByAgentIdAndOperationState(agentId, AppConstant.ACTIVE_STATE, PageRequest.of(reqPage,reqSize))));
        dashboardWSDTO.setDashboardCampaigns(apiGetDashboardCampaignsService(agentId));

        return dashboardWSDTO;
    }


    public ApiDashboardOperationWSDTO apiGetDashboardOperationsService(long agentId,String operationType,String operationState,int reqPage,int reqSize){

        Page<OperationDBModel> operationModelPage = operationRepository.findAllByAgentIdAndOperationTypeAndOperationState(agentId,operationType,operationState,PageRequest.of(reqPage,reqSize));
        if (operationModelPage != null){
            return operationHelper.createApiDashboardOperationWSDTO(operationModelPage);
        }
        return null;
    }


    public ApiOperationWSDTO apiGetDashboardOperationService(long agentId, String operationId){

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            return operationHelper.mapApiOperationWSDTO(operationDBModels.get(0));
        }
        return null;
    }


    public ApiValidateOperationWSDTO apiValidateDashboardOperationService(long agentId, String operationId){

        Optional<UserDBModel> userDBModel = userRepository.findById(agentId);
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (userDBModel.isPresent() && !operationDBModels.isEmpty()){

            ApiValidateOperationWSDTO validateOperationWSDTO = new ApiValidateOperationWSDTO();
            validateOperationWSDTO.setAgent(userDBModel.get());
            validateOperationWSDTO.setOperation(operationDBModels.get(0));
            validateOperationWSDTO.setOperationCount(operationRepository.countByAgentIdAndOperationState(agentId,AppConstant.ACTIVE_STATE));
            if (userDBModel.get().getUserRole().equalsIgnoreCase(AppConstant.BASIC_AGENT)){
                validateOperationWSDTO.setOperationLimit(AppConstant.BASIC_AGENT_OPERATION_LIMIT);
            }
            if (userDBModel.get().getUserRole().equalsIgnoreCase(AppConstant.SUPER_AGENT)){
                validateOperationWSDTO.setOperationLimit(AppConstant.SUPER_AGENT_OPERATION_LIMIT);
            }
            return validateOperationWSDTO;
        }
        return null;
    }


    public List<ApiDashboardCampaignWSDTO> apiGetDashboardCampaignsService(long agentId) {

        List<ApiDashboardCampaignWSDTO> dashboardCampaignWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel campaignAgentDBModel : campaignAgentDBModels) {
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignAgentDBModel.getCampaignId());
            if (campaignDBModel.isPresent()) {
                ApiDashboardCampaignWSDTO dashboardCampaignWSDTO = campaignHelper.mapApiDashboardCampaignWSDTO(campaignDBModel.get());
                if (dashboardCampaignWSDTO != null) {
                    dashboardCampaignWSDTOS.add(dashboardCampaignWSDTO);
                }
            }
        }
        return dashboardCampaignWSDTOS;
    }


    public List<ApiSummaryWSDTO> apiGetDashboardSummaryService(long agentId) {

        List<ApiSummaryWSDTO> apiDashboardSummary = new ArrayList<>();
        apiDashboardSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ALL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));
        apiDashboardSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATIONS_SUMMARY,String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId,AppConstant.READY_STATE))));
        apiDashboardSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATIONS_SUMMARY,String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId,AppConstant.ACTIVE_STATE))));

        return apiDashboardSummary;
    }


}
