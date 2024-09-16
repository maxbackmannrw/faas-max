package com.faas.core.api.middleware.dashboard;

import com.faas.core.api.framework.dashboard.ApiDashboardFramework;
import com.faas.core.data.ws.api.campaign.content.ApiCampaignWSModel;
import com.faas.core.data.ws.api.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.data.ws.api.dashboard.ApiDashboardWSModel;
import com.faas.core.data.ws.api.dashboard.dto.ApiDashboardWSDTO;
import com.faas.core.data.ws.api.general.ApiSummaryWSDTO;
import com.faas.core.data.ws.api.general.ApiSummaryWSModel;
import com.faas.core.data.ws.api.operation.content.ApiOperationListWSModel;
import com.faas.core.data.ws.api.operation.content.ApiOperationValidateWSModel;
import com.faas.core.data.ws.api.operation.content.ApiOperationWSModel;
import com.faas.core.data.ws.api.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.data.ws.api.operation.content.dto.ApiOperationValidateWSDTO;
import com.faas.core.data.ws.api.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiDashboardMiddleware {


    @Autowired
    ApiDashboardFramework apiDashboardFramework;


    public ApiDashboardWSModel apiGetDashboard(long agentId, int reqPage, int reqSize) {

        ApiDashboardWSModel response = new ApiDashboardWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiDashboardWSDTO dashboardWSDTO = apiDashboardFramework.apiGetDashboardService(agentId, reqPage, reqSize);
        if (dashboardWSDTO != null) {
            response.setDashboard(dashboardWSDTO);
        }

        general.setOperation("apiGetDashboard");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationListWSModel apiGetDashboardOperations(long agentId, String operationType, String operationState, String operationInquiryState, String operationFlowState, int reqPage, int reqSize) {

        ApiOperationListWSModel response = new ApiOperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationListWSDTO operationListWSDTO = apiDashboardFramework.apiGetDashboardOperationsService(agentId, operationType, operationState, operationInquiryState, operationFlowState, reqPage, reqSize);
        if (operationListWSDTO != null) {
            response.setOperationList(operationListWSDTO);
        }

        general.setOperation("apiGetDashboardOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWSModel apiGetDashboardOperation(long agentId, String operationId) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiDashboardFramework.apiGetDashboardOperationService(agentId, operationId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiGetDashboardOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationValidateWSModel apiDashboardOperationValidate(long agentId, String operationId) {

        ApiOperationValidateWSModel response = new ApiOperationValidateWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationValidateWSDTO operationValidateWSDTO = apiDashboardFramework.apiDashboardOperationValidateService(agentId, operationId);
        if (operationValidateWSDTO != null) {
            response.setOperationValidate(operationValidateWSDTO);
        }

        general.setOperation("apiDashboardOperationValidate");
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
        if (campaignWSDTOS != null) {
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

        List<ApiSummaryWSDTO> dashboardSummaries = apiDashboardFramework.apiGetDashboardSummaryService(agentId);
        if (dashboardSummaries != null) {
            response.setSummaries(dashboardSummaries);
        }

        general.setOperation("apiGetDashboardSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
