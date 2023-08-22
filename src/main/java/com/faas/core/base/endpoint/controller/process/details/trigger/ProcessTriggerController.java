package com.faas.core.base.endpoint.controller.process.details.trigger;

import com.faas.core.base.middleware.process.details.trigger.ProcessTriggerMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.TriggerWSModel;
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

        TriggerWSModel response = processTriggerMiddleware.getProcessTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_TRIGGERS_BY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessTriggersByType(@RequestParam long userId,
                                                      @RequestParam String processId,
                                                      @RequestParam String baseType) {

        TriggerWSModel response = processTriggerMiddleware.getProcessTriggersByType(userId,processId,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessTrigger(@RequestParam long userId,
                                               @RequestParam String processId,
                                               @RequestParam String triggerId) {

        TriggerWSModel response = processTriggerMiddleware.getProcessTrigger(userId,processId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createAITrigger(@RequestParam long userId,
                                             @RequestParam String processId,
                                             @RequestParam String accountId,
                                             @RequestParam long typeId) {

        TriggerWSModel response = processTriggerMiddleware.createAITrigger(userId,processId,accountId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateAITrigger(@RequestParam long userId,
                                             @RequestParam String processId,
                                             @RequestParam String triggerId,
                                             @RequestParam String accountId,
                                             @RequestParam long typeId) {

        TriggerWSModel response = processTriggerMiddleware.updateAITrigger(userId,processId,triggerId,accountId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.CREATE_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createEmailTrigger(@RequestParam long userId,
                                                @RequestParam String processId,
                                                @RequestParam String accountId,
                                                @RequestParam String emailSubject,
                                                @RequestParam String emailTitle,
                                                @RequestParam String emailBody,
                                                @RequestParam String emailSender,
                                                @RequestParam long typeId) {

        TriggerWSModel response = processTriggerMiddleware.createEmailTrigger(userId,processId,accountId,emailSubject,emailTitle,emailBody,emailSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateEmailTrigger(@RequestParam long userId,
                                                @RequestParam String processId,
                                                @RequestParam String triggerId,
                                                @RequestParam String accountId,
                                                @RequestParam String emailSubject,
                                                @RequestParam String emailTitle,
                                                @RequestParam String emailBody,
                                                @RequestParam String emailSender,
                                                @RequestParam long typeId) {

        TriggerWSModel response = processTriggerMiddleware.updateEmailTrigger(userId,processId,triggerId,accountId,emailSubject,emailTitle,emailBody,emailSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createSipTrigger(@RequestParam long userId,
                                              @RequestParam String processId,
                                              @RequestParam String accountId,
                                              @RequestParam String callerId,
                                              @RequestParam long typeId) {

        TriggerWSModel response = processTriggerMiddleware.createSipTrigger(userId,processId,accountId,callerId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateSipTrigger(@RequestParam long userId,
                                              @RequestParam String processId,
                                              @RequestParam String triggerId,
                                              @RequestParam String accountId,
                                              @RequestParam String callerId,
                                              @RequestParam long typeId) {

        TriggerWSModel response = processTriggerMiddleware.updateSipTrigger(userId,processId,triggerId,accountId,callerId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.CREATE_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createSmsTrigger(@RequestParam long userId,
                                              @RequestParam String processId,
                                              @RequestParam String accountId,
                                              @RequestParam String smsTitle,
                                              @RequestParam String smsBody,
                                              @RequestParam String senderId,
                                              @RequestParam long typeId) {

        TriggerWSModel response = processTriggerMiddleware.createSmsTrigger(userId,processId,accountId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateSmsTrigger(@RequestParam long userId,
                                              @RequestParam String processId,
                                              @RequestParam String triggerId,
                                              @RequestParam String accountId,
                                              @RequestParam String smsTitle,
                                              @RequestParam String smsBody,
                                              @RequestParam String senderId,
                                              @RequestParam long typeId) {

        TriggerWSModel response = processTriggerMiddleware.updateSmsTrigger(userId,processId,triggerId,accountId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_WAPP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createWappTrigger(@RequestParam long userId,
                                               @RequestParam String processId,
                                               @RequestParam String accountId,
                                               @RequestParam String wappTitle,
                                               @RequestParam String wappBody,
                                               @RequestParam long typeId) {

        TriggerWSModel response = processTriggerMiddleware.createWappTrigger(userId,processId,accountId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_WAPP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateWappTrigger(@RequestParam long userId,
                                               @RequestParam String processId,
                                               @RequestParam String triggerId,
                                               @RequestParam String accountId,
                                               @RequestParam String wappTitle,
                                               @RequestParam String wappBody,
                                               @RequestParam long typeId) {

        TriggerWSModel response = processTriggerMiddleware.updateWappTrigger(userId,processId,triggerId,accountId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.REMOVE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeTrigger(@RequestParam long userId,
                                           @RequestParam String processId,
                                           @RequestParam String triggerId) {

        TriggerWSModel response = processTriggerMiddleware.removeTrigger(userId,processId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
