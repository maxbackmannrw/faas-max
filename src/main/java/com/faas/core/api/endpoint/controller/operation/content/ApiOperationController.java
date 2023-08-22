package com.faas.core.api.endpoint.controller.operation.content;

import com.faas.core.api.middleware.operation.content.ApiOperationMiddleware;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/")
public class ApiOperationController {


    @Autowired
    ApiOperationMiddleware apiOperationMiddleware;



    @RequestMapping(value = ApiRoute.API_GET_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperation(@RequestParam long agentId,
                                             @RequestParam long sessionId,
                                             @RequestParam long clientId) {

        ApiOperationWSModel response = apiOperationMiddleware.apiGetOperation(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_VALIDATE_AGENT_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiValidateAgentOperation(@RequestParam long agentId,
                                                       @RequestParam long sessionId,
                                                       @RequestParam String sessionState,
                                                       @RequestParam String operationState) {

        ApiOperationWSModel response = apiOperationMiddleware.apiValidateAgentOperation(agentId,sessionId,sessionState,operationState);

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

        ApiOperationWSModel response = apiOperationMiddleware.apiOperationLaunch(agentId,sessionId,clientId,campaignId);

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

        ApiOperationWSModel response = apiOperationMiddleware.apiOperationFinish(agentId,sessionId,clientId,campaignId,operationResult);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_OPERATION_UPDATE, method = RequestMethod.POST)
    public ResponseEntity<?> apiOperationUpdate(@RequestParam long agentId,
                                                @RequestParam long sessionId,
                                                @RequestParam long clientId,
                                                @RequestParam String campaignId) {

        ApiOperationWSModel response = apiOperationMiddleware.apiOperationUpdate(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_OPERATION_REMOVE, method = RequestMethod.POST)
    public ResponseEntity<?> apiOperationRemove(@RequestParam long agentId,
                                                @RequestParam long sessionId,
                                                @RequestParam long clientId,
                                                @RequestParam String campaignId) {

        ApiOperationWSModel response = apiOperationMiddleware.apiOperationRemove(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
