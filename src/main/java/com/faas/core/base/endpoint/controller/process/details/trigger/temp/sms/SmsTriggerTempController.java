package com.faas.core.base.endpoint.controller.process.details.trigger.temp.sms;

import com.faas.core.base.middleware.process.details.trigger.temp.sms.SmsTriggerTempMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.temp.sms.SmsTriggerTempWSModel;
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
public class SmsTriggerTempController {


    @Autowired
    SmsTriggerTempMiddleware smsTriggerTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_SMS_TRIGGER_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getSmsTriggerTemps(@RequestParam long userId,
                                                @RequestParam String processId) {

        SmsTriggerTempWSModel response = smsTriggerTempMiddleware.getSmsTriggerTemps(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_SMS_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getSmsTriggerTemp(@RequestParam long userId,
                                               @RequestParam String tempId) {

        SmsTriggerTempWSModel response = smsTriggerTempMiddleware.getSmsTriggerTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_SMS_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createSmsTriggerTemp(@RequestParam long userId,
                                                  @RequestParam String processId,
                                                  @RequestParam String trigger,
                                                  @RequestParam String accountId,
                                                  @RequestParam String smsTitle,
                                                  @RequestParam String smsBody,
                                                  @RequestParam String senderId,
                                                  @RequestParam long typeId) {

        SmsTriggerTempWSModel response = smsTriggerTempMiddleware.createSmsTriggerTemp(userId,processId,trigger,accountId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_SMS_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateSmsTriggerTemp(@RequestParam long userId,
                                                  @RequestParam String tempId,
                                                  @RequestParam String trigger,
                                                  @RequestParam String accountId,
                                                  @RequestParam String smsTitle,
                                                  @RequestParam String smsBody,
                                                  @RequestParam String senderId) {

        SmsTriggerTempWSModel response = smsTriggerTempMiddleware.updateSmsTriggerTemp(userId,tempId,trigger,accountId,smsTitle,smsBody,senderId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_SMS_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeSmsTriggerTemp(@RequestParam long userId,
                                                  @RequestParam String tempId) {

        SmsTriggerTempWSModel response = smsTriggerTempMiddleware.removeSmsTriggerTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
