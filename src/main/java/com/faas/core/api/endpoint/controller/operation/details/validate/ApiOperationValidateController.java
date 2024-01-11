package com.faas.core.api.endpoint.controller.operation.details.validate;

import com.faas.core.api.middleware.operation.details.validate.ApiOperationValidateMiddleware;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/validate/")
public class ApiOperationValidateController {


    @Autowired
    ApiOperationValidateMiddleware apiOperationValidateMiddleware;


    @RequestMapping(value = ApiRoute.API_OPERATION_VALIDATE, method = RequestMethod.POST)
    public ResponseEntity<?> apiOperationValidate(@RequestParam long agentId,
                                                  @RequestParam long sessionId) {

        ApiOperationDetailsWSModel response = apiOperationValidateMiddleware.apiOperationValidate(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_AGENT_OPERATION_VALIDATE, method = RequestMethod.POST)
    public ResponseEntity<?> apiAgentOperationValidate(@RequestParam long agentId,
                                                       @RequestParam long sessionId,
                                                       @RequestParam String sessionState,
                                                       @RequestParam String operationState) {

        ApiOperationWSModel response = apiOperationValidateMiddleware.apiAgentOperationValidate(agentId,sessionId,sessionState,operationState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_OPERATION_LAUNCH, method = RequestMethod.POST)
    public ResponseEntity<?> apiOperationLaunch(@RequestParam long agentId,
                                                @RequestParam long sessionId,
                                                @RequestParam long clientId,
                                                @RequestParam String campaignId) {

        ApiOperationWSModel response = apiOperationValidateMiddleware.apiOperationLaunch(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_OPERATION_FINISH, method = RequestMethod.POST)
    public ResponseEntity<?> apiOperationFinish(@RequestParam long agentId,
                                                @RequestParam long sessionId,
                                                @RequestParam long clientId,
                                                @RequestParam String campaignId,
                                                @RequestParam String operationResult) {

        ApiOperationWSModel response = apiOperationValidateMiddleware.apiOperationFinish(agentId,sessionId,clientId,campaignId,operationResult);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
