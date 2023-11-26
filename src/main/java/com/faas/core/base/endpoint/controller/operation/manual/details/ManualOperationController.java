package com.faas.core.base.endpoint.controller.operation.manual.details;

import com.faas.core.base.middleware.operation.manual.details.ManualOperationMiddleware;
import com.faas.core.base.model.ws.operation.content.OperationCampaignWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/manager/manual/operation/")
public class ManualOperationController {


    @Autowired
    ManualOperationMiddleware manualOperationMiddleware;


    @RequestMapping(value = BaseRoute.GET_MANUAL_OPERATION_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getManualOperationDetails(@RequestParam long userId) {

        OperationCampaignWSModel response = manualOperationMiddleware.getManualOperationDetails(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}