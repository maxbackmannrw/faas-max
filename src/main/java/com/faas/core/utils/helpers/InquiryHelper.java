package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.inquiry.dto.InquiryWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InquiryHelper {


    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public ApiInquiryWSDTO getApiInquiryWSDTO(Page<InquiryDBModel> inquiryModelPage){

        ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();
        List<ApiInquiryDTO> inquiryDTOS = new ArrayList<>();
        for (int i=0;i<inquiryModelPage.getContent().size();i++){
            inquiryDTOS.add(getApiInquiryDTO(inquiryModelPage.getContent().get(i)));
        }
        inquiryWSDTO.setInquiries(inquiryDTOS);
        inquiryWSDTO.setPagination(createInquiryPagination(inquiryModelPage));

        return inquiryWSDTO;
    }


    public ApiInquiryDTO getApiInquiryDTO(InquiryDBModel inquiryDBModel){

        ApiInquiryDTO inquiryWrapper = new ApiInquiryDTO();
        inquiryWrapper.setInquiry(inquiryDBModel);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(inquiryDBModel.getSessionId(),inquiryDBModel.getClientId());
        if (!sessionDBModels.isEmpty()){
            inquiryWrapper.setInquirySession(sessionDBModels.get(0));
        }
        return inquiryWrapper;
    }


    public List<ApiSummaryWSDTO> getApiInquirySummary(long agentId) {

        List<ApiSummaryWSDTO> apiSummaryWSDTOS = new ArrayList<>();
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.READY_INQUIRY_SUMMARY, String.valueOf(inquiryRepository.countByAgentIdAndInquiryState(agentId,AppConstant.READY_INQUIRY))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_INQUIRY_SUMMARY, String.valueOf(inquiryRepository.countByAgentIdAndInquiryState(agentId,AppConstant.ACTIVE_INQUIRY))));

        return apiSummaryWSDTOS;
    }


    public InquiryDBModel mapInquiryDBModel(SessionDBModel sessionDBModel){

        InquiryDBModel inquiryDBModel = new InquiryDBModel();

        inquiryDBModel.setSessionId(sessionDBModel.getId());
        inquiryDBModel.setClientId(sessionDBModel.getClientId());
        inquiryDBModel.setClientName(sessionDBModel.getClientName());
        inquiryDBModel.setPhoneNumber(sessionDBModel.getPhoneNumber());
        inquiryDBModel.setEmailAddress(sessionDBModel.getEmailAddress());
        inquiryDBModel.setClientCity(sessionDBModel.getClientCity());
        inquiryDBModel.setClientCountry(sessionDBModel.getClientCountry());
        inquiryDBModel.setCampaignId(sessionDBModel.getCampaignId());
        inquiryDBModel.setCampaign(sessionDBModel.getCampaign());
        inquiryDBModel.setProcessId(sessionDBModel.getProcessId());
        inquiryDBModel.setProcess(sessionDBModel.getProcess());
        inquiryDBModel.setAgentId(sessionDBModel.getAgentId());
        inquiryDBModel.setAgentName(sessionDBModel.getAgentName());
        inquiryDBModel.setInquiryState(AppConstant.NEW_INQUIRY);
        inquiryDBModel.setuDate(appUtils.getCurrentTimeStamp());
        inquiryDBModel.setcDate(appUtils.getCurrentTimeStamp());
        inquiryDBModel.setStatus(1);

        return inquiryDBModel;
    }


    public List<InquiryWSDTO> createInquiryWSDTOS(List<InquiryDBModel> inquiryDBModels){

        List<InquiryWSDTO> inquiryWSDTOS = new ArrayList<>();
        for (InquiryDBModel inquiryDBModel : inquiryDBModels) {
            inquiryWSDTOS.add(new InquiryWSDTO(inquiryDBModel));
        }
        return inquiryWSDTOS;
    }



    public PaginationWSDTO createInquiryPagination(Page<InquiryDBModel> inquiryDBModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(inquiryDBModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(inquiryDBModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(inquiryDBModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(inquiryDBModelPage.getTotalElements());

        return paginationWSDTO;
    }



    public SessionDBModel mapInquirySession(ClientDBModel clientDBModel, UserDBModel agentDBModel, CampaignDBModel campaignDBModel) {

        SessionDBModel sessionDBModel = new SessionDBModel();

        sessionDBModel.setSessionUUID(appUtils.generateUUID());
        sessionDBModel.setClientId(clientDBModel.getId());
        sessionDBModel.setClientName(clientDBModel.getClientName());
        sessionDBModel.setNationalId(clientDBModel.getNationalId());
        sessionDBModel.setPhoneNumber(clientDBModel.getPhoneNumber());
        sessionDBModel.setEmailAddress(clientDBModel.getEmailAddress());
        sessionDBModel.setClientCity(clientDBModel.getClientCity());
        sessionDBModel.setClientCountry(clientDBModel.getClientCountry());
        sessionDBModel.setClientType(clientDBModel.getClientType());
        sessionDBModel.setCampaignId(campaignDBModel.getId());
        sessionDBModel.setCampaign(campaignDBModel.getCampaign());
        sessionDBModel.setCampaignType(campaignDBModel.getCampaignType());
        sessionDBModel.setCampaignCategory(campaignDBModel.getCampaignCategory());
        sessionDBModel.setProcessId(campaignDBModel.getProcessId());
        sessionDBModel.setProcess(campaignDBModel.getProcess());
        sessionDBModel.setProcessType(campaignDBModel.getProcessType());
        sessionDBModel.setProcessCategory(campaignDBModel.getProcessCategory());
        sessionDBModel.setAgentId(agentDBModel.getId());
        sessionDBModel.setAgentName(agentDBModel.getUserName());
        sessionDBModel.setSessionType(campaignDBModel.getCampaignCategory());
        sessionDBModel.setSessionState(AppConstant.NEW_SESSION);
        sessionDBModel.setuDate(appUtils.getCurrentTimeStamp());
        sessionDBModel.setcDate(appUtils.getCurrentTimeStamp());
        sessionDBModel.setStatus(1);

        return sessionDBModel;
    }


    public OperationDBModel mapInquiryOperation(SessionDBModel sessionDBModel) {

        if (!operationRepository.existsBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId())){

            OperationDBModel operationDBModel = new OperationDBModel();
            operationDBModel.setSessionId(sessionDBModel.getId());
            operationDBModel.setSessionUUID(sessionDBModel.getSessionUUID());
            operationDBModel.setClientId(sessionDBModel.getClientId());
            operationDBModel.setAgentId(sessionDBModel.getAgentId());
            operationDBModel.setCampaignId(sessionDBModel.getCampaignId());
            operationDBModel.setProcessId(sessionDBModel.getProcessId());
            operationDBModel.setActivities(new ArrayList<>());
            operationDBModel.setOperationState(AppConstant.NEW_OPERATION);
            operationDBModel.setOperationResult(AppConstant.RESULT_EMPTY);
            operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
            operationDBModel.setcDate(appUtils.getCurrentTimeStamp());
            operationDBModel.setStatus(1);

            return operationDBModel;
        }
        return null;
    }


    public ApiInquiryWSDTO mapApiInquiryWSDTO(InquiryDBModel inquiryDBModel){

        ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();
        List<ApiInquiryDTO>inquiryDTOS = new ArrayList<>();
        inquiryDTOS.add(mapApiInquiryDTO(inquiryDBModel));
        inquiryWSDTO.setInquiries(inquiryDTOS);

        return inquiryWSDTO;
    }


    public ApiInquiryDTO mapApiInquiryDTO(InquiryDBModel inquiryDBModel){

        ApiInquiryDTO inquiryWrapper = new ApiInquiryDTO();
        inquiryWrapper.setInquiry(inquiryDBModel);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(inquiryDBModel.getSessionId(),inquiryDBModel.getClientId());
        if (!sessionDBModels.isEmpty()){
            inquiryWrapper.setInquirySession(sessionDBModels.get(0));
        }
        return inquiryWrapper;
    }




}
