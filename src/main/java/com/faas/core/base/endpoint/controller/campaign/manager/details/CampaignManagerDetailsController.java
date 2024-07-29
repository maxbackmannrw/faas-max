package com.faas.core.base.endpoint.controller.campaign.manager.details;

import com.faas.core.base.middleware.campaign.manager.details.CampaignManagerDetailsMiddleware;
import com.faas.core.base.model.ws.campaign.manager.details.CampaignManagerDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/manager/details/")
public class CampaignManagerDetailsController {


    @Autowired
    CampaignManagerDetailsMiddleware campaignManagerDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANAGER_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManagerDetails(@RequestParam long userId,
                                                       @RequestParam String campaignId) {

        CampaignManagerDetailsWSModel response = campaignManagerDetailsMiddleware.getCampaignManagerDetails(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
