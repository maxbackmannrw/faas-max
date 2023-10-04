package com.faas.core.base.middleware.operation.flow.details;

import com.faas.core.base.framework.operation.flow.details.OperationFlowDetailsFramework;
import com.faas.core.base.model.ws.operation.flow.OperationFlowCampaignWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OperationFlowDetailsMiddleware {


    @Autowired
    OperationFlowDetailsFramework operationFlowDetailsFramework;


    public OperationFlowCampaignWSModel getOperationFlowCampaigns(long userId, int reqPage, int reqSize) {

        OperationFlowCampaignWSModel response = new OperationFlowCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getOperationFlowCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
