package com.faas.core.base.framework.campaign.details.agent;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.agent.dto.CampaignAgentWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.CampaignHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CampaignAgentFramework {

    @Autowired
    CampaignHelper campaignHelper;

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
            return campaignHelper.mapCampaignAgentWSDTO(agentDBModel.get());
        }
        return null;
    }


    public CampaignAgentWSDTO assignCampaignAgentService(String campaignId, long agentId) {

        if (!(campaignAgentRepository.findByCampaignIdAndAgentId(campaignId, agentId).size() > 0)
                && campaignRepository.findById(campaignId).isPresent() && userRepository.findById(agentId).isPresent()) {

            CampaignAgentDBModel campaignAgentDBModel = new CampaignAgentDBModel();
            campaignAgentDBModel.setCampaignId(campaignId);
            campaignAgentDBModel.setAgentId(agentId);
            campaignAgentDBModel.setuDate(appUtils.getCurrentTimeStamp());
            campaignAgentDBModel.setcDate(appUtils.getCurrentTimeStamp());
            campaignAgentDBModel.setStatus(1);

            return fillCampaignAgentWSDTO(campaignAgentRepository.save(campaignAgentDBModel));
        }
        return null;
    }


    public CampaignAgentDBModel removeCampaignAgentService(String campaignId, long agentId) {

        List<CampaignAgentDBModel> campaignAgents = campaignAgentRepository.findByCampaignIdAndAgentId(campaignId, agentId);
        if (campaignAgents.size() > 0) {
            campaignAgentRepository.deleteAll(campaignAgents);
            return campaignAgents.get(0);
        }
        return null;
    }


    public List<CampaignAgentWSDTO> getAssignableAgentsService(String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            if (campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.MANUAL_CAMPAIGN) || campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)) {
                return filterAssignableAgents(campaignId, userRepository.findByUserRoleAndUserTypeAndStatus(AppConstant.BASIC_AGENT, AppConstant.AGENT_USER, 1));
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
            if (!(campaignAgentRepository.findByCampaignIdAndAgentId(campaignId, agentDBModel.getId()).size() > 0)) {
                campaignAgentWSDTOS.add(new CampaignAgentWSDTO(agentDBModel));
            }
        }
        return campaignAgentWSDTOS;
    }


}
