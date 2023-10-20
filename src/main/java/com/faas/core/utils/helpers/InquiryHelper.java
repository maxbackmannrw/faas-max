package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiOperationInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.inquiry.OperationInquiryDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.operation.inquiry.dto.OperationInquirySessionWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.operation.inquiry.dto.OperationInquiryWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InquiryHelper {

    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;



    public ApiOperationInquiryWSDTO getApiOperationInquiryWSDTO(Page<OperationInquiryDBModel> operationInquiryPage){

        ApiOperationInquiryWSDTO operationInquiryWSDTO = new ApiOperationInquiryWSDTO();
        List<ApiInquiryWSDTO> inquiryWSDTOS = new ArrayList<>();
        for (int i=0;i<operationInquiryPage.getContent().size();i++){
            ApiInquiryWSDTO inquiryWSDTO = getApiInquiryWSDTO(operationInquiryPage.getContent().get(i));
            if (inquiryWSDTO != null){
                inquiryWSDTOS.add(inquiryWSDTO);
            }
        }
        operationInquiryWSDTO.setInquiries(inquiryWSDTOS);
        operationInquiryWSDTO.setPagination(createInquiryPagination(operationInquiryPage));
        return operationInquiryWSDTO;
    }


    public ApiInquiryWSDTO getApiInquiryWSDTO(OperationInquiryDBModel operationInquiryDBModel){

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(operationInquiryDBModel.getSessionId());
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(operationInquiryDBModel.getSessionId());
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty()){

            ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();
            inquiryWSDTO.setOperation(operationDBModels.get(0));
            inquiryWSDTO.setOperationSession(sessionDBModel.get());
            inquiryWSDTO.setOperationInquiry(operationInquiryDBModel);

            return inquiryWSDTO;
        }
        return null;
    }


    public List<ApiSummaryWSDTO> getApiInquirySummary(long agentId) {

        List<ApiSummaryWSDTO> apiOperationInquirySummaryWSDTOS = new ArrayList<>();
        apiOperationInquirySummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.READY_INQUIRIES_SUMMARY, String.valueOf(operationInquiryRepository.countByAgentIdAndInquiryState(agentId,AppConstant.READY_INQUIRY))));
        apiOperationInquirySummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_INQUIRIES_SUMMARY, String.valueOf(operationInquiryRepository.countByAgentIdAndInquiryState(agentId,AppConstant.ACTIVE_INQUIRY))));
        apiOperationInquirySummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.TOTAL_INQUIRIES_SUMMARY, String.valueOf(operationInquiryRepository.countByAgentId(agentId))));

        return apiOperationInquirySummaryWSDTOS;
    }


    public OperationInquiryDBModel mapOperationInquiryDBModel(SessionDBModel sessionDBModel){

        OperationInquiryDBModel operationInquiryDBModel = new OperationInquiryDBModel();
        operationInquiryDBModel.setSessionId(sessionDBModel.getId());
        operationInquiryDBModel.setClientId(sessionDBModel.getClientId());
        operationInquiryDBModel.setAgentId(sessionDBModel.getAgentId());
        operationInquiryDBModel.setCampaignId(sessionDBModel.getCampaignId());
        operationInquiryDBModel.setProcessId(sessionDBModel.getProcessId());
        operationInquiryDBModel.setInquiryState(AppConstant.NEW_INQUIRY);
        operationInquiryDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationInquiryDBModel.setcDate(appUtils.getCurrentTimeStamp());
        operationInquiryDBModel.setStatus(1);

        return operationInquiryDBModel;
    }

    public List<OperationInquirySessionWSDTO> createInquirySessionWSDTOS(List<SessionDBModel> sessionDBModels){

        List<OperationInquirySessionWSDTO> operationInquirySessionWSDTOS = new ArrayList<>();
        for (SessionDBModel sessionDBModel : sessionDBModels) {
            operationInquirySessionWSDTOS.add(createInquirySessionWSDTO(sessionDBModel));
        }
        return operationInquirySessionWSDTOS;
    }

    public OperationInquirySessionWSDTO createInquirySessionWSDTO(SessionDBModel sessionDBModel){

        OperationInquirySessionWSDTO operationInquirySessionWSDTO = new OperationInquirySessionWSDTO();
        operationInquirySessionWSDTO.setClientSession(sessionDBModel);
        List<OperationInquiryDBModel> operationInquiryDBModels = operationInquiryRepository.findBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId());
        if (!operationInquiryDBModels.isEmpty()){
            operationInquirySessionWSDTO.setClientInquiry(operationInquiryDBModels.get(0));
        }
        return operationInquirySessionWSDTO;
    }


    public List<OperationInquiryWSDTO> createInquiryWSDTOS(List<OperationInquiryDBModel> operationInquiryDBModels){

        List<OperationInquiryWSDTO> operationInquiryWSDTOS = new ArrayList<>();
        for (OperationInquiryDBModel operationInquiryDBModel : operationInquiryDBModels) {
            operationInquiryWSDTOS.add(new OperationInquiryWSDTO(operationInquiryDBModel));
        }
        return operationInquiryWSDTOS;
    }


    public PaginationWSDTO createInquirySessionPagination(Page<SessionDBModel> sessionDBModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(sessionDBModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(sessionDBModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(sessionDBModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(sessionDBModelPage.getTotalElements());

        return paginationWSDTO;
    }


    public PaginationWSDTO createInquiryPagination(Page<OperationInquiryDBModel> operationInquiryPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();

        paginationWSDTO.setPageSize(operationInquiryPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(operationInquiryPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(operationInquiryPage.getTotalPages());
        paginationWSDTO.setTotalElements(operationInquiryPage.getTotalElements());

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


    public OperationDBModel mapInquirySessionOperation(SessionDBModel sessionDBModel) {

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
            operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
            operationDBModel.setcDate(appUtils.getCurrentTimeStamp());
            operationDBModel.setStatus(1);

            return operationDBModel;
        }
        return null;
    }


    public ApiInquiryWSDTO mapApiInquiryWSDTO(OperationInquiryDBModel operationInquiryDBModel){

        ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();

        return inquiryWSDTO;
    }







}
