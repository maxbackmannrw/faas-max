package com.faas.core.base.middleware.operation.inquiry;

import com.faas.core.base.framework.operation.inquiry.InquiryCampaignFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.content.OperationCampaignWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InquiryCampaignMiddleware {


    @Autowired
    InquiryCampaignFramework inquiryCampaignFramework;


    public OperationCampaignWSModel getInquiryCampaignDetails(long userId) {

        OperationCampaignWSModel response = new OperationCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getInquiryCampaignDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
