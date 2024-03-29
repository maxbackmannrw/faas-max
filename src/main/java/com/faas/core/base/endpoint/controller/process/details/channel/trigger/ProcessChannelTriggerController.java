package com.faas.core.base.endpoint.controller.process.details.channel.trigger;

import com.faas.core.base.middleware.process.details.channel.trigger.ProcessChannelTriggerMiddleware;
import com.faas.core.base.model.ws.process.details.channel.trigger.*;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/channel/trigger/")
public class ProcessChannelTriggerController {


    @Autowired
    ProcessChannelTriggerMiddleware processChannelTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessTrigger(@RequestParam long userId,
                                               @RequestParam String processId) {

        ProcessTriggerWSModel response = processChannelTriggerMiddleware.getProcessTrigger(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_AI_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessAITriggers(@RequestParam long userId,
                                                  @RequestParam String processId) {

        ProcessAITriggerWSModel response = processChannelTriggerMiddleware.getProcessAITriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessAITrigger(@RequestParam long userId,
                                                 @RequestParam String triggerId) {

        ProcessAITriggerWSModel response = processChannelTriggerMiddleware.getProcessAITrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessAITrigger(@RequestParam long userId,
                                                    @RequestParam String processId,
                                                    @RequestParam String trigger,
                                                    @RequestParam String triggerDesc,
                                                    @RequestParam String accountId,
                                                    @RequestParam long typeId) {

        ProcessAITriggerWSModel response = processChannelTriggerMiddleware.createProcessAITrigger(userId,processId,trigger,triggerDesc,accountId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessAITrigger(@RequestParam long userId,
                                                    @RequestParam String triggerId,
                                                    @RequestParam String trigger,
                                                    @RequestParam String triggerDesc,
                                                    @RequestParam String accountId) {

        ProcessAITriggerWSModel response = processChannelTriggerMiddleware.updateProcessAITrigger(userId,triggerId,trigger,triggerDesc,accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessAITrigger(@RequestParam long userId,
                                                    @RequestParam String triggerId) {

        ProcessAITriggerWSModel response = processChannelTriggerMiddleware.removeProcessAITrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_EMAIL_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessEmailTriggers(@RequestParam long userId,
                                                     @RequestParam String processId) {

        ProcessEmailTriggerWSModel response = processChannelTriggerMiddleware.getProcessEmailTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessEmailTrigger(@RequestParam long userId,
                                                    @RequestParam String triggerId) {

        ProcessEmailTriggerWSModel response = processChannelTriggerMiddleware.getProcessEmailTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessEmailTrigger(@RequestParam long userId,
                                                       @RequestParam String processId,
                                                       @RequestParam String trigger,
                                                       @RequestParam String triggerDesc,
                                                       @RequestParam String accountId,
                                                       @RequestParam String emailSubject,
                                                       @RequestParam String emailTitle,
                                                       @RequestParam String emailBody,
                                                       @RequestParam String emailSender,
                                                       @RequestParam long typeId) {

        ProcessEmailTriggerWSModel response = processChannelTriggerMiddleware.createProcessEmailTrigger(userId,processId,trigger,triggerDesc,accountId,emailSubject,emailTitle,emailBody,emailSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessEmailTrigger(@RequestParam long userId,
                                                       @RequestParam String triggerId,
                                                       @RequestParam String trigger,
                                                       @RequestParam String triggerDesc,
                                                       @RequestParam String accountId,
                                                       @RequestParam String emailSubject,
                                                       @RequestParam String emailTitle,
                                                       @RequestParam String emailBody,
                                                       @RequestParam String emailSender) {

        ProcessEmailTriggerWSModel response = processChannelTriggerMiddleware.updateProcessEmailTrigger(userId,triggerId,trigger,triggerDesc,accountId,emailSubject,emailTitle,emailBody,emailSender);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessEmailTrigger(@RequestParam long userId,
                                                       @RequestParam String triggerId) {

        ProcessEmailTriggerWSModel response = processChannelTriggerMiddleware.removeProcessEmailTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_SIP_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSipTriggers(@RequestParam long userId,
                                                   @RequestParam String processId){

        ProcessSipTriggerWSModel response = processChannelTriggerMiddleware.getProcessSipTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSipTrigger(@RequestParam long userId,
                                                  @RequestParam String triggerId) {

        ProcessSipTriggerWSModel response = processChannelTriggerMiddleware.getProcessSipTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessSipTrigger(@RequestParam long userId,
                                                     @RequestParam String processId,
                                                     @RequestParam String trigger,
                                                     @RequestParam String triggerDesc,
                                                     @RequestParam String accountId,
                                                     @RequestParam String callerId,
                                                     @RequestParam long typeId) {

        ProcessSipTriggerWSModel response = processChannelTriggerMiddleware.createProcessSipTrigger(userId,processId,trigger,triggerDesc,accountId,callerId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessSipTrigger(@RequestParam long userId,
                                                     @RequestParam String triggerId,
                                                     @RequestParam String trigger,
                                                     @RequestParam String triggerDesc,
                                                     @RequestParam String accountId,
                                                     @RequestParam String callerId) {

        ProcessSipTriggerWSModel response = processChannelTriggerMiddleware.updateProcessSipTrigger(userId,triggerId,trigger,triggerDesc,accountId,callerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessSipTrigger(@RequestParam long userId,
                                                     @RequestParam String triggerId) {

        ProcessSipTriggerWSModel response = processChannelTriggerMiddleware.removeProcessSipTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_SMS_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSmsTriggers(@RequestParam long userId,
                                                   @RequestParam String processId) {

        ProcessSmsTriggerWSModel response = processChannelTriggerMiddleware.getProcessSmsTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSmsTrigger(@RequestParam long userId,
                                                  @RequestParam String triggerId) {

        ProcessSmsTriggerWSModel response = processChannelTriggerMiddleware.getProcessSmsTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessSmsTrigger(@RequestParam long userId,
                                                     @RequestParam String processId,
                                                     @RequestParam String trigger,
                                                     @RequestParam String triggerDesc,
                                                     @RequestParam String accountId,
                                                     @RequestParam String smsTitle,
                                                     @RequestParam String smsBody,
                                                     @RequestParam String senderId,
                                                     @RequestParam long typeId) {

        ProcessSmsTriggerWSModel response = processChannelTriggerMiddleware.createProcessSmsTrigger(userId,processId,trigger,triggerDesc,accountId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessSmsTrigger(@RequestParam long userId,
                                                     @RequestParam String triggerId,
                                                     @RequestParam String trigger,
                                                     @RequestParam String triggerDesc,
                                                     @RequestParam String accountId,
                                                     @RequestParam String smsTitle,
                                                     @RequestParam String smsBody,
                                                     @RequestParam String senderId) {

        ProcessSmsTriggerWSModel response = processChannelTriggerMiddleware.updateProcessSmsTrigger(userId,triggerId,trigger,triggerDesc,accountId,smsTitle,smsBody,senderId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessSmsTrigger(@RequestParam long userId,
                                                     @RequestParam String triggerId) {

        ProcessSmsTriggerWSModel response = processChannelTriggerMiddleware.removeProcessSmsTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_CALL_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappCallTriggers(@RequestParam long userId,
                                                        @RequestParam String processId) {

        ProcessWappCallTriggerWSModel response = processChannelTriggerMiddleware.getProcessWappCallTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappCallTrigger(@RequestParam long userId,
                                                       @RequestParam String triggerId) {

        ProcessWappCallTriggerWSModel response = processChannelTriggerMiddleware.getProcessWappCallTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessWappCallTrigger(@RequestParam long userId,
                                                          @RequestParam String processId,
                                                          @RequestParam String trigger,
                                                          @RequestParam String triggerDesc,
                                                          @RequestParam String accountId,
                                                          @RequestParam long typeId) {

        ProcessWappCallTriggerWSModel response = processChannelTriggerMiddleware.createProcessWappCallTrigger(userId,processId,trigger,triggerDesc,accountId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessWappCallTrigger(@RequestParam long userId,
                                                          @RequestParam String triggerId,
                                                          @RequestParam String trigger,
                                                          @RequestParam String triggerDesc,
                                                          @RequestParam String accountId) {

        ProcessWappCallTriggerWSModel response = processChannelTriggerMiddleware.updateProcessWappCallTrigger(userId,triggerId,trigger,triggerDesc,accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessWappCallTrigger(@RequestParam long userId,
                                                          @RequestParam String triggerId) {

        ProcessWappCallTriggerWSModel response = processChannelTriggerMiddleware.removeProcessWappCallTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_MESSAGE_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappMessageTriggers(@RequestParam long userId,
                                                           @RequestParam String processId) {

        ProcessWappMessageTriggerWSModel response = processChannelTriggerMiddleware.getProcessWappMessageTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappMessageTrigger(@RequestParam long userId,
                                                          @RequestParam String triggerId) {

        ProcessWappMessageTriggerWSModel response = processChannelTriggerMiddleware.getProcessWappMessageTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessWappMessageTrigger(@RequestParam long userId,
                                                             @RequestParam String processId,
                                                             @RequestParam String trigger,
                                                             @RequestParam String triggerDesc,
                                                             @RequestParam String accountId,
                                                             @RequestParam String wappTitle,
                                                             @RequestParam String wappBody,
                                                             @RequestParam long typeId) {

        ProcessWappMessageTriggerWSModel response = processChannelTriggerMiddleware.createProcessWappMessageTrigger(userId,processId,trigger,triggerDesc,accountId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessWappMessageTrigger(@RequestParam long userId,
                                                             @RequestParam String triggerId,
                                                             @RequestParam String trigger,
                                                             @RequestParam String triggerDesc,
                                                             @RequestParam String accountId,
                                                             @RequestParam String wappTitle,
                                                             @RequestParam String wappBody) {

        ProcessWappMessageTriggerWSModel response = processChannelTriggerMiddleware.updateProcessWappMessageTrigger(userId,triggerId,trigger,triggerDesc,accountId,wappTitle,wappBody);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessWappMessageTrigger(@RequestParam long userId,
                                                             @RequestParam String triggerId) {

        ProcessWappMessageTriggerWSModel response = processChannelTriggerMiddleware.removeProcessWappMessageTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
