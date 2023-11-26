package com.faas.core.base.middleware.operation.manual.details;

import com.faas.core.base.framework.operation.manual.details.ManualCampaignFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.content.OperationCampaignWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ManualCampaignMiddleware {


    @Autowired
    ManualCampaignFramework manualCampaignFramework;


    public OperationCampaignWSModel getManualCampaignDetails(long userId) {

        OperationCampaignWSModel response = new OperationCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getManualCampaignDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}