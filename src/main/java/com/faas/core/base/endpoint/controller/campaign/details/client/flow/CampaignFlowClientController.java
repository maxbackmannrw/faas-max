package com.faas.core.base.endpoint.controller.campaign.details.client.flow;

import com.faas.core.base.middleware.campaign.details.client.flow.CampaignFlowClientMiddleware;
import com.faas.core.base.model.ws.campaign.details.client.flow.CampaignFlowWSModel;
import com.faas.core.base.model.ws.campaign.details.client.flow.CampaignFlowClientRequest;
import com.faas.core.base.model.ws.client.flow.ClientFlowWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/client/flow/")
public class CampaignFlowClientController {


    @Autowired
    CampaignFlowClientMiddleware campaignFlowClientMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_FLOW_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignFlowClients(@RequestParam long userId,
                                                       @RequestParam String campaignId,
                                                       @RequestParam String clientCity,
                                                       @RequestParam String clientCountry,
                                                       @RequestParam int reqPage,
                                                       @RequestParam int reqSize) {

        CampaignFlowWSModel response = campaignFlowClientMiddleware.searchCampaignFlowClients(userId,campaignId,clientCity,clientCountry,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_FLOW_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignFlowClients(@RequestParam long userId,
                                                    @RequestParam String campaignId,
                                                    @RequestParam int reqPage,
                                                    @RequestParam int reqSize) {

        CampaignFlowWSModel response = campaignFlowClientMiddleware.getCampaignFlowClients(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_FLOW_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignFlowClient(@RequestParam long userId,
                                                   @RequestParam long flowId,
                                                   @RequestParam long clientId) {

        ClientFlowWSModel response = campaignFlowClientMiddleware.getCampaignFlowClient(userId,flowId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_FLOW_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignFlowClient(@RequestBody CampaignFlowClientRequest campaignFlowClientRequest) {

        ClientFlowWSModel response = campaignFlowClientMiddleware.createCampaignFlowClient(campaignFlowClientRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_FLOW_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignFlowClient(@RequestParam long userId,
                                                      @RequestParam long flowId,
                                                      @RequestParam long clientId,
                                                      @RequestParam String flowState) {

        ClientFlowWSModel response = campaignFlowClientMiddleware.updateCampaignFlowClient(userId,flowId,clientId,flowState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_FLOW_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignFlowClient(@RequestParam long userId,
                                                      @RequestParam long flowId,
                                                      @RequestParam long clientId) {

        ClientFlowWSModel response = campaignFlowClientMiddleware.removeCampaignFlowClient(userId,flowId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
