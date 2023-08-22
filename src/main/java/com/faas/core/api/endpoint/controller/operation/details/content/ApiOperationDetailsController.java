package com.faas.core.api.endpoint.controller.operation.details.content;

import com.faas.core.api.middleware.operation.details.content.ApiOperationDetailsMiddleware;
import com.faas.core.api.model.ws.operation.details.content.ApiOperationCampaignWSModel;
import com.faas.core.api.model.ws.operation.details.content.ApiOperationDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/")
public class ApiOperationDetailsController {


    @Autowired
    ApiOperationDetailsMiddleware apiOperationDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationDetails(@RequestParam long agentId,
                                                    @RequestParam long sessionId,
                                                    @RequestParam long clientId,
                                                    @RequestParam String campaignId,
                                                    @RequestParam String processId,
                                                    @RequestParam String operationId) {

        ApiOperationDetailsWSModel response = apiOperationDetailsMiddleware.apiGetOperationDetails(agentId,sessionId,clientId,campaignId,processId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_OPERATION_VALIDATE, method = RequestMethod.POST)
    public ResponseEntity<?> apiOperationValidate(@RequestParam long agentId,
                                                  @RequestParam long sessionId) {

        ApiOperationDetailsWSModel response = apiOperationDetailsMiddleware.apiOperationValidate(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationCampaign(@RequestParam long agentId,
                                                     @RequestParam long sessionId,
                                                     @RequestParam long clientId,
                                                     @RequestParam String campaignId,
                                                     @RequestParam String processId) {

        ApiOperationCampaignWSModel response = apiOperationDetailsMiddleware.apiGetOperationCampaign(agentId,sessionId,clientId,campaignId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
