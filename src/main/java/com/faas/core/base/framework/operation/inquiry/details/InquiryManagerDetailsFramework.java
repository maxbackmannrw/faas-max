package com.faas.core.base.framework.operation.inquiry.details;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.operation.inquiry.details.dto.InquiryCampaignWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class InquiryManagerDetailsFramework {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public List<InquiryCampaignWSDTO> getInquiryCampaignsService(long userId) {

        List<InquiryCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.INQUIRY_CAMPAIGN);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            InquiryCampaignWSDTO campaignWSDTO = new InquiryCampaignWSDTO();
            campaignWSDTO.setCampaign(campaignDBModel);
            campaignWSDTOS.add(campaignWSDTO);
        }
        return campaignWSDTOS;
    }


    public InquiryCampaignWSDTO getInquiryCampaignService(long userId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            InquiryCampaignWSDTO campaignWSDTO = new InquiryCampaignWSDTO();
            campaignWSDTO.setCampaign(campaignDBModel.get());
            return campaignWSDTO;
        }
        return null;
    }



}
