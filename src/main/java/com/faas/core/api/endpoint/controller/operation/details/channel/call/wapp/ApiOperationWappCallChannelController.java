package com.faas.core.api.endpoint.controller.operation.details.channel.call.wapp;

import com.faas.core.api.middleware.operation.details.channel.call.wapp.ApiOperationWappCallChannelMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiWappCallWSModel;
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


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappCall(@RequestParam long agentId,
                                                     @RequestParam long sessionId,
                                                     @RequestParam long clientId) {

        ApiOperationWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiGetOperationWappCall(agentId,sessionId,clientId);

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

        ApiWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiGetWappCalls(agentId,sessionId,campaignId,processId);

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

        ApiWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiGetWappCall(agentId,sessionId,clientId,callId);

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

        ApiWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiCreateWappCall(agentId,sessionId,clientId,processId,numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_MAKE_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiMakeWappCall(@RequestParam long agentId,
                                             @RequestParam long sessionId,
                                             @RequestParam long clientId,
                                             @RequestParam String processId,
                                             @RequestParam long numberId) {

        ApiWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiMakeWappCall(agentId,sessionId,clientId,processId,numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_END_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiEndWappCall(@RequestParam long agentId,
                                            @RequestParam long sessionId,
                                            @RequestParam long clientId,
                                            @RequestParam String processId,
                                            @RequestParam long numberId) {

        ApiWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiEndWappCall(agentId,sessionId,clientId,processId,numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_FINISH_WAPP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiFinishWappCall(@RequestParam long agentId,
                                               @RequestParam long sessionId,
                                               @RequestParam long clientId,
                                               @RequestParam String processId,
                                               @RequestParam long numberId) {

        ApiWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiFinishWappCall(agentId,sessionId,clientId,processId,numberId);

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

        ApiWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiUpdateWappCall(agentId,sessionId,clientId,callId);

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

        ApiWappCallWSModel response = apiOperationWappCallChannelMiddleware.apiRemoveWappCall(agentId,sessionId,clientId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
