package com.faas.core.base.middleware.manager.campaign.details.automatic;

import com.faas.core.base.framework.manager.campaign.details.automatic.AutomaticCampaignFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.campaign.content.CampaignManagerWSModel;
import com.faas.core.base.model.ws.manager.campaign.details.automatic.AutomaticCampaignWSModel;
import com.faas.core.base.model.ws.manager.campaign.details.automatic.dto.AutomaticCampaignWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutomaticCampaignMiddleware {


    @Autowired
    AutomaticCampaignFramework automaticCampaignFramework;


    public AutomaticCampaignWSModel getAutomaticCampaigns(long userId) {

        AutomaticCampaignWSModel response = new AutomaticCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<AutomaticCampaignWSDTO> automaticCampaignWSDTOS = automaticCampaignFramework.getAutomaticCampaignsService(userId);
        if (automaticCampaignWSDTOS != null){
            response.setAutomaticCampaigns(automaticCampaignWSDTOS);
        }

        general.setOperation("getAutomaticCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomaticCampaignWSModel getAutomaticCampaignsByState(long userId,String campaignState) {

        AutomaticCampaignWSModel response = new AutomaticCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<AutomaticCampaignWSDTO> automaticCampaignWSDTOS = automaticCampaignFramework.getAutomaticCampaignsByStateService(userId,campaignState);
        if (automaticCampaignWSDTOS != null){
            response.setAutomaticCampaigns(automaticCampaignWSDTOS);
        }

        general.setOperation("getAutomaticCampaignsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomaticCampaignWSModel getAutomaticCampaign(long userId,String campaignId) {

        AutomaticCampaignWSModel response = new AutomaticCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomaticCampaignWSDTO> automaticCampaignWSDTOS = new ArrayList<>();

        AutomaticCampaignWSDTO automaticCampaignWSDTO = automaticCampaignFramework.getAutomaticCampaignService(userId,campaignId);
        if (automaticCampaignWSDTO != null){
            automaticCampaignWSDTOS.add(automaticCampaignWSDTO);
        }

        response.setAutomaticCampaigns(automaticCampaignWSDTOS);
        general.setOperation("getAutomaticCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
