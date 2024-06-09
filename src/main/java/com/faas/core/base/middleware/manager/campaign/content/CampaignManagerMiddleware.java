package com.faas.core.base.middleware.manager.campaign.content;

import com.faas.core.base.framework.manager.campaign.content.CampaignManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.campaign.content.CampaignManagerWSModel;
import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
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


    public CampaignManagerWSModel getCampaignManager(long userId,String campaignId) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignManagerWSDTO>campaignManagerWSDTOS = new ArrayList<>();

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


    public CampaignManagerWSModel updateCampaignManager(long userId,String campaignId) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignManagerWSDTO>campaignManagerWSDTOS = new ArrayList<>();

        CampaignManagerWSDTO campaignManagerWSDTO = campaignManagerFramework.updateCampaignManagerService(userId,campaignId);
        if (campaignManagerWSDTO != null){
            campaignManagerWSDTOS.add(campaignManagerWSDTO);
        }

        response.setCampaignManagers(campaignManagerWSDTOS);
        general.setOperation("updateCampaignManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignManagerWSModel removeCampaignManager(long userId,String campaignId) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignManagerWSDTO>campaignManagerWSDTOS = new ArrayList<>();

        CampaignManagerWSDTO campaignManagerWSDTO = campaignManagerFramework.removeCampaignManagerService(userId,campaignId);
        if (campaignManagerWSDTO != null){
            campaignManagerWSDTOS.add(campaignManagerWSDTO);
        }

        response.setCampaignManagers(campaignManagerWSDTOS);
        general.setOperation("removeCampaignManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
