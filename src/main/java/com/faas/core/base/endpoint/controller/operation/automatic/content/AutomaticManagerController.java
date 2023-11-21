package com.faas.core.base.endpoint.controller.operation.automatic.content;

import com.faas.core.base.middleware.operation.automatic.content.AutomaticManagerMiddleware;
import com.faas.core.base.model.ws.operation.automatic.content.AutomaticManagerWSModel;
import com.faas.core.base.model.ws.operation.content.OperationCampaignWSModel;
import com.faas.core.base.model.ws.operation.content.OperationListWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/manager/automatic/")
public class AutomaticManagerController {


    @Autowired
    AutomaticManagerMiddleware automaticManagerMiddleware;


    @RequestMapping(value = BaseRoute.GET_AUTOMATIC_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomaticManager(@RequestParam long userId,
                                                 @RequestParam int reqPage,
                                                 @RequestParam int reqSize) {

        AutomaticManagerWSModel response = automaticManagerMiddleware.getAutomaticManager(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATIC_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomaticOperations(@RequestParam long userId,
                                                    @RequestParam String sessionState,
                                                    @RequestParam int reqPage,
                                                    @RequestParam int reqSize) {

        OperationListWSModel response = automaticManagerMiddleware.getAutomaticOperations(userId,sessionState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_AUTOMATIC_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomaticOperation(@RequestParam long userId,
                                                   @RequestParam long sessionId) {

        OperationWSModel response = automaticManagerMiddleware.getAutomaticOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_AUTOMATIC_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> createAutomaticOperation(@RequestParam long userId,
                                                      @RequestParam long clientId,
                                                      @RequestParam long agentId,
                                                      @RequestParam String campaignId) {

        OperationWSModel response = automaticManagerMiddleware.createAutomaticOperation(userId,clientId,agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_AUTOMATIC_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> updateAutomaticOperation(@RequestParam long userId,
                                                      @RequestParam long sessionId) {

        OperationWSModel response = automaticManagerMiddleware.updateAutomaticOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_AUTOMATIC_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> removeAutomaticOperation(@RequestParam long userId,
                                                      @RequestParam long sessionId) {

        OperationWSModel response = automaticManagerMiddleware.removeAutomaticOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATIC_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomaticCampaigns(@RequestParam long userId) {

        OperationCampaignWSModel response = automaticManagerMiddleware.getAutomaticCampaigns(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATIC_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomaticCampaign(@RequestParam long userId,
                                                  @RequestParam String campaignId) {

        OperationCampaignWSModel response = automaticManagerMiddleware.getAutomaticCampaign(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
