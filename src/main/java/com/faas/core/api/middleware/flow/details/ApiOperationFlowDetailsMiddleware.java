package com.faas.core.api.middleware.flow.details;

import com.faas.core.api.framework.flow.details.ApiOperationFlowDetailsFramework;
import com.faas.core.api.model.ws.flow.details.ApiOperationFlowDetailsWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationFlowDetailsMiddleware {


    @Autowired
    ApiOperationFlowDetailsFramework apiOperationFlowDetailsFramework;


    public ApiOperationFlowDetailsWSModel apiGetOperationFlowDetails(long agentId, long inquiryId) {

        ApiOperationFlowDetailsWSModel response = new ApiOperationFlowDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationFlowDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
