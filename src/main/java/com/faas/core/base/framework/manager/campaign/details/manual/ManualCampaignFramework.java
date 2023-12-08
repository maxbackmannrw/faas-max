package com.faas.core.base.framework.manager.campaign.details.manual;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.manager.campaign.details.inquiry.dto.InquiryCampaignWSDTO;
import com.faas.core.base.model.ws.manager.campaign.details.manual.dto.ManualCampaignWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ManualHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ManualCampaignFramework {


    @Autowired
    ManualHelper manualHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public List<ManualCampaignWSDTO> getManualCampaignsService(long userId) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.MANUAL_CAMPAIGN);
        if (campaignDBModels != null){
            return manualHelper.getManualCampaignWSDTOS(campaignDBModels);
        }
        return null;
    }


    public List<ManualCampaignWSDTO> getManualCampaignsByStateService(long userId,String campaignState) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategoryAndCampaignState(AppConstant.MANUAL_CAMPAIGN,campaignState);
        if (campaignDBModels != null){
            return manualHelper.getManualCampaignWSDTOS(campaignDBModels);
        }
        return null;
    }


    public ManualCampaignWSDTO getManualCampaignService(long userId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            ManualCampaignWSDTO manualCampaignWSDTO = new ManualCampaignWSDTO();
            manualCampaignWSDTO.setCampaign(campaignDBModel.get());
            return manualCampaignWSDTO;
        }
        return null;
    }


}
