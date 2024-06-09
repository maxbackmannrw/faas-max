package com.faas.core.base.endpoint.controller.operation.details;

import com.faas.core.base.middleware.operation.details.OperationDetailsMiddleware;
import com.faas.core.base.model.ws.operation.content.OperationListWSModel;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/details/")
public class OperationDetailsController {


    @Autowired
    OperationDetailsMiddleware operationDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_OPERATION_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationDetails(@RequestParam long userId,
                                                 @RequestParam long sessionId) {

        OperationListWSModel response = operationDetailsMiddleware.getOperationDetails(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
