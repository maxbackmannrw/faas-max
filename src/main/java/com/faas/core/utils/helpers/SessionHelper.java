package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.client.session.dto.ApiSessionWSDTO;
import com.faas.core.api.model.ws.client.session.dto.ApiSessionDetailsWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.client.content.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.client.session.content.dto.SessionWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SessionHelper {

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public ApiSessionWSDTO mapApiSessionWSDTO(Page<SessionDBModel> sessionPage) {

        ApiSessionWSDTO apiSessionWSDTO = new ApiSessionWSDTO();
        apiSessionWSDTO.setSessions(sessionPage.getContent());
        PaginationWSDTO paginationWSDTO = createSessionPaginationWSDTO(sessionPage);
        if (paginationWSDTO != null){
            apiSessionWSDTO.setPagination(paginationWSDTO);
        }
        return apiSessionWSDTO;
    }


    public ApiSessionWSDTO getApiSessionWSDTO(long agentId, String sessionState, int reqPage, int reqSize) {

        Page<SessionDBModel> sessionsPage = sessionRepository.findAllByAgentIdAndSessionStateAndSessionType(agentId,sessionState,AppConstant.MANUAL_CAMPAIGN,PageRequest.of(reqPage,reqSize));
        if (sessionsPage != null){
            ApiSessionWSDTO apiSessionWSDTO  = new ApiSessionWSDTO();
            apiSessionWSDTO.setPagination(createSessionPaginationWSDTO(sessionsPage));
            apiSessionWSDTO.setSessions(sessionsPage.getContent());

            return apiSessionWSDTO;
        }
        return null;
    }


    public List<SessionWSDTO> mapSessionWSDTOS(List<SessionDBModel>sessionDBModels){

        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();
        for (SessionDBModel sessionDBModel : sessionDBModels) {
            SessionWSDTO sessionWSDTO =  new SessionWSDTO();
            sessionWSDTO.setSession(sessionDBModel);
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionDBModel.getClientId());
            if (clientDBModel.isPresent()){
                sessionWSDTO.setClient(clientDBModel.get());
            }
            sessionWSDTOS.add(sessionWSDTO);
        }
        return sessionWSDTOS;
    }

    public SessionWSDTO mapSessionWSDTO(SessionDBModel sessionDBModel){

        SessionWSDTO sessionWSDTO =  new SessionWSDTO();
        sessionWSDTO.setSession(sessionDBModel);
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionDBModel.getClientId());
        if (clientDBModel.isPresent()){
            sessionWSDTO.setClient(clientDBModel.get());

        }
        return sessionWSDTO;
    }





    public PaginationWSDTO createSessionPaginationWSDTO(Page<SessionDBModel> sessionPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(sessionPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(sessionPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(sessionPage.getTotalPages());
        paginationWSDTO.setTotalElements(sessionPage.getTotalElements());

        return paginationWSDTO;
    }


    public List<ApiSummaryWSDTO> getApiSessionSummary(long agentId){

        List<ApiSummaryWSDTO> sessionSummaries = new ArrayList<>();
        sessionSummaries.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.ACTIVE_STATE))));
        sessionSummaries.add(new ApiSummaryWSDTO(AppConstant.READY_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.READY_STATE))));
        sessionSummaries.add(new ApiSummaryWSDTO(AppConstant.TOTAL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));

        return sessionSummaries;
    }


    public ApiSessionDetailsWSDTO mapApiSessionDetailsWSDTO(SessionDBModel sessionDBModel){

        ApiSessionDetailsWSDTO sessionDetailsWSDTO = new ApiSessionDetailsWSDTO();
        sessionDetailsWSDTO.setSession(sessionDBModel);
        List<OperationDBModel> operationDBModels =operationRepository.findBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId());
        Optional<CampaignDBModel> campaignDBModel =campaignRepository.findById(sessionDBModel.getCampaignId());
        Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModel.getProcessId());

        if (!operationDBModels.isEmpty() && campaignDBModel.isPresent() && processDBModel.isPresent() ){
            sessionDetailsWSDTO.setOperation(operationDBModels.get(0));
            sessionDetailsWSDTO.setCampaign(campaignDBModel.get());
            sessionDetailsWSDTO.setProcess(processDBModel.get());
        }
        return sessionDetailsWSDTO;
    }


}
