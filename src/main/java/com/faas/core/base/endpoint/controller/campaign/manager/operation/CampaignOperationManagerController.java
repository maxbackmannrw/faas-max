package com.faas.core.base.endpoint.controller.campaign.manager.operation;

import com.faas.core.base.middleware.campaign.manager.operation.CampaignOperationManagerMiddleware;
import com.faas.core.base.model.ws.campaign.manager.operation.CampaignOperationRequest;
import com.faas.core.base.model.ws.campaign.manager.operation.CampaignOperationWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.BaseRoute;
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
public class CampaignOperationManagerController {


    @Autowired
    CampaignOperationManagerMiddleware campaignOperationManagerMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignOperations(@RequestParam long userId,
                                                      @RequestParam String campaignId,
                                                      @RequestParam String city,
                                                      @RequestParam String country,
                                                      @RequestParam int reqPage,
                                                      @RequestParam int reqSize) {

        CampaignOperationWSModel response = campaignOperationManagerMiddleware.searchCampaignOperations(userId,campaignId,city,country,reqPage,reqSize);

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

        CampaignOperationWSModel response = campaignOperationManagerMiddleware.getCampaignOperations(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignOperation(@RequestParam long userId,
                                                  @RequestParam long sessionId,
                                                  @RequestParam String campaignId) {

        OperationWSModel response = campaignOperationManagerMiddleware.getCampaignOperation(userId,sessionId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignOperation(@RequestBody CampaignOperationRequest operationRequest) {

        OperationWSModel response = campaignOperationManagerMiddleware.createCampaignOperation(operationRequest);

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

        OperationWSModel response = campaignOperationManagerMiddleware.updateCampaignOperation(userId,sessionId,agentId,operationState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignOperation(@RequestParam long userId,
                                                     @RequestParam long sessionId,
                                                     @RequestParam String campaignId) {

        OperationWSModel response = campaignOperationManagerMiddleware.removeCampaignOperation(userId,sessionId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
