package com.faas.core.base.endpoint.controller.process.details.trigger.wapp;

import com.faas.core.base.middleware.process.details.trigger.wapp.ProcessWappCallTriggerMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.wapp.ProcessWappCallTriggerWSModel;
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
public class ProcessWappCallTriggerController {


    @Autowired
    ProcessWappCallTriggerMiddleware processWappCallTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_CALL_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappCallTriggers(@RequestParam long userId,
                                                        @RequestParam String processId) {

        ProcessWappCallTriggerWSModel response = processWappCallTriggerMiddleware.getProcessWappCallTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappCallTrigger(@RequestParam long userId,
                                                       @RequestParam String triggerId) {

        ProcessWappCallTriggerWSModel response = processWappCallTriggerMiddleware.getProcessWappCallTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessWappCallTrigger(@RequestParam long userId,
                                                          @RequestParam String processId,
                                                          @RequestParam String trigger,
                                                          @RequestParam String accountId,
                                                          @RequestParam long typeId) {

        ProcessWappCallTriggerWSModel response = processWappCallTriggerMiddleware.createProcessWappCallTrigger(userId,processId,trigger,accountId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessWappCallTrigger(@RequestParam long userId,
                                                          @RequestParam String triggerId,
                                                          @RequestParam String trigger,
                                                          @RequestParam String accountId) {

        ProcessWappCallTriggerWSModel response = processWappCallTriggerMiddleware.updateProcessWappCallTrigger(userId,triggerId,trigger,accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessWappCallTrigger(@RequestParam long userId,
                                                          @RequestParam String triggerId) {

        ProcessWappCallTriggerWSModel response = processWappCallTriggerMiddleware.removeProcessWappCallTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
