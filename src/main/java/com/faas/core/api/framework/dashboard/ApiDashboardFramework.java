package com.faas.core.api.framework.dashboard;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationSessionWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.CampaignHelper;
import com.faas.core.utils.helpers.InquiryHelper;
import com.faas.core.utils.helpers.OperationHelper;
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
    InquiryHelper inquiryHelper;

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
    AppUtils appUtils;


    public ApiDashboardWSDTO apiGetDashboardService(long agentId,int reqPage,int reqSize){

        ApiDashboardWSDTO dashboardWSDTO = new ApiDashboardWSDTO();

        dashboardWSDTO.setReadyOperation(operationHelper.createApiOperationSessionFromOperationModel(operationRepository.findAllByAgentIdAndOperationState(agentId, AppConstant.READY_STATE, PageRequest.of(reqPage,reqSize))));
        dashboardWSDTO.setReadyInquiry(operationHelper.createApiOperationSessionFromSessionModel(sessionRepository.findAllByAgentIdAndSessionStateAndSessionType(agentId, AppConstant.READY_STATE, AppConstant.INQUIRY_CAMPAIGN, PageRequest.of(reqPage,reqSize))));;
        dashboardWSDTO.setActiveOperation(operationHelper.createApiOperationSessionFromOperationModel(operationRepository.findAllByAgentIdAndOperationState(agentId, AppConstant.ACTIVE_STATE, PageRequest.of(reqPage,reqSize))));
        dashboardWSDTO.setDashCampaigns(apiDashCampaignsService(agentId));

        return dashboardWSDTO;
    }


    public ApiOperationSessionWSDTO apiGetDashOperationsService(long agentId,String sessionType, String sessionState, int reqPage, int reqSize){

        if (sessionType.equalsIgnoreCase(AppConstant.MANUAL_CAMPAIGN)){
            return operationHelper.createApiOperationSessionFromSessionModel(sessionRepository.findAllByAgentIdAndSessionStateAndSessionType(agentId, sessionState, AppConstant.MANUAL_CAMPAIGN, PageRequest.of(reqPage,reqSize)));
        }
        if (sessionType.equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){
            return operationHelper.createApiOperationSessionFromSessionModel(sessionRepository.findAllByAgentIdAndSessionStateAndSessionType(agentId, sessionState, AppConstant.INQUIRY_CAMPAIGN, PageRequest.of(reqPage,reqSize)));
        }
        if (sessionType.equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)){
            return operationHelper.createApiOperationSessionFromSessionModel(sessionRepository.findAllByAgentIdAndSessionStateAndSessionType(agentId, sessionState, AppConstant.AUTOMATIC_CAMPAIGN, PageRequest.of(reqPage,reqSize)));
        }
        if (sessionType.equalsIgnoreCase(AppConstant.ALL_CAMPAIGN)){
            return operationHelper.createApiOperationSessionFromSessionModel(sessionRepository.findAllByAgentIdAndSessionState(agentId, sessionState,  PageRequest.of(reqPage,reqSize)));
        }
        return null;
    }


    public List<ApiCampaignWSDTO> apiDashCampaignsService(long agentId) {

        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> dashCampaigns = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel dashCampaign : dashCampaigns) {
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(dashCampaign.getCampaignId());
            if (campaignDBModel.isPresent()) {
                ApiCampaignWSDTO campaignWSDTO = fillApiDashCampaignWSDTO(agentId,campaignDBModel.get());
                if (campaignWSDTO != null) {
                    campaignWSDTOS.add(campaignWSDTO);
                }
            }
        }
        return campaignWSDTOS;
    }

    public ApiCampaignWSDTO fillApiDashCampaignWSDTO(long agentId,CampaignDBModel campaignDBModel){

        ApiCampaignWSDTO dashCampaignWSDTO = new ApiCampaignWSDTO();
        dashCampaignWSDTO.setCampaign(campaignDBModel);
        List<ProcessDBModel> processDBModels = processRepository.findByIdAndStatus(campaignDBModel.getProcessId(),1);
        if (!processDBModels.isEmpty()){
            dashCampaignWSDTO.setCampaignProcess(processDBModels.get(0));
        }
        return dashCampaignWSDTO;
    }


    public List<ApiSummaryWSDTO> apiGetDashSummaryService(long agentId) {

        List<ApiSummaryWSDTO> apiSummaryWSDTOS = new ArrayList<>();
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.TOTAL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.READY_OPERATIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.READY_SESSION))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_OPERATIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.ACTIVE_SESSION))));

        return apiSummaryWSDTOS;
    }


}
