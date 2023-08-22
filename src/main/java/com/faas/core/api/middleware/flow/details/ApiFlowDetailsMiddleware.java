package com.faas.core.api.middleware.flow.details;

import com.faas.core.api.framework.flow.details.ApiFlowDetailsFramework;
import com.faas.core.api.model.ws.flow.details.ApiFlowDetailsWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiFlowDetailsMiddleware {


    @Autowired
    ApiFlowDetailsFramework apiFlowDetailsFramework;


    public ApiFlowDetailsWSModel apiGetFlowDetails(long agentId, long inquiryId) {

        ApiFlowDetailsWSModel response = new ApiFlowDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetFlowDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





}
