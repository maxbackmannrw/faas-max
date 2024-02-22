package com.faas.core.api.endpoint.controller.operation.details.channel.call.content;

import com.faas.core.api.middleware.operation.details.channel.call.content.ApiOperationCallChannelMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.call.content.ApiOperationCallChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallChannelWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/channel/call/")
public class ApiOperationCallChannelController {


    @Autowired
    ApiOperationCallChannelMiddleware apiOperationCallChannelMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CALL_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationCallChannel(@RequestParam long agentId,
                                                        @RequestParam String operationId) {

        ApiOperationCallChannelWSModel response = apiOperationCallChannelMiddleware.apiGetOperationCallChannel(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipChannel(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiOperationSipChannelWSModel response = apiOperationCallChannelMiddleware.apiGetOperationSipChannel(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_CALL_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappCallChannel(@RequestParam long agentId,
                                                            @RequestParam String operationId) {

        ApiOperationWappCallChannelWSModel response = apiOperationCallChannelMiddleware.apiGetOperationWappCallChannel(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
