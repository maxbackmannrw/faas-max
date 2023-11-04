package com.faas.core.base.framework.manager.manual.campaign;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.manager.inquiry.campaign.dto.InquiryCampaignWSDTO;
import com.faas.core.base.model.ws.manager.manual.campaign.dto.ManualCampaignWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ManualCampaignFramework {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public List<ManualCampaignWSDTO> getManualCampaignsService(long userId) {

        List<ManualCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.MANUAL_CAMPAIGN);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            ManualCampaignWSDTO campaignWSDTO = new ManualCampaignWSDTO();
            campaignWSDTO.setCampaign(campaignDBModel);
            campaignWSDTOS.add(campaignWSDTO);
        }
        return campaignWSDTOS;
    }


    public ManualCampaignWSDTO getManualCampaignService(long userId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            ManualCampaignWSDTO campaignWSDTO = new ManualCampaignWSDTO();
            campaignWSDTO.setCampaign(campaignDBModel.get());
            return campaignWSDTO;
        }
        return null;
    }


}
