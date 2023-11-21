package com.faas.core.base.middleware.operation.inquiry.details;

import com.faas.core.base.framework.operation.inquiry.details.InquiryOperationFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.content.OperationCampaignWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InquiryOperationMiddleware {


    @Autowired
    InquiryOperationFramework inquiryOperationFramework;


    public OperationCampaignWSModel getInquiryOperationDetails(long userId) {

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
