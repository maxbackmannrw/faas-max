package com.faas.core.api.middleware.session;

import com.faas.core.api.framework.session.ApiSessionFramework;
import com.faas.core.api.model.ws.session.ApiSessionDetailsWSModel;
import com.faas.core.api.model.ws.session.dto.ApiSessionDetailsWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.session.ApiAgentSessionWSModel;
import com.faas.core.api.model.ws.session.ApiSessionWSModel;
import com.faas.core.api.model.ws.session.dto.ApiAgentSessionWSDTO;
import com.faas.core.api.model.ws.session.dto.ApiSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiSessionMiddleware {


    @Autowired
    ApiSessionFramework apiSessionFramework;


    public ApiAgentSessionWSModel apiGetAgentSession(long agentId, int reqPage, int reqSize) {

        ApiAgentSessionWSModel response = new ApiAgentSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentSessionWSDTO agentSessionWSDTO = apiSessionFramework.apiGetAgentSessionService(agentId,reqPage,reqSize);
        if (agentSessionWSDTO != null){
            response.setAgentSession(agentSessionWSDTO);
        }

        general.setOperation("apiGetAgentSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiSessionWSModel apiGetCampaignSessions(long agentId, String campaignId, String sessionState, int reqPage, int reqSize) {

        ApiSessionWSModel response = new ApiSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiSessionWSDTO sessionWSDTO = apiSessionFramework.apiGetCampaignSessionsService(agentId,campaignId,sessionState,reqPage,reqSize);
        if (sessionWSDTO != null){
            response.setSession(sessionWSDTO);
        }

        general.setOperation("apiGetCampaignSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSessionWSModel apiGetSessions(long agentId,String sessionState,int reqPage,int reqSize) {

        ApiSessionWSModel response = new ApiSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiSessionWSDTO sessionWSDTO = apiSessionFramework.apiGetSessionsService(agentId,sessionState,reqPage,reqSize);
        if (sessionWSDTO != null){
            response.setSession(sessionWSDTO);
        }

        general.setOperation("apiGetSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSessionWSModel apiGetSession(long agentId, long sessionId) {

        ApiSessionWSModel response = new ApiSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiSessionWSDTO sessionWSDTO = apiSessionFramework.apiGetSessionService(agentId,sessionId);
        if (sessionWSDTO != null){
            response.setSession(sessionWSDTO);
        }

        general.setOperation("apiGetSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSessionDetailsWSModel apiGetSessionDetails(long agentId, long sessionId) {

        ApiSessionDetailsWSModel response = new ApiSessionDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiSessionDetailsWSDTO sessionDetailsWSDTO = apiSessionFramework.apiGetSessionDetailsService(agentId,sessionId);
        if (sessionDetailsWSDTO != null) {
            response.setSessionDetails(sessionDetailsWSDTO);
        }

        general.setOperation("apiGetSessionDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiSummaryWSModel apiGetSessionSummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSummaryWSDTO> sessionSummary = apiSessionFramework.apiGetSessionSummaryService(agentId);
        if (sessionSummary != null){
            response.setSummaries(sessionSummary);
        }

        general.setOperation("apiGetSessionSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
