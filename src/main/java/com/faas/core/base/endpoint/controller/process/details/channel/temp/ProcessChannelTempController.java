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


    @RequestMapping(value = BaseRoute.GET_PROCESS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessTemp(@RequestParam long userId,
                                            @RequestParam String processId) {

        ProcessTempWSModel response = processChannelTempMiddleware.getProcessTemp(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_SMS_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSmsTemps(@RequestParam long userId,
                                                @RequestParam String processId) {

        ProcessSmsTempWSModel response = processChannelTempMiddleware.getProcessSmsTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_SMS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSmsTemp(@RequestParam long userId,
                                               @RequestParam String tempId) {

        ProcessSmsTempWSModel response = processChannelTempMiddleware.getProcessSmsTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_SMS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessSmsTemp(@RequestParam long userId,
                                                  @RequestParam String processId,
                                                  @RequestParam String smsTitle,
                                                  @RequestParam String smsBody,
                                                  @RequestParam String senderId,
                                                  @RequestParam String processRemoteId,
                                                  @RequestParam String remoteUrlId,
                                                  @RequestParam long typeId) {

        ProcessSmsTempWSModel response = processChannelTempMiddleware.createProcessSmsTemp(userId,processId,smsTitle,smsBody,senderId,processRemoteId,remoteUrlId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_SMS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessSmsTemp(@RequestParam long userId,
                                                  @RequestParam String tempId,
                                                  @RequestParam String smsTitle,
                                                  @RequestParam String smsBody,
                                                  @RequestParam String senderId,
                                                  @RequestParam long typeId) {

        ProcessSmsTempWSModel response = processChannelTempMiddleware.updateProcessSmsTemp(userId,tempId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_SMS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessSmsTemp(@RequestParam long userId,
                                                  @RequestParam String tempId) {

        ProcessSmsTempWSModel response = processChannelTempMiddleware.removeProcessSmsTemp(userId,tempId);

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

    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappMessageTemp(@RequestParam long userId,
                                                       @RequestParam String tempId) {

        ProcessWappMessageTempWSModel response = processChannelTempMiddleware.getProcessWappMessageTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessWappMessageTemp(@RequestParam long userId,
                                                          @RequestParam String processId,
                                                          @RequestParam String wappTitle,
                                                          @RequestParam String wappBody,
                                                          @RequestParam long typeId) {

        ProcessWappMessageTempWSModel response = processChannelTempMiddleware.createProcessWappMessageTemp(userId,processId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessWappMessageTemp(@RequestParam long userId,
                                                          @RequestParam String tempId,
                                                          @RequestParam String wappTitle,
                                                          @RequestParam String wappBody,
                                                          @RequestParam long typeId) {

        ProcessWappMessageTempWSModel response = processChannelTempMiddleware.updateProcessWappMessageTemp(userId,tempId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessWappMessageTemp(@RequestParam long userId,
                                                          @RequestParam String tempId) {

        ProcessWappMessageTempWSModel response = processChannelTempMiddleware.removeProcessWappMessageTemp(userId,tempId);

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

    @RequestMapping(value = BaseRoute.GET_PROCESS_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessEmailTemp(@RequestParam long userId,
                                                 @RequestParam String tempId) {

        ProcessEmailTempWSModel response = processChannelTempMiddleware.getProcessEmailTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessEmailTemp(@RequestParam long userId,
                                                    @RequestParam String processId,
                                                    @RequestParam String emailSubject,
                                                    @RequestParam String emailBody,
                                                    @RequestParam String emailFooter,
                                                    @RequestParam String emailSender,
                                                    @RequestParam long typeId) {

        ProcessEmailTempWSModel response = processChannelTempMiddleware.createProcessEmailTemp(userId,processId,emailSubject,emailBody,emailFooter,emailSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessEmailTemp(@RequestParam long userId,
                                                    @RequestParam String tempId,
                                                    @RequestParam String emailSubject,
                                                    @RequestParam String emailBody,
                                                    @RequestParam String emailFooter,
                                                    @RequestParam String emailSender,
                                                    @RequestParam long typeId) {

        ProcessEmailTempWSModel response = processChannelTempMiddleware.updateProcessEmailTemp(userId,tempId,emailSubject,emailBody,emailFooter,emailSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessEmailTemp(@RequestParam long userId,
                                                    @RequestParam String tempId) {

        ProcessEmailTempWSModel response = processChannelTempMiddleware.removeProcessEmailTemp(userId,tempId);

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

    @RequestMapping(value = BaseRoute.GET_PROCESS_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessPushTemp(@RequestParam long userId,
                                                @RequestParam String tempId) {

        ProcessPushTempWSModel response = processChannelTempMiddleware.getProcessPushTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessPushTemp(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam String pushHeader,
                                                   @RequestParam String pushBody,
                                                   @RequestParam String pushFooter,
                                                   @RequestParam String pushSender,
                                                   @RequestParam long typeId) {

        ProcessPushTempWSModel response = processChannelTempMiddleware.createProcessPushTemp(userId,processId,pushHeader,pushBody,pushFooter,pushSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessPushTemp(@RequestParam long userId,
                                                   @RequestParam String tempId,
                                                   @RequestParam String pushHeader,
                                                   @RequestParam String pushBody,
                                                   @RequestParam String pushFooter,
                                                   @RequestParam String pushSender,
                                                   @RequestParam long typeId) {

        ProcessPushTempWSModel response = processChannelTempMiddleware.updateProcessPushTemp(userId,tempId,pushHeader,pushBody,pushFooter,pushSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessPushTemp(@RequestParam long userId,
                                                   @RequestParam String tempId) {

        ProcessPushTempWSModel response = processChannelTempMiddleware.removeProcessPushTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
