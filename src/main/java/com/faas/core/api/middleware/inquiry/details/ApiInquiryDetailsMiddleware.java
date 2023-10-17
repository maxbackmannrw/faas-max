package com.faas.core.api.middleware.inquiry.details;

import com.faas.core.api.framework.inquiry.details.ApiInquiryDetailsFramework;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.inquiry.details.ApiInquiryDetailsWSModel;
import com.faas.core.api.model.ws.inquiry.details.dto.ApiInquiryDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiInquiryDetailsMiddleware {


    @Autowired
    ApiInquiryDetailsFramework apiInquiryDetailsFramework;


    public ApiInquiryDetailsWSModel apiGetOperationInquiryDetails(long agentId, long inquiryId) {

        ApiInquiryDetailsWSModel response = new ApiInquiryDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiInquiryDetailsWSDTO inquiryDetailsWSDTO  = apiInquiryDetailsFramework.apiGetOperationInquiryDetailsService(agentId,inquiryId);
        if (inquiryDetailsWSDTO != null){
            response.setInquiryDetails(inquiryDetailsWSDTO);
        }

        general.setOperation("apiGetOperationInquiryDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSummaryWSModel apiGetOperationInquirySummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSummaryWSDTO> inquirySummaries  = apiInquiryDetailsFramework.apiGetOperationInquirySummaryService(agentId);
        if (inquirySummaries != null){
            response.setSummaries(inquirySummaries);
        }

        general.setOperation("apiGetOperationInquirySummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
