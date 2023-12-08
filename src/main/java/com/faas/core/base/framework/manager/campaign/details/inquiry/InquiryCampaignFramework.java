package com.faas.core.base.framework.manager.campaign.details.inquiry;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.manager.campaign.details.automatic.dto.AutomaticCampaignWSDTO;
import com.faas.core.base.model.ws.manager.campaign.details.inquiry.dto.InquiryCampaignWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class InquiryCampaignFramework {


    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public List<InquiryCampaignWSDTO> getInquiryCampaignsService(long userId) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.INQUIRY_CAMPAIGN);
        if (campaignDBModels != null){
            return inquiryHelper.getInquiryCampaignWSDTOS(campaignDBModels);
        }
        return null;
    }


    public List<InquiryCampaignWSDTO> getInquiryCampaignsByStateService(long userId,String campaignState) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategoryAndCampaignState(AppConstant.INQUIRY_CAMPAIGN,campaignState);
        if (campaignDBModels != null){
            return inquiryHelper.getInquiryCampaignWSDTOS(campaignDBModels);
        }
        return null;
    }


    public InquiryCampaignWSDTO getInquiryCampaignService(long userId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            InquiryCampaignWSDTO inquiryCampaignWSDTO = new InquiryCampaignWSDTO();
            inquiryCampaignWSDTO.setCampaign(campaignDBModel.get());
            return inquiryCampaignWSDTO;
        }
        return null;
    }

}
