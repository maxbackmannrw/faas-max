package com.faas.core.base.middleware.manager.manual.campaign;

import com.faas.core.base.framework.manager.manual.campaign.ManualCampaignFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.manual.operation.ManualOperationListWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ManualCampaignMiddleware {


    @Autowired
    ManualCampaignFramework manualCampaignFramework;


    public ManualOperationListWSModel getManualOperations(long userId, String sessionState, int reqPage, int reqSize) {

        ManualOperationListWSModel response = new ManualOperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getManualOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
