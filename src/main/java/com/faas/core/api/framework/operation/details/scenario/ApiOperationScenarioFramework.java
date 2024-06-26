package com.faas.core.api.framework.operation.details.scenario;

import com.faas.core.api.model.ws.operation.details.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.api.model.ws.operation.details.scenario.dto.ApiProcessScenarioWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.content.dao.OperationScenarioDAO;
import com.faas.core.base.model.db.campaign.details.scenario.CampaignScenarioDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.campaign.details.scenario.CampaignScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.scenario.ScenarioHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationScenarioFramework {

    @Autowired
    ScenarioHelpers scenarioHelpers;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    CampaignScenarioRepository campaignScenarioRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationScenarioWSDTO> apiGetOperationScenariosService(long agentId,String operationId) {

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);

        return operationScenarioWSDTOS;
    }


    public ApiOperationScenarioWSDTO apiGetOperationScenarioService(long agentId,String operationId,String executeId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        return null;
    }


    public ApiOperationScenarioWSDTO apiOperationExecuteScenarioService(long agentId,String operationId,String scenarioId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){

        }
        return null;
    }


    public ApiOperationScenarioWSDTO apiUpdateOperationScenarioService(long agentId,String operationId,String executeId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);

        return null;
    }


    public ApiOperationScenarioWSDTO apiRemoveOperationScenarioService(long agentId,String operationId,String executeId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);

        return null;
    }


    public List<ApiProcessScenarioWSDTO> apiGetOperationProcessScenariosService(long agentId,String operationId) {

        List<ApiProcessScenarioWSDTO>processScenarioWSDTOS = new ArrayList<>();

        return processScenarioWSDTOS;
    }

    public ApiProcessScenarioWSDTO apiGetOperationProcessScenarioService(long agentId,String operationId,String scenarioId) {


        return null;
    }


}
