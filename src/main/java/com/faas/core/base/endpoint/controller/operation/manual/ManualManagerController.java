package com.faas.core.base.endpoint.controller.operation.manual;

import com.faas.core.base.middleware.operation.manual.ManualManagerMiddleware;
import com.faas.core.base.model.ws.operation.content.OperationCampaignWSModel;
import com.faas.core.base.model.ws.operation.content.OperationListWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.base.model.ws.operation.manual.ManualManagerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/manager/manual/")
public class ManualManagerController {


    @Autowired
    ManualManagerMiddleware manualManagerMiddleware;


    @RequestMapping(value = BaseRoute.GET_MANUAL_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> getManualManager(@RequestParam long userId,
                                              @RequestParam int reqPage,
                                              @RequestParam int reqSize) {

        ManualManagerWSModel response = manualManagerMiddleware.getManualManager(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_MANUAL_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getManualOperations(@RequestParam long userId,
                                                 @RequestParam String sessionState,
                                                 @RequestParam int reqPage,
                                                 @RequestParam int reqSize) {

        OperationListWSModel response = manualManagerMiddleware.getManualOperations(userId,sessionState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_MANUAL_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> getManualOperation(@RequestParam long userId,
                                                @RequestParam long sessionId) {

        OperationWSModel response = manualManagerMiddleware.getManualOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_MANUAL_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> createManualOperation(@RequestParam long userId,
                                                   @RequestParam long clientId,
                                                   @RequestParam long agentId,
                                                   @RequestParam String campaignId) {

        OperationWSModel response = manualManagerMiddleware.createManualOperation(userId,clientId,agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_MANUAL_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> updateManualOperation(@RequestParam long userId,
                                                   @RequestParam long sessionId) {

        OperationWSModel response = manualManagerMiddleware.updateManualOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_MANUAL_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> removeManualOperation(@RequestParam long userId,
                                                   @RequestParam long sessionId) {

        OperationWSModel response = manualManagerMiddleware.removeManualOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_MANUAL_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getManualCampaigns(@RequestParam long userId) {

        OperationCampaignWSModel response = manualManagerMiddleware.getManualCampaigns(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_MANUAL_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> getManualCampaign(@RequestParam long userId,
                                               @RequestParam String campaignId) {

        OperationCampaignWSModel response = manualManagerMiddleware.getManualCampaign(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
