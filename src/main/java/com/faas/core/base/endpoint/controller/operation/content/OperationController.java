package com.faas.core.base.endpoint.controller.operation.content;

import com.faas.core.base.middleware.operation.content.OperationMiddleware;
import com.faas.core.base.model.ws.operation.content.OperationListWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/")
public class OperationController {

    @Autowired
    OperationMiddleware operationMiddleware;

    @RequestMapping(value = BaseRoute.GET_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getOperations(@RequestParam long userId,
                                           @RequestParam String operationState,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        OperationListWSModel response = operationMiddleware.getOperations(userId, operationState, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_OPERATIONS_BY_CATEGORY, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationsByCategory(@RequestParam long userId,
                                                     @RequestParam String operationCategory,
                                                     @RequestParam String operationState,
                                                     @RequestParam int reqPage,
                                                     @RequestParam int reqSize) {

        OperationListWSModel response = operationMiddleware.getOperationsByCategory(userId, operationCategory, operationState, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> getOperation(@RequestParam long userId,
                                          @RequestParam String operationId) {

        OperationWSModel response = operationMiddleware.getOperation(userId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> createOperation(@RequestParam long userId) {

        OperationWSModel response = operationMiddleware.createOperation(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> updateOperation(@RequestParam long userId,
                                             @RequestParam String operationId) {

        OperationWSModel response = operationMiddleware.updateOperation(userId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> removeOperation(@RequestParam long userId,
                                             @RequestParam String operationId) {

        OperationWSModel response = operationMiddleware.removeOperation(userId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_OPERATION_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationDetails(@RequestParam long userId,
                                                 @RequestParam long sessionId) {

        OperationListWSModel response = operationMiddleware.getOperationDetails(userId, sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
