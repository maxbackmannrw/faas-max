package com.faas.core.api.framework.client.inquiry;

import com.faas.core.api.model.ws.client.session.dto.ApiAgentSessionWSDTO;
import com.faas.core.api.model.ws.client.session.dto.ApiSessionWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.CampaignHelper;
import com.faas.core.utils.helpers.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiClientInquiryFramework {

    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    CampaignHelper campaignHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentSessionWSDTO apiGetAgentSessionService(long agentId, int reqPage, int reqSize) {

        ApiAgentSessionWSDTO agentSessionWSDTO = new ApiAgentSessionWSDTO();
        agentSessionWSDTO.setReadySession(sessionHelper.getApiSessionWSDTO(agentId,AppConstant.READY_SESSION,reqPage,reqSize));
        agentSessionWSDTO.setActiveSession(sessionHelper.getApiSessionWSDTO(agentId,AppConstant.ACTIVE_SESSION,reqPage,reqSize));

        return agentSessionWSDTO;
    }


    public ApiSessionWSDTO fillApiSessionWSDTO(List<SessionDBModel> sessionDBModels,PaginationWSDTO pagination) {

        ApiSessionWSDTO apiSessionWSDTO = new ApiSessionWSDTO();
        apiSessionWSDTO.setSessions(sessionDBModels);
        if (pagination != null){
            apiSessionWSDTO.setPagination(pagination);
        }
        return apiSessionWSDTO;
    }


    public ApiSessionWSDTO apiGetSessionsService(long agentId,String sessionState,int reqPage,int reqSize) {

        Page<SessionDBModel> sessionModelPage =sessionRepository.findAllByAgentIdAndSessionState(agentId,sessionState,PageRequest.of(reqPage,reqSize));
        if (sessionModelPage != null){
            return fillApiSessionWSDTO(sessionModelPage.getContent(),sessionHelper.createSessionPaginationWSDTO(sessionModelPage)) ;
        }
        return null;
    }


    public ApiSessionWSDTO apiGetCampaignSessionsService(long agentId, String campaignId, String sessionState, int reqPage, int reqSize) {

        return null;
    }


    public ApiSessionWSDTO apiGetSessionService(long agentId, long sessionId) {

        Page<SessionDBModel> sessionModelPage =sessionRepository.findAllByIdAndAgentId(sessionId,agentId,PageRequest.of(0,20));
        if (sessionModelPage != null){
            return fillApiSessionWSDTO(sessionModelPage.getContent(),sessionHelper.createSessionPaginationWSDTO(sessionModelPage)) ;
        }
        return null;
    }


    public List<ApiSummaryWSDTO> apiGetSessionSummaryService(long agentId) {
        return sessionHelper.getApiSessionSummary(agentId);
    }

    
}
