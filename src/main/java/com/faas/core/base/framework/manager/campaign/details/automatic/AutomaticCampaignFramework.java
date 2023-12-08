package com.faas.core.base.framework.manager.campaign.details.automatic;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.manager.campaign.details.automatic.dto.AutomaticCampaignWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.AutomaticHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class AutomaticCampaignFramework {

    @Autowired
    AutomaticHelper automaticHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public List<AutomaticCampaignWSDTO> getAutomaticCampaignsService(long userId) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.AUTOMATIC_CAMPAIGN);
        if (campaignDBModels != null){
            return automaticHelper.getAutomaticCampaignWSDTOS(campaignDBModels);
        }
        return null;
    }


    public List<AutomaticCampaignWSDTO> getAutomaticCampaignsByStateService(long userId,String campaignState) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategoryAndCampaignState(AppConstant.AUTOMATIC_CAMPAIGN,campaignState);
        if (campaignDBModels != null){
            return automaticHelper.getAutomaticCampaignWSDTOS(campaignDBModels);
        }
        return null;
    }


    public AutomaticCampaignWSDTO getAutomaticCampaignService(long userId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            AutomaticCampaignWSDTO automaticCampaignWSDTO = new AutomaticCampaignWSDTO();
            automaticCampaignWSDTO.setCampaign(campaignDBModel.get());
            return automaticCampaignWSDTO;
        }
        return null;
    }


}
