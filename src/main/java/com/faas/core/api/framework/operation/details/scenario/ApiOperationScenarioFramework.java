package com.faas.core.api.framework.operation.details.scenario;

import com.faas.core.api.model.ws.operation.details.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.api.model.ws.operation.details.scenario.dto.ApiProcessScenarioWSDTO;
import com.faas.core.base.model.db.operation.content.dao.OperationScenarioDAO;
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


    public List<ApiOperationScenarioWSDTO> apiGetOperationScenariosService(long agentId,String operationId) {

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty() && operationDBModels.get(0).getOperationScenarios() != null){
            for (int i=0;i<operationDBModels.get(0).getOperationScenarios().size();i++){
                operationScenarioWSDTOS.add(new ApiOperationScenarioWSDTO(operationDBModels.get(0).getOperationScenarios().get(i)));
            }
        }
        return operationScenarioWSDTOS;
    }

    public ApiOperationScenarioWSDTO apiGetOperationScenarioService(long agentId,String operationId,String executeId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty() && operationDBModels.get(0).getOperationScenarios() != null){
            for (int i=0;i<operationDBModels.get(0).getOperationScenarios().size();i++){
                if (operationDBModels.get(0).getOperationScenarios().get(i).getId().equalsIgnoreCase(executeId)){
                    return new ApiOperationScenarioWSDTO(operationDBModels.get(0).getOperationScenarios().get(i));
                }
            }
        }
        return null;
    }

    public ApiOperationScenarioWSDTO apiOperationExecuteScenarioService(long agentId,String operationId,String scenarioId) {


        return null;
    }

    public ApiOperationScenarioWSDTO apiUpdateOperationScenarioService(long agentId,String operationId,String executeId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty() && operationDBModels.get(0).getOperationScenarios() != null){
            for (int i=0;i<operationDBModels.get(0).getOperationScenarios().size();i++){
                if (operationDBModels.get(0).getOperationScenarios().get(i).getId().equalsIgnoreCase(executeId)){
                    return new ApiOperationScenarioWSDTO(operationDBModels.get(0).getOperationScenarios().get(i));
                }
            }
        }
        return null;
    }

    public ApiOperationScenarioWSDTO apiRemoveOperationScenarioService(long agentId,String operationId,String executeId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty() && operationDBModels.get(0).getOperationScenarios() != null){
            for (int i=0;i<operationDBModels.get(0).getOperationScenarios().size();i++){
                if (operationDBModels.get(0).getOperationScenarios().get(i).getId().equalsIgnoreCase(executeId)){

                    OperationScenarioDAO operationScenarioDAO = operationDBModels.get(0).getOperationScenarios().get(i);
                    operationDBModels.get(0).getOperationScenarios().remove(operationScenarioDAO);
                    operationDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    operationRepository.save(operationDBModels.get(0));

                    return new ApiOperationScenarioWSDTO(operationScenarioDAO);
                }
            }
        }
        return null;
    }



    public List<ApiProcessScenarioWSDTO> apiGetOperationProcessScenariosService(long agentId,String operationId) {

        List<ApiProcessScenarioWSDTO>processScenarioWSDTOS = new ArrayList<>();
        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessId(sessionDBModels.get(0).getProcessId());
            for (ProcessScenarioDBModel processScenarioDBModel : processScenarioDBModels) {
                processScenarioWSDTOS.add(new ApiProcessScenarioWSDTO(processScenarioDBModel));
            }
        }
        return processScenarioWSDTOS;
    }

    public ApiProcessScenarioWSDTO apiGetOperationProcessScenarioService(long agentId,String operationId,String scenarioId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(sessionDBModels.get(0).getProcessId(),scenarioId);
            if (!processScenarioDBModels.isEmpty()){
                return new ApiProcessScenarioWSDTO(processScenarioDBModels.get(0));
            }
        }
        return null;
    }


}
