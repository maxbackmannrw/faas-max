package com.faas.core.api.framework.operation.scenario;

import com.faas.core.api.model.ws.operation.scenario.inquiry.dto.ApiOperationInquiryWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationInquiryFramework {

    @Autowired
    AppUtils appUtils;


    public ApiOperationInquiryWSDTO apiGetOperationInquiryService(){

        ApiOperationInquiryWSDTO apiOperationInquiryWSDTO = new ApiOperationInquiryWSDTO();

        return apiOperationInquiryWSDTO;
    }


}
