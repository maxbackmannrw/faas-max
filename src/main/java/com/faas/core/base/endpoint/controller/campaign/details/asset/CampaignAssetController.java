package com.faas.core.base.endpoint.controller.campaign.details.asset;

import com.faas.core.base.middleware.campaign.details.asset.CampaignAssetMiddleware;
import com.faas.core.base.model.ws.campaign.details.assets.CampaignAssetWSModel;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/asset/")
public class CampaignAssetController {


    @Autowired
    CampaignAssetMiddleware campaignAssetMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_ASSETS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignAssets(@RequestParam long userId,
                                               @RequestParam String campaignId) {

        CampaignAssetWSModel response = campaignAssetMiddleware.getCampaignAssets(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_ASSET, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignAsset(@RequestParam long userId,
                                              @RequestParam long assetId) {

        CampaignAssetWSModel response = campaignAssetMiddleware.getCampaignAsset(userId,assetId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_ASSET, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignAsset(@RequestParam long userId,
                                                 @RequestParam String campaignId,
                                                 @RequestParam long assetId) {

        CampaignAssetWSModel response = campaignAssetMiddleware.createCampaignAsset(userId,campaignId,assetId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_ASSET, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignAsset(@RequestParam long userId,
                                                 @RequestParam String campaignId,
                                                 @RequestParam long assetId) {

        CampaignAssetWSModel response = campaignAssetMiddleware.updateCampaignAsset(userId, campaignId, assetId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_ASSET, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignAsset(@RequestParam long userId,
                                                 @RequestParam String campaignId,
                                                 @RequestParam long assetId) {

        CampaignAssetWSModel response = campaignAssetMiddleware.removeCampaignAsset(userId, campaignId, assetId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
