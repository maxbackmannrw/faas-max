package com.faas.core.base.endpoint.controller.process.details.trigger.temp;

import com.faas.core.base.middleware.process.details.trigger.temp.WappTriggerTempMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.temp.WappCallTriggerTempWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.WappMessageTriggerTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/trigger/temp/wapp/")
public class WappTriggerTempController {


    @Autowired
    WappTriggerTempMiddleware wappTriggerTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_WAPP_CALL_TRIGGER_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getWappCallTriggerTemps(@RequestParam long userId,
                                                     @RequestParam String processId) {

        WappCallTriggerTempWSModel response = wappTriggerTempMiddleware.getWappCallTriggerTemps(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_WAPP_CALL_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getWappCallTriggerTemp(@RequestParam long userId,
                                                    @RequestParam String tempId) {

        WappCallTriggerTempWSModel response = wappTriggerTempMiddleware.getWappCallTriggerTemp(userId,tempId);

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

        WappCallTriggerTempWSModel response = wappTriggerTempMiddleware.createWappCallTriggerTemp(userId,processId,trigger,accountId,typeId);

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

        WappCallTriggerTempWSModel response = wappTriggerTempMiddleware.updateWappCallTriggerTemp(userId,tempId,trigger,accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_WAPP_CALL_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeWappCallTriggerTemp(@RequestParam long userId,
                                                       @RequestParam String tempId) {

        WappCallTriggerTempWSModel response = wappTriggerTempMiddleware.removeWappCallTriggerTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_WAPP_MESSAGE_TRIGGER_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getWappMessageTriggerTemps(@RequestParam long userId,
                                                        @RequestParam String processId) {

        WappMessageTriggerTempWSModel response = wappTriggerTempMiddleware.getWappMessageTriggerTemps(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_WAPP_MESSAGE_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getWappMessageTriggerTemp(@RequestParam long userId,
                                                       @RequestParam String tempId) {

        WappMessageTriggerTempWSModel response = wappTriggerTempMiddleware.getWappMessageTriggerTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_WAPP_MESSAGE_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createWappMessageTriggerTemp(@RequestParam long userId,
                                                          @RequestParam String processId,
                                                          @RequestParam String trigger,
                                                          @RequestParam String accountId,
                                                          @RequestParam String wappTitle,
                                                          @RequestParam String wappBody,
                                                          @RequestParam long typeId) {

        WappMessageTriggerTempWSModel response = wappTriggerTempMiddleware.createWappMessageTriggerTemp(userId,processId,trigger,accountId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_WAPP_MESSAGE_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateWappMessageTriggerTemp(@RequestParam long userId,
                                                          @RequestParam String tempId,
                                                          @RequestParam String trigger,
                                                          @RequestParam String accountId,
                                                          @RequestParam String wappTitle,
                                                          @RequestParam String wappBody) {

        WappMessageTriggerTempWSModel response = wappTriggerTempMiddleware.updateWappMessageTriggerTemp(userId,tempId,trigger,accountId,wappTitle,wappBody);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_WAPP_MESSAGE_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeWappMessageTriggerTemp(@RequestParam long userId,
                                                          @RequestParam String tempId) {

        WappMessageTriggerTempWSModel response = wappTriggerTempMiddleware.removeWappMessageTriggerTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
