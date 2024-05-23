package com.faas.core.base.endpoint.controller.process.details.trigger.temp.sip;

import com.faas.core.base.middleware.process.details.trigger.temp.sip.SipTriggerTempMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.temp.sip.SipTriggerTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/trigger/temp/sip/")
public class SipTriggerTempController {


    @Autowired
    SipTriggerTempMiddleware sipTriggerTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_SIP_TRIGGER_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getSipTriggerTemps(@RequestParam long userId,
                                                @RequestParam String processId){

        SipTriggerTempWSModel response = sipTriggerTempMiddleware.getSipTriggerTemps(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_SIP_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getSipTriggerTemp(@RequestParam long userId,
                                               @RequestParam String tempId) {

        SipTriggerTempWSModel response = sipTriggerTempMiddleware.getSipTriggerTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_SIP_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createSipTriggerTemp(@RequestParam long userId,
                                                  @RequestParam String processId,
                                                  @RequestParam String trigger,
                                                  @RequestParam String accountId,
                                                  @RequestParam String callerId,
                                                  @RequestParam long typeId) {

        SipTriggerTempWSModel response = sipTriggerTempMiddleware.createSipTriggerTemp(userId,processId,trigger,accountId,callerId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_SIP_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateSipTriggerTemp(@RequestParam long userId,
                                                  @RequestParam String tempId,
                                                  @RequestParam String trigger,
                                                  @RequestParam String accountId,
                                                  @RequestParam String callerId) {

        SipTriggerTempWSModel response = sipTriggerTempMiddleware.updateSipTriggerTemp(userId,tempId,trigger,accountId,callerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_SIP_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeSipTriggerTemp(@RequestParam long userId,
                                                  @RequestParam String tempId) {

        SipTriggerTempWSModel response = sipTriggerTempMiddleware.removeSipTriggerTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
