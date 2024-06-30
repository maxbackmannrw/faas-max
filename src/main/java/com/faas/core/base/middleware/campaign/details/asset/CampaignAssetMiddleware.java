package com.faas.core.base.middleware.campaign.details.asset;

import com.faas.core.base.framework.campaign.details.asset.CampaignAssetFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.assets.CampaignAssetWSModel;
import com.faas.core.base.model.ws.campaign.details.assets.dto.CampaignAssetWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignAssetMiddleware {


    @Autowired
    CampaignAssetFramework campaignAssetFramework;


    public CampaignAssetWSModel getCampaignAssets(long userId, String campaignId) {

        CampaignAssetWSModel response = new CampaignAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAssetWSDTO> campaignAssetWSDTOS = new ArrayList<>();


        response.setCampaignAssets(campaignAssetWSDTOS);
        general.setOperation("getCampaignAssets");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignAssetWSModel getCampaignAsset(long userId,long assetId) {

        CampaignAssetWSModel response = new CampaignAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAssetWSDTO> campaignAssetWSDTOS = new ArrayList<>();


        response.setCampaignAssets(campaignAssetWSDTOS);
        general.setOperation("getCampaignAsset");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignAssetWSModel createCampaignAsset(long userId, String campaignId, long assetId) {

        CampaignAssetWSModel response = new CampaignAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAssetWSDTO> campaignAssetWSDTOS = new ArrayList<>();


        response.setCampaignAssets(campaignAssetWSDTOS);
        general.setOperation("createCampaignAsset");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignAssetWSModel updateCampaignAsset(long userId, String campaignId, long assetId) {

        CampaignAssetWSModel response = new CampaignAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAssetWSDTO> campaignAssetWSDTOS = new ArrayList<>();


        response.setCampaignAssets(campaignAssetWSDTOS);
        general.setOperation("updateCampaignAsset");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignAssetWSModel removeCampaignAsset(long userId, String campaignId, long assetId) {

        CampaignAssetWSModel response = new CampaignAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAssetWSDTO> campaignAssetWSDTOS = new ArrayList<>();


        response.setCampaignAssets(campaignAssetWSDTOS);
        general.setOperation("removeCampaignAsset");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
