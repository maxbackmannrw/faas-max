package com.faas.core.api.endpoint.controller.operation.details.channel.call.wapp;

import com.faas.core.api.middleware.operation.details.channel.call.wapp.ApiOperationWappCallChannelMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallAccountWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/channel/call/wapp/")
public class ApiOperationWappCallChannelController {


    @Autowired
    ApiOperationWappCallChannelMiddleware apiOperationWappCallChannelMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_CALL_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappCallChannel(@RequestParam long agentId,
                                                            @RequestParam String operationId) {

        ApiOperationWappCallChannelWSModel response = apiOperationWappCallChannelMiddleware.apiGetOperationWappCallChannel(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_CALLS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappCalls(@RequestParam long agentId,
                                                      @RequestParam String operationId) {

        ApiOperationWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiGetOperationWappCalls(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappCall(@RequestParam long agentId,
                                                     @RequestParam String operationId,
                                                     @RequestParam String callId) {

        ApiOperationWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiGetOperationWappCall(agentId,operationId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CREATE_OPERATION_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateOperationWappCall(@RequestParam long agentId,
                                                        @RequestParam String operationId,
                                                        @RequestParam String numberId) {

        ApiOperationWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiCreateOperationWappCall(agentId,operationId,numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_START_OPERATION_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiStartOperationWappCall(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String callId) {

        ApiOperationWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiStartOperationWappCall(agentId,operationId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_HANGUP_OPERATION_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiHangUpOperationWappCall(@RequestParam long agentId,
                                                        @RequestParam String operationId,
                                                        @RequestParam String callId) {

        ApiOperationWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiHangUpOperationWappCall(agentId,operationId,callId);

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

        ApiOperationWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiUpdateOperationWappCall(agentId,operationId,callId,callState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationWappCall(@RequestParam long agentId,
                                                        @RequestParam String operationId,
                                                        @RequestParam String callId) {

        ApiOperationWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiRemoveOperationWappCall(agentId,operationId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_CALL_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappCallAccount(@RequestParam long agentId,
                                                            @RequestParam String operationId) {

        ApiOperationWappCallAccountWSModel response = apiOperationWappCallChannelMiddleware.apiGetOperationWappCallAccount(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
