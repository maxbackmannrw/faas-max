package com.faas.core.api.endpoint.controller.operation.details.content;

import com.faas.core.api.middleware.operation.details.content.ApiOperationDetailsMiddleware;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignDetailsWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
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
                                                    @RequestParam String operationId) {

        ApiOperationDetailsWSModel response = apiOperationDetailsMiddleware.apiGetOperationDetails(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_START_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiStartOperation(@RequestParam long agentId,
                                               @RequestParam String operationId) {

        ApiOperationWSModel response = apiOperationDetailsMiddleware.apiStartOperation(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_FINISH_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiFinishOperation(@RequestParam long agentId,
                                                @RequestParam String operationId,
                                                @RequestParam String operationEndResult) {

        ApiOperationWSModel response = apiOperationDetailsMiddleware.apiFinishOperation(agentId,operationId,operationEndResult);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_SWITCHABLE_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSwichtableOperations(@RequestParam long agentId,
                                                        @RequestParam String operationId) {

        ApiOperationWSModel response = apiOperationDetailsMiddleware.apiGetSwichtableOperations(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_SWITCH_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiSwitchOperation(@RequestParam long agentId,
                                                @RequestParam String operationId,
                                                @RequestParam String selectedId) {

        ApiOperationWSModel response = apiOperationDetailsMiddleware.apiSwitchOperation(agentId,operationId,selectedId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationCampaign(@RequestParam long agentId,
                                                     @RequestParam String operationId) {

        ApiCampaignDetailsWSModel response = apiOperationDetailsMiddleware.apiGetOperationCampaign(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
