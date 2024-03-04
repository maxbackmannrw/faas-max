package com.faas.core.api.endpoint.controller.operation.details.channel.call.sip;

import com.faas.core.api.middleware.operation.details.channel.call.sip.ApiOperationSipChannelMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipAccountWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipCallWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipChannelWSModel;
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
public class ApiOperationSipChannelController {


    @Autowired
    ApiOperationSipChannelMiddleware apiOperationSipChannelMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipChannel(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiOperationSipChannelWSModel response = apiOperationSipChannelMiddleware.apiGetOperationSipChannel(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_CALLS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipCalls(@RequestParam long agentId,
                                                     @RequestParam String operationId) {

        ApiOperationSipCallWSModel response = apiOperationSipChannelMiddleware.apiGetOperationSipCalls(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipCall(@RequestParam long agentId,
                                                    @RequestParam String operationId,
                                                    @RequestParam String callId) {

        ApiOperationSipCallWSModel response = apiOperationSipChannelMiddleware.apiGetOperationSipCall(agentId,operationId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CREATE_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateOperationSipCall(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String numberId) {

        ApiOperationSipCallWSModel response = apiOperationSipChannelMiddleware.apiCreateOperationSipCall(agentId,operationId,numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationSipCall(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String callId,
                                                       @RequestParam String updateType) {

        ApiOperationSipCallWSModel response = apiOperationSipChannelMiddleware.apiUpdateOperationSipCall(agentId,operationId,callId,updateType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationSipCall(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String callId) {

        ApiOperationSipCallWSModel response = apiOperationSipChannelMiddleware.apiRemoveOperationSipCall(agentId,operationId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipAccount(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiOperationSipAccountWSModel response = apiOperationSipChannelMiddleware.apiGetOperationSipAccount(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
