package com.faas.core.api.endpoint.controller.operation.channel.call.wapp;

import com.faas.core.api.middleware.operation.channel.call.wapp.ApiWappCallMiddleware;
import com.faas.core.api.model.ws.operation.channel.call.wapp.ApiOperationWappCallWSModel;
import com.faas.core.api.model.ws.operation.channel.call.wapp.ApiWappCallWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/channel/call/wapp/")
public class ApiWappCallController {


    @Autowired
    ApiWappCallMiddleware apiWappCallMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappCall(@RequestParam long agentId,
                                                     @RequestParam long sessionId,
                                                     @RequestParam long clientId) {

        ApiOperationWappCallWSModel response = apiWappCallMiddleware.apiGetOperationWappCall(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_WAPP_CALLS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetWappCalls(@RequestParam long agentId,
                                             @RequestParam long sessionId,
                                             @RequestParam String campaignId,
                                             @RequestParam String processId) {

        ApiWappCallWSModel response = apiWappCallMiddleware.apiGetWappCalls(agentId,sessionId,campaignId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetWappCall(@RequestParam long agentId,
                                            @RequestParam long sessionId,
                                            @RequestParam long clientId,
                                            @RequestParam long callId) {

        ApiWappCallWSModel response = apiWappCallMiddleware.apiGetWappCall(agentId,sessionId,clientId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_CREATE_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateWappCall(@RequestParam long agentId,
                                               @RequestParam long sessionId,
                                               @RequestParam long clientId,
                                               @RequestParam String processId,
                                               @RequestParam long numberId) {

        ApiWappCallWSModel response = apiWappCallMiddleware.apiCreateWappCall(agentId,sessionId,clientId,processId,numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateWappCall(@RequestParam long agentId,
                                               @RequestParam long sessionId,
                                               @RequestParam long clientId,
                                               @RequestParam long callId) {

        ApiWappCallWSModel response = apiWappCallMiddleware.apiUpdateWappCall(agentId,sessionId,clientId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveWappCall(@RequestParam long agentId,
                                               @RequestParam long sessionId,
                                               @RequestParam long clientId,
                                               @RequestParam long callId) {

        ApiWappCallWSModel response = apiWappCallMiddleware.apiRemoveWappCall(agentId,sessionId,clientId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
