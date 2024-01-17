package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.campaign.content.dto.ApiAgentCampaignSummary;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignProcessWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardCampaignWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.agent.dto.CampaignAgentWSDTO;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignProcessWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CampaignHelper {


    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;

    
    public CampaignAgentWSDTO mapCampaignAgentWSDTO(UserDBModel agentDBModel) {

        CampaignAgentWSDTO campaignAgentWSDTO = new CampaignAgentWSDTO();
        campaignAgentWSDTO.setCampaignAgent(agentDBModel);
        return campaignAgentWSDTO;
    }


    public List<CampaignAgentWSDTO> mapCampaignAgentWSDTOS(List<CampaignAgentDBModel> agentDBModels) {

        List<CampaignAgentWSDTO>campaignAgentWSDTOS = new ArrayList<>();
        for (CampaignAgentDBModel agentDBModel : agentDBModels) {
            CampaignAgentWSDTO campaignAgentWSDTO = mapCampaignAgentWSDTO(agentDBModel);
            if (campaignAgentWSDTO != null) {
                campaignAgentWSDTOS.add(campaignAgentWSDTO);
            }
        }
        return campaignAgentWSDTOS;
    }


    public CampaignAgentWSDTO mapCampaignAgentWSDTO(CampaignAgentDBModel agentDBModels) {

        Optional<UserDBModel> agentDBModel = userRepository.findById(agentDBModels.getAgentId());
        if (agentDBModel.isPresent()){
            agentDBModel.get().setPassword("");
            return mapCampaignAgentWSDTO(agentDBModel.get());
        }
        return null;
    }


    public CampaignProcessWSDTO mapCampaignProcessWSDTO(ProcessDBModel processDBModel){

        CampaignProcessWSDTO campaignProcessWSDTO = new CampaignProcessWSDTO();
        campaignProcessWSDTO.setProcess(processDBModel);
        List<ProcessScenarioWSDTO> processScenarioWSDTOS = new ArrayList<>();
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessId(processDBModel.getId());
        for (ProcessScenarioDBModel processScenarioDBModel : processScenarioDBModels) {
            processScenarioWSDTOS.add(mapProcessScenarioWSDTO(processScenarioDBModel));
        }
        campaignProcessWSDTO.setProcessScenarios(processScenarioWSDTOS);

        return campaignProcessWSDTO;
    }


    public ProcessScenarioWSDTO mapProcessScenarioWSDTO(ProcessScenarioDBModel processScenarioDBModel){

        ProcessScenarioWSDTO processScenarioWSDTO = new ProcessScenarioWSDTO();
        processScenarioWSDTO.setProcessScenario(processScenarioDBModel);
        return processScenarioWSDTO;
    }

    public ApiDashboardCampaignWSDTO mapApiDashboardCampaignWSDTO(long agentId,CampaignDBModel campaignDBModel){

        ApiDashboardCampaignWSDTO dashboardCampaignWSDTO = new ApiDashboardCampaignWSDTO();
        dashboardCampaignWSDTO.setCampaign(campaignDBModel);
        dashboardCampaignWSDTO.setCampaignSummary(getApiAgentCampaignSummary(agentId,campaignDBModel.getId()));

        return dashboardCampaignWSDTO;
    }

    public ApiCampaignWSDTO getApiCampaignWSDTO(long agentId,CampaignDBModel campaignDBModel){

        ApiCampaignWSDTO campaignWSDTO = new ApiCampaignWSDTO();
        campaignWSDTO.setCampaign(campaignDBModel);
        campaignWSDTO.setCampaignSummary(getApiAgentCampaignSummary(agentId,campaignDBModel.getId()));

        return campaignWSDTO;
    }

    public ApiCampaignDetailsWSDTO getApiCampaignDetailsWSDTO(CampaignDBModel campaignDBModel){

        ApiCampaignDetailsWSDTO campaignDetailsWSDTO = new ApiCampaignDetailsWSDTO();
        campaignDetailsWSDTO.setCampaign(campaignDBModel);
        Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.getProcessId());
        if (processDBModel.isPresent()){
            campaignDetailsWSDTO.setCampaignProcess(getApiCampaignProcessWSDTO(processDBModel.get()));
        }
        return campaignDetailsWSDTO;
    }

    public ApiCampaignProcessWSDTO getApiCampaignProcessWSDTO(ProcessDBModel processDBModel){

        ApiCampaignProcessWSDTO campaignProcessWSDTO = new ApiCampaignProcessWSDTO();
        campaignProcessWSDTO.setProcess(processDBModel);
        campaignProcessWSDTO.setProcessScenarios(getProcessScenarioWSDTOS(processDBModel));

        return campaignProcessWSDTO;
    }

    public List<ProcessScenarioWSDTO> getProcessScenarioWSDTOS(ProcessDBModel processDBModel){

        List<ProcessScenarioWSDTO> processScenarioWSDTOS = new ArrayList<>();
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessId(processDBModel.getId());
        for (ProcessScenarioDBModel processScenarioDBModel : processScenarioDBModels) {
            processScenarioWSDTOS.add(mapProcessScenarioWSDTO(processScenarioDBModel));
        }
        return processScenarioWSDTOS;
    }

    public ApiAgentCampaignSummary getApiAgentCampaignSummary(long agentId,String campaignId){

        ApiAgentCampaignSummary agentCampaignSummary = new ApiAgentCampaignSummary();
        agentCampaignSummary.setReadyOperationCount(operationRepository.countByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,AppConstant.READY_STATE));
        agentCampaignSummary.setActiveOperationCount(operationRepository.countByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,AppConstant.ACTIVE_STATE));
        agentCampaignSummary.setTotalOperationCount(operationRepository.countByAgentIdAndCampaignId(agentId,campaignId));

        return agentCampaignSummary;
    }


}
