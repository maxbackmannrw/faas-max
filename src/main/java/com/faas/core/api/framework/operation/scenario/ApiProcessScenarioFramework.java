package com.faas.core.api.framework.operation.scenario;

import com.faas.core.api.model.ws.operation.scenario.dto.ApiProcessScenarioWSDTO;
import com.faas.core.api.model.ws.operation.scenario.dto.ApiScenarioElementWSDTO;
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

        List<ApiProcessScenarioWSDTO>scenarioWSDTOS = new ArrayList<>();
        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessId(processId);
        if (sessionDBModel.isPresent() && !processScenarioDBModels.isEmpty()){
            for (ProcessScenarioDBModel processScenarioDBModel : processScenarioDBModels) {
                Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(processScenarioDBModel.getScenarioId());
                if (scenarioDBModel.isPresent()) {
                    scenarioWSDTOS.add(new ApiProcessScenarioWSDTO(scenarioDBModel.get(), processScenarioDBModel));
                }
            }
        }
        return scenarioWSDTOS;
    }


    public ApiProcessScenarioWSDTO apiGetProcessScenarioService(long agentId, long sessionId, String processId, String scenarioId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (sessionDBModel.isPresent() && !processScenarioDBModels.isEmpty() && scenarioDBModel.isPresent()){
            return new ApiProcessScenarioWSDTO(scenarioDBModel.get(),processScenarioDBModels.get(0));
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
