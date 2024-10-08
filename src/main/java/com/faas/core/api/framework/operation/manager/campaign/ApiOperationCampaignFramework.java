package com.faas.core.api.framework.operation.manager.campaign;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.operation.manager.campaign.dto.ApiOperationScenarioWSDTO;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.repo.operation.content.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationCampaignFramework {


    @Autowired
    OperationRepository operationRepository;


    public ApiCampaignDetailsWSDTO apiGetOperationCampaignService(long agentId, String operationId) {

        return null;
    }

    public List<ApiOperationScenarioWSDTO> apiGetOperationScenariosService(long agentId, String operationId) {

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);

        return operationScenarioWSDTOS;
    }

    public ApiOperationScenarioWSDTO apiGetOperationScenarioService(long agentId, String operationId, String executeId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        return null;
    }

    public ApiOperationScenarioWSDTO apiOperationExecuteScenarioService(long agentId, String operationId, String scenarioId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {

        }
        return null;
    }

    public ApiOperationScenarioWSDTO apiUpdateOperationScenarioService(long agentId, String operationId, String executeId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);

        return null;
    }

    public ApiOperationScenarioWSDTO apiRemoveOperationScenarioService(long agentId, String operationId, String executeId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);

        return null;
    }



}
