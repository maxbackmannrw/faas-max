package com.faas.core.api.middleware.operation.scenario;

import com.faas.core.api.framework.operation.scenario.ApiOperationInquiryFramework;
import com.faas.core.api.model.ws.operation.scenario.inquiry.ApiOperationInquiryWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationInquiryMiddleware {


    @Autowired
    ApiOperationInquiryFramework apiOperationInquiryFramework;


    public ApiOperationInquiryWSModel apiGetOperationInquiry(long agentId, long sessionId, long clientId, String campaignId) {

        ApiOperationInquiryWSModel response = new ApiOperationInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
