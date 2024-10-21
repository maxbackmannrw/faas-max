package com.faas.core.base.endpoint.controller.campaign.details.remote;

import com.faas.core.base.middleware.campaign.details.remote.CampaignRemoteMiddleware;
import com.faas.core.base.model.ws.campaign.details.remote.CampaignRemoteWSModel;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/remote/")
public class CampaignRemoteController {

    @Autowired
    CampaignRemoteMiddleware campaignRemoteMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_REMOTES, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignRemotes(@RequestParam long userId,
                                                @RequestParam String campaignId) {

        CampaignRemoteWSModel response = campaignRemoteMiddleware.getCampaignRemotes(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_REMOTES_BY_CATEGORY, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignRemotesByCategory(@RequestParam long userId,
                                                          @RequestParam String campaignId,
                                                          @RequestParam String remoteCategory) {

        CampaignRemoteWSModel response = campaignRemoteMiddleware.getCampaignRemotesByCategory(userId, campaignId, remoteCategory);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignRemote(@RequestParam long userId,
                                               @RequestParam String campaignRemoteId) {

        CampaignRemoteWSModel response = campaignRemoteMiddleware.getCampaignRemote(userId, campaignRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignRemote(@RequestParam long userId,
                                                  @RequestParam String campaignId,
                                                  @RequestParam String remoteId,
                                                  @RequestParam String remoteCategory) {

        CampaignRemoteWSModel response = campaignRemoteMiddleware.createCampaignRemote(userId, campaignId, remoteId, remoteCategory);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignRemote(@RequestParam long userId,
                                                  @RequestParam String campaignRemoteId) {

        CampaignRemoteWSModel response = campaignRemoteMiddleware.removeCampaignRemote(userId, campaignRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
