package com.faas.core.base.endpoint.controller.campaign.manager.details.client;

import com.faas.core.base.middleware.campaign.manager.details.client.CampaignClientManagerMiddleware;
import com.faas.core.base.model.ws.campaign.manager.details.client.CampaignClientWSModel;
import com.faas.core.base.model.ws.client.content.ClientWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/manager/details/client/")
public class CampaignClientManagerController {


    @Autowired
    CampaignClientManagerMiddleware campaignClientManagerMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignClients(@RequestParam long userId,
                                                   @RequestParam String city,
                                                   @RequestParam String country,
                                                   @RequestParam String clientState,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        CampaignClientWSModel response = campaignClientManagerMiddleware.searchCampaignClients(userId,city,country,clientState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignClient(@RequestParam long userId,
                                               @RequestParam long clientId,
                                               @RequestParam String campaignId) {

        ClientWSModel response = campaignClientManagerMiddleware.getCampaignClient(userId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
