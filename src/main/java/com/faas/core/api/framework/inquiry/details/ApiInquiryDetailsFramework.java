package com.faas.core.api.framework.inquiry.details;

import com.faas.core.api.model.ws.inquiry.details.dto.ApiInquiryDetailsWSDTO;
import com.faas.core.base.repo.operation.inquiry.OperationInquiryRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiInquiryDetailsFramework {

    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

    @Autowired
    AppUtils appUtils;


    public ApiInquiryDetailsWSDTO apiGetInquiryDetailsService(long agentId, long inquiryId){

        ApiInquiryDetailsWSDTO inquiryDetailsWSDTO = new ApiInquiryDetailsWSDTO();
        return inquiryDetailsWSDTO;
    }





}
