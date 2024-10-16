package com.faas.core.api.middleware.operation.manager.scenario;

import com.faas.core.api.framework.operation.manager.scenario.ApiOperationScenarioFramework;
import com.faas.core.api.model.ws.operation.manager.scenario.ApiOperationScenarioWSModel;
import com.faas.core.api.model.ws.operation.manager.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationScenarioMiddleware {


    @Autowired
    ApiOperationScenarioFramework apiOperationScenarioFramework;


    public ApiOperationScenarioWSModel apiGetOperationScenarios(long agentId, String operationId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = apiOperationScenarioFramework.apiGetOperationScenariosService(agentId, operationId);
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

    public ApiOperationScenarioWSModel apiGetOperationScenario(long agentId, String operationId, String runId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO operationScenarioWSDTO = apiOperationScenarioFramework.apiGetOperationScenarioService(agentId,operationId,runId);
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

    public ApiOperationScenarioWSModel apiRunOperationScenario(long agentId, String operationId, String scenarioId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO operationScenarioWSDTO = apiOperationScenarioFramework.apiRunOperationScenarioService(agentId, operationId, scenarioId);
        if (operationScenarioWSDTO != null) {
            operationScenarioWSDTOS.add(operationScenarioWSDTO);
        }

        response.setOperationScenarios(operationScenarioWSDTOS);
        general.setOperation("apiRunOperationScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationScenarioWSModel apiUpdateOperationScenario(long agentId, String operationId, String runId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO operationScenarioWSDTO = apiOperationScenarioFramework.apiUpdateOperationScenarioService(agentId, operationId, runId);
        if (operationScenarioWSDTO != null) {
            operationScenarioWSDTOS.add(operationScenarioWSDTO);
        }

        response.setOperationScenarios(operationScenarioWSDTOS);
        general.setOperation("apiUpdateOperationScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationScenarioWSModel apiRemoveOperationScenario(long agentId, String operationId, String runId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO operationScenarioWSDTO = apiOperationScenarioFramework.apiRemoveOperationScenarioService(agentId, operationId,runId);
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
