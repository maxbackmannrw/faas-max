package com.faas.core.base.endpoint.controller.operation.manager.details;

import com.faas.core.base.middleware.operation.manager.details.OperationManagerDetailsMiddleware;
import com.faas.core.base.model.ws.operation.manager.details.OperationManagerDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/manager/details/")
public class OperationManagerDetailsController {


    @Autowired
    OperationManagerDetailsMiddleware operationManagerDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_OPERATION_MANAGER_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationManagerDetails(@RequestParam long userId,
                                                        @RequestParam long sessionId) {

        OperationManagerDetailsWSModel response = operationManagerDetailsMiddleware.getOperationManagerDetails(userId, sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
