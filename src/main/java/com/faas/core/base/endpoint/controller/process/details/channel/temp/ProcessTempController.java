package com.faas.core.base.endpoint.controller.process.details.channel.temp;

import com.faas.core.base.middleware.process.details.channel.temp.ProcessTempMiddleware;
import com.faas.core.base.model.ws.process.details.channel.temp.*;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/channel/temp/")
public class ProcessTempController {


    @Autowired
    ProcessTempMiddleware processTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessTemps(@RequestParam long userId,
                                             @RequestParam String processId) {

        ProcessTempWSModel response = processTempMiddleware.getProcessTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_SMS_MESSAGE_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSmsMessageTemps(@RequestParam long userId,
                                                       @RequestParam String processId) {

        SmsMessageTempWSModel response = processTempMiddleware.getProcessSmsMessageTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_SMS_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getSmsMessageTemp(@RequestParam long userId,
                                               @RequestParam String tempId) {

        SmsMessageTempWSModel response = processTempMiddleware.getSmsMessageTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SMS_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createSmsMessageTemp(@RequestParam long userId,
                                                  @RequestParam String processId,
                                                  @RequestParam String smsTitle,
                                                  @RequestParam String smsBody,
                                                  @RequestParam String senderId,
                                                  @RequestParam long typeId) {

        SmsMessageTempWSModel response = processTempMiddleware.createSmsMessageTemp(userId,processId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SMS_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateSmsMessageTemp(@RequestParam long userId,
                                                  @RequestParam String tempId,
                                                  @RequestParam String smsTitle,
                                                  @RequestParam String smsBody,
                                                  @RequestParam String senderId,
                                                  @RequestParam long typeId) {

        SmsMessageTempWSModel response = processTempMiddleware.updateSmsMessageTemp(userId,tempId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_SMS_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeSmsMessageTemp(@RequestParam long userId,
                                                  @RequestParam String tempId) {

        SmsMessageTempWSModel response = processTempMiddleware.removeSmsMessageTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_MESSAGE_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappMessageTemps(@RequestParam long userId,
                                                        @RequestParam String processId) {

        WappMessageTempWSModel response = processTempMiddleware.getProcessWappMessageTemps(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getWappMessageTemp(@RequestParam long userId,
                                                @RequestParam String tempId) {

        WappMessageTempWSModel response = processTempMiddleware.getWappMessageTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createWappMessageTemp(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam String wappTitle,
                                                   @RequestParam String wappBody,
                                                   @RequestParam long typeId) {

        WappMessageTempWSModel response = processTempMiddleware.createWappMessageTemp(userId,processId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateWappMessageTemp(@RequestParam long userId,
                                                   @RequestParam String tempId,
                                                   @RequestParam String wappTitle,
                                                   @RequestParam String wappBody,
                                                   @RequestParam long typeId) {

        WappMessageTempWSModel response = processTempMiddleware.updateWappMessageTemp(userId,tempId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeWappMessageTemp(@RequestParam long userId,
                                                   @RequestParam String tempId) {

        WappMessageTempWSModel response = processTempMiddleware.removeWappMessageTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_EMAIL_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessEmailTemps(@RequestParam long userId,
                                                  @RequestParam String processId) {

        EmailTempWSModel response = processTempMiddleware.getProcessEmailTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getEmailTemp(@RequestParam long userId,
                                          @RequestParam String tempId) {

        EmailTempWSModel response = processTempMiddleware.getEmailTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createEmailTemp(@RequestParam long userId,
                                             @RequestParam String processId,
                                             @RequestParam String emailSubject,
                                             @RequestParam String emailBody,
                                             @RequestParam String emailFooter,
                                             @RequestParam String emailSender,
                                             @RequestParam long typeId) {

        EmailTempWSModel response = processTempMiddleware.createEmailTemp(userId,processId,emailSubject,emailBody,emailFooter,emailSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateEmailTemp(@RequestParam long userId,
                                             @RequestParam String tempId,
                                             @RequestParam String emailSubject,
                                             @RequestParam String emailBody,
                                             @RequestParam String emailFooter,
                                             @RequestParam String emailSender,
                                             @RequestParam long typeId) {

        EmailTempWSModel response = processTempMiddleware.updateEmailTemp(userId,tempId,emailSubject,emailBody,emailFooter,emailSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeEmailTemp(@RequestParam long userId,
                                             @RequestParam String tempId) {

        EmailTempWSModel response = processTempMiddleware.removeEmailTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_PUSH_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessPushTemps(@RequestParam long userId,
                                                 @RequestParam String processId) {

        PushTempWSModel response = processTempMiddleware.getProcessPushTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getPushTemp(@RequestParam long userId,
                                         @RequestParam String tempId) {

        PushTempWSModel response = processTempMiddleware.getPushTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createPushTemp(@RequestParam long userId,
                                            @RequestParam String processId,
                                            @RequestParam String pushHeader,
                                            @RequestParam String pushBody,
                                            @RequestParam String pushFooter,
                                            @RequestParam String pushSender,
                                            @RequestParam long typeId) {

        PushTempWSModel response = processTempMiddleware.createPushTemp(userId,processId,pushHeader,pushBody,pushFooter,pushSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updatePushTemp(@RequestParam long userId,
                                            @RequestParam String tempId,
                                            @RequestParam String pushHeader,
                                            @RequestParam String pushBody,
                                            @RequestParam String pushFooter,
                                            @RequestParam String pushSender,
                                            @RequestParam long typeId) {

        PushTempWSModel response = processTempMiddleware.updatePushTemp(userId,tempId,pushHeader,pushBody,pushFooter,pushSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removePushTemp(@RequestParam long userId,
                                            @RequestParam String tempId) {

        PushTempWSModel response = processTempMiddleware.removePushTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
