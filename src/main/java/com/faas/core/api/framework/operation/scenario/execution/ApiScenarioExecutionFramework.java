package com.faas.core.api.framework.operation.scenario.execution;

import com.faas.core.api.model.ws.operation.scenario.execution.dto.ApiScenarioExecutionWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.scenario.ScenarioExecutionDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.scenario.ScenarioExecutionRepository;
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
public class ApiScenarioExecutionFramework {



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
    ScenarioExecutionRepository scenarioExecutionRepository;

    @Autowired
    AppUtils appUtils;


    public ApiScenarioExecutionWSDTO apiScenarioExecuteService(long agentId,long sessionId,String processId,String scenarioId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentIdAndProcessId(sessionId,agentId,processId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);

        if (!sessionDBModels.isEmpty() && sessionDBModels.get(0).getSessionState().equalsIgnoreCase(AppConstant.ACTIVE_SESSION)
                && !operationDBModels.isEmpty() && operationDBModels.get(0).getOperationState().equalsIgnoreCase(AppConstant.ACTIVE_OPERATION)
                && scenarioDBModel.isPresent()){

            ScenarioExecutionDBModel scenarioExecutionDBModel = new ScenarioExecutionDBModel();
            scenarioExecutionDBModel.setSessionId(sessionId);
            scenarioExecutionDBModel.setAgentId(agentId);
            scenarioExecutionDBModel.setOperationId(operationDBModels.get(0).getId());
            scenarioExecutionDBModel.setCampaignId(sessionDBModels.get(0).getCampaignId());
            scenarioExecutionDBModel.setProcessId(sessionDBModels.get(0).getProcessId());
            scenarioExecutionDBModel.setScenarioId(scenarioDBModel.get().getId());
            scenarioExecutionDBModel.setScenario(scenarioDBModel.get().getScenario());
            scenarioExecutionDBModel.setScenarioType(scenarioDBModel.get().getScenarioType());
            scenarioExecutionDBModel.setBaseType(scenarioDBModel.get().getBaseType());
            scenarioExecutionDBModel.setExecutions(new ArrayList<>());
            scenarioExecutionDBModel.setExecutionState(AppConstant.READY_EXECUTION);
            scenarioExecutionDBModel.setuDate(appUtils.getCurrentTimeStamp());
            scenarioExecutionDBModel.setcDate(appUtils.getCurrentTimeStamp());
            scenarioExecutionDBModel.setStatus(1);

            return new ApiScenarioExecutionWSDTO(scenarioExecutionRepository.save(scenarioExecutionDBModel));
        }
        return null;
    }


    public List<ApiScenarioExecutionWSDTO> apiGetScenarioExecutionsService(long agentId,long sessionId,String processId) {

        List<ApiScenarioExecutionWSDTO> scenarioExecutionWSDTOS = new ArrayList<>();
        List<ScenarioExecutionDBModel> scenarioExecutionDBModels = scenarioExecutionRepository.findBySessionIdAndProcessId(sessionId,processId);
        for (ScenarioExecutionDBModel scenarioExecutionDBModel : scenarioExecutionDBModels) {
            scenarioExecutionWSDTOS.add(new ApiScenarioExecutionWSDTO(scenarioExecutionDBModel));
        }
        return scenarioExecutionWSDTOS;
    }


    public ApiScenarioExecutionWSDTO apiGetScenarioExecutionService(long agentId,long sessionId,String executionId) {

        List<ScenarioExecutionDBModel> scenarioExecutionDBModels = scenarioExecutionRepository.findByIdAndSessionId(executionId,sessionId);
        if (!scenarioExecutionDBModels.isEmpty()){
            return new ApiScenarioExecutionWSDTO(scenarioExecutionDBModels.get(0));
        }
        return null;
    }


    public ApiScenarioExecutionWSDTO apiUpdateScenarioExecutionService(long agentId, long sessionId,String executionId) {

        List<ScenarioExecutionDBModel> scenarioExecutionDBModels = scenarioExecutionRepository.findByIdAndSessionId(executionId,sessionId);
        if (!scenarioExecutionDBModels.isEmpty()){
            return new ApiScenarioExecutionWSDTO(scenarioExecutionDBModels.get(0));
        }
        return null;
    }


    public ApiScenarioExecutionWSDTO apiRemoveScenarioExecutionService(long agentId, long sessionId,String executionId) {

        List<ScenarioExecutionDBModel> scenarioExecutionDBModels = scenarioExecutionRepository.findByIdAndSessionId(executionId,sessionId);
        if (!scenarioExecutionDBModels.isEmpty()){
            scenarioExecutionRepository.delete(scenarioExecutionDBModels.get(0));
            return new ApiScenarioExecutionWSDTO(scenarioExecutionDBModels.get(0));
        }
        return null;
    }


}
