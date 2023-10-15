package com.faas.core.api.middleware.dashboard;

import com.faas.core.api.framework.dashboard.ApiDashboardFramework;
import com.faas.core.api.model.ws.campaign.content.ApiCampaignWSModel;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.dashboard.ApiDashboardWSModel;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.inquiry.content.ApiInquiryWSModel;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.api.model.ws.operation.content.ApiOperationSessionWSModel;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationSessionWSDTO;
import com.faas.core.api.model.ws.session.ApiSessionWSModel;
import com.faas.core.api.model.ws.session.dto.ApiSessionWSDTO;
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


    public ApiOperationSessionWSModel apiGetDashOperations(long agentId,String sessionType, String sessionState, int reqPage, int reqSize) {

        ApiOperationSessionWSModel response = new ApiOperationSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSessionWSDTO operationSession = apiDashboardFramework.apiGetDashOperationsService(agentId,sessionType,sessionState,reqPage,reqSize);
        if (operationSession != null){
            response.setOperationSession(operationSession);
        }

        general.setOperation("apiGetDashOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiCampaignWSModel apiGetDashCampaigns(long agentId) {

        ApiCampaignWSModel response = new ApiCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiCampaignWSDTO> campaignWSDTOS = apiDashboardFramework.apiDashCampaignsService(agentId);
        if (campaignWSDTOS != null){
            response.setCampaigns(campaignWSDTOS);
        }

        general.setOperation("apiGetDashCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiSummaryWSModel apiGetDashSummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSummaryWSDTO> summaries = apiDashboardFramework.apiGetDashSummaryService(agentId);
        if (summaries != null){
            response.setSummaries(summaries);
        }

        general.setOperation("apiGetDashSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
