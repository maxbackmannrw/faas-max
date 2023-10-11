
package com.faas.core.api.endpoint.controller.flow.details;

import com.faas.core.api.middleware.flow.details.ApiOperationFlowDetailsMiddleware;
import com.faas.core.api.model.ws.flow.details.ApiFlowDetailsWSModel;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/flow/details/")
public class ApiOperationFlowDetailsController {


    @Autowired
    ApiOperationFlowDetailsMiddleware apiOperationFlowDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_FLOW_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationFlowDetails(@RequestParam long agentId,
                                                        @RequestParam long inquiryId) {

        ApiFlowDetailsWSModel response = apiOperationFlowDetailsMiddleware.apiGetOperationFlowDetails(agentId,inquiryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_FLOW_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationFlowSummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiOperationFlowDetailsMiddleware.apiGetOperationFlowSummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
