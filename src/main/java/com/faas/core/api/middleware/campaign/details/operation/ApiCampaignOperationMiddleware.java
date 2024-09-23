package com.faas.core.api.middleware.campaign.details.operation;

import com.faas.core.api.framework.campaign.details.operation.ApiCampaignOperationFramework;
import com.faas.core.api.model.ws.operation.content.ApiOperationListWSModel;
import com.faas.core.api.model.ws.operation.content.ApiValidateOperationWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiValidateOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiCampaignOperationMiddleware {


    @Autowired
    ApiCampaignOperationFramework apiCampaignOperationFramework;


    public ApiOperationListWSModel apiGetCampaignOperations(long agentId, String campaignId, String operationState, int reqPage, int reqSize) {

        ApiOperationListWSModel response = new ApiOperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationListWSDTO operationListWSDTO = apiCampaignOperationFramework.apiGetCampaignOperationsService(agentId, campaignId, operationState, reqPage, reqSize);
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

        ApiOperationWSDTO operationWSDTO = apiCampaignOperationFramework.apiGetCampaignOperationService(agentId, operationId);
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


    public ApiValidateOperationWSModel apiCampaignOperationValidate(long agentId, String operationId) {

        ApiValidateOperationWSModel response = new ApiValidateOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiValidateOperationWSDTO validateOperationWSDTO = apiCampaignOperationFramework.apiCampaignOperationValidateService(agentId, operationId);
        if (validateOperationWSDTO != null) {
            response.setValidateOperation(validateOperationWSDTO);
        }

        general.setOperation("apiCampaignOperationValidate");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
