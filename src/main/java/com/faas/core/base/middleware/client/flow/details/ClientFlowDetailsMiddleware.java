package com.faas.core.base.middleware.client.flow.details;

import com.faas.core.base.framework.client.flow.details.ClientFlowDetailsFramework;
import com.faas.core.base.model.ws.client.flow.FlowCampaignWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClientFlowDetailsMiddleware {


    @Autowired
    ClientFlowDetailsFramework clientFlowDetailsFramework;


    public FlowCampaignWSModel getFlowCampaigns(long userId,int reqPage,int reqSize) {

        FlowCampaignWSModel response = new FlowCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getFlowCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
