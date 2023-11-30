package com.faas.core.base.endpoint.controller.process.details.trigger;

import com.faas.core.base.middleware.process.details.trigger.ProcessTriggerMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.*;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/trigger/")
public class ProcessTriggerController {


    @Autowired
    ProcessTriggerMiddleware processTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessTriggers(@RequestParam long userId,
                                                @RequestParam String processId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.getProcessTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AI_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getAITriggers(@RequestParam long userId,
                                           @RequestParam String processId) {

        AiTriggerWSModel response = processTriggerMiddleware.getAITriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getAITrigger(@RequestParam long userId,
                                          @RequestParam String triggerId) {

        AiTriggerWSModel response = processTriggerMiddleware.getAITrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createAITrigger(@RequestParam long userId,
                                             @RequestParam String processId,
                                             @RequestParam String trigger,
                                             @RequestParam String triggerDesc,
                                             @RequestParam String accountId,
                                             @RequestParam long typeId) {

        AiTriggerWSModel response = processTriggerMiddleware.createAITrigger(userId,processId,trigger,triggerDesc,accountId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateAITrigger(@RequestParam long userId,
                                             @RequestParam String triggerId,
                                             @RequestParam String trigger,
                                             @RequestParam String triggerDesc,
                                             @RequestParam String accountId) {

        AiTriggerWSModel response = processTriggerMiddleware.updateAITrigger(userId,triggerId,trigger,triggerDesc,accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeAITrigger(@RequestParam long userId,
                                             @RequestParam String triggerId) {

        AiTriggerWSModel response = processTriggerMiddleware.removeAITrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_EMAIL_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getEmailTriggers(@RequestParam long userId,
                                              @RequestParam String processId) {

        EmailTriggerWSModel response = processTriggerMiddleware.getEmailTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getEmailTrigger(@RequestParam long userId,
                                             @RequestParam String triggerId) {

        EmailTriggerWSModel response = processTriggerMiddleware.getEmailTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createEmailTrigger(@RequestParam long userId,
                                                @RequestParam String processId,
                                                @RequestParam String trigger,
                                                @RequestParam String triggerDesc,
                                                @RequestParam String accountId,
                                                @RequestParam String emailSubject,
                                                @RequestParam String emailTitle,
                                                @RequestParam String emailBody,
                                                @RequestParam String emailSender,
                                                @RequestParam long typeId) {

        EmailTriggerWSModel response = processTriggerMiddleware.createEmailTrigger(userId,processId,trigger,triggerDesc,accountId,emailSubject,emailTitle,emailBody,emailSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateEmailTrigger(@RequestParam long userId,
                                                @RequestParam String triggerId,
                                                @RequestParam String trigger,
                                                @RequestParam String triggerDesc,
                                                @RequestParam String accountId,
                                                @RequestParam String emailSubject,
                                                @RequestParam String emailTitle,
                                                @RequestParam String emailBody,
                                                @RequestParam String emailSender) {

        EmailTriggerWSModel response = processTriggerMiddleware.updateEmailTrigger(userId,triggerId,trigger,triggerDesc,accountId,emailSubject,emailTitle,emailBody,emailSender);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeEmailTrigger(@RequestParam long userId,
                                                @RequestParam String triggerId) {

        EmailTriggerWSModel response = processTriggerMiddleware.removeEmailTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_SIP_CALL_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getSipCallTriggers(@RequestParam long userId,
                                                @RequestParam String processId){

        SipCallTriggerWSModel response = processTriggerMiddleware.getSipCallTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_SIP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getSipCallTrigger(@RequestParam long userId,
                                               @RequestParam String triggerId) {

        SipCallTriggerWSModel response = processTriggerMiddleware.getSipCallTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SIP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createSipCallTrigger(@RequestParam long userId,
                                                  @RequestParam String processId,
                                                  @RequestParam String trigger,
                                                  @RequestParam String triggerDesc,
                                                  @RequestParam String accountId,
                                                  @RequestParam String callerId,
                                                  @RequestParam long typeId) {

        SipCallTriggerWSModel response = processTriggerMiddleware.createSipCallTrigger(userId,processId,trigger,triggerDesc,accountId,callerId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_SIP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateSipCallTrigger(@RequestParam long userId,
                                                  @RequestParam String triggerId,
                                                  @RequestParam String trigger,
                                                  @RequestParam String triggerDesc,
                                                  @RequestParam String accountId,
                                                  @RequestParam String callerId) {

        SipCallTriggerWSModel response = processTriggerMiddleware.updateSipCallTrigger(userId,triggerId,trigger,triggerDesc,accountId,callerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_SIP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeSipCallTrigger(@RequestParam long userId,
                                                  @RequestParam String triggerId) {

        SipCallTriggerWSModel response = processTriggerMiddleware.removeSipCallTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_SMS_MESSAGE_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getSmsMessageTriggers(@RequestParam long userId,
                                                   @RequestParam String processId) {

        SmsMessageTriggerWSModel response = processTriggerMiddleware.getSmsMessageTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_SMS_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getSmsMessageTrigger(@RequestParam long userId,
                                                  @RequestParam String triggerId) {

        SmsMessageTriggerWSModel response = processTriggerMiddleware.getSmsMessageTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_SMS_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createSmsMessageTrigger(@RequestParam long userId,
                                                     @RequestParam String processId,
                                                     @RequestParam String trigger,
                                                     @RequestParam String triggerDesc,
                                                     @RequestParam String accountId,
                                                     @RequestParam String smsTitle,
                                                     @RequestParam String smsBody,
                                                     @RequestParam String senderId,
                                                     @RequestParam long typeId) {

        SmsMessageTriggerWSModel response = processTriggerMiddleware.createSmsMessageTrigger(userId,processId,trigger,triggerDesc,accountId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_SMS_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateSmsMessageTrigger(@RequestParam long userId,
                                                     @RequestParam String triggerId,
                                                     @RequestParam String trigger,
                                                     @RequestParam String triggerDesc,
                                                     @RequestParam String accountId,
                                                     @RequestParam String smsTitle,
                                                     @RequestParam String smsBody,
                                                     @RequestParam String senderId) {

        SmsMessageTriggerWSModel response = processTriggerMiddleware.updateSmsMessageTrigger(userId,triggerId,trigger,triggerDesc,accountId,smsTitle,smsBody,senderId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_SMS_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeSmsMessageTrigger(@RequestParam long userId,
                                                     @RequestParam String triggerId) {

        SmsMessageTriggerWSModel response = processTriggerMiddleware.removeSmsMessageTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_WAPP_CALL_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getWappCallTriggers(@RequestParam long userId,
                                                 @RequestParam String processId) {

        WappCallTriggerWSModel response = processTriggerMiddleware.getWappCallTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getWappCallTrigger(@RequestParam long userId,
                                                @RequestParam String triggerId) {

        WappCallTriggerWSModel response = processTriggerMiddleware.getWappCallTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createWappCallTrigger(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam String trigger,
                                                   @RequestParam String triggerDesc,
                                                   @RequestParam String accountId,
                                                   @RequestParam long typeId) {

        WappCallTriggerWSModel response = processTriggerMiddleware.createWappCallTrigger(userId,processId,trigger,triggerDesc,accountId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateWappCallTrigger(@RequestParam long userId,
                                                   @RequestParam String triggerId,
                                                   @RequestParam String trigger,
                                                   @RequestParam String triggerDesc,
                                                   @RequestParam String accountId) {

        WappCallTriggerWSModel response = processTriggerMiddleware.updateWappCallTrigger(userId,triggerId,trigger,triggerDesc,accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeWappCallTrigger(@RequestParam long userId,
                                                   @RequestParam String triggerId) {

        WappCallTriggerWSModel response = processTriggerMiddleware.removeWappCallTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_WAPP_MESSAGE_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getWappMessageTriggers(@RequestParam long userId,
                                                    @RequestParam String processId) {

        WappMessageTriggerWSModel response = processTriggerMiddleware.getWappMessageTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getWappMessageTrigger(@RequestParam long userId,
                                                   @RequestParam String triggerId) {

        WappMessageTriggerWSModel response = processTriggerMiddleware.getWappMessageTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createWappMessageTrigger(@RequestParam long userId,
                                                      @RequestParam String processId,
                                                      @RequestParam String trigger,
                                                      @RequestParam String triggerDesc,
                                                      @RequestParam String accountId,
                                                      @RequestParam String wappTitle,
                                                      @RequestParam String wappBody,
                                                      @RequestParam long typeId) {

        WappMessageTriggerWSModel response = processTriggerMiddleware.createWappMessageTrigger(userId,processId,trigger,triggerDesc,accountId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateWappMessageTrigger(@RequestParam long userId,
                                                      @RequestParam String triggerId,
                                                      @RequestParam String trigger,
                                                      @RequestParam String triggerDesc,
                                                      @RequestParam String accountId,
                                                      @RequestParam String wappTitle,
                                                      @RequestParam String wappBody) {

        WappMessageTriggerWSModel response = processTriggerMiddleware.updateWappMessageTrigger(userId,triggerId,trigger,triggerDesc,accountId,wappTitle,wappBody);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeWappMessageTrigger(@RequestParam long userId,
                                                      @RequestParam String triggerId) {

        WappMessageTriggerWSModel response = processTriggerMiddleware.removeWappMessageTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
