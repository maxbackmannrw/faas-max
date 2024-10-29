package com.faas.core.api.endpoint.controller.operation.manager.channel.call.wapp;

import com.faas.core.api.middleware.operation.manager.channel.call.wapp.ApiOperationWappCallMiddleware;
import com.faas.core.api.model.ws.operation.manager.channel.call.wapp.ApiOperationWappCallAccountWSModel;
import com.faas.core.api.model.ws.operation.manager.channel.call.wapp.ApiOperationWappCallChannelWSModel;
import com.faas.core.api.model.ws.operation.manager.channel.call.wapp.ApiOperationWappCallWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/call/wapp/")
public class ApiOperationWappCallController {


    @Autowired
    ApiOperationWappCallMiddleware apiOperationWappCallMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_CALL_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappCallChannel(@RequestParam long agentId,
                                                            @RequestParam String operationId) {

        ApiOperationWappCallChannelWSModel response = apiOperationWappCallMiddleware.apiGetOperationWappCallChannel(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_CALL_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappCallAccount(@RequestParam long agentId,
                                                            @RequestParam String operationId) {

        ApiOperationWappCallAccountWSModel response = apiOperationWappCallMiddleware.apiGetOperationWappCallAccount(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_CALLS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappCalls(@RequestParam long agentId,
                                                      @RequestParam String operationId) {

        ApiOperationWappCallWSModel response = apiOperationWappCallMiddleware.apiGetOperationWappCalls(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappCall(@RequestParam long agentId,
                                                     @RequestParam String operationId,
                                                     @RequestParam String callId) {

        ApiOperationWappCallWSModel response = apiOperationWappCallMiddleware.apiGetOperationWappCall(agentId, operationId, callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CREATE_OPERATION_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateOperationWappCall(@RequestParam long agentId,
                                                        @RequestParam String operationId,
                                                        @RequestParam String numberId) {

        ApiOperationWappCallWSModel response = apiOperationWappCallMiddleware.apiCreateOperationWappCall(agentId, operationId, numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_START_OPERATION_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiStartOperationWappCall(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String callId) {

        ApiOperationWappCallWSModel response = apiOperationWappCallMiddleware.apiStartOperationWappCall(agentId, operationId, callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CANCEL_OPERATION_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiCancelOperationWappCall(@RequestParam long agentId,
                                                        @RequestParam String operationId,
                                                        @RequestParam String callId) {

        ApiOperationWappCallWSModel response = apiOperationWappCallMiddleware.apiCancelOperationWappCall(agentId, operationId, callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_HANGUP_OPERATION_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiHangUpOperationWappCall(@RequestParam long agentId,
                                                        @RequestParam String operationId,
                                                        @RequestParam String callId) {

        ApiOperationWappCallWSModel response = apiOperationWappCallMiddleware.apiHangUpOperationWappCall(agentId, operationId, callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationWappCall(@RequestParam long agentId,
                                                        @RequestParam String operationId,
                                                        @RequestParam String callId,
                                                        @RequestParam String callState) {

        ApiOperationWappCallWSModel response = apiOperationWappCallMiddleware.apiUpdateOperationWappCall(agentId, operationId, callId, callState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationWappCall(@RequestParam long agentId,
                                                        @RequestParam String operationId,
                                                        @RequestParam String callId) {

        ApiOperationWappCallWSModel response = apiOperationWappCallMiddleware.apiRemoveOperationWappCall(agentId, operationId, callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
