package com.faas.core.api.framework.operation.details.scenario;

import com.faas.core.api.model.ws.operation.details.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.api.model.ws.operation.details.scenario.dto.ApiProcessScenarioElementWSDTO;
import com.faas.core.api.model.ws.operation.details.scenario.dto.ApiProcessScenarioWSDTO;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationScenarioFramework {

    @Autowired
    OperationHelper operationHelper;

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
    AppUtils appUtils;


    public List<ApiOperationScenarioWSDTO> apiGetOperationScenariosService(long agentId,long sessionId,String processId) {

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();

        return operationScenarioWSDTOS;
    }


    public ApiOperationScenarioWSDTO apiGetOperationScenarioService(long agentId,long sessionId,String executeId) {


        return null;
    }


    public ApiOperationScenarioWSDTO apiExecuteOperationScenarioService(long agentId,long sessionId,String processId,String scenarioId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentIdAndProcessId(sessionId,agentId,processId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);

        return null;
    }

    public ApiOperationScenarioWSDTO apiUpdateOperationScenarioService(long agentId,long sessionId,String executeId) {


        return null;
    }

    public ApiOperationScenarioWSDTO apiRemoveOperationScenarioService(long agentId,long sessionId,String executeId) {


        return null;
    }


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


    public List<ApiProcessScenarioElementWSDTO> apiGetProcessScenarioElementsService(long agentId, long sessionId, String scenarioId) {

        List<ApiProcessScenarioElementWSDTO>scenarioElementWSDTOS = new ArrayList<>();
        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (sessionDBModel.isPresent() && scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null){

        }
        return scenarioElementWSDTOS;
    }

    public ApiProcessScenarioElementWSDTO apiGetProcessScenarioElementService(long agentId, long sessionId, String scenarioId, String elementId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (sessionDBModel.isPresent() && scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){

            }
        }
        return null;
    }


}
