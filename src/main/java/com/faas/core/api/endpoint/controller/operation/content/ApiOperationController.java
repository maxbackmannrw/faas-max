package com.faas.core.api.endpoint.controller.operation.content;

import com.faas.core.api.middleware.operation.content.ApiOperationMiddleware;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.operation.content.ApiAgentOperationWSModel;
import com.faas.core.api.model.ws.operation.content.ApiValidateOperationWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.misc.config.ApiRoute;
import com.faas.core.misc.config.AppConstant;
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


    @RequestMapping(value = ApiRoute.API_GET_AGENT_OPERATION_LISTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentOperationLists(@RequestParam long agentId,
                                                       @RequestParam int reqPage,
                                                       @RequestParam int reqSize) {

        ApiAgentOperationWSModel response = apiOperationMiddleware.apiGetAgentOperationLists(agentId, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_AGENT_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentOperations(@RequestParam long agentId,
                                                   @RequestParam String operationState,
                                                   @RequestParam String operationCategory,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        ApiOperationWSModel response = apiOperationMiddleware.apiGetAgentOperations(agentId, operationCategory, operationState, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_AGENT_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentOperation(@RequestParam long agentId,
                                                  @RequestParam String operationId) {

        ApiOperationWSModel response = apiOperationMiddleware.apiGetAgentOperation(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_AGENT_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateAgentOperation(@RequestParam long agentId,
                                                     @RequestParam String operationId,
                                                     @RequestParam String operationState) {

        ApiOperationWSModel response = apiOperationMiddleware.apiUpdateAgentOperation(agentId, operationId, operationState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_AGENT_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveAgentOperation(@RequestParam long agentId,
                                                     @RequestParam String operationId) {

        ApiOperationWSModel response = apiOperationMiddleware.apiRemoveAgentOperation(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_VALIDATE_AGENT_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiValidateAgentOperation(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiValidateOperationWSModel response = apiOperationMiddleware.apiValidateAgentOperation(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_AGENT_OPERATIONS_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentOperationsSummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiOperationMiddleware.apiGetAgentOperationsSummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
