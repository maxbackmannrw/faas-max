package com.faas.core.api.endpoint.controller.operation.manager.channel.message.sms;

import com.faas.core.api.middleware.operation.manager.channel.message.sms.ApiOperationSmsMessageMiddleware;
import com.faas.core.api.model.ws.operation.manager.channel.message.sms.ApiOperationSmsAccountWSModel;
import com.faas.core.api.model.ws.operation.manager.channel.message.sms.ApiOperationSmsChannelWSModel;
import com.faas.core.api.model.ws.operation.manager.channel.message.sms.ApiOperationSmsTempWSModel;
import com.faas.core.api.model.ws.operation.manager.channel.message.sms.ApiOperationSmsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/message/sms/")
public class ApiOperationSmsMessageController {


    @Autowired
    ApiOperationSmsMessageMiddleware apiOperationSmsMessageMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SMS_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSmsChannel(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiOperationSmsChannelWSModel response = apiOperationSmsMessageMiddleware.apiGetOperationSmsChannel(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SMS_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSmsAccount(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiOperationSmsAccountWSModel response = apiOperationSmsMessageMiddleware.apiGetOperationSmsAccount(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SMS_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSmsTemps(@RequestParam long agentId,
                                                     @RequestParam String operationId) {

        ApiOperationSmsTempWSModel response = apiOperationSmsMessageMiddleware.apiGetOperationSmsTemps(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SMS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSmsTemp(@RequestParam long agentId,
                                                    @RequestParam String operationId,
                                                    @RequestParam String tempId) {

        ApiOperationSmsTempWSModel response = apiOperationSmsMessageMiddleware.apiGetOperationSmsTemp(agentId, operationId, tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SMSS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSmss(@RequestParam long agentId,
                                                 @RequestParam String operationId) {

        ApiOperationSmsWSModel response = apiOperationSmsMessageMiddleware.apiGetOperationSmss(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SMS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSms(@RequestParam long agentId,
                                                @RequestParam String operationId,
                                                @RequestParam String smsId) {

        ApiOperationSmsWSModel response = apiOperationSmsMessageMiddleware.apiGetOperationSms(agentId, operationId, smsId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_SEND_OPERATION_SMS, method = RequestMethod.POST)
    public ResponseEntity<?> apiSendOperationSms(@RequestParam long agentId,
                                                 @RequestParam String operationId,
                                                 @RequestParam String tempId,
                                                 @RequestParam String numberId) throws IOException {

        ApiOperationSmsWSModel response = apiOperationSmsMessageMiddleware.apiSendOperationSms(agentId, operationId, tempId, numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_SMS, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationSms(@RequestParam long agentId,
                                                   @RequestParam String operationId,
                                                   @RequestParam String smsId,
                                                   @RequestParam String smsState) {

        ApiOperationSmsWSModel response = apiOperationSmsMessageMiddleware.apiUpdateOperationSms(agentId, operationId, smsId, smsState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_SMS, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationSms(@RequestParam long agentId,
                                                   @RequestParam String operationId,
                                                   @RequestParam String smsId) {

        ApiOperationSmsWSModel response = apiOperationSmsMessageMiddleware.apiRemoveOperationSms(agentId, operationId, smsId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
