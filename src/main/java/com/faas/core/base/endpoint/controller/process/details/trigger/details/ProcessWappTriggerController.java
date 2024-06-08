package com.faas.core.base.endpoint.controller.process.details.trigger.details;

import com.faas.core.base.middleware.process.details.trigger.details.ProcessWappTriggerMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.details.ProcessWappCallTriggerWSModel;
import com.faas.core.base.model.ws.process.details.trigger.details.ProcessWappMessageTriggerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/trigger/wapp/")
public class ProcessWappTriggerController {


    @Autowired
    ProcessWappTriggerMiddleware processWappTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_MESSAGE_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappMessageTriggers(@RequestParam long userId,
                                                           @RequestParam String processId) {

        ProcessWappMessageTriggerWSModel response = processWappTriggerMiddleware.getProcessWappMessageTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappMessageTrigger(@RequestParam long userId,
                                                          @RequestParam String triggerId) {

        ProcessWappMessageTriggerWSModel response = processWappTriggerMiddleware.getProcessWappMessageTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessWappMessageTrigger(@RequestParam long userId,
                                                             @RequestParam String processId,
                                                             @RequestParam String trigger,
                                                             @RequestParam String accountId,
                                                             @RequestParam String wappTitle,
                                                             @RequestParam String wappBody,
                                                             @RequestParam long typeId) {

        ProcessWappMessageTriggerWSModel response = processWappTriggerMiddleware.createProcessWappMessageTrigger(userId,processId,trigger,accountId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessWappMessageTrigger(@RequestParam long userId,
                                                             @RequestParam String triggerId,
                                                             @RequestParam String trigger,
                                                             @RequestParam String accountId,
                                                             @RequestParam String wappTitle,
                                                             @RequestParam String wappBody) {

        ProcessWappMessageTriggerWSModel response = processWappTriggerMiddleware.updateProcessWappMessageTrigger(userId,triggerId,trigger,accountId,wappTitle,wappBody);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_WAPP_MESSAGE_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessWappMessageTrigger(@RequestParam long userId,
                                                             @RequestParam String triggerId) {

        ProcessWappMessageTriggerWSModel response = processWappTriggerMiddleware.removeProcessWappMessageTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_CALL_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappCallTriggers(@RequestParam long userId,
                                                        @RequestParam String processId) {

        ProcessWappCallTriggerWSModel response = processWappTriggerMiddleware.getProcessWappCallTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappCallTrigger(@RequestParam long userId,
                                                       @RequestParam String triggerId) {

        ProcessWappCallTriggerWSModel response = processWappTriggerMiddleware.getProcessWappCallTrigger(userId,triggerId);

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

        ProcessWappCallTriggerWSModel response = processWappTriggerMiddleware.createProcessWappCallTrigger(userId,processId,trigger,accountId,typeId);

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

        ProcessWappCallTriggerWSModel response = processWappTriggerMiddleware.updateProcessWappCallTrigger(userId,triggerId,trigger,accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_WAPP_CALL_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessWappCallTrigger(@RequestParam long userId,
                                                          @RequestParam String triggerId) {

        ProcessWappCallTriggerWSModel response = processWappTriggerMiddleware.removeProcessWappCallTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
