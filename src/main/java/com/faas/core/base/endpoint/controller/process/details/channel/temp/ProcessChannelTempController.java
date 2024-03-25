package com.faas.core.base.endpoint.controller.process.details.channel.temp;

import com.faas.core.base.middleware.process.details.channel.temp.ProcessChannelTempMiddleware;
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
public class ProcessChannelTempController {


    @Autowired
    ProcessChannelTempMiddleware processChannelTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessTemps(@RequestParam long userId,
                                             @RequestParam String processId) {

        ProcessTempWSModel response = processChannelTempMiddleware.getProcessTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_SMS_MESSAGE_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSmsMessageTemps(@RequestParam long userId,
                                                       @RequestParam String processId) {

        ProcessSmsTempWSModel response = processChannelTempMiddleware.getProcessSmsMessageTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_SMS_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getSmsMessageTemp(@RequestParam long userId,
                                               @RequestParam String tempId) {

        ProcessSmsTempWSModel response = processChannelTempMiddleware.getSmsMessageTemp(userId,tempId);

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

        ProcessSmsTempWSModel response = processChannelTempMiddleware.createSmsMessageTemp(userId,processId,smsTitle,smsBody,senderId,typeId);

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

        ProcessSmsTempWSModel response = processChannelTempMiddleware.updateSmsMessageTemp(userId,tempId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_SMS_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeSmsMessageTemp(@RequestParam long userId,
                                                  @RequestParam String tempId) {

        ProcessSmsTempWSModel response = processChannelTempMiddleware.removeSmsMessageTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_MESSAGE_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappMessageTemps(@RequestParam long userId,
                                                        @RequestParam String processId) {

        ProcessWappMessageTempWSModel response = processChannelTempMiddleware.getProcessWappMessageTemps(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getWappMessageTemp(@RequestParam long userId,
                                                @RequestParam String tempId) {

        ProcessWappMessageTempWSModel response = processChannelTempMiddleware.getWappMessageTemp(userId,tempId);

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

        ProcessWappMessageTempWSModel response = processChannelTempMiddleware.createWappMessageTemp(userId,processId,wappTitle,wappBody,typeId);

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

        ProcessWappMessageTempWSModel response = processChannelTempMiddleware.updateWappMessageTemp(userId,tempId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeWappMessageTemp(@RequestParam long userId,
                                                   @RequestParam String tempId) {

        ProcessWappMessageTempWSModel response = processChannelTempMiddleware.removeWappMessageTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_EMAIL_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessEmailTemps(@RequestParam long userId,
                                                  @RequestParam String processId) {

        ProcessEmailTempWSModel response = processChannelTempMiddleware.getProcessEmailTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getEmailTemp(@RequestParam long userId,
                                          @RequestParam String tempId) {

        ProcessEmailTempWSModel response = processChannelTempMiddleware.getEmailTemp(userId,tempId);

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

        ProcessEmailTempWSModel response = processChannelTempMiddleware.createEmailTemp(userId,processId,emailSubject,emailBody,emailFooter,emailSender,typeId);

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

        ProcessEmailTempWSModel response = processChannelTempMiddleware.updateEmailTemp(userId,tempId,emailSubject,emailBody,emailFooter,emailSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeEmailTemp(@RequestParam long userId,
                                             @RequestParam String tempId) {

        ProcessEmailTempWSModel response = processChannelTempMiddleware.removeEmailTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_PUSH_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessPushTemps(@RequestParam long userId,
                                                 @RequestParam String processId) {

        ProcessPushTempWSModel response = processChannelTempMiddleware.getProcessPushTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getPushTemp(@RequestParam long userId,
                                         @RequestParam String tempId) {

        ProcessPushTempWSModel response = processChannelTempMiddleware.getPushTemp(userId,tempId);

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

        ProcessPushTempWSModel response = processChannelTempMiddleware.createPushTemp(userId,processId,pushHeader,pushBody,pushFooter,pushSender,typeId);

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

        ProcessPushTempWSModel response = processChannelTempMiddleware.updatePushTemp(userId,tempId,pushHeader,pushBody,pushFooter,pushSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removePushTemp(@RequestParam long userId,
                                            @RequestParam String tempId) {

        ProcessPushTempWSModel response = processChannelTempMiddleware.removePushTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
