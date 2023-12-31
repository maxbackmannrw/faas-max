package com.faas.core.api.framework.client.content;

import com.faas.core.api.model.ws.client.session.dto.ApiAgentSessionWSDTO;
import com.faas.core.api.model.ws.client.session.dto.ApiSessionWSDTO;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.CampaignHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiClientFramework {


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


    public ApiAgentSessionWSDTO apiGetAgentClientsService(long agentId, int reqPage, int reqSize) {

        ApiAgentSessionWSDTO agentSessionWSDTO = new ApiAgentSessionWSDTO();

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
        }
        return null;
    }


    
}
