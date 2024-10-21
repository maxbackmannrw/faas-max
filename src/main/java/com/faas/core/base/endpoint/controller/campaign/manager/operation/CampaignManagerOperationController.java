package com.faas.core.base.endpoint.controller.campaign.manager.operation;

import com.faas.core.base.middleware.campaign.manager.operation.CampaignManagerOperationMiddleware;
import com.faas.core.base.model.ws.campaign.manager.client.CampaignClientRequest;
import com.faas.core.base.model.ws.campaign.manager.client.CampaignClientWSModel;
import com.faas.core.base.model.ws.campaign.manager.operation.CampaignOperationRequest;
import com.faas.core.base.model.ws.campaign.manager.operation.CampaignOperationWSModel;
import com.faas.core.base.model.ws.client.content.ClientWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/manager/operation/")
public class CampaignManagerOperationController {


    @Autowired
    CampaignManagerOperationMiddleware campaignManagerOperationMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignOperations(@RequestParam long userId,
                                                      @RequestParam String campaignId,
                                                      @RequestParam String city,
                                                      @RequestParam String country,
                                                      @RequestParam int reqPage,
                                                      @RequestParam int reqSize) {

        CampaignOperationWSModel response = campaignManagerOperationMiddleware.searchCampaignOperations(userId, campaignId, city, country, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignOperations(@RequestParam long userId,
                                                   @RequestParam String campaignId,
                                                   @RequestParam String operationState,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        CampaignOperationWSModel response = campaignManagerOperationMiddleware.getCampaignOperations(userId, campaignId, operationState, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignOperation(@RequestParam long userId,
                                                  @RequestParam String operationId) {

        OperationWSModel response = campaignManagerOperationMiddleware.getCampaignOperation(userId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignOperations(@RequestBody CampaignOperationRequest operationRequest) {

        OperationWSModel response = campaignManagerOperationMiddleware.createCampaignOperations(operationRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignOperation(@RequestParam long userId,
                                                     @RequestParam long clientId,
                                                     @RequestParam String campaignId,
                                                     @RequestParam long agentId) {

        OperationWSModel response = campaignManagerOperationMiddleware.createCampaignOperation(userId, clientId, campaignId, agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignOperation(@RequestParam long userId,
                                                     @RequestParam String operationId,
                                                     @RequestParam String operationState) {

        OperationWSModel response = campaignManagerOperationMiddleware.updateCampaignOperation(userId, operationId, operationState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignOperation(@RequestParam long userId,
                                                     @RequestParam String operationId) {

        OperationWSModel response = campaignManagerOperationMiddleware.removeCampaignOperation(userId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignClients(@RequestParam long userId,
                                                   @RequestParam String city,
                                                   @RequestParam String clientState,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        CampaignClientWSModel response = campaignManagerOperationMiddleware.searchCampaignClients(userId, city, clientState, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_SELECTED_CAMPAIGN_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getSelectedCampaignClients(@RequestBody CampaignClientRequest clientRequest) {

        ClientWSModel response = campaignManagerOperationMiddleware.getSelectedCampaignClients(clientRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignClient(@RequestParam long userId,
                                               @RequestParam long clientId,
                                               @RequestParam String campaignId) {

        ClientWSModel response = campaignManagerOperationMiddleware.getCampaignClient(userId, clientId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}