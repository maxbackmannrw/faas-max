package com.faas.core.api.middleware.operation.manager.campaign;

import com.faas.core.api.framework.operation.manager.campaign.ApiOperationCampaignFramework;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignDetailsWSModel;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.operation.manager.campaign.ApiOperationScenarioWSModel;
import com.faas.core.api.model.ws.operation.manager.campaign.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationCampaignMiddleware {


    @Autowired
    ApiOperationCampaignFramework apiOperationCampaignFramework;


    public ApiCampaignDetailsWSModel apiGetOperationCampaign(long agentId, String operationId) {

        ApiCampaignDetailsWSModel response = new ApiCampaignDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiCampaignDetailsWSDTO operationCampaign = apiOperationCampaignFramework.apiGetOperationCampaignService(agentId, operationId);
        if (operationCampaign != null) {
            response.setCampaignDetails(operationCampaign);
        }

        general.setOperation("apiGetOperationCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationScenarioWSModel apiGetOperationScenarios(long agentId, String operationId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = apiOperationCampaignFramework.apiGetOperationScenariosService(agentId, operationId);
        if (operationScenarioWSDTOS != null) {
            response.setOperationScenarios(operationScenarioWSDTOS);
        }

        general.setOperation("apiGetOperationScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationScenarioWSModel apiGetOperationScenario(long agentId, String operationId, String executeId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO operationScenarioWSDTO = apiOperationCampaignFramework.apiGetOperationScenarioService(agentId, operationId, executeId);
        if (operationScenarioWSDTO != null) {
            operationScenarioWSDTOS.add(operationScenarioWSDTO);
        }

        response.setOperationScenarios(operationScenarioWSDTOS);
        general.setOperation("apiGetOperationScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationScenarioWSModel apiOperationExecuteScenario(long agentId, String operationId, String scenarioId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO> scenarioExecutionWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO scenarioExecutionWSDTO = apiOperationCampaignFramework.apiOperationExecuteScenarioService(agentId, operationId, scenarioId);
        if (scenarioExecutionWSDTO != null) {
            scenarioExecutionWSDTOS.add(scenarioExecutionWSDTO);
        }

        response.setOperationScenarios(scenarioExecutionWSDTOS);
        general.setOperation("apiOperationExecuteScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationScenarioWSModel apiUpdateOperationScenario(long agentId, String operationId, String executeId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO> scenarioExecutionWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO scenarioExecutionWSDTO = apiOperationCampaignFramework.apiUpdateOperationScenarioService(agentId, operationId, executeId);
        if (scenarioExecutionWSDTO != null) {
            scenarioExecutionWSDTOS.add(scenarioExecutionWSDTO);
        }

        response.setOperationScenarios(scenarioExecutionWSDTOS);
        general.setOperation("apiUpdateOperationScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationScenarioWSModel apiRemoveOperationScenario(long agentId, String operationId, String executeId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO operationScenarioWSDTO = apiOperationCampaignFramework.apiRemoveOperationScenarioService(agentId, operationId, executeId);
        if (operationScenarioWSDTO != null) {
            operationScenarioWSDTOS.add(operationScenarioWSDTO);
        }

        response.setOperationScenarios(operationScenarioWSDTOS);
        general.setOperation("apiRemoveOperationScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
