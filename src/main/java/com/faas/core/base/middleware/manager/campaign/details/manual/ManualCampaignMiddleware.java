package com.faas.core.base.middleware.manager.campaign.details.manual;

import com.faas.core.base.framework.manager.campaign.details.manual.ManualCampaignFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.campaign.content.CampaignManagerWSModel;
import com.faas.core.base.model.ws.manager.campaign.details.manual.ManualCampaignWSModel;
import com.faas.core.base.model.ws.manager.campaign.details.manual.dto.ManualCampaignWSDTO;
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
            response.setManualCampaigns(manualCampaignWSDTOS);
        }

        general.setOperation("getManualCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ManualCampaignWSModel getManualCampaignsByState(long userId,String campaignState) {

        ManualCampaignWSModel response = new ManualCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ManualCampaignWSDTO> manualCampaignWSDTOS = manualCampaignFramework.getManualCampaignsByStateService(userId,campaignState);
        if (manualCampaignWSDTOS != null){
            response.setManualCampaigns(manualCampaignWSDTOS);
        }

        general.setOperation("getManualCampaignsByState");
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

        response.setManualCampaigns(manualCampaignWSDTOS);
        general.setOperation("getManualCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
