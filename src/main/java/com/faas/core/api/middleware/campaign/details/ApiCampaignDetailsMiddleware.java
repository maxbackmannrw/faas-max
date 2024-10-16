package com.faas.core.api.middleware.campaign.details;

import com.faas.core.api.framework.campaign.details.ApiCampaignDetailsFramework;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignDetailsWSModel;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignScenarioWSModel;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignScenarioWSDTO;
import com.faas.core.api.model.ws.general.dto.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationListWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.api.model.ws.operation.content.ApiValidateOperationWSModel;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiValidateOperationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiCampaignDetailsMiddleware {


    @Autowired
    ApiCampaignDetailsFramework apiCampaignDetailsFramework;


    public ApiCampaignDetailsWSModel apiGetCampaignDetails(long agentId, String campaignId) {

        ApiCampaignDetailsWSModel response = new ApiCampaignDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiCampaignDetailsWSDTO campaignDetailsWSDTO = apiCampaignDetailsFramework.apiGetCampaignDetailsService(agentId, campaignId);
        if (campaignDetailsWSDTO != null) {
            response.setCampaignDetails(campaignDetailsWSDTO);
        }

        general.setOperation("apiGetCampaignDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiCampaignScenarioWSModel apiGetCampaignScenarios(long agentId, String campaignId) {

        ApiCampaignScenarioWSModel response = new ApiCampaignScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiCampaignScenarioWSDTO>campaignScenarioWSDTOS = apiCampaignDetailsFramework.apiGetCampaignScenariosService(agentId, campaignId);
        if (campaignScenarioWSDTOS != null) {
            response.setCampaignScenarios(campaignScenarioWSDTOS);
        }

        general.setOperation("apiGetCampaignScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiCampaignScenarioWSModel apiGetCampaignScenario(long agentId,String campaignId,String scenarioId) {

        ApiCampaignScenarioWSModel response = new ApiCampaignScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiCampaignScenarioWSDTO> campaignScenarioWSDTOS = new ArrayList<>();

        ApiCampaignScenarioWSDTO campaignDetailsWSDTO = apiCampaignDetailsFramework.apiGetCampaignScenarioService(agentId,campaignId,scenarioId);
        if (campaignDetailsWSDTO != null) {
            campaignScenarioWSDTOS.add(campaignDetailsWSDTO);
        }

        response.setCampaignScenarios(campaignScenarioWSDTOS);
        general.setOperation("apiGetCampaignScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationListWSModel apiGetCampaignOperations(long agentId, String campaignId, String operationState, int reqPage, int reqSize) {

        ApiOperationListWSModel response = new ApiOperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationListWSDTO operationListWSDTO = apiCampaignDetailsFramework.apiGetCampaignOperationsService(agentId, campaignId, operationState, reqPage, reqSize);
        if (operationListWSDTO != null) {
            response.setOperationList(operationListWSDTO);
        }

        general.setOperation("apiGetCampaignOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiGetCampaignOperation(long agentId, String operationId) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiCampaignDetailsFramework.apiGetCampaignOperationService(agentId, operationId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiGetCampaignOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiValidateOperationWSModel apiValidateCampaignOperation(long agentId, String operationId) {

        ApiValidateOperationWSModel response = new ApiValidateOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiValidateOperationWSDTO validateOperationWSDTO = apiCampaignDetailsFramework.apiValidateCampaignOperationService(agentId, operationId);
        if (validateOperationWSDTO != null) {
            response.setValidateOperation(validateOperationWSDTO);
        }

        general.setOperation("apiValidateCampaignOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiSummaryWSModel apiGetCampaignDetailsSummary(long agentId, String campaignId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSummaryWSDTO> campaignDetailsSummary = apiCampaignDetailsFramework.apiGetCampaignDetailsSummaryService(agentId, campaignId);
        if (campaignDetailsSummary != null) {
            response.setSummaries(campaignDetailsSummary);
        }

        general.setOperation("apiGetCampaignDetailsSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
