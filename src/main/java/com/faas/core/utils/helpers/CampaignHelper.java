package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardCampaignWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
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


    public List<ApiSummaryWSDTO> mapAgentCampaignSummary(long agentId){

        List<ApiSummaryWSDTO> apiSummaryWSDTOS = new ArrayList<>();
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATIONS_SUMMARY, String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId,AppConstant.READY_STATE))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATIONS_SUMMARY, String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId,AppConstant.ACTIVE_STATE))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.AGENT_ALL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));

        return apiSummaryWSDTOS;
    }

    public ApiDashboardCampaignWSDTO mapApiDashboardCampaignWSDTO(CampaignDBModel campaignDBModel){

        Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.getProcessId());
        if (processDBModel.isPresent()){

            ApiDashboardCampaignWSDTO dashboardCampaignWSDTO = new ApiDashboardCampaignWSDTO();
            dashboardCampaignWSDTO.setCampaign(campaignDBModel);
            dashboardCampaignWSDTO.setCampaignProcess(processDBModel.get());

            return dashboardCampaignWSDTO;
        }
        return null;
    }


    public ApiCampaignWSDTO mapApiCampaignWSDTO(CampaignDBModel campaignDBModel){

        ApiCampaignWSDTO campaignWSDTO = new ApiCampaignWSDTO();
        campaignWSDTO.setCampaign(campaignDBModel);
        Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.getProcessId());
        if (processDBModel.isPresent()) {
            campaignWSDTO.setCampaignProcess(processDBModel.get());
        }
        return campaignWSDTO;
    }


}
