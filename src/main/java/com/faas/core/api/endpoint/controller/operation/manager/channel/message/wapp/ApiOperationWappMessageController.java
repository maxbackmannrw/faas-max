package com.faas.core.api.endpoint.controller.operation.manager.channel.message.wapp;

import com.faas.core.api.middleware.operation.manager.channel.message.wapp.ApiOperationWappMessageMiddleware;
import com.faas.core.api.model.ws.operation.manager.channel.message.wapp.ApiOperationWappMessageAccountWSModel;
import com.faas.core.api.model.ws.operation.manager.channel.message.wapp.ApiOperationWappMessageChannelWSModel;
import com.faas.core.api.model.ws.operation.manager.channel.message.wapp.ApiOperationWappMessageTempWSModel;
import com.faas.core.api.model.ws.operation.manager.channel.message.wapp.ApiOperationWappMessageWSModel;
import com.faas.core.misc.config.ApiRoute;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/channel/message/wapp/")
public class ApiOperationWappMessageController {


    @Autowired
    ApiOperationWappMessageMiddleware apiOperationWappMessageMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_MESSAGE_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappMessageChannel(@RequestParam long agentId,
                                                               @RequestParam String operationId) {

        ApiOperationWappMessageChannelWSModel response = apiOperationWappMessageMiddleware.apiGetOperationWappMessageChannel(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_MESSAGE_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappMessageAccount(@RequestParam long agentId,
                                                               @RequestParam String operationId) {

        ApiOperationWappMessageAccountWSModel response = apiOperationWappMessageMiddleware.apiGetOperationWappMessageAccount(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_MESSAGE_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappMessageTemps(@RequestParam long agentId,
                                                             @RequestParam String operationId) {

        ApiOperationWappMessageTempWSModel response = apiOperationWappMessageMiddleware.apiGetOperationWappMessageTemps(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappMessageTemp(@RequestParam long agentId,
                                                            @RequestParam String operationId,
                                                            @RequestParam String tempId) {

        ApiOperationWappMessageTempWSModel response = apiOperationWappMessageMiddleware.apiGetOperationWappMessageTemp(agentId, operationId, tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_MESSAGES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappMessages(@RequestParam long agentId,
                                                         @RequestParam String operationId) {

        ApiOperationWappMessageWSModel response = apiOperationWappMessageMiddleware.apiGetOperationWappMessages(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappMessage(@RequestParam long agentId,
                                                        @RequestParam String operationId,
                                                        @RequestParam String messageId) {

        ApiOperationWappMessageWSModel response = apiOperationWappMessageMiddleware.apiGetOperationWappMessage(agentId, operationId, messageId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_SEND_OPERATION_WAPP_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiSendOperationWappMessage(@RequestParam long agentId,
                                                         @RequestParam String operationId,
                                                         @RequestParam String tempId,
                                                         @RequestParam String numberId) throws IOException {

        ApiOperationWappMessageWSModel response = apiOperationWappMessageMiddleware.apiSendOperationWappMessage(agentId, operationId, tempId, numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_WAPP_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationWappMessage(@RequestParam long agentId,
                                                           @RequestParam String operationId,
                                                           @RequestParam String messageId,
                                                           @RequestParam String messageState) {

        ApiOperationWappMessageWSModel response = apiOperationWappMessageMiddleware.apiUpdateOperationWappMessage(agentId, operationId, messageId, messageState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_WAPP_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationWappMessage(@RequestParam long agentId,
                                                           @RequestParam String operationId,
                                                           @RequestParam String messageId) {

        ApiOperationWappMessageWSModel response = apiOperationWappMessageMiddleware.apiRemoveOperationWappMessage(agentId, operationId, messageId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
