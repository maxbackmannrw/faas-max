package com.faas.core.api.framework.operation.manager.details;

import com.faas.core.api.model.ws.operation.manager.details.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.manager.details.dto.ApiOperationCampaignWSDTO;
import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.campaign.content.dao.CampaignScriptDAO;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.operation.content.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationManagerDetailsFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    CampaignRepository campaignRepository;

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


    public List<ApiOperationActivityWSDTO> apiGetOperationActivitiesService(long agentId, String operationId) {

        List<ApiOperationActivityWSDTO> operationActivityWSDTOS = new ArrayList<>();

        return operationActivityWSDTOS;
    }

    public ApiOperationActivityWSDTO apiGetOperationActivityService(long agentId, String operationId, String activityId) {


        return null;
    }


}
