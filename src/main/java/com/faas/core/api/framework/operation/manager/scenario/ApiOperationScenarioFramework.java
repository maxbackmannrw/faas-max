package com.faas.core.api.framework.operation.manager.scenario;

import com.faas.core.api.model.ws.operation.manager.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.data.repo.operation.details.scenario.OperationScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationScenarioFramework {

    @Autowired
    OperationScenarioRepository operationScenarioRepository;


    public List<ApiOperationScenarioWSDTO> apiGetOperationScenariosService(long agentId, String operationId) {

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();

        return operationScenarioWSDTOS;
    }

    public ApiOperationScenarioWSDTO apiGetOperationScenarioService(long agentId, String operationId, String runId) {

        return null;
    }

    public ApiOperationScenarioWSDTO apiRunOperationScenarioService(long agentId, String operationId, String scenarioId) {

        return null;
    }

    public ApiOperationScenarioWSDTO apiUpdateOperationScenarioService(long agentId, String operationId, String runId) {

        return null;
    }

    public ApiOperationScenarioWSDTO apiRemoveOperationScenarioService(long agentId, String operationId, String runId) {

        return null;
    }



}
