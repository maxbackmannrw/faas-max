package com.faas.core.base.endpoint.controller.process.details.trigger;

import com.faas.core.base.middleware.process.details.trigger.ProcessTriggerMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.ProcessTriggerWSModel;
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


    @RequestMapping(value = BaseRoute.GET_PROCESS_TRIGGERS_BY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessTriggersByType(@RequestParam long userId,
                                                      @RequestParam String processId,
                                                      @RequestParam String baseType) {

        ProcessTriggerWSModel response = processTriggerMiddleware.getProcessTriggersByType(userId,processId,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getTrigger(@RequestParam long userId,
                                        @RequestParam String triggerId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.getTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.CREATE_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createAITrigger(@RequestParam long userId,
                                             @RequestParam String processId,
                                             @RequestParam String accountId,
                                             @RequestParam String trigger,
                                             @RequestParam long typeId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.createAITrigger(userId,processId,accountId,trigger,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateAITrigger(@RequestParam long userId,
                                             @RequestParam String triggerId,
                                             @RequestParam String accountId,
                                             @RequestParam String trigger) {

        ProcessTriggerWSModel response = processTriggerMiddleware.updateAITrigger(userId,triggerId,accountId,trigger);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createEmailTrigger(@RequestParam long userId,
                                                @RequestParam String processId,
                                                @RequestParam String accountId,
                                                @RequestParam String trigger,
                                                @RequestParam String emailSubject,
                                                @RequestParam String emailTitle,
                                                @RequestParam String emailBody,
                                                @RequestParam String emailSender,
                                                @RequestParam long typeId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.createEmailTrigger(userId,processId,accountId,trigger,emailSubject,emailTitle,emailBody,emailSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateEmailTrigger(@RequestParam long userId,
                                                @RequestParam String triggerId,
                                                @RequestParam String accountId,
                                                @RequestParam String trigger,
                                                @RequestParam String emailSubject,
                                                @RequestParam String emailTitle,
                                                @RequestParam String emailBody,
                                                @RequestParam String emailSender) {

        ProcessTriggerWSModel response = processTriggerMiddleware.updateEmailTrigger(userId,triggerId,accountId,trigger,emailSubject,emailTitle,emailBody,emailSender);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createSipTrigger(@RequestParam long userId,
                                              @RequestParam String processId,
                                              @RequestParam String accountId,
                                              @RequestParam String trigger,
                                              @RequestParam String callerId,
                                              @RequestParam long typeId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.createSipTrigger(userId,processId,accountId,trigger,callerId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateSipTrigger(@RequestParam long userId,
                                              @RequestParam String triggerId,
                                              @RequestParam String accountId,
                                              @RequestParam String trigger,
                                              @RequestParam String callerId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.updateSipTrigger(userId,triggerId,accountId,trigger,callerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.CREATE_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createSmsTrigger(@RequestParam long userId,
                                              @RequestParam String processId,
                                              @RequestParam String accountId,
                                              @RequestParam String trigger,
                                              @RequestParam String smsTitle,
                                              @RequestParam String smsBody,
                                              @RequestParam String senderId,
                                              @RequestParam long typeId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.createSmsTrigger(userId,processId,accountId,trigger,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateSmsTrigger(@RequestParam long userId,
                                              @RequestParam String triggerId,
                                              @RequestParam String accountId,
                                              @RequestParam String trigger,
                                              @RequestParam String smsTitle,
                                              @RequestParam String smsBody,
                                              @RequestParam String senderId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.updateSmsTrigger(userId,triggerId,accountId,trigger,smsTitle,smsBody,senderId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createWappCallTrigger(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam String accountId,
                                                   @RequestParam String trigger,
                                                   @RequestParam long typeId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.createWappCallTrigger(userId,processId,accountId,trigger,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateWappCallTrigger(@RequestParam long userId,
                                                   @RequestParam String triggerId,
                                                   @RequestParam String accountId,
                                                   @RequestParam String trigger) {

        ProcessTriggerWSModel response = processTriggerMiddleware.updateWappCallTrigger(userId,triggerId,accountId,trigger);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createWappMessageTrigger(@RequestParam long userId,
                                                      @RequestParam String processId,
                                                      @RequestParam String accountId,
                                                      @RequestParam String trigger,
                                                      @RequestParam String wappTitle,
                                                      @RequestParam String wappBody,
                                                      @RequestParam long typeId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.createWappMessageTrigger(userId,processId,accountId,trigger,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateWappMessageTrigger(@RequestParam long userId,
                                                      @RequestParam String triggerId,
                                                      @RequestParam String accountId,
                                                      @RequestParam String trigger,
                                                      @RequestParam String wappTitle,
                                                      @RequestParam String wappBody) {

        ProcessTriggerWSModel response = processTriggerMiddleware.updateWappMessageTrigger(userId,triggerId,accountId,trigger,wappTitle,wappBody);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeTrigger(@RequestParam long userId,
                                           @RequestParam String triggerId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.removeTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
