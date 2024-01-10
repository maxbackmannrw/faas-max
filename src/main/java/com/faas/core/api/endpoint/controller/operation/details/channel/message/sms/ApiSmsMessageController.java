package com.faas.core.api.endpoint.controller.operation.details.channel.message.sms;

import com.faas.core.api.middleware.operation.details.channel.message.sms.ApiSmsMessageMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiOperationSmsMessageWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiSmsMessageTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiSmsMessageWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/channel/message/sms/")
public class ApiSmsMessageController {


    @Autowired
    ApiSmsMessageMiddleware apiSmsMessageMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SMS_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSmsMessage(@RequestParam long agentId,
                                                       @RequestParam long sessionId) {

        ApiOperationSmsMessageWSModel response = apiSmsMessageMiddleware.apiGetOperationSmsMessage(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SMS_MESSAGES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSmsMessages(@RequestParam long agentId,
                                               @RequestParam long sessionId,
                                               @RequestParam String campaignId,
                                               @RequestParam String processId) {

        ApiSmsMessageWSModel response = apiSmsMessageMiddleware.apiGetSmsMessages(agentId,sessionId,campaignId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SMS_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSmsMessage(@RequestParam long agentId,
                                              @RequestParam long sessionId,
                                              @RequestParam String campaignId,
                                              @RequestParam String processId,
                                              @RequestParam String messageId) {

        ApiSmsMessageWSModel response = apiSmsMessageMiddleware.apiGetSmsMessage(agentId,sessionId,campaignId,processId,messageId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_SEND_SMS_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiSendSmsMessage(@RequestParam long agentId,
                                               @RequestParam long sessionId,
                                               @RequestParam String campaignId,
                                               @RequestParam String processId,
                                               @RequestParam String tempId,
                                               @RequestParam long numberId) throws IOException {

        ApiSmsMessageWSModel response = apiSmsMessageMiddleware.apiSendSmsMessage(agentId,sessionId,campaignId,processId,tempId,numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_SMS_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateSmsMessage(@RequestParam long agentId,
                                                 @RequestParam long sessionId,
                                                 @RequestParam String campaignId,
                                                 @RequestParam String processId,
                                                 @RequestParam String messageId) {

        ApiSmsMessageWSModel response = apiSmsMessageMiddleware.apiUpdateSmsMessage(agentId,sessionId,campaignId,processId,messageId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_SMS_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveSmsMessage(@RequestParam long agentId,
                                                 @RequestParam long sessionId,
                                                 @RequestParam String campaignId,
                                                 @RequestParam String processId,
                                                 @RequestParam String messageId) {

        ApiSmsMessageWSModel response = apiSmsMessageMiddleware.apiRemoveSmsMessage(agentId,sessionId,campaignId,processId,messageId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




    @RequestMapping(value = ApiRoute.API_GET_SMS_MESSAGE_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSmsMessageTemps(@RequestParam long agentId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam String campaignId,
                                                   @RequestParam String processId) {

        ApiSmsMessageTempWSModel response = apiSmsMessageMiddleware.apiGetSmsMessageTemps(agentId,sessionId,campaignId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SMS_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSmsMessageTemp(@RequestParam long agentId,
                                                  @RequestParam long sessionId,
                                                  @RequestParam String campaignId,
                                                  @RequestParam String processId,
                                                  @RequestParam String tempId) {

        ApiSmsMessageTempWSModel response = apiSmsMessageMiddleware.apiGetSmsMessageTemp(agentId,sessionId,campaignId,processId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
