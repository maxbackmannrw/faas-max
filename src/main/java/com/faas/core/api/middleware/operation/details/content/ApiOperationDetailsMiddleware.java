package com.faas.core.api.middleware.operation.details.content;

import com.faas.core.api.framework.operation.details.content.ApiOperationDetailsFramework;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.operation.details.content.ApiOperationCampaignWSModel;
import com.faas.core.api.model.ws.operation.details.content.ApiOperationDetailsWSModel;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiOperationDetailsMiddleware {


    @Autowired
    ApiOperationDetailsFramework apiOperationDetailsFramework;


    public ApiOperationDetailsWSModel apiGetOperationDetails(long agentId, long sessionId, long clientId, String campaignId, String processId, String operationId) {

        ApiOperationDetailsWSModel response = new ApiOperationDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationDetailsWSDTO operationDetailsWSDTO = apiOperationDetailsFramework.apiGetOperationDetailsService(agentId,sessionId,clientId,campaignId,processId,operationId);
        if (operationDetailsWSDTO != null){
            response.setOperationDetails(operationDetailsWSDTO);
        }

        general.setOperation("apiGetOperationDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationCampaignWSModel apiGetOperationCampaign(long agentId, long sessionId, long clientId, String campaignId, String processId) {

        ApiOperationCampaignWSModel response = new ApiOperationCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationCampaignWSDTO operationCampaignWSDTO = apiOperationDetailsFramework.apiGetOperationCampaignService(sessionId,clientId,campaignId,processId);
        if (operationCampaignWSDTO != null){
            response.setCampaign(operationCampaignWSDTO);
        }

        general.setOperation("apiGetOperationCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSummaryWSModel apiGetOperationSummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSummaryWSDTO> sessionSummary = apiOperationDetailsFramework.apiGetOperationSummaryService(agentId);
        if (sessionSummary != null){
            response.setSummaries(sessionSummary);
        }

        general.setOperation("apiGetOperationSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
