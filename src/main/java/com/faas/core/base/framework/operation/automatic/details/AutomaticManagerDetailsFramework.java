package com.faas.core.base.framework.operation.automatic.details;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.operation.automatic.details.dto.AutomaticCampaignWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class AutomaticManagerDetailsFramework {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public List<AutomaticCampaignWSDTO> getAutomaticCampaignsService(long userId) {

        List<AutomaticCampaignWSDTO>campaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.AUTOMATIC_CAMPAIGN);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            AutomaticCampaignWSDTO campaignWSDTO = new AutomaticCampaignWSDTO();
            campaignWSDTO.setCampaign(campaignDBModel);
            campaignWSDTOS.add(campaignWSDTO);
        }
        return campaignWSDTOS;
    }

    public AutomaticCampaignWSDTO getAutomaticCampaignService(long userId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            AutomaticCampaignWSDTO campaignWSDTO = new AutomaticCampaignWSDTO();
            campaignWSDTO.setCampaign(campaignDBModel.get());
            return campaignWSDTO;
        }
        return null;
    }


}
