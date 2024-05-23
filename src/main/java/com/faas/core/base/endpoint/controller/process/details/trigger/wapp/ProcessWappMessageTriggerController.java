package com.faas.core.base.endpoint.controller.process.details.trigger.wapp;

import com.faas.core.base.middleware.process.details.trigger.wapp.ProcessWappMessageTriggerMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.wapp.ProcessWappMessageTriggerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/trigger/wapp/message/")
public class ProcessWappMessageTriggerController {


    @Autowired
    ProcessWappMessageTriggerMiddleware processWappMessageTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_MESSAGE_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappMessageTriggers(@RequestParam long userId,
                                                           @RequestParam String processId) {

        ProcessWappMessageTriggerWSModel response = processWappMessageTriggerMiddleware.getProcessWappMessageTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappMessageTrigger(@RequestParam long userId,
                                                          @RequestParam String triggerId) {

        ProcessWappMessageTriggerWSModel response = processWappMessageTriggerMiddleware.getProcessWappMessageTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessWappMessageTrigger(@RequestParam long userId,
                                                             @RequestParam String processId,
                                                             @RequestParam String trigger,
                                                             @RequestParam String triggerDesc,
                                                             @RequestParam String accountId,
                                                             @RequestParam String wappTitle,
                                                             @RequestParam String wappBody,
                                                             @RequestParam long typeId) {

        ProcessWappMessageTriggerWSModel response = processWappMessageTriggerMiddleware.createProcessWappMessageTrigger(userId,processId,trigger,triggerDesc,accountId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessWappMessageTrigger(@RequestParam long userId,
                                                             @RequestParam String triggerId,
                                                             @RequestParam String trigger,
                                                             @RequestParam String triggerDesc,
                                                             @RequestParam String accountId,
                                                             @RequestParam String wappTitle,
                                                             @RequestParam String wappBody) {

        ProcessWappMessageTriggerWSModel response = processWappMessageTriggerMiddleware.updateProcessWappMessageTrigger(userId,triggerId,trigger,triggerDesc,accountId,wappTitle,wappBody);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessWappMessageTrigger(@RequestParam long userId,
                                                             @RequestParam String triggerId) {

        ProcessWappMessageTriggerWSModel response = processWappMessageTriggerMiddleware.removeProcessWappMessageTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
