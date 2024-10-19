package com.faas.core.api.framework.operation.manager.campaign;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignScenarioWSDTO;
import com.faas.core.api.model.ws.operation.manager.campaign.dto.ApiOperationCampaignWSDTO;
import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.campaign.content.dao.CampaignScriptDAO;
import com.faas.core.data.db.campaign.details.scenario.CampaignScenarioDBModel;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.campaign.details.scenario.CampaignScenarioRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.operation.content.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ApiOperationCampaignFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignScenarioRepository campaignScenarioRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationCampaignWSDTO apiGetOperationCampaignService(long agentId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            return operationHelper.getApiOperationCampaignWSDTO(campaignDBModel.get());
        }
        return null;
    }

    public List<CampaignScriptDAO> apiGetOperationCampaignScriptsService(long agentId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignScripts() != null) {
            return campaignDBModel.get().getCampaignScripts();
        }
        return null;
    }

    public List<ApiCampaignScenarioWSDTO> apiGetOperationCampaignScenariosService(long agentId, String campaignId) {

        List<ApiCampaignScenarioWSDTO> campaignScenarioWSDTOS = new ArrayList<>();
        List<CampaignScenarioDBModel> campaignScenarioDBModels = campaignScenarioRepository.findByCampaignId(campaignId);
        for (CampaignScenarioDBModel campaignScenarioDBModel : campaignScenarioDBModels) {
            campaignScenarioWSDTOS.add(new ApiCampaignScenarioWSDTO(campaignScenarioDBModel));
        }
        return campaignScenarioWSDTOS;
    }

    public ApiCampaignScenarioWSDTO apiGetOperationCampaignScenarioService(long agentId, String campaignId, String scenarioId) {

        List<CampaignScenarioDBModel> campaignScenarioDBModels = campaignScenarioRepository.findByCampaignIdAndScenarioId(campaignId,scenarioId);
        if (!campaignScenarioDBModels.isEmpty()) {
            return new ApiCampaignScenarioWSDTO(campaignScenarioDBModels.get(0));
        }
        return null;
    }

}
