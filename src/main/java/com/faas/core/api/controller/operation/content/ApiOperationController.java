package com.faas.core.api.controller.operation.content;

import com.faas.core.api.middleware.operation.content.ApiOperationMiddleware;
import com.faas.core.data.ws.api.general.ApiSummaryWSModel;
import com.faas.core.data.ws.api.operation.content.ApiAgentOperationWSModel;
import com.faas.core.data.ws.api.operation.content.ApiOperationListWSModel;
import com.faas.core.data.ws.api.operation.content.ApiOperationValidateWSModel;
import com.faas.core.data.ws.api.operation.content.ApiOperationWSModel;
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


    @RequestMapping(value = ApiRoute.API_GET_AGENT_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentOperations(@RequestParam long agentId,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        ApiAgentOperationWSModel response = apiOperationMiddleware.apiGetAgentOperations(agentId, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperations(@RequestParam long agentId,
                                              @RequestParam String operationType,
                                              @RequestParam String operationState,
                                              @RequestParam String operationInquiryState,
                                              @RequestParam String operationFlowState,
                                              @RequestParam int reqPage,
                                              @RequestParam int reqSize) {

        ApiOperationListWSModel response = apiOperationMiddleware.apiGetOperations(agentId, operationType, operationState, operationInquiryState, operationFlowState, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperation(@RequestParam long agentId,
                                             @RequestParam String operationId) {

        ApiOperationWSModel response = apiOperationMiddleware.apiGetOperation(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperation(@RequestParam long agentId,
                                                @RequestParam String operationId,
                                                @RequestParam String operationState) {

        ApiOperationWSModel response = apiOperationMiddleware.apiUpdateOperation(agentId, operationId, operationState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperation(@RequestParam long agentId,
                                                @RequestParam String operationId) {

        ApiOperationWSModel response = apiOperationMiddleware.apiRemoveOperation(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_OPERATION_VALIDATE, method = RequestMethod.POST)
    public ResponseEntity<?> apiOperationValidate(@RequestParam long agentId,
                                                  @RequestParam String operationId) {

        ApiOperationValidateWSModel response = apiOperationMiddleware.apiOperationValidate(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiOperationMiddleware.apiGetOperationSummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
