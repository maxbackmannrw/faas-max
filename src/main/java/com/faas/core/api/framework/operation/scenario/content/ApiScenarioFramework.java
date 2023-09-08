package com.faas.core.api.framework.operation.scenario.content;

import com.faas.core.api.model.ws.operation.scenario.content.dto.*;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.repo.operation.scenario.ScenarioExecutionRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiScenarioFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ActivityHelper activityHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    ScenarioExecutionRepository scenarioExecutionRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationScenarioWSDTO apiGetOperationScenarioService(long agentId,long sessionId,String processId) {
        return operationHelper.mapApiOperationScenarioWSDTO(sessionId,processId);
    }


    public List<ApiScenarioWSDTO> apiGetScenariosService(long agentId,long sessionId,String processId) {

        List<ApiScenarioWSDTO>scenarioWSDTOS = new ArrayList<>();
        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessId(processId);
        if (sessionDBModel.isPresent() && !processScenarioDBModels.isEmpty()){
            for (ProcessScenarioDBModel processScenarioDBModel : processScenarioDBModels) {
                Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(processScenarioDBModel.getScenarioId());
                if (scenarioDBModel.isPresent()) {
                    scenarioWSDTOS.add(new ApiScenarioWSDTO(scenarioDBModel.get(), processScenarioDBModel));
                }
            }
        }
        return scenarioWSDTOS;
    }


    public ApiScenarioWSDTO apiGetScenarioService(long agentId,long sessionId,String processId,String scenarioId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (sessionDBModel.isPresent() && !processScenarioDBModels.isEmpty() && scenarioDBModel.isPresent()){
            return new ApiScenarioWSDTO(scenarioDBModel.get(),processScenarioDBModels.get(0));
        }
        return null;
    }


    public ApiScenarioDetailsWSDTO apiGetScenarioDetailsService(long agentId, long sessionId, String processId, String scenarioId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        if (sessionDBModel.isPresent() && scenarioDBModel.isPresent() && !processScenarioDBModels.isEmpty()){
            return new ApiScenarioDetailsWSDTO(scenarioDBModel.get(),processScenarioDBModels.get(0));
        }
        return null;
    }


    public List<ApiScenarioElementWSDTO> apiGetScenarioElementsService(long agentId,long sessionId,String scenarioId) {

        List<ApiScenarioElementWSDTO>scenarioElementWSDTOS = new ArrayList<>();
        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (sessionDBModel.isPresent() && scenarioDBModel.isPresent() && scenarioDBModel.get().getElements() != null){
            for (int i=0;i<scenarioDBModel.get().getElements().size();i++){
                scenarioElementWSDTOS.add(new ApiScenarioElementWSDTO(scenarioDBModel.get().getElements().get(i)));
            }
        }
        return scenarioElementWSDTOS;
    }


    public ApiScenarioElementWSDTO apiGetScenarioElementService(long agentId,long sessionId, String scenarioId,String elementId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (sessionDBModel.isPresent() && scenarioDBModel.isPresent() && scenarioDBModel.get().getElements() != null){
            for (int i=0;i<scenarioDBModel.get().getElements().size();i++){
                if (scenarioDBModel.get().getElements().get(i).getId().equalsIgnoreCase(elementId)){
                    return new ApiScenarioElementWSDTO(scenarioDBModel.get().getElements().get(i));
                }
            }
        }
        return null;
    }




}
