package com.faas.core.api.middleware.dashboard;

import com.faas.core.api.framework.dashboard.ApiDashboardFramework;
import com.faas.core.api.model.ws.campaign.content.ApiCampaignWSModel;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.dashboard.ApiDashboardWSModel;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationListWSModel;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiDashboardMiddleware {


    @Autowired
    ApiDashboardFramework apiDashboardFramework;


    public ApiDashboardWSModel apiGetDashboard(long agentId,int reqPage,int reqSize) {

        ApiDashboardWSModel response = new ApiDashboardWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiDashboardWSDTO dashboardWSDTO = apiDashboardFramework.apiGetDashboardService(agentId,reqPage,reqSize);
        if (dashboardWSDTO != null){
            response.setDashboard(dashboardWSDTO);
        }

        general.setOperation("apiGetDashboard");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationListWSModel apiGetDashboardOperations(long agentId, String operationType, String operationState, int reqPage, int reqSize) {

        ApiOperationListWSModel response = new ApiOperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationListWSDTO operationListWSDTO = apiDashboardFramework.apiGetDashboardOperationsService(agentId,operationType,operationState,reqPage,reqSize);
        if (operationListWSDTO != null){
            response.setOperationList(operationListWSDTO);
        }

        general.setOperation("apiGetDashboardOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiCampaignWSModel apiGetDashboardCampaigns(long agentId) {

        ApiCampaignWSModel response = new ApiCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiCampaignWSDTO> campaignWSDTOS = apiDashboardFramework.apiGetDashboardCampaignsService(agentId);
        if (campaignWSDTOS != null){
            response.setCampaigns(campaignWSDTOS);
        }

        general.setOperation("apiGetDashboardCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiSummaryWSModel apiGetDashboardSummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSummaryWSDTO> summaries = apiDashboardFramework.apiGetDashboardSummaryService(agentId);
        if (summaries != null){
            response.setSummaries(summaries);
        }

        general.setOperation("apiGetDashboardSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
