package com.faas.core.api.endpoint.controller.operation.details.channel.call.sip;

import com.faas.core.api.middleware.operation.details.channel.call.sip.ApiOperationSipMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipAccountWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipCallWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipChannelWSModel;
import com.faas.core.utility.config.ApiRoute;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/channel/call/sip/")
public class ApiOperationSipController {


    @Autowired
    ApiOperationSipMiddleware apiOperationSipMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipChannel(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiOperationSipChannelWSModel response = apiOperationSipMiddleware.apiGetOperationSipChannel(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipAccount(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiOperationSipAccountWSModel response = apiOperationSipMiddleware.apiGetOperationSipAccount(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_CALLS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipCalls(@RequestParam long agentId,
                                                     @RequestParam String operationId) {

        ApiOperationSipCallWSModel response = apiOperationSipMiddleware.apiGetOperationSipCalls(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipCall(@RequestParam long agentId,
                                                    @RequestParam String operationId,
                                                    @RequestParam String callId) {

        ApiOperationSipCallWSModel response = apiOperationSipMiddleware.apiGetOperationSipCall(agentId,operationId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CREATE_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateOperationSipCall(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String numberId) {

        ApiOperationSipCallWSModel response = apiOperationSipMiddleware.apiCreateOperationSipCall(agentId,operationId,numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_START_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiStartOperationSipCall(@RequestParam long agentId,
                                                      @RequestParam String operationId,
                                                      @RequestParam String callId) {

        ApiOperationSipCallWSModel response = apiOperationSipMiddleware.apiStartOperationSipCall(agentId,operationId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CANCEL_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiCancelOperationSipCall(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String callId) {

        ApiOperationSipCallWSModel response = apiOperationSipMiddleware.apiCancelOperationSipCall(agentId,operationId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_HANG_UP_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiHangupOperationSipCall(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String callId) {

        ApiOperationSipCallWSModel response = apiOperationSipMiddleware.apiHangupOperationSipCall(agentId,operationId,callId);

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

        ApiOperationSipCallWSModel response = apiOperationSipMiddleware.apiUpdateOperationSipCall(agentId,operationId,callId,callState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationSipCall(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String callId) {

        ApiOperationSipCallWSModel response = apiOperationSipMiddleware.apiRemoveOperationSipCall(agentId,operationId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
