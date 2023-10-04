package com.faas.core.base.middleware.operation.inquiry.details;

import com.faas.core.base.framework.operation.inquiry.details.OperationInquiryDetailsFramework;
import com.faas.core.base.model.ws.operation.inquiry.OperationInquiryCampaignWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OperationInquiryDetailsMiddleware {


    @Autowired
    OperationInquiryDetailsFramework operationInquiryDetailsFramework;


    public OperationInquiryCampaignWSModel getOperationInquiryCampaigns(long userId, int reqPage, int reqSize) {

        OperationInquiryCampaignWSModel response = new OperationInquiryCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getOperationInquiryCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
