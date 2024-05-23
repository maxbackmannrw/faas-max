package com.faas.core.base.endpoint.controller.process.details.trigger.temp.wapp.call;

import com.faas.core.base.middleware.process.details.trigger.temp.wapp.call.WappCallTriggerTempMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.temp.wapp.call.WappCallTriggerTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/trigger/wapp/call/")
public class WappCallTriggerTempController {


    @Autowired
    WappCallTriggerTempMiddleware wappCallTriggerTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_WAPP_CALL_TRIGGER_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getWappCallTriggerTemps(@RequestParam long userId,
                                                     @RequestParam String processId) {

        WappCallTriggerTempWSModel response = wappCallTriggerTempMiddleware.getWappCallTriggerTemps(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_WAPP_CALL_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getWappCallTriggerTemp(@RequestParam long userId,
                                                    @RequestParam String tempId) {

        WappCallTriggerTempWSModel response = wappCallTriggerTempMiddleware.getWappCallTriggerTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_WAPP_CALL_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createWappCallTriggerTemp(@RequestParam long userId,
                                                       @RequestParam String processId,
                                                       @RequestParam String trigger,
                                                       @RequestParam String accountId,
                                                       @RequestParam long typeId) {

        WappCallTriggerTempWSModel response = wappCallTriggerTempMiddleware.createWappCallTriggerTemp(userId,processId,trigger,accountId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_WAPP_CALL_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateWappCallTriggerTemp(@RequestParam long userId,
                                                       @RequestParam String tempId,
                                                       @RequestParam String trigger,
                                                       @RequestParam String accountId) {

        WappCallTriggerTempWSModel response = wappCallTriggerTempMiddleware.updateWappCallTriggerTemp(userId,tempId,trigger,accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_WAPP_CALL_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeWappCallTriggerTemp(@RequestParam long userId,
                                                       @RequestParam String tempId) {

        WappCallTriggerTempWSModel response = wappCallTriggerTempMiddleware.removeWappCallTriggerTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
