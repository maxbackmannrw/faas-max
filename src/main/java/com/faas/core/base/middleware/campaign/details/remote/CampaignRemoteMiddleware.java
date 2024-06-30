package com.faas.core.base.middleware.campaign.details.remote;

import com.faas.core.base.framework.campaign.details.remote.CampaignRemoteFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.remote.CampaignRemoteWSModel;
import com.faas.core.base.model.ws.campaign.details.remote.dto.CampaignRemoteWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignRemoteMiddleware {


    @Autowired
    CampaignRemoteFramework campaignRemoteFramework;


    public CampaignRemoteWSModel getCampaignRemotes(long userId, String campaignId) {

        CampaignRemoteWSModel response = new CampaignRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignRemoteWSDTO> campaignRemoteWSDTOS = campaignRemoteFramework.getCampaignRemotesService(userId,campaignId);
        if (campaignRemoteWSDTOS != null){
            response.setCampaignRemotes(campaignRemoteWSDTOS);
        }

        general.setOperation("getCampaignRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignRemoteWSModel getCampaignRemotesByCategory(long userId, String campaignId, String remoteCategory) {

        CampaignRemoteWSModel response = new CampaignRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignRemoteWSDTO> campaignRemoteWSDTOS = campaignRemoteFramework.getCampaignRemotesByCategoryService(userId,campaignId,remoteCategory);
        if (campaignRemoteWSDTOS != null){
            response.setCampaignRemotes(campaignRemoteWSDTOS);
        }

        general.setOperation("getCampaignRemotesByCategory");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignRemoteWSModel getCampaignRemote(long userId, String campaignRemoteId) {

        CampaignRemoteWSModel response = new CampaignRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignRemoteWSDTO> campaignRemoteWSDTOS = new ArrayList<>();

        CampaignRemoteWSDTO campaignRemoteWSDTO = campaignRemoteFramework.getCampaignRemoteService(userId,campaignRemoteId);
        if (campaignRemoteWSDTO != null){
            campaignRemoteWSDTOS.add(campaignRemoteWSDTO);
        }

        response.setCampaignRemotes(campaignRemoteWSDTOS);
        general.setOperation("getCampaignRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignRemoteWSModel createCampaignRemote(long userId, String campaignId, String remoteId, String remoteCategory) {

        CampaignRemoteWSModel response = new CampaignRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignRemoteWSDTO> campaignRemoteWSDTOS = new ArrayList<>();

        CampaignRemoteWSDTO campaignRemoteWSDTO = campaignRemoteFramework.createCampaignRemoteService(userId,campaignId,remoteId,remoteCategory);
        if (campaignRemoteWSDTO != null){
            campaignRemoteWSDTOS.add(campaignRemoteWSDTO);
        }

        response.setCampaignRemotes(campaignRemoteWSDTOS);
        general.setOperation("createCampaignRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignRemoteWSModel removeCampaignRemote(long userId, String campaignRemoteId) {

        CampaignRemoteWSModel response = new CampaignRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignRemoteWSDTO> campaignRemoteWSDTOS = new ArrayList<>();

        CampaignRemoteWSDTO campaignRemoteWSDTO = campaignRemoteFramework.removeCampaignRemoteService(userId,campaignRemoteId);
        if (campaignRemoteWSDTO != null){
            campaignRemoteWSDTOS.add(campaignRemoteWSDTO);
        }

        response.setCampaignRemotes(campaignRemoteWSDTOS);
        general.setOperation("removeCampaignRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
