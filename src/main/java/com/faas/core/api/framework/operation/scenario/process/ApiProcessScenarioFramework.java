package com.faas.core.api.framework.operation.scenario.process;

import com.faas.core.api.model.ws.operation.scenario.process.dto.ApiProcessScenarioWSDTO;
import com.faas.core.api.model.ws.operation.scenario.process.dto.ApiScenarioElementWSDTO;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.operation.scenario.OperationScenarioRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiProcessScenarioFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ActivityHelper activityHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    OperationScenarioRepository operationScenarioRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiProcessScenarioWSDTO> apiGetProcessScenariosService(long agentId, long sessionId, String processId) {

        List<ApiProcessScenarioWSDTO>processScenarioWSDTOS = new ArrayList<>();
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessId(processId);
        if (!processScenarioDBModels.isEmpty()){
            for (ProcessScenarioDBModel processScenarioDBModel : processScenarioDBModels) {
                processScenarioWSDTOS.add(new ApiProcessScenarioWSDTO(processScenarioDBModel));
            }
        }
        return processScenarioWSDTOS;
    }

    public ApiProcessScenarioWSDTO apiGetProcessScenarioService(long agentId, long sessionId, String processId, String scenarioId) {

        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        if (!processScenarioDBModels.isEmpty()){
            return new ApiProcessScenarioWSDTO(processScenarioDBModels.get(0));
        }
        return null;
    }


    public List<ApiScenarioElementWSDTO> apiGetProcessScenarioElementsService(long agentId, long sessionId, String scenarioId) {

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

    public ApiScenarioElementWSDTO apiGetProcessScenarioElementService(long agentId,long sessionId, String scenarioId,String elementId) {

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
