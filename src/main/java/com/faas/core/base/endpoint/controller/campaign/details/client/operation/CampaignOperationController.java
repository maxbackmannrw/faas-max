package com.faas.core.base.endpoint.controller.campaign.details.client.operation;

import com.faas.core.base.middleware.campaign.details.client.operation.CampaignOperationMiddleware;
import com.faas.core.base.model.ws.campaign.details.client.operation.CampaignOperationRequest;
import com.faas.core.base.model.ws.campaign.details.client.operation.CampaignOperationWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/client/operation/")
public class CampaignOperationController {


    @Autowired
    CampaignOperationMiddleware campaignOperationMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignOperations(@RequestParam long userId,
                                                      @RequestParam String campaignId,
                                                      @RequestParam String city,
                                                      @RequestParam String country,
                                                      @RequestParam int reqPage,
                                                      @RequestParam int reqSize) {

        CampaignOperationWSModel response = campaignOperationMiddleware.searchCampaignOperations(userId,campaignId,city,country,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignOperations(@RequestParam long userId,
                                                   @RequestParam String campaignId,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        CampaignOperationWSModel response = campaignOperationMiddleware.getCampaignOperations(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignOperation(@RequestParam long userId,
                                                  @RequestParam long sessionId) {

        OperationWSModel response = campaignOperationMiddleware.getCampaignOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignOperation(@RequestBody CampaignOperationRequest operationRequest) {

        OperationWSModel response = campaignOperationMiddleware.createCampaignOperation(operationRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignOperation(@RequestParam long userId,
                                                     @RequestParam long sessionId,
                                                     @RequestParam long agentId,
                                                     @RequestParam String operationState) {

        OperationWSModel response = campaignOperationMiddleware.updateCampaignOperation(userId,sessionId,agentId,operationState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignOperation(@RequestParam long userId,
                                                     @RequestParam long sessionId) {

        OperationWSModel response = campaignOperationMiddleware.removeCampaignOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
