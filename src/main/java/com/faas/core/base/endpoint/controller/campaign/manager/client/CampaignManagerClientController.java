package com.faas.core.base.endpoint.controller.campaign.manager.client;

import com.faas.core.base.middleware.campaign.manager.client.CampaignManagerClientMiddleware;
import com.faas.core.base.model.ws.campaign.manager.client.CampaignClientWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/manager/client/")
public class CampaignManagerClientController {


    @Autowired
    CampaignManagerClientMiddleware campaignManagerClientMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignClients(@RequestParam long userId,
                                                   @RequestParam String city,
                                                   @RequestParam String country,
                                                   @RequestParam String clientState,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        CampaignClientWSModel response = campaignManagerClientMiddleware.searchCampaignClients(userId,city,country,clientState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignClient(@RequestParam long userId,
                                               @RequestParam long clientId,
                                               @RequestParam String campaignId) {

        ClientWSModel response = campaignManagerClientMiddleware.getCampaignClient(userId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
