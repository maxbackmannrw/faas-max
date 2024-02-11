package com.faas.core.api.endpoint.controller.operation.details.channel.message.content;

import com.faas.core.api.middleware.operation.details.channel.message.content.ApiOperationMessageChannelMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.message.content.ApiOperationMessageChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.email.ApiOperationEmailChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiOperationSmsChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.ApiOperationWappMessageChannelWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/channel/message/")
public class ApiOperationMessageChannelController {


    @Autowired
    ApiOperationMessageChannelMiddleware apiOperationMessageChannelMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_MESSAGE_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationMessageChannel(@RequestParam long agentId,
                                                           @RequestParam String operationId) {

        ApiOperationMessageChannelWSModel response = apiOperationMessageChannelMiddleware.apiGetOperationMessageChannel(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SMS_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSmsChannel(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiOperationSmsChannelWSModel response = apiOperationMessageChannelMiddleware.apiGetOperationSmsChannel(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_MESSAGE_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappMessageChannel(@RequestParam long agentId,
                                                               @RequestParam String operationId) {

        ApiOperationWappMessageChannelWSModel response = apiOperationMessageChannelMiddleware.apiGetOperationWappMessageChannel(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_EMAIL_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationEmailChannel(@RequestParam long agentId,
                                                         @RequestParam String operationId) {

        ApiOperationEmailChannelWSModel response = apiOperationMessageChannelMiddleware.apiGetOperationEmailChannel(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_PUSH_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationPushChannel(@RequestParam long agentId,
                                                        @RequestParam String operationId) {

        ApiOperationPushChannelWSModel response = apiOperationMessageChannelMiddleware.apiGetOperationPushChannel(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
