package com.faas.core.api.endpoint.controller.operation.manager.call.sip;

import com.faas.core.api.middleware.operation.manager.call.sip.ApiOperationSipCallMiddleware;
import com.faas.core.api.model.ws.operation.manager.call.sip.ApiOperationSipAccountWSModel;
import com.faas.core.api.model.ws.operation.manager.call.sip.ApiOperationSipCallWSModel;
import com.faas.core.api.model.ws.operation.manager.call.sip.ApiOperationSipChannelWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/call/sip/")
public class ApiOperationSipCallController {


    @Autowired
    ApiOperationSipCallMiddleware apiOperationSipCallMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipChannel(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiOperationSipChannelWSModel response = apiOperationSipCallMiddleware.apiGetOperationSipChannel(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipAccount(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiOperationSipAccountWSModel response = apiOperationSipCallMiddleware.apiGetOperationSipAccount(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_CALLS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipCalls(@RequestParam long agentId,
                                                     @RequestParam String operationId) {

        ApiOperationSipCallWSModel response = apiOperationSipCallMiddleware.apiGetOperationSipCalls(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipCall(@RequestParam long agentId,
                                                    @RequestParam String operationId,
                                                    @RequestParam String callId) {

        ApiOperationSipCallWSModel response = apiOperationSipCallMiddleware.apiGetOperationSipCall(agentId, operationId, callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CREATE_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateOperationSipCall(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String numberId) {

        ApiOperationSipCallWSModel response = apiOperationSipCallMiddleware.apiCreateOperationSipCall(agentId, operationId, numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_START_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiStartOperationSipCall(@RequestParam long agentId,
                                                      @RequestParam String operationId,
                                                      @RequestParam String callId) {

        ApiOperationSipCallWSModel response = apiOperationSipCallMiddleware.apiStartOperationSipCall(agentId, operationId, callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CANCEL_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiCancelOperationSipCall(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String callId) {

        ApiOperationSipCallWSModel response = apiOperationSipCallMiddleware.apiCancelOperationSipCall(agentId, operationId, callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_HANG_UP_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiHangupOperationSipCall(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String callId) {

        ApiOperationSipCallWSModel response = apiOperationSipCallMiddleware.apiHangupOperationSipCall(agentId, operationId, callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationSipCall(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String callId,
                                                       @RequestParam String callState) {

        ApiOperationSipCallWSModel response = apiOperationSipCallMiddleware.apiUpdateOperationSipCall(agentId, operationId, callId, callState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationSipCall(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String callId) {

        ApiOperationSipCallWSModel response = apiOperationSipCallMiddleware.apiRemoveOperationSipCall(agentId, operationId, callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
