package com.faas.core.api.middleware.inquiry.details;

import com.faas.core.api.framework.inquiry.details.ApiOperationInquiryDetailsFramework;
import com.faas.core.api.model.ws.inquiry.details.ApiOperationInquiryDetailsWSModel;
import com.faas.core.api.model.ws.inquiry.details.dto.ApiOperationInquiryDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationInquiryDetailsMiddleware {


    @Autowired
    ApiOperationInquiryDetailsFramework apiOperationInquiryDetailsFramework;


    public ApiOperationInquiryDetailsWSModel apiGetOperationInquiryDetails(long agentId, long inquiryId) {

        ApiOperationInquiryDetailsWSModel response = new ApiOperationInquiryDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationInquiryDetailsWSDTO operationInquiryDetailsWSDTO  = apiOperationInquiryDetailsFramework.apiGetOperationInquiryDetailsService(agentId,inquiryId);
        if (operationInquiryDetailsWSDTO != null){
            response.setOperationInquiryDetails(operationInquiryDetailsWSDTO);
        }

        general.setOperation("apiGetOperationInquiryDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
