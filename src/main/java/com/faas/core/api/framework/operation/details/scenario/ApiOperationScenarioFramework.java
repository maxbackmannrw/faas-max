package com.faas.core.api.framework.operation.details.scenario;

import com.faas.core.api.model.ws.operation.details.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.api.model.ws.operation.details.scenario.dto.ApiProcessScenarioElementWSDTO;
import com.faas.core.api.model.ws.operation.details.scenario.dto.ApiProcessScenarioWSDTO;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.scenario.OperationScenarioDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.scenario.OperationScenarioRepository;
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
    OperationScenarioRepository operationScenarioRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationScenarioWSDTO> apiGetOperationScenariosService(long agentId,long sessionId,String processId) {

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();
        List<OperationScenarioDBModel> operationScenarioDBModels = operationScenarioRepository.findBySessionIdAndProcessId(sessionId,processId);
        for (OperationScenarioDBModel operationScenarioDBModel : operationScenarioDBModels) {
            operationScenarioWSDTOS.add(operationHelper.getApiOperationScenarioWSDTO(operationScenarioDBModel));
        }
        return operationScenarioWSDTOS;
    }


    public ApiOperationScenarioWSDTO apiGetOperationScenarioService(long agentId,long sessionId,String executeId) {

        List<OperationScenarioDBModel> operationScenarioDBModels = operationScenarioRepository.findByIdAndSessionId(executeId,sessionId);
        if (!operationScenarioDBModels.isEmpty()){
            return operationHelper.getApiOperationScenarioWSDTO(operationScenarioDBModels.get(0));
        }
        return null;
    }


    public ApiOperationScenarioWSDTO apiExecuteOperationScenarioService(long agentId,long sessionId,String processId,String scenarioId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentIdAndProcessId(sessionId,agentId,processId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);

        if (!sessionDBModels.isEmpty() && sessionDBModels.get(0).getSessionState().equalsIgnoreCase(AppConstant.ACTIVE_SESSION) && !operationDBModels.isEmpty()
                && operationDBModels.get(0).getOperationState().equalsIgnoreCase(AppConstant.ACTIVE_OPERATION) && scenarioDBModel.isPresent()){

            OperationScenarioDBModel operationScenarioDBModel = new OperationScenarioDBModel();
            operationScenarioDBModel.setSessionId(sessionId);
            operationScenarioDBModel.setAgentId(agentId);
            operationScenarioDBModel.setOperationId(operationDBModels.get(0).getId());
            operationScenarioDBModel.setCampaignId(sessionDBModels.get(0).getCampaignId());
            operationScenarioDBModel.setProcessId(sessionDBModels.get(0).getProcessId());
            operationScenarioDBModel.setScenarioId(scenarioDBModel.get().getId());
            operationScenarioDBModel.setScenario(scenarioDBModel.get().getScenario());
            operationScenarioDBModel.setScenarioType(scenarioDBModel.get().getScenarioType());
            operationScenarioDBModel.setScenarioExecutions(new ArrayList<>());
            operationScenarioDBModel.setExecutionState(AppConstant.READY_EXECUTION);
            operationScenarioDBModel.setuDate(appUtils.getCurrentTimeStamp());
            operationScenarioDBModel.setcDate(appUtils.getCurrentTimeStamp());
            operationScenarioDBModel.setStatus(1);

            return operationHelper.getApiOperationScenarioWSDTO(operationScenarioRepository.save(operationScenarioDBModel));
        }
        return null;
    }

    public ApiOperationScenarioWSDTO apiUpdateOperationScenarioService(long agentId,long sessionId,String executeId) {

        List<OperationScenarioDBModel> operationScenarioDBModels = operationScenarioRepository.findByIdAndSessionId(executeId,sessionId);
        if (!operationScenarioDBModels.isEmpty()){
            return operationHelper.getApiOperationScenarioWSDTO(operationScenarioDBModels.get(0));
        }
        return null;
    }

    public ApiOperationScenarioWSDTO apiRemoveOperationScenarioService(long agentId,long sessionId,String executeId) {

        List<OperationScenarioDBModel> operationScenarioDBModels = operationScenarioRepository.findByIdAndSessionId(executeId,sessionId);
        if (!operationScenarioDBModels.isEmpty()){
            operationScenarioRepository.delete(operationScenarioDBModels.get(0));
            return operationHelper.getApiOperationScenarioWSDTO(operationScenarioDBModels.get(0));
        }
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
        if (sessionDBModel.isPresent() && scenarioDBModel.isPresent() && scenarioDBModel.get().getElements() != null){

        }
        return scenarioElementWSDTOS;
    }

    public ApiProcessScenarioElementWSDTO apiGetProcessScenarioElementService(long agentId, long sessionId, String scenarioId, String elementId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (sessionDBModel.isPresent() && scenarioDBModel.isPresent() && scenarioDBModel.get().getElements() != null){
            for (int i=0;i<scenarioDBModel.get().getElements().size();i++){

            }
        }
        return null;
    }


}
