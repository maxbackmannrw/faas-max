package com.faas.core.api.endpoint.controller.operation.details.channel.content;

import com.faas.core.api.middleware.operation.details.channel.content.ApiOperationChannelMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.content.ApiOperationCallChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.content.ApiOperationMessageChannelWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/channel/")
public class ApiOperationChannelController {


    @Autowired
    ApiOperationChannelMiddleware apiOperationChannelMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CALL_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationCallChannel(@RequestParam long agentId,
                                                        @RequestParam String operationId) {

        ApiOperationCallChannelWSModel response = apiOperationChannelMiddleware.apiGetOperationCallChannel(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_MESSAGE_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationMessageChannel(@RequestParam long agentId,
                                                           @RequestParam String operationId) {

        ApiOperationMessageChannelWSModel response = apiOperationChannelMiddleware.apiGetOperationMessageChannel(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
