package com.faas.core.base.endpoint.controller.process.details.trigger.email;

import com.faas.core.base.middleware.process.details.trigger.email.ProcessEmailTriggerMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.email.ProcessEmailTriggerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/trigger/email/")
public class ProcessEmailTriggerController {


    @Autowired
    ProcessEmailTriggerMiddleware processEmailTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_EMAIL_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessEmailTriggers(@RequestParam long userId,
                                                     @RequestParam String processId) {

        ProcessEmailTriggerWSModel response = processEmailTriggerMiddleware.getProcessEmailTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessEmailTrigger(@RequestParam long userId,
                                                    @RequestParam String triggerId) {

        ProcessEmailTriggerWSModel response = processEmailTriggerMiddleware.getProcessEmailTrigger(userId,triggerId);

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

        ProcessEmailTriggerWSModel response = processEmailTriggerMiddleware.createProcessEmailTrigger(userId,processId,trigger,triggerDesc,accountId,emailSubject,emailTitle,emailBody,emailSender,typeId);

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

        ProcessEmailTriggerWSModel response = processEmailTriggerMiddleware.updateProcessEmailTrigger(userId,triggerId,trigger,triggerDesc,accountId,emailSubject,emailTitle,emailBody,emailSender);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_EMAIL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessEmailTrigger(@RequestParam long userId,
                                                       @RequestParam String triggerId) {

        ProcessEmailTriggerWSModel response = processEmailTriggerMiddleware.removeProcessEmailTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
