package com.faas.core.api.middleware.operation.details.content;

import com.faas.core.api.framework.operation.details.content.ApiOperationDetailsFramework;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignDetailsWSModel;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.details.content.ApiOperationDetailsWSModel;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationDetailsMiddleware {


    @Autowired
    ApiOperationDetailsFramework apiOperationDetailsFramework;


    public ApiOperationDetailsWSModel apiGetOperationDetails(long agentId,String operationId) {

        ApiOperationDetailsWSModel response = new ApiOperationDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationDetailsWSDTO operationDetailsWSDTO = apiOperationDetailsFramework.apiGetOperationDetailsService(agentId,operationId);
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


    public ApiCampaignDetailsWSModel apiGetOperationCampaign(long agentId, String operationId) {

        ApiCampaignDetailsWSModel response = new ApiCampaignDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiCampaignDetailsWSDTO operationCampaign = apiOperationDetailsFramework.apiGetOperationCampaignService(agentId,operationId);
        if (operationCampaign != null){
            response.setCampaignDetails(operationCampaign);
        }

        general.setOperation("apiGetOperationCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSummaryWSModel apiGetOperationDetailsSummary(long agentId,String operationId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSummaryWSDTO> operationSummary = apiOperationDetailsFramework.apiGetOperationDetailsSummaryService(agentId,operationId);
        if (operationSummary != null){
            response.setSummaries(operationSummary);
        }

        general.setOperation("apiGetOperationDetailsSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWSModel apiOperationLaunch(long agentId,String operationId) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO>operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiOperationDetailsFramework.apiOperationLaunchService(agentId,operationId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiOperationLaunch");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWSModel apiOperationFinish(long agentId,String operationId,String operationState) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO>operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiOperationDetailsFramework.apiOperationFinishService(agentId,operationId,operationState);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiOperationFinish");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
