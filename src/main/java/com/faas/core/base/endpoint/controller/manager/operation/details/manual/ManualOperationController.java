package com.faas.core.base.endpoint.controller.manager.operation.details.manual;

import com.faas.core.base.middleware.manager.operation.details.manual.ManualOperationMiddleware;
import com.faas.core.base.model.ws.manager.operation.details.inquiry.InquiryManagerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/manager/operation/manual/")
public class ManualOperationController {


    @Autowired
    ManualOperationMiddleware manualOperationMiddleware;


    @RequestMapping(value = BaseRoute.GET_OPERATION_MANAGER_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationManagerDetails(@RequestParam long userId) {

        InquiryManagerWSModel response = manualOperationMiddleware.getOperationManagerDetails(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
