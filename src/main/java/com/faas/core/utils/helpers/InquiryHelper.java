package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiOperationInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.model.ws.operation.details.content.dto.OperationInquirySessionWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.session.SessionRepository;
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
    CampaignRepository campaignRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public OperationListWSDTO getInquiryOperationListWSDTO(Page<SessionDBModel> sessionDBModelPage){

        OperationListWSDTO operationListWSDTO = new OperationListWSDTO();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        operationListWSDTO.setOperations(operationWSDTOS);
        operationListWSDTO.setPagination(createInquirySessionPagination(sessionDBModelPage));

        return operationListWSDTO;
    }




    public ApiOperationInquiryWSDTO getApiOperationInquiryWSDTO(){

        ApiOperationInquiryWSDTO operationInquiryWSDTO = new ApiOperationInquiryWSDTO();

        return operationInquiryWSDTO;
    }




    public List<ApiSummaryWSDTO> getApiInquirySummary(long agentId) {

        List<ApiSummaryWSDTO> apiOperationInquirySummaryWSDTOS = new ArrayList<>();

        return apiOperationInquirySummaryWSDTOS;
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

        return operationInquirySessionWSDTO;
    }



    public PaginationWSDTO createInquirySessionPagination(Page<SessionDBModel> sessionDBModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();

        paginationWSDTO.setPageSize(sessionDBModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(sessionDBModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(sessionDBModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(sessionDBModelPage.getTotalElements());

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
        sessionDBModel.setSessionState(AppConstant.READY_SESSION);
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
            operationDBModel.setOperationState(AppConstant.READY_OPERATION);
            operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
            operationDBModel.setcDate(appUtils.getCurrentTimeStamp());
            operationDBModel.setStatus(1);

            return operationDBModel;
        }
        return null;
    }






}
