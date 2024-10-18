package com.faas.core.api.middleware.operation.manager.campaign;

import com.faas.core.api.framework.operation.manager.campaign.ApiOperationCampaignFramework;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignScenarioWSModel;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignScenarioWSDTO;
import com.faas.core.api.model.ws.operation.manager.campaign.ApiOperationCampaignScriptWSModel;
import com.faas.core.api.model.ws.operation.manager.campaign.ApiOperationCampaignWSModel;
import com.faas.core.api.model.ws.operation.manager.campaign.dto.ApiOperationCampaignWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.data.db.campaign.content.dao.CampaignScriptDAO;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationCampaignMiddleware {


    @Autowired
    ApiOperationCampaignFramework apiOperationCampaignFramework;


    public ApiOperationCampaignWSModel apiGetOperationCampaign(long agentId, String campaignId) {

        ApiOperationCampaignWSModel response = new ApiOperationCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationCampaignWSDTO operationCampaign = apiOperationCampaignFramework.apiGetOperationCampaignService(agentId,campaignId);
        if (operationCampaign != null) {
            response.setCampaign(operationCampaign);
        }

        general.setOperation("apiGetOperationCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationCampaignScriptWSModel apiGetOperationCampaignScripts(long agentId, String campaignId) {

        ApiOperationCampaignScriptWSModel response = new ApiOperationCampaignScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignScriptDAO> campaignScripts = apiOperationCampaignFramework.apiGetOperationCampaignScriptsService(agentId, campaignId);
        if (campaignScripts != null) {
            response.setCampaignScripts(campaignScripts);
        }

        general.setOperation("apiGetOperationCampaignScripts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiCampaignScenarioWSModel apiGetOperationCampaignScenarios(long agentId, String campaignId) {

        ApiCampaignScenarioWSModel response = new ApiCampaignScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiCampaignScenarioWSDTO> campaignScenarioWSDTOS = apiOperationCampaignFramework.apiGetOperationCampaignScenariosService(agentId, campaignId);
        if (campaignScenarioWSDTOS != null) {
            response.setCampaignScenarios(campaignScenarioWSDTOS);
        }

        general.setOperation("apiGetOperationCampaignScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiCampaignScenarioWSModel apiGetOperationCampaignScenario(long agentId, String campaignId, String scenarioId) {

        ApiCampaignScenarioWSModel response = new ApiCampaignScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiCampaignScenarioWSDTO> campaignScenarioWSDTOS = new ArrayList<>();

        ApiCampaignScenarioWSDTO campaignScenarioWSDTO = apiOperationCampaignFramework.apiGetOperationCampaignScenarioService(agentId, campaignId, scenarioId);
        if (campaignScenarioWSDTO != null) {
            campaignScenarioWSDTOS.add(campaignScenarioWSDTO);
        }

        response.setCampaignScenarios(campaignScenarioWSDTOS);
        general.setOperation("apiGetOperationCampaignScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}