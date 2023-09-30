package com.faas.core.api.middleware.operation.flow;

import com.faas.core.api.framework.operation.flow.ApiOperationFlowFramework;
import com.faas.core.api.model.ws.operation.device.ApiOperationDeviceWSModel;
import com.faas.core.api.model.ws.operation.flow.ApiOperationFlowWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationFlowMiddleware {


    @Autowired
    ApiOperationFlowFramework apiOperationFlowFramework;


    public ApiOperationFlowWSModel apiGetOperationFlow(long agentId, long sessionId, long clientId, String campaignId) {

        ApiOperationFlowWSModel response = new ApiOperationFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
