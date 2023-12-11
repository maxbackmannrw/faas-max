package com.faas.core.base.middleware.manager.campaign.content;

import com.faas.core.base.framework.manager.campaign.content.CampaignManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.campaign.content.CampaignManagerWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CampaignManagerMiddleware {


    @Autowired
    CampaignManagerFramework campaignManagerFramework;


    public CampaignManagerWSModel getCampaignManagers(long userId) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getCampaignManagers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignManagerWSModel getCampaignManagersByCategory(long userId,String campaignCategory) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getCampaignManagersByCategory");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignManagerWSModel getCampaignManager(long userId,String campaignId) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getCampaignManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
