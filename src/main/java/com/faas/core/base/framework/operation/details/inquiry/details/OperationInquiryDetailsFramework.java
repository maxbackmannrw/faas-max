package com.faas.core.base.framework.operation.details.inquiry.details;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.operation.inquiry.dto.OperationInquiryCampaignWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.inquiry.OperationInquiryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class OperationInquiryDetailsFramework {


    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

    @Autowired
    AppUtils appUtils;


    public List<OperationInquiryCampaignWSDTO> getInquiryCampaignsService(long userId, int reqPage, int reqSize) {

        List<OperationInquiryCampaignWSDTO> operationInquiryCampaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.INQUIRY_CAMPAIGN);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {

            OperationInquiryCampaignWSDTO operationInquiryCampaignWSDTO = new OperationInquiryCampaignWSDTO();
            operationInquiryCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel));
       //     Page<InquiryDBModel> clientInquiryModelPage = inquiryRepository.findAllByCampaignId(campaignDBModel.getId(), PageRequest.of(reqPage, reqSize));
        //    inquiryCampaignWSDTO.setInquiries(inquiryHelper.createInquiryWSDTOS(clientInquiryModelPage.getContent()));
       //     inquiryCampaignWSDTO.setPagination(inquiryHelper.createInquiryPagination(clientInquiryModelPage));

            operationInquiryCampaignWSDTOS.add(operationInquiryCampaignWSDTO);
        }
        return operationInquiryCampaignWSDTOS;
    }



}
