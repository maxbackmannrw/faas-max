package com.faas.core.base.endpoint.controller.manager.operation.content;

import com.faas.core.base.middleware.manager.operation.content.OperationManagerMiddleware;
import com.faas.core.base.model.ws.manager.operation.content.OperationManagerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/manager/operation/")
public class OperationManagerController {


    @Autowired
    OperationManagerMiddleware operationManagerMiddleware;


    @RequestMapping(value = BaseRoute.GET_OPERATION_MANAGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationManagers(@RequestParam long userId,
                                                  @RequestParam int reqPage,
                                                  @RequestParam int reqSize) {

        OperationManagerWSModel response = operationManagerMiddleware.getOperationManagers(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_OPERATION_MANAGERS_BY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationManagersByType(@RequestParam long userId,
                                                        @RequestParam int reqPage,
                                                        @RequestParam int reqSize) {

        OperationManagerWSModel response = operationManagerMiddleware.getOperationManagersByType(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_OPERATION_MANAGERS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationManagersByState(@RequestParam long userId,
                                                         @RequestParam int reqPage,
                                                         @RequestParam int reqSize) {

        OperationManagerWSModel response = operationManagerMiddleware.getOperationManagersByState(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_OPERATION_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationManager(@RequestParam long userId,
                                                 @RequestParam int reqPage,
                                                 @RequestParam int reqSize) {

        OperationManagerWSModel response = operationManagerMiddleware.getOperationManager(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_OPERATION_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateOperationManager(@RequestParam long userId,
                                                 @RequestParam int reqPage,
                                                 @RequestParam int reqSize) {

        OperationManagerWSModel response = operationManagerMiddleware.updateOperationManager(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_OPERATION_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeOperationManager(@RequestParam long userId,
                                                    @RequestParam int reqPage,
                                                    @RequestParam int reqSize) {

        OperationManagerWSModel response = operationManagerMiddleware.removeOperationManager(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
