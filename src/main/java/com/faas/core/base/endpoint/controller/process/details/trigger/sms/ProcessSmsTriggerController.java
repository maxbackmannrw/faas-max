package com.faas.core.base.endpoint.controller.process.details.trigger.sms;

import com.faas.core.base.middleware.process.details.trigger.sms.ProcessSmsTriggerMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.sms.ProcessSmsTriggerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/trigger/sms/")
public class ProcessSmsTriggerController {


    @Autowired
    ProcessSmsTriggerMiddleware processSmsTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_SMS_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSmsTriggers(@RequestParam long userId,
                                                   @RequestParam String processId) {

        ProcessSmsTriggerWSModel response = processSmsTriggerMiddleware.getProcessSmsTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSmsTrigger(@RequestParam long userId,
                                                  @RequestParam String triggerId) {

        ProcessSmsTriggerWSModel response = processSmsTriggerMiddleware.getProcessSmsTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessSmsTrigger(@RequestParam long userId,
                                                     @RequestParam String processId,
                                                     @RequestParam String trigger,
                                                     @RequestParam String accountId,
                                                     @RequestParam String smsTitle,
                                                     @RequestParam String smsBody,
                                                     @RequestParam String senderId,
                                                     @RequestParam long typeId) {

        ProcessSmsTriggerWSModel response = processSmsTriggerMiddleware.createProcessSmsTrigger(userId,processId,trigger,accountId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessSmsTrigger(@RequestParam long userId,
                                                     @RequestParam String triggerId,
                                                     @RequestParam String trigger,
                                                     @RequestParam String accountId,
                                                     @RequestParam String smsTitle,
                                                     @RequestParam String smsBody,
                                                     @RequestParam String senderId) {

        ProcessSmsTriggerWSModel response = processSmsTriggerMiddleware.updateProcessSmsTrigger(userId,triggerId,trigger,accountId,smsTitle,smsBody,senderId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessSmsTrigger(@RequestParam long userId,
                                                     @RequestParam String triggerId) {

        ProcessSmsTriggerWSModel response = processSmsTriggerMiddleware.removeProcessSmsTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
