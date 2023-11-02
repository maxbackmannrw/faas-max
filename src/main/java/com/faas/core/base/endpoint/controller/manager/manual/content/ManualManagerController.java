package com.faas.core.base.endpoint.controller.manager.manual.content;

import com.faas.core.base.middleware.manager.manual.content.ManualManagerMiddleware;
import com.faas.core.base.model.ws.manager.manual.ManualOperationListWSModel;
import com.faas.core.base.model.ws.manager.manual.ManualOperationWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/manager/manual/")
public class ManualManagerController {


    @Autowired
    ManualManagerMiddleware manualManagerMiddleware;


    @RequestMapping(value = BaseRoute.GET_MANUAL_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getManualOperations(@RequestParam long userId,
                                                 @RequestParam String sessionState,
                                                 @RequestParam int reqPage,
                                                 @RequestParam int reqSize) {

        ManualOperationListWSModel response = manualManagerMiddleware.getManualOperations(userId,sessionState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_MANUAL_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> getManualOperation(@RequestParam long userId,
                                                @RequestParam long sessionId) {

        ManualOperationWSModel response = manualManagerMiddleware.getManualOperation(userId,sessionId);

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

        ManualOperationWSModel response = manualManagerMiddleware.createManualOperation(userId,clientId,agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_MANUAL_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> updateManualOperation(@RequestParam long userId,
                                                   @RequestParam long sessionId) {

        ManualOperationWSModel response = manualManagerMiddleware.updateManualOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_MANUAL_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> removeManualOperation(@RequestParam long userId,
                                                   @RequestParam long sessionId) {

        ManualOperationWSModel response = manualManagerMiddleware.removeManualOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
