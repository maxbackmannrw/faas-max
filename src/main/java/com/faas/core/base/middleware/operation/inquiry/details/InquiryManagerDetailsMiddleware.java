package com.faas.core.base.middleware.operation.inquiry.details;

import com.faas.core.base.framework.operation.inquiry.details.InquiryManagerDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.inquiry.details.InquiryCampaignWSModel;
import com.faas.core.base.model.ws.operation.inquiry.details.dto.InquiryCampaignWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class InquiryManagerDetailsMiddleware {


    @Autowired
    InquiryManagerDetailsFramework inquiryManagerDetailsFramework;


    public InquiryCampaignWSModel getInquiryCampaigns(long userId) {

        InquiryCampaignWSModel response = new InquiryCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<InquiryCampaignWSDTO> inquiryCampaignWSDTOS = inquiryManagerDetailsFramework.getInquiryCampaignsService(userId);
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

        InquiryCampaignWSDTO inquiryCampaignWSDTO = inquiryManagerDetailsFramework.getInquiryCampaignService(userId,campaignId);
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
