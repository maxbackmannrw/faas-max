package com.faas.core.base.middleware.manager.inquiry.campaign;

import com.faas.core.base.framework.manager.inquiry.campaign.InquiryCampaignFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.inquiry.campaign.InquiryCampaignWSModel;
import com.faas.core.base.model.ws.manager.inquiry.campaign.dto.InquiryCampaignWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class InquiryCampaignMiddleware {


    @Autowired
    InquiryCampaignFramework inquiryCampaignFramework;


    public InquiryCampaignWSModel getInquiryCampaigns(long userId) {

        InquiryCampaignWSModel response = new InquiryCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<InquiryCampaignWSDTO> inquiryCampaignWSDTOS = inquiryCampaignFramework.getInquiryCampaignsService(userId);
        if (inquiryCampaignWSDTOS != null){
            response.setCampaigns(inquiryCampaignWSDTOS);
        }

        general.setOperation("getInquiryCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public InquiryCampaignWSModel getInquiryCampaign(long userId,String campaignId) {

        InquiryCampaignWSModel response = new InquiryCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryCampaignWSDTO>inquiryCampaignWSDTOS = new ArrayList<>();

        InquiryCampaignWSDTO inquiryCampaignWSDTO = inquiryCampaignFramework.getInquiryCampaignService(userId,campaignId);
        if (inquiryCampaignWSDTO != null){
            inquiryCampaignWSDTOS.add(inquiryCampaignWSDTO);
        }

        response.setCampaigns(inquiryCampaignWSDTOS);
        general.setOperation("getInquiryCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
