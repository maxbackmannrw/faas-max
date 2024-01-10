package com.faas.core.api.endpoint.controller.operation.details.channel.call.sip;

import com.faas.core.api.middleware.operation.details.channel.call.sip.ApiSipCallMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipCallWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiSipCallWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/channel/call/sip/")
public class ApiSipCallController {


    @Autowired
    ApiSipCallMiddleware apiSipCallMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipCall(@RequestParam long agentId,
                                                    @RequestParam long sessionId,
                                                    @RequestParam long clientId) {

        ApiOperationSipCallWSModel response = apiSipCallMiddleware.apiGetOperationSipCall(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SIP_CALLS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSipCalls(@RequestParam long agentId,
                                            @RequestParam long sessionId,
                                            @RequestParam long clientId) {

        ApiSipCallWSModel response = apiSipCallMiddleware.apiGetSipCalls(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSipCall(@RequestParam long agentId,
                                           @RequestParam long sessionId,
                                           @RequestParam long clientId,
                                           @RequestParam long callId) {

        ApiSipCallWSModel response = apiSipCallMiddleware.apiGetSipCall(agentId,sessionId,clientId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_CREATE_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateSipCall(@RequestParam long agentId,
                                              @RequestParam long sessionId,
                                              @RequestParam long clientId,
                                              @RequestParam long numberId) {

        ApiSipCallWSModel response = apiSipCallMiddleware.apiCreateSipCall(agentId,sessionId,clientId,numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_MAKE_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiMakeSipCall(@RequestParam long agentId,
                                            @RequestParam long sessionId,
                                            @RequestParam long clientId,
                                            @RequestParam long callId) {

        ApiSipCallWSModel response = apiSipCallMiddleware.apiMakeSipCall(agentId,sessionId,clientId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_END_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiEndSipCall(@RequestParam long agentId,
                                           @RequestParam long sessionId,
                                           @RequestParam long clientId,
                                           @RequestParam long callId) {

        ApiSipCallWSModel response = apiSipCallMiddleware.apiEndSipCall(agentId,sessionId,clientId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_FINISH_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiFinishSipCall(@RequestParam long agentId,
                                              @RequestParam long sessionId,
                                              @RequestParam long clientId,
                                              @RequestParam long callId) {

        ApiSipCallWSModel response = apiSipCallMiddleware.apiFinishSipCall(agentId,sessionId,clientId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateSipCall(@RequestParam long agentId,
                                              @RequestParam long sessionId,
                                              @RequestParam long clientId,
                                              @RequestParam long callId,
                                              @RequestParam String callState) {

        ApiSipCallWSModel response = apiSipCallMiddleware.apiUpdateSipCall(agentId,sessionId,clientId,callId,callState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveSipCall(@RequestParam long agentId,
                                              @RequestParam long sessionId,
                                              @RequestParam long clientId,
                                              @RequestParam long callId) {

        ApiSipCallWSModel response = apiSipCallMiddleware.apiRemoveSipCall(agentId,sessionId,clientId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
