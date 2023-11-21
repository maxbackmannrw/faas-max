package com.faas.core.base.middleware.operation.manual.details;

import com.faas.core.base.framework.operation.manual.details.ManualOperationFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.content.OperationCampaignWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ManualOperationMiddleware {


    @Autowired
    ManualOperationFramework manualOperationFramework;


    public OperationCampaignWSModel getManualOperationDetails(long userId) {

        OperationCampaignWSModel response = new OperationCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getManualOperationDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
