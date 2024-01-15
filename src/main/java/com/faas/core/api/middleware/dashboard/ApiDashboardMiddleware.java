package com.faas.core.api.middleware.dashboard;

import com.faas.core.api.framework.dashboard.ApiDashboardFramework;
import com.faas.core.api.model.ws.dashboard.ApiDashboardCampaignWSModel;
import com.faas.core.api.model.ws.dashboard.ApiDashboardOperationWSModel;
import com.faas.core.api.model.ws.dashboard.ApiDashboardWSModel;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardCampaignWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardOperationWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.api.model.ws.operation.details.validate.ApiOperationValidateWSModel;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.details.validate.dto.ApiOperationValidateWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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


    public ApiDashboardOperationWSModel apiGetDashboardOperations(long agentId,String operationType,String operationState,String operationInquiryState,String operationFlowState,int reqPage,int reqSize) {

        ApiDashboardOperationWSModel response = new ApiDashboardOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiDashboardOperationWSDTO dashboardOperationWSDTO = apiDashboardFramework.apiGetDashboardOperationsService(agentId,operationType,operationState,operationInquiryState,operationFlowState,reqPage,reqSize);
        if (dashboardOperationWSDTO != null){
            response.setDashboardOperation(dashboardOperationWSDTO);
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
        List<ApiOperationWSDTO>operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiDashboardFramework.apiGetDashboardOperationService(agentId,operationId);
        if (operationWSDTO != null){
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

        ApiOperationValidateWSDTO operationValidateWSDTO = apiDashboardFramework.apiDashboardOperationValidateService(agentId,operationId);
        if (operationValidateWSDTO != null){
            response.setOperationValidate(operationValidateWSDTO);
        }

        general.setOperation("apiDashboardOperationValidate");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiDashboardCampaignWSModel apiGetDashboardCampaigns(long agentId) {

        ApiDashboardCampaignWSModel response = new ApiDashboardCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiDashboardCampaignWSDTO> dashboardCampaignWSDTOS = apiDashboardFramework.apiGetDashboardCampaignsService(agentId);
        if (dashboardCampaignWSDTOS != null){
            response.setDashboardCampaigns(dashboardCampaignWSDTOS);
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
        if (dashboardSummaries != null){
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
