package com.faas.core.api.framework.operation.scenario.content;

import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.scenario.OperationScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.scenario.OperationScenarioRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationScenarioFramework {



    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    OperationScenarioRepository operationScenarioRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationScenarioWSDTO> apiGetOperationScenariosService(long agentId, long sessionId, String processId) {

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();
        List<OperationScenarioDBModel> operationScenarioDBModels = operationScenarioRepository.findBySessionIdAndProcessId(sessionId,processId);
        for (OperationScenarioDBModel operationScenarioDBModel : operationScenarioDBModels) {
            operationScenarioWSDTOS.add(new ApiOperationScenarioWSDTO(operationScenarioDBModel));
        }
        return operationScenarioWSDTOS;
    }


    public ApiOperationScenarioWSDTO apiGetOperationScenarioService(long agentId, long sessionId, String executionId) {

        List<OperationScenarioDBModel> operationScenarioDBModels = operationScenarioRepository.findByIdAndSessionId(executionId,sessionId);
        if (!operationScenarioDBModels.isEmpty()){
            return new ApiOperationScenarioWSDTO(operationScenarioDBModels.get(0));
        }
        return null;
    }


    public ApiOperationScenarioWSDTO apiExecuteOperationScenarioService(long agentId, long sessionId, String processId, String scenarioId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentIdAndProcessId(sessionId,agentId,processId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);

        if (!sessionDBModels.isEmpty() && sessionDBModels.get(0).getSessionState().equalsIgnoreCase(AppConstant.ACTIVE_SESSION)
                && !operationDBModels.isEmpty() && operationDBModels.get(0).getOperationState().equalsIgnoreCase(AppConstant.ACTIVE_OPERATION)
                && scenarioDBModel.isPresent()){

            OperationScenarioDBModel operationScenarioDBModel = new OperationScenarioDBModel();
            operationScenarioDBModel.setSessionId(sessionId);
            operationScenarioDBModel.setAgentId(agentId);
            operationScenarioDBModel.setOperationId(operationDBModels.get(0).getId());
            operationScenarioDBModel.setCampaignId(sessionDBModels.get(0).getCampaignId());
            operationScenarioDBModel.setProcessId(sessionDBModels.get(0).getProcessId());
            operationScenarioDBModel.setScenarioId(scenarioDBModel.get().getId());
            operationScenarioDBModel.setScenario(scenarioDBModel.get().getScenario());
            operationScenarioDBModel.setScenarioType(scenarioDBModel.get().getScenarioType());
            operationScenarioDBModel.setBaseType(scenarioDBModel.get().getBaseType());
            operationScenarioDBModel.setScenarioExecutions(new ArrayList<>());
            operationScenarioDBModel.setExecutionState(AppConstant.READY_EXECUTION);
            operationScenarioDBModel.setuDate(appUtils.getCurrentTimeStamp());
            operationScenarioDBModel.setcDate(appUtils.getCurrentTimeStamp());
            operationScenarioDBModel.setStatus(1);

            return new ApiOperationScenarioWSDTO(operationScenarioRepository.save(operationScenarioDBModel));
        }
        return null;
    }


    public ApiOperationScenarioWSDTO apiUpdateOperationScenarioService(long agentId, long sessionId, String executionId) {

        List<OperationScenarioDBModel> operationScenarioDBModels = operationScenarioRepository.findByIdAndSessionId(executionId,sessionId);
        if (!operationScenarioDBModels.isEmpty()){
            return new ApiOperationScenarioWSDTO(operationScenarioDBModels.get(0));
        }
        return null;
    }


    public ApiOperationScenarioWSDTO apiRemoveOperationScenarioService(long agentId, long sessionId, String executionId) {

        List<OperationScenarioDBModel> operationScenarioDBModels = operationScenarioRepository.findByIdAndSessionId(executionId,sessionId);
        if (!operationScenarioDBModels.isEmpty()){
            operationScenarioRepository.delete(operationScenarioDBModels.get(0));
            return new ApiOperationScenarioWSDTO(operationScenarioDBModels.get(0));
        }
        return null;
    }


}