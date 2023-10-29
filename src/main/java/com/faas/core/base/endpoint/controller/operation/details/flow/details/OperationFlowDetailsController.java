package com.faas.core.base.endpoint.controller.operation.details.flow.details;

import com.faas.core.base.middleware.operation.details.flow.details.OperationFlowDetailsMiddleware;
import com.faas.core.base.model.ws.operation.flow.OperationFlowCampaignWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/flow/details/")
public class OperationFlowDetailsController {


    @Autowired
    OperationFlowDetailsMiddleware operationFlowDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_OPERATION_FLOW_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationFlowCampaigns(@RequestParam long userId,
                                                       @RequestParam int reqPage,
                                                       @RequestParam int reqSize) {

        OperationFlowCampaignWSModel response = operationFlowDetailsMiddleware.getOperationFlowCampaigns(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
