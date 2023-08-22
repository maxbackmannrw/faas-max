package com.faas.core.base.middleware.campaign.details.agent;

import com.faas.core.base.framework.campaign.details.agent.CampaignAgentFramework;
import com.faas.core.base.framework.user.content.UserFramework;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.agent.CampaignAgentWSModel;
import com.faas.core.base.model.ws.campaign.details.agent.dto.CampaignAgentWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.user.content.UserWSModel;
import com.faas.core.base.model.ws.user.content.dto.UserWSDTO;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignAgentMiddleware {


    @Autowired
    CampaignAgentFramework campaignAgentFramework;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    UserFramework userFramework;

    @Autowired
    AppUtils appUtils;


    public CampaignAgentWSModel getCampaignAgents(long userId, String campaignId) {

        CampaignAgentWSModel response = new CampaignAgentWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAgentWSDTO> campaignAgentWSDTOS = new ArrayList<>();

        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByCampaignId(campaignId);
        for (CampaignAgentDBModel campaignAgentDBModel : campaignAgentDBModels) {
            CampaignAgentWSDTO campaignAgentWSDTO = campaignAgentFramework.fillCampaignAgentWSDTO(campaignAgentDBModel);
            if (campaignAgentWSDTO != null){
                campaignAgentWSDTOS.add(campaignAgentWSDTO);
            }
        }

        response.setCampaignAgents(campaignAgentWSDTOS);
        general.setOperation("getCampaignAgents");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignAgentWSModel getCampaignAgent(long userId,String campaignId,long agentId) {

        CampaignAgentWSModel response = new CampaignAgentWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAgentWSDTO> campaignAgentWSDTOS = new ArrayList<>();

        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByCampaignIdAndAgentId(campaignId,agentId);
        if (campaignAgentDBModels.size()>0){
            CampaignAgentWSDTO campaignAgentWSDTO = campaignAgentFramework.fillCampaignAgentWSDTO(campaignAgentDBModels.get(0));
            if (campaignAgentWSDTO != null){
                campaignAgentWSDTOS.add(campaignAgentWSDTO);
            }
        }

        response.setCampaignAgents(campaignAgentWSDTOS);
        general.setOperation("getCampaignAgent");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignAgentWSModel assignCampaignAgent(long userId, String campaignId,long agentId) {

        CampaignAgentWSModel response = new CampaignAgentWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAgentWSDTO> campaignAgentWSDTOS = new ArrayList<>();

        CampaignAgentWSDTO campaignAgentWSDTO = campaignAgentFramework.assignCampaignAgentService(campaignId, agentId);
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

        CampaignAgentDBModel campaignAgentDBModel = campaignAgentFramework.removeCampaignAgentService(campaignId, agentId);
        if (campaignAgentDBModel != null) {
            CampaignAgentWSDTO campaignAgentWSDTO = campaignAgentFramework.fillCampaignAgentWSDTO(campaignAgentDBModel);
            if (campaignAgentWSDTO != null){
                campaignAgentWSDTOS.add(campaignAgentWSDTO);
            }
        }

        response.setCampaignAgents(campaignAgentWSDTOS);
        general.setOperation("removeCampaignAgent");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignAgentWSModel getAssignableAgents(long userId,String campaignId) {

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
