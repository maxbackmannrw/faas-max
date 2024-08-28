package com.faas.core.base.framework.campaign.details.agent;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.agent.CampaignAgentDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.agent.dto.CampaignAgentWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CampaignAgentFramework {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;

    public CampaignAgentWSDTO fillCampaignAgentWSDTO(CampaignAgentDBModel campaignAgentDBModel) {

        Optional<UserDBModel> agentDBModel = userRepository.findById(campaignAgentDBModel.getAgentId());
        if (agentDBModel.isPresent()) {

            agentDBModel.get().setPassword("");
            CampaignAgentWSDTO campaignAgentWSDTO = new CampaignAgentWSDTO();
            campaignAgentWSDTO.setAgentUser(agentDBModel.get());
            campaignAgentWSDTO.setCampaignAgent(campaignAgentDBModel);

            return campaignAgentWSDTO;
        }
        return null;
    }

    public List<CampaignAgentWSDTO> getCampaignAgentsService(String campaignId) {

        List<CampaignAgentWSDTO>campaignAgentWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByCampaignId(campaignId);
        for (CampaignAgentDBModel campaignAgentDBModel : campaignAgentDBModels) {
            CampaignAgentWSDTO campaignAgentWSDTO = fillCampaignAgentWSDTO(campaignAgentDBModel);
            if (campaignAgentWSDTO != null) {
                campaignAgentWSDTOS.add(campaignAgentWSDTO);
            }
        }
        return campaignAgentWSDTOS;
    }

    public CampaignAgentWSDTO getCampaignAgentService(String campaignId,long agentId) {

        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByCampaignIdAndAgentId(campaignId,agentId);
        if (!campaignAgentDBModels.isEmpty()) {
            return fillCampaignAgentWSDTO(campaignAgentDBModels.get(0));
        }
        return null;
    }

    public CampaignAgentWSDTO assignCampaignAgentService(long userId, String campaignId, long agentId) {

        if (campaignAgentRepository.findByCampaignIdAndAgentId(campaignId, agentId).isEmpty()
                && campaignRepository.findById(campaignId).isPresent() && userRepository.findById(agentId).isPresent()) {

            CampaignAgentDBModel campaignAgentDBModel = new CampaignAgentDBModel();
            campaignAgentDBModel.setCampaignId(campaignId);
            campaignAgentDBModel.setAgentId(agentId);
            campaignAgentDBModel.setAgentState(AppConstant.ACTIVE_STATE);
            campaignAgentDBModel.setuDate(appUtils.getCurrentTimeStamp());
            campaignAgentDBModel.setcDate(appUtils.getCurrentTimeStamp());
            campaignAgentDBModel.setStatus(1);

            return fillCampaignAgentWSDTO(campaignAgentRepository.save(campaignAgentDBModel));
        }
        return null;
    }

    public CampaignAgentWSDTO updateCampaignAgentStateService(long userId, String campaignId,long agentId, String agentState) {

        if (campaignAgentRepository.findByCampaignIdAndAgentId(campaignId, agentId).isEmpty()
                && campaignRepository.findById(campaignId).isPresent() && userRepository.findById(agentId).isPresent()) {

            CampaignAgentDBModel campaignAgentDBModel = new CampaignAgentDBModel();
            campaignAgentDBModel.setCampaignId(campaignId);
            campaignAgentDBModel.setAgentId(agentId);
            campaignAgentDBModel.setAgentState(AppConstant.ACTIVE_STATE);
            campaignAgentDBModel.setuDate(appUtils.getCurrentTimeStamp());
            campaignAgentDBModel.setcDate(appUtils.getCurrentTimeStamp());
            campaignAgentDBModel.setStatus(1);

            return fillCampaignAgentWSDTO(campaignAgentRepository.save(campaignAgentDBModel));
        }
        return null;
    }

    public CampaignAgentWSDTO removeCampaignAgentService(String campaignId, long agentId) {

        List<CampaignAgentDBModel> campaignAgents = campaignAgentRepository.findByCampaignIdAndAgentId(campaignId, agentId);
        if (!campaignAgents.isEmpty()) {
            campaignAgentRepository.deleteAll(campaignAgents);
            return fillCampaignAgentWSDTO(campaignAgents.get(0));
        }
        return null;
    }

    public List<CampaignAgentWSDTO> getAssignableAgentsService(String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            if (campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.MANUAL_CAMPAIGN)
                    || campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)) {
                return filterAssignableAgents(campaignId, userRepository.findByUserTypeAndUserRoleNotAndStatus(AppConstant.AGENT_USER, AppConstant.AUTO_AGENT, 1));
            }
            if (campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)) {
                return filterAssignableAgents(campaignId, userRepository.findByUserRoleAndUserTypeAndStatus(AppConstant.AUTO_AGENT, AppConstant.AGENT_USER, 1));
            }
        }
        return null;
    }

    public List<CampaignAgentWSDTO> filterAssignableAgents(String campaignId, List<UserDBModel> agentDBModels) {

        List<CampaignAgentWSDTO> campaignAgentWSDTOS = new ArrayList<>();
        for (UserDBModel agentDBModel : agentDBModels) {
            if (campaignAgentRepository.findByCampaignIdAndAgentId(campaignId, agentDBModel.getId()).isEmpty()) {
                campaignAgentWSDTOS.add(new CampaignAgentWSDTO(agentDBModel));
            }
        }
        return campaignAgentWSDTOS;
    }


}
