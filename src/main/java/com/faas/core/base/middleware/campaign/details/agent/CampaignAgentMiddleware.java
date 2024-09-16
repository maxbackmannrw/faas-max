package com.faas.core.base.middleware.campaign.details.agent;

import com.faas.core.base.framework.campaign.details.agent.CampaignAgentFramework;
import com.faas.core.data.ws.base.campaign.details.agent.CampaignAgentWSModel;
import com.faas.core.data.ws.base.campaign.details.agent.dto.CampaignAgentWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignAgentMiddleware {


    @Autowired
    CampaignAgentFramework campaignAgentFramework;


    public CampaignAgentWSModel getCampaignAgents(long userId, String campaignId) {

        CampaignAgentWSModel response = new CampaignAgentWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignAgentWSDTO> campaignAgentWSDTOS = campaignAgentFramework.getCampaignAgentsService(campaignId);
        if (campaignAgentWSDTOS != null) {
            response.setCampaignAgents(campaignAgentWSDTOS);
        }

        general.setOperation("getCampaignAgents");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignAgentWSModel getCampaignAgent(long userId, String campaignId, long agentId) {

        CampaignAgentWSModel response = new CampaignAgentWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAgentWSDTO> campaignAgentWSDTOS = new ArrayList<>();

        CampaignAgentWSDTO campaignAgentWSDTO = campaignAgentFramework.getCampaignAgentService(campaignId, agentId);
        if (campaignAgentWSDTO != null) {
            campaignAgentWSDTOS.add(campaignAgentWSDTO);
        }

        response.setCampaignAgents(campaignAgentWSDTOS);
        general.setOperation("getCampaignAgent");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignAgentWSModel assignCampaignAgent(long userId, String campaignId, long agentId) {

        CampaignAgentWSModel response = new CampaignAgentWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAgentWSDTO> campaignAgentWSDTOS = new ArrayList<>();

        CampaignAgentWSDTO campaignAgentWSDTO = campaignAgentFramework.assignCampaignAgentService(userId, campaignId, agentId);
        if (campaignAgentWSDTO != null) {
            campaignAgentWSDTOS.add(campaignAgentWSDTO);
        }

        response.setCampaignAgents(campaignAgentWSDTOS);
        general.setOperation("assignCampaignAgent");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignAgentWSModel updateCampaignAgentState(long userId, String campaignId, long agentId, String agentState) {

        CampaignAgentWSModel response = new CampaignAgentWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAgentWSDTO> campaignAgentWSDTOS = new ArrayList<>();

        CampaignAgentWSDTO campaignAgentWSDTO = campaignAgentFramework.updateCampaignAgentStateService(userId, campaignId, agentId, agentState);
        if (campaignAgentWSDTO != null) {
            campaignAgentWSDTOS.add(campaignAgentWSDTO);
        }

        response.setCampaignAgents(campaignAgentWSDTOS);
        general.setOperation("assignCampaignAgent");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignAgentWSModel removeCampaignAgent(long userId, String campaignId, long agentId) {

        CampaignAgentWSModel response = new CampaignAgentWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAgentWSDTO> campaignAgentWSDTOS = new ArrayList<>();

        CampaignAgentWSDTO campaignAgentWSDTO = campaignAgentFramework.removeCampaignAgentService(campaignId, agentId);
        if (campaignAgentWSDTO != null) {
            campaignAgentWSDTOS.add(campaignAgentWSDTO);
        }

        response.setCampaignAgents(campaignAgentWSDTOS);
        general.setOperation("removeCampaignAgent");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignAgentWSModel getAssignableAgents(long userId, String campaignId) {

        CampaignAgentWSModel response = new CampaignAgentWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignAgentWSDTO> campaignAgentWSDTOS = campaignAgentFramework.getAssignableAgentsService(campaignId);
        if (campaignAgentWSDTOS != null) {
            response.setCampaignAgents(campaignAgentWSDTOS);
        }

        general.setOperation("getAssignableAgents");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
