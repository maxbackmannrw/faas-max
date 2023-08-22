package com.faas.core.api.framework.inquiry.content;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiAgentInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiInquiryFramework {


    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentInquiryWSDTO apiGetAgentInquiryService(long agentId,int reqPage,int reqSize){

        ApiAgentInquiryWSDTO agentInquiryWSDTO = new ApiAgentInquiryWSDTO();
        agentInquiryWSDTO.setReadyInquiry(inquiryHelper.getApiInquiryWSDTO(inquiryRepository.findAllByAgentIdAndInquiryState(agentId,AppConstant.NEW_INQUIRY,PageRequest.of(reqPage,reqSize))));
        agentInquiryWSDTO.setActiveInquiry(inquiryHelper.getApiInquiryWSDTO(inquiryRepository.findAllByAgentIdAndInquiryState(agentId,AppConstant.ACTIVE_INQUIRY,PageRequest.of(reqPage,reqSize))));

        return agentInquiryWSDTO;
    }


    public ApiInquiryWSDTO apiGetCampaignInquiryService(long agentId, String campaignId,String inquiryState, int reqPage, int reqSize){
        return inquiryHelper.getApiInquiryWSDTO(inquiryRepository.findAllByAgentIdAndCampaignIdAndInquiryState(agentId,campaignId,inquiryState,PageRequest.of(reqPage,reqSize)));
    }


    public ApiInquiryWSDTO apiGetInquiriesService(long agentId, String inquiryState, int reqPage, int reqSize){
        return inquiryHelper.getApiInquiryWSDTO(inquiryRepository.findAllByAgentIdAndInquiryState(agentId,inquiryState,PageRequest.of(reqPage,reqSize)));
    }


    public ApiInquiryWSDTO apiGetInquiryService(long agentId,long inquiryId,String campaignId){

        List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndAgentIdAndCampaignId(inquiryId,agentId,campaignId);
        if (!inquiryDBModels.isEmpty()){
            return inquiryHelper.mapApiInquiryWSDTO(inquiryDBModels.get(0));
        }
       return null;
    }


    public ApiInquiryWSDTO apiStartInquiryService(long agentId,long inquiryId,long sessionId,String campaignId){

        List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndAgentIdAndCampaignIdAndInquiryState(inquiryId,agentId,campaignId,AppConstant.NEW_INQUIRY);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndCampaignIdAndSessionStateAndSessionType(sessionId,campaignId,AppConstant.READY_SESSION,AppConstant.INQUIRY_CAMPAIGN);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndCampaignIdAndOperationState(sessionId,campaignId,AppConstant.READY_OPERATION);

        if (!inquiryDBModels.isEmpty() && !sessionDBModels.isEmpty() && !operationDBModels.isEmpty()){

            sessionDBModels.get(0).setSessionState(AppConstant.ACTIVE_SESSION);
            sessionDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            sessionRepository.save(sessionDBModels.get(0));

            operationDBModels.get(0).setOperationState(AppConstant.ACTIVE_OPERATION);
            operationDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            operationRepository.save(operationDBModels.get(0));

            inquiryDBModels.get(0).setInquiryState(AppConstant.ACTIVE_INQUIRY);
            inquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());

            return inquiryHelper.mapApiInquiryWSDTO(inquiryRepository.save(inquiryDBModels.get(0)));
        }
        return null;
    }



    public ApiInquiryWSDTO apiUpdateInquiryService(long agentId, long inquiryId,String inquiryState){

        ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();

        return inquiryWSDTO;
    }


    public ApiInquiryWSDTO apiRemoveInquiryService(long agentId, long inquiryId){

        ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();
        return inquiryWSDTO;
    }



    public List<ApiSummaryWSDTO> apiGetInquirySummaryService(long agentId){
        return inquiryHelper.getApiInquirySummary(agentId);
    }



}
