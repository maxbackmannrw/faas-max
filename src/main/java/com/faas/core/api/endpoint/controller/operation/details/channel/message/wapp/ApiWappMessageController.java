package com.faas.core.api.endpoint.controller.operation.details.channel.message.wapp;

import com.faas.core.api.middleware.operation.details.channel.message.wapp.ApiWappMessageMiddleware;
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
public class ApiWappMessageController {


    @Autowired
    ApiWappMessageMiddleware apiWappMessageMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_WAPP_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationWappMessage(@RequestParam long agentId,
                                                        @RequestParam long sessionId) {

        ApiOperationWappMessageWSModel response = apiWappMessageMiddleware.apiGetOperationWappMessage(agentId,sessionId);

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

        ApiWappMessageWSModel response = apiWappMessageMiddleware.apiGetWappMessages(agentId,sessionId,campaignId,processId);

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

        ApiWappMessageWSModel response = apiWappMessageMiddleware.apiGetWappMessage(agentId,sessionId,campaignId,processId,messageId);

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

        ApiWappMessageWSModel response = apiWappMessageMiddleware.apiSendWappMessage(agentId,sessionId,campaignId,processId,tempId,numberId);

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

        ApiWappMessageWSModel response = apiWappMessageMiddleware.apiUpdateWappMessage(agentId,sessionId,campaignId,processId,messageId);

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

        ApiWappMessageWSModel response = apiWappMessageMiddleware.apiRemoveWappMessage(agentId,sessionId,campaignId,processId,messageId);

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

        ApiWappMessageTempWSModel response = apiWappMessageMiddleware.apiGetWappMessageTemps(agentId,sessionId,campaignId,processId);

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

        ApiWappMessageTempWSModel response = apiWappMessageMiddleware.apiGetWappMessageTemp(agentId,sessionId,campaignId,processId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
