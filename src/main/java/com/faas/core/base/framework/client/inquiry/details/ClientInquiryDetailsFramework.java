package com.faas.core.base.framework.client.inquiry.details;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.client.inquiry.dto.InquiryCampaignWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.inquiry.ClientInquiryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ClientInquiryDetailsFramework {


    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ClientInquiryRepository clientInquiryRepository;

    @Autowired
    AppUtils appUtils;


    public List<InquiryCampaignWSDTO> getInquiryCampaignsService(long userId,int reqPage,int reqSize) {

        List<InquiryCampaignWSDTO> inquiryCampaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.INQUIRY_CAMPAIGN);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {

            InquiryCampaignWSDTO inquiryCampaignWSDTO = new InquiryCampaignWSDTO();
            inquiryCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel));
       //     Page<InquiryDBModel> clientInquiryModelPage = inquiryRepository.findAllByCampaignId(campaignDBModel.getId(), PageRequest.of(reqPage, reqSize));
        //    inquiryCampaignWSDTO.setInquiries(inquiryHelper.createInquiryWSDTOS(clientInquiryModelPage.getContent()));
       //     inquiryCampaignWSDTO.setPagination(inquiryHelper.createInquiryPagination(clientInquiryModelPage));

            inquiryCampaignWSDTOS.add(inquiryCampaignWSDTO);
        }
        return inquiryCampaignWSDTOS;
    }



}
