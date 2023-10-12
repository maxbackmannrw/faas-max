package com.faas.core.api.middleware.flow.details;

import com.faas.core.api.framework.flow.details.ApiClientFlowDetailsFramework;
import com.faas.core.api.model.ws.flow.details.ApiFlowDetailsWSModel;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiClientFlowDetailsMiddleware {


    @Autowired
    ApiClientFlowDetailsFramework apiClientFlowDetailsFramework;


    public ApiFlowDetailsWSModel apiGetOperationFlowDetails(long agentId, long inquiryId) {

        ApiFlowDetailsWSModel response = new ApiFlowDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetOperationFlowDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSummaryWSModel apiGetOperationFlowSummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetOperationFlowSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
