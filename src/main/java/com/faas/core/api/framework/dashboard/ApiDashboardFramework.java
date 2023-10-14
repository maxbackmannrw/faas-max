package com.faas.core.api.framework.dashboard;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.api.model.ws.session.dto.ApiSessionWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.operation.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import com.faas.core.utils.helpers.SessionHelper;
import com.faas.core.utils.helpers.CampaignHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiDashboardFramework {

    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    CampaignHelper campaignHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

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
        dashboardWSDTO.setReadySession(sessionHelper.mapApiSessionWSDTO(sessionRepository.findAllByAgentIdAndSessionStateAndSessionType(agentId,AppConstant.READY_SESSION,AppConstant.MANUAL_CAMPAIGN,PageRequest.of(reqPage,reqSize))));
        dashboardWSDTO.setActiveSession(sessionHelper.mapApiSessionWSDTO(sessionRepository.findAllByAgentIdAndSessionState(agentId,AppConstant.ACTIVE_SESSION,PageRequest.of(reqPage,reqSize))));
        dashboardWSDTO.setClientInquiry(inquiryHelper.mapApiClientInquiryWSDTO(sessionRepository.findAllByAgentIdAndSessionStateAndSessionType(agentId,AppConstant.READY_SESSION,AppConstant.INQUIRY_CAMPAIGN,PageRequest.of(reqPage,reqSize))));
        dashboardWSDTO.setDashCampaigns(apiDashCampaignsService(agentId));

        return dashboardWSDTO;
    }


    public ApiSessionWSDTO apiGetDashSessionsService(long agentId,String sessionType,String sessionState,int reqPage,int reqSize){

        if (sessionType.equalsIgnoreCase(AppConstant.MANUAL_CAMPAIGN)){
            return sessionHelper.mapApiSessionWSDTO(sessionRepository.findAllByAgentIdAndSessionTypeAndSessionState(agentId,sessionType,sessionState,PageRequest.of(reqPage,reqSize)));
        }
        if (sessionType.equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){
            return sessionHelper.mapApiSessionWSDTO(sessionRepository.findAllByAgentIdAndSessionTypeAndSessionState(agentId,sessionType,sessionState,PageRequest.of(reqPage,reqSize)));
        }
        if (sessionType.equalsIgnoreCase(AppConstant.ALL_CAMPAIGN)){
            return sessionHelper.mapApiSessionWSDTO(sessionRepository.findAllByAgentIdAndSessionState(agentId,sessionState,PageRequest.of(reqPage,reqSize)));
        }
        return null;
    }


    public ApiInquiryWSDTO apiGetDashInquiriesService(long agentId,String inquiryState,int reqPage,int reqSize){
        // return inquiryHelper.getApiInquiryWSDTO(inquiryRepository.findAllByAgentIdAndInquiryState(agentId,inquiryState,PageRequest.of(reqPage,reqSize)));
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
        if (processDBModels.size()>0){
            dashCampaignWSDTO.setCampaignProcess(processDBModels.get(0));
        }
        return dashCampaignWSDTO;
    }


    public List<ApiSummaryWSDTO> apiGetDashSummaryService(long agentId) {

        List<ApiSummaryWSDTO> apiSummaryWSDTOS = new ArrayList<>();
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.TOTAL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.READY_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.READY_SESSION))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.ACTIVE_SESSION))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.FINISHED_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.FINISHED_SESSION))));

        return apiSummaryWSDTOS;
    }


}
