package com.faas.core.base.middleware.manager.manual.campaign;

import com.faas.core.base.framework.manager.manual.campaign.ManualCampaignFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.manual.campaign.ManualCampaignWSModel;
import com.faas.core.base.model.ws.manager.manual.campaign.dto.ManualCampaignWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ManualCampaignMiddleware {


    @Autowired
    ManualCampaignFramework manualCampaignFramework;


    public ManualCampaignWSModel getManualCampaigns(long userId) {

        ManualCampaignWSModel response = new ManualCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ManualCampaignWSDTO> manualCampaignWSDTOS = manualCampaignFramework.getManualCampaignsService(userId);
        if (manualCampaignWSDTOS != null){
            response.setCampaigns(manualCampaignWSDTOS);
        }

        general.setOperation("getManualCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ManualCampaignWSModel getManualCampaign(long userId,String campaignId) {

        ManualCampaignWSModel response = new ManualCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ManualCampaignWSDTO> manualCampaignWSDTOS = new ArrayList<>();

        ManualCampaignWSDTO manualCampaignWSDTO = manualCampaignFramework.getManualCampaignService(userId,campaignId);
        if (manualCampaignWSDTO != null){
            manualCampaignWSDTOS.add(manualCampaignWSDTO);
        }

        response.setCampaigns(manualCampaignWSDTOS);
        general.setOperation("getManualCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
