package com.faas.core.base.middleware.operation.automatic.details;

import com.faas.core.base.framework.operation.automatic.details.AutomaticManagerDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.automatic.details.AutomaticCampaignWSModel;
import com.faas.core.base.model.ws.operation.automatic.details.dto.AutomaticCampaignWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutomaticManagerDetailsMiddleware {


    @Autowired
    AutomaticManagerDetailsFramework automaticManagerDetailsFramework;


    public AutomaticCampaignWSModel getAutomaticCampaigns(long userId) {

        AutomaticCampaignWSModel response = new AutomaticCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<AutomaticCampaignWSDTO> automaticCampaignWSDTOS = automaticManagerDetailsFramework.getAutomaticCampaignsService(userId);
        if (automaticCampaignWSDTOS != null){
            response.setCampaigns(automaticCampaignWSDTOS);
        }

        general.setOperation("getAutomaticCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AutomaticCampaignWSModel getAutomaticCampaign(long userId,String campaignId) {

        AutomaticCampaignWSModel response = new AutomaticCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomaticCampaignWSDTO>automaticCampaignWSDTOS = new ArrayList<>();

        AutomaticCampaignWSDTO automaticCampaignWSDTO = automaticManagerDetailsFramework.getAutomaticCampaignService(userId,campaignId);
        if (automaticCampaignWSDTO != null){
            automaticCampaignWSDTOS.add(automaticCampaignWSDTO);
        }

        response.setCampaigns(automaticCampaignWSDTOS);
        general.setOperation("getAutomaticCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
