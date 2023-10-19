package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiOperationInquiryContent;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiOperationInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryDTO;
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


    public ApiOperationInquiryWSDTO mapApiClientInquiryWSDTO(Page<SessionDBModel> sessionDBModelPage){

        ApiOperationInquiryWSDTO clientInquiryWSDTO = new ApiOperationInquiryWSDTO();
        List<ApiOperationInquiryContent> clientInquiryContents = new ArrayList<>();
        for (int i=0;i<sessionDBModelPage.getContent().size();i++){
            clientInquiryContents.add(mapApiClientInquiryContent(sessionDBModelPage.getContent().get(i)));
        }
        clientInquiryWSDTO.setPagination(sessionHelper.createSessionPaginationWSDTO(sessionDBModelPage));
        return clientInquiryWSDTO;
    }


    public ApiOperationInquiryContent mapApiClientInquiryContent(SessionDBModel sessionDBModel){

        ApiOperationInquiryContent clientInquiryContent = new ApiOperationInquiryContent();
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionDBModel.getClientId());
        List<OperationInquiryDBModel> operationInquiryDBModels = operationInquiryRepository.findBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId());
        if (clientDBModel.isPresent() && !operationInquiryDBModels.isEmpty()){
            clientInquiryContent.setClient(clientDBModel.get());
            clientInquiryContent.setClientInquiry(operationInquiryDBModels.get(0));
        }
        return clientInquiryContent;
    }


    public ApiInquiryWSDTO getApiInquiryWSDTO(Page<OperationInquiryDBModel> inquiryModelPage){

        ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();


        return inquiryWSDTO;
    }



    public ApiInquiryDTO getApiInquiryDTO(OperationInquiryDBModel operationInquiryDBModel){

        ApiInquiryDTO inquiryWrapper = new ApiInquiryDTO();
        inquiryWrapper.setInquiry(operationInquiryDBModel);
        //List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(inquiryDBModel.getSessionId(),inquiryDBModel.getClientId());
       // if (!sessionDBModels.isEmpty()){
        //    inquiryWrapper.setInquirySession(sessionDBModels.get(0));
        //}
        return inquiryWrapper;
    }


    public ApiOperationInquiryWSDTO getApiOperationInquiryWSDTO(Page<OperationInquiryDBModel> inquiryModelPage){

        ApiOperationInquiryWSDTO inquiryWSDTO = new ApiOperationInquiryWSDTO();
        List<ApiInquiryDTO> inquiryDTOS = new ArrayList<>();
        for (int i=0;i<inquiryModelPage.getContent().size();i++){
            inquiryDTOS.add(getApiInquiryDTO(inquiryModelPage.getContent().get(i)));
        }

        return inquiryWSDTO;
    }


    public List<ApiSummaryWSDTO> getApiInquirySummary(long agentId) {

        List<ApiSummaryWSDTO> apiSummaryWSDTOS = new ArrayList<>();
        //apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.READY_INQUIRY_SUMMARY, String.valueOf(inquiryRepository.countByAgentIdAndInquiryState(agentId,AppConstant.READY_INQUIRY))));
       // apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_INQUIRY_SUMMARY, String.valueOf(inquiryRepository.countByAgentIdAndInquiryState(agentId,AppConstant.ACTIVE_INQUIRY))));

        return apiSummaryWSDTOS;
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


    public PaginationWSDTO createInquiryPagination(Page<OperationInquiryDBModel> inquiryDBModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(inquiryDBModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(inquiryDBModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(inquiryDBModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(inquiryDBModelPage.getTotalElements());

        return paginationWSDTO;
    }


    public PaginationWSDTO createClientInquiryPagination(Page<OperationInquiryDBModel> clientInquiryDBModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(clientInquiryDBModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(clientInquiryDBModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(clientInquiryDBModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(clientInquiryDBModelPage.getTotalElements());

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
        List<ApiInquiryDTO>inquiryDTOS = new ArrayList<>();
        inquiryDTOS.add(mapApiInquiryDTO(operationInquiryDBModel));

        return inquiryWSDTO;
    }


    public ApiInquiryDTO mapApiInquiryDTO(OperationInquiryDBModel operationInquiryDBModel){

        ApiInquiryDTO inquiryWrapper = new ApiInquiryDTO();
        inquiryWrapper.setInquiry(operationInquiryDBModel);
        //List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(inquiryDBModel.getSessionId(),inquiryDBModel.getClientId());
        //if (!sessionDBModels.isEmpty()){
        //    inquiryWrapper.setInquirySession(sessionDBModels.get(0));
        // }
        return inquiryWrapper;
    }




}
