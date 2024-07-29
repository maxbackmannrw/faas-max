package com.faas.core.base.middleware.campaign.manager.content;

import com.faas.core.base.framework.campaign.manager.content.CampaignManagerFramework;
import com.faas.core.base.model.ws.campaign.manager.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.manager.content.CampaignManagerWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignManagerMiddleware {


    @Autowired
    CampaignManagerFramework campaignManagerFramework;


    public CampaignManagerWSModel getCampaignManagers(long userId) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignManagerWSDTO> campaignManagerWSDTOS = campaignManagerFramework.getCampaignManagersService(userId);
        if (campaignManagerWSDTOS != null){
            response.setCampaignManagers(campaignManagerWSDTOS);
        }

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

        List<CampaignManagerWSDTO> campaignManagerWSDTOS = campaignManagerFramework.getCampaignManagersByCategoryService(userId,campaignCategory);
        if (campaignManagerWSDTOS != null){
            response.setCampaignManagers(campaignManagerWSDTOS);
        }

        general.setOperation("getCampaignManagersByCategory");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignManagerWSModel getCampaignManagersByState(long userId,String campaignState) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignManagerWSDTO> campaignManagerWSDTOS = campaignManagerFramework.getCampaignManagersByStateService(userId,campaignState);
        if (campaignManagerWSDTOS != null){
            response.setCampaignManagers(campaignManagerWSDTOS);
        }

        general.setOperation("getCampaignManagersByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignManagerWSModel getCampaignManager(long userId,String campaignId) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignManagerWSDTO> campaignManagerWSDTOS = new ArrayList<>();

        CampaignManagerWSDTO campaignManagerWSDTO = campaignManagerFramework.getCampaignManagerService(userId,campaignId);
        if (campaignManagerWSDTO != null){
            campaignManagerWSDTOS.add(campaignManagerWSDTO);
        }

        response.setCampaignManagers(campaignManagerWSDTOS);
        general.setOperation("getCampaignManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
