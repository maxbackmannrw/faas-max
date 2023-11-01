package com.faas.core.base.endpoint.controller.operation.automatic;

import com.faas.core.base.middleware.operation.automatic.AutomaticOperationMiddleware;
import com.faas.core.base.model.ws.operation.automatic.AutomaticOperationListWSModel;
import com.faas.core.base.model.ws.operation.automatic.AutomaticOperationWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/automatic/")
public class AutomaticOperationController {


    @Autowired
    AutomaticOperationMiddleware automaticOperationMiddleware;


    @RequestMapping(value = BaseRoute.GET_AUTOMATIC_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomaticOperations(@RequestParam long userId,
                                                    @RequestParam String sessionState,
                                                    @RequestParam int reqPage,
                                                    @RequestParam int reqSize) {

        AutomaticOperationListWSModel response = automaticOperationMiddleware.getAutomaticOperations(userId,sessionState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_AUTOMATIC_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomaticOperation(@RequestParam long userId,
                                                   @RequestParam long sessionId) {

        AutomaticOperationWSModel response = automaticOperationMiddleware.getAutomaticOperation(userId,sessionId);

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

        AutomaticOperationWSModel response = automaticOperationMiddleware.createAutomaticOperation(userId,clientId,agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_AUTOMATIC_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> updateAutomaticOperation(@RequestParam long userId,
                                                      @RequestParam long sessionId) {

        AutomaticOperationWSModel response = automaticOperationMiddleware.updateAutomaticOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_AUTOMATIC_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> removeAutomaticOperation(@RequestParam long userId,
                                                      @RequestParam long sessionId) {

        AutomaticOperationWSModel response = automaticOperationMiddleware.removeAutomaticOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
