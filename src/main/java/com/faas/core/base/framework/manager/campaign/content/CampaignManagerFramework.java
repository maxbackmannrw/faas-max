package com.faas.core.base.framework.manager.campaign.content;

import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.AutomaticHelper;
import com.faas.core.utils.helpers.InquiryHelper;
import com.faas.core.utils.helpers.ManualHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CampaignManagerFramework {

    @Autowired
    ManualHelper manualHelper;

    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    AutomaticHelper automaticHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignManagerWSDTO getCampaignManagerService(long userId) {

        CampaignManagerWSDTO campaignManagerWSDTO = new CampaignManagerWSDTO();
        campaignManagerWSDTO.setManualCampaigns(manualHelper.getManualCampaignWSDTOS(campaignRepository.findByCampaignCategoryAndCampaignState(AppConstant.MANUAL_CAMPAIGN,AppConstant.ACTIVE_CAMPAIGN)));
        campaignManagerWSDTO.setInquiryCampaigns(inquiryHelper.getInquiryCampaignWSDTOS(campaignRepository.findByCampaignCategoryAndCampaignState(AppConstant.INQUIRY_CAMPAIGN,AppConstant.ACTIVE_CAMPAIGN)));
        campaignManagerWSDTO.setAutomaticCampaigns(automaticHelper.getAutomaticCampaignWSDTOS(campaignRepository.findByCampaignCategoryAndCampaignState(AppConstant.MANUAL_CAMPAIGN,AppConstant.ACTIVE_CAMPAIGN)));

        return campaignManagerWSDTO;
    }




}
