package com.faas.core.api.endpoint.controller.operation.details.channel.message.wapp;

import com.faas.core.api.middleware.operation.details.channel.message.wapp.ApiOperationWappMessageChannelMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.ApiOperationWappMessageWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.ApiWappMessageTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.ApiWappMessageWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/channel/message/wapp/")
public class ApiOperationWappMessageChannelController {


    @Autowired
    ApiOperationWappMessageChannelMiddleware apiOperationWappMessageChannelMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappMessage(@RequestParam long agentId,
                                                        @RequestParam long sessionId) {

        ApiOperationWappMessageWSModel response = apiOperationWappMessageChannelMiddleware.apiGetOperationWappMessage(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_WAPP_MESSAGES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetWappMessages(@RequestParam long agentId,
                                                @RequestParam long sessionId,
                                                @RequestParam String campaignId,
                                                @RequestParam String processId) {

        ApiWappMessageWSModel response = apiOperationWappMessageChannelMiddleware.apiGetWappMessages(agentId,sessionId,campaignId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_WAPP_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetWappMessage(@RequestParam long agentId,
                                               @RequestParam long sessionId,
                                               @RequestParam String campaignId,
                                               @RequestParam String processId,
                                               @RequestParam String messageId) {

        ApiWappMessageWSModel response = apiOperationWappMessageChannelMiddleware.apiGetWappMessage(agentId,sessionId,campaignId,processId,messageId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_SEND_WAPP_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiSendWappMessage(@RequestParam long agentId,
                                                @RequestParam long sessionId,
                                                @RequestParam String campaignId,
                                                @RequestParam String processId,
                                                @RequestParam String tempId,
                                                @RequestParam long numberId) throws IOException {

        ApiWappMessageWSModel response = apiOperationWappMessageChannelMiddleware.apiSendWappMessage(agentId,sessionId,campaignId,processId,tempId,numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_WAPP_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateWappMessage(@RequestParam long agentId,
                                                  @RequestParam long sessionId,
                                                  @RequestParam String campaignId,
                                                  @RequestParam String processId,
                                                  @RequestParam String messageId) {

        ApiWappMessageWSModel response = apiOperationWappMessageChannelMiddleware.apiUpdateWappMessage(agentId,sessionId,campaignId,processId,messageId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_WAPP_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveWappMessage(@RequestParam long agentId,
                                                  @RequestParam long sessionId,
                                                  @RequestParam String campaignId,
                                                  @RequestParam String processId,
                                                  @RequestParam String messageId) {

        ApiWappMessageWSModel response = apiOperationWappMessageChannelMiddleware.apiRemoveWappMessage(agentId,sessionId,campaignId,processId,messageId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_WAPP_MESSAGE_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetWappMessageTemps(@RequestParam long agentId,
                                                    @RequestParam long sessionId,
                                                    @RequestParam String campaignId,
                                                    @RequestParam String processId) {

        ApiWappMessageTempWSModel response = apiOperationWappMessageChannelMiddleware.apiGetWappMessageTemps(agentId,sessionId,campaignId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetWappMessageTemp(@RequestParam long agentId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam String campaignId,
                                                   @RequestParam String processId,
                                                   @RequestParam String tempId) {

        ApiWappMessageTempWSModel response = apiOperationWappMessageChannelMiddleware.apiGetWappMessageTemp(agentId,sessionId,campaignId,processId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
