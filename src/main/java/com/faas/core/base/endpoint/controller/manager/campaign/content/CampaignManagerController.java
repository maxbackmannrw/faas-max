package com.faas.core.base.endpoint.controller.manager.campaign.content;

import com.faas.core.base.middleware.manager.campaign.content.CampaignManagerMiddleware;
import com.faas.core.base.model.ws.manager.campaign.content.CampaignManagerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/manager/campaign/")
public class CampaignManagerController {


    @Autowired
    CampaignManagerMiddleware campaignManagerMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANAGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManagers(@RequestParam long userId) {

        CampaignManagerWSModel response = campaignManagerMiddleware.getCampaignManagers(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANAGERS_BY_CATEGORY, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManagersByCategory(@RequestParam long userId,
                                                           @RequestParam String campaignCategory) {

        CampaignManagerWSModel response = campaignManagerMiddleware.getCampaignManagersByCategory(userId,campaignCategory);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManager(@RequestParam long userId,
                                                @RequestParam String campaignId) {

        CampaignManagerWSModel response = campaignManagerMiddleware.getCampaignManager(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignManager(@RequestParam long userId,
                                                   @RequestParam String campaignId) {

        CampaignManagerWSModel response = campaignManagerMiddleware.updateCampaignManager(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignManager(@RequestParam long userId,
                                                   @RequestParam String campaignId) {

        CampaignManagerWSModel response = campaignManagerMiddleware.removeCampaignManager(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
