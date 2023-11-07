package com.faas.core.base.middleware.manager.client.details;

import com.faas.core.base.framework.manager.client.details.ClientManagerDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.inquiry.campaign.InquiryCampaignWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClientManagerDetailsMiddleware {


    @Autowired
    ClientManagerDetailsFramework clientManagerDetailsFramework;


    public InquiryCampaignWSModel getInquiryCampaigns(long userId) {

        InquiryCampaignWSModel response = new InquiryCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getInquiryCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}