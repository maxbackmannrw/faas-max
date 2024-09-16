package com.faas.core.api.middleware.operation.details.scenario;

import com.faas.core.api.framework.operation.details.scenario.ApiOperationScenarioFramework;
import com.faas.core.data.ws.api.operation.details.scenario.ApiOperationScenarioWSModel;
import com.faas.core.data.ws.api.operation.details.scenario.ApiProcessScenarioWSModel;
import com.faas.core.data.ws.api.operation.details.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.data.ws.api.operation.details.scenario.dto.ApiProcessScenarioWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;
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


    public ApiOperationScenarioWSModel apiGetOperationScenario(long agentId, String operationId, String executeId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO operationScenarioWSDTO = apiOperationScenarioFramework.apiGetOperationScenarioService(agentId, operationId, executeId);
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

        ApiOperationScenarioWSDTO scenarioExecutionWSDTO = apiOperationScenarioFramework.apiOperationExecuteScenarioService(agentId, operationId, scenarioId);
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

        ApiOperationScenarioWSDTO scenarioExecutionWSDTO = apiOperationScenarioFramework.apiUpdateOperationScenarioService(agentId, operationId, executeId);
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

        ApiOperationScenarioWSDTO operationScenarioWSDTO = apiOperationScenarioFramework.apiRemoveOperationScenarioService(agentId, operationId, executeId);
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


    public ApiProcessScenarioWSModel apiGetOperationProcessScenarios(long agentId, String operationId) {

        ApiProcessScenarioWSModel response = new ApiProcessScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiProcessScenarioWSDTO> processScenarioWSDTOS = apiOperationScenarioFramework.apiGetOperationProcessScenariosService(agentId, operationId);
        if (processScenarioWSDTOS != null) {
            response.setProcessScenarios(processScenarioWSDTOS);
        }

        general.setOperation("apiGetOperationProcessScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiProcessScenarioWSModel apiGetOperationProcessScenario(long agentId, String operationId, String scenarioId) {

        ApiProcessScenarioWSModel response = new ApiProcessScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiProcessScenarioWSDTO> processScenarioWSDTOS = new ArrayList<>();

        ApiProcessScenarioWSDTO processScenarioWSDTO = apiOperationScenarioFramework.apiGetOperationProcessScenarioService(agentId, operationId, scenarioId);
        if (processScenarioWSDTO != null) {
            processScenarioWSDTOS.add(processScenarioWSDTO);
        }

        response.setProcessScenarios(processScenarioWSDTOS);
        general.setOperation("apiGetOperationProcessScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
