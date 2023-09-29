package com.faas.core.api.middleware.operation.scenario.content;

import com.faas.core.api.framework.operation.scenario.content.ApiOperationScenarioFramework;
import com.faas.core.api.model.ws.operation.scenario.content.ApiOperationScenarioWSModel;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationScenarioMiddleware {


    @Autowired
    ApiOperationScenarioFramework apiOperationScenarioFramework;


    public ApiOperationScenarioWSModel apiGetOperationScenarios(long agentId, long sessionId, String processId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = apiOperationScenarioFramework.apiGetOperationScenariosService(agentId,sessionId,processId);
        if (operationScenarioWSDTOS != null){
            response.setOperationScenarios(operationScenarioWSDTOS);
        }

        general.setOperation("apiGetOperationScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationScenarioWSModel apiGetOperationScenario(long agentId, long sessionId, String executionId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO>operationScenarioWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO operationScenarioWSDTO =  apiOperationScenarioFramework.apiGetOperationScenarioService(agentId,sessionId,executionId);
        if (operationScenarioWSDTO != null){
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


    public ApiOperationScenarioWSModel apiExecuteOperationScenario(long agentId, long sessionId, String processId, String scenarioId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO scenarioExecutionWSDTO =  apiOperationScenarioFramework.apiExecuteOperationScenarioService(agentId,sessionId,processId,scenarioId);
        if (scenarioExecutionWSDTO != null){
            scenarioExecutionWSDTOS.add(scenarioExecutionWSDTO);
        }

        response.setOperationScenarios(scenarioExecutionWSDTOS);
        general.setOperation("apiExecuteOperationScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationScenarioWSModel apiUpdateOperationScenario(long agentId, long sessionId, String executionId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO scenarioExecutionWSDTO =  apiOperationScenarioFramework.apiUpdateOperationScenarioService(agentId,sessionId,executionId);
        if (scenarioExecutionWSDTO != null){
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


    public ApiOperationScenarioWSModel apiRemoveOperationScenario(long agentId, long sessionId, long clientId, String executionId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO>operationScenarioWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO operationScenarioWSDTO =  apiOperationScenarioFramework.apiRemoveOperationScenarioService(agentId,sessionId,executionId);
        if (operationScenarioWSDTO != null){
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
