package com.faas.core.base.middleware.dashboard.campaign;

import com.faas.core.base.framework.dashboard.campaign.DashCampaignFramework;
import com.faas.core.base.model.ws.dashboard.campaign.DashboardCampaignWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DashCampaignMiddleware {


    @Autowired
    DashCampaignFramework dashCampaignFramework;


    public DashboardCampaignWSModel getDashCampaigns(long userId, int reqPage, int reqSize) {

        DashboardCampaignWSModel response = new DashboardCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getDashCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
