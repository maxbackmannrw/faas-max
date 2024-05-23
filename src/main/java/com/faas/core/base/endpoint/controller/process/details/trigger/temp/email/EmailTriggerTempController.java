package com.faas.core.base.endpoint.controller.process.details.trigger.temp.email;

import com.faas.core.base.middleware.process.details.trigger.temp.email.EmailTriggerTempMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.temp.email.EmailTriggerTempWSModel;
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
public class EmailTriggerTempController {


    @Autowired
    EmailTriggerTempMiddleware emailTriggerTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_EMAIL_TRIGGER_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getEmailTriggerTemps(@RequestParam long userId,
                                                  @RequestParam String processId) {

        EmailTriggerTempWSModel response = emailTriggerTempMiddleware.getEmailTriggerTemps(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_EMAIL_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getEmailTriggerTemp(@RequestParam long userId,
                                                 @RequestParam String tempId) {

        EmailTriggerTempWSModel response = emailTriggerTempMiddleware.getEmailTriggerTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_EMAIL_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createEmailTriggerTemp(@RequestParam long userId,
                                                    @RequestParam String processId,
                                                    @RequestParam String trigger,
                                                    @RequestParam String accountId,
                                                    @RequestParam String emailSubject,
                                                    @RequestParam String emailTitle,
                                                    @RequestParam String emailBody,
                                                    @RequestParam String emailSender,
                                                    @RequestParam long typeId) {

        EmailTriggerTempWSModel response = emailTriggerTempMiddleware.createEmailTriggerTemp(userId,processId,trigger,accountId,emailSubject,emailTitle,emailBody,emailSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_EMAIL_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateEmailTriggerTemp(@RequestParam long userId,
                                                    @RequestParam String tempId,
                                                    @RequestParam String trigger,
                                                    @RequestParam String accountId,
                                                    @RequestParam String emailSubject,
                                                    @RequestParam String emailTitle,
                                                    @RequestParam String emailBody,
                                                    @RequestParam String emailSender) {

        EmailTriggerTempWSModel response = emailTriggerTempMiddleware.updateEmailTriggerTemp(userId,tempId,trigger,accountId,emailSubject,emailTitle,emailBody,emailSender);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_EMAIL_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeEmailTriggerTemp(@RequestParam long userId,
                                                    @RequestParam String tempId) {

        EmailTriggerTempWSModel response = emailTriggerTempMiddleware.removeEmailTriggerTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
