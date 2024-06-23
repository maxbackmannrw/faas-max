package com.faas.core.base.endpoint.controller.process.details.trigger.details;

import com.faas.core.base.middleware.process.details.trigger.details.ProcessSipTriggerMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.ProcessSipTriggerWSModel;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/trigger/sip/")
public class ProcessSipTriggerController {


    @Autowired
    ProcessSipTriggerMiddleware processSipTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_SIP_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSipTriggers(@RequestParam long userId,
                                                   @RequestParam String processId){

        ProcessSipTriggerWSModel response = processSipTriggerMiddleware.getProcessSipTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSipTrigger(@RequestParam long userId,
                                                  @RequestParam String triggerId) {

        ProcessSipTriggerWSModel response = processSipTriggerMiddleware.getProcessSipTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessSipTrigger(@RequestParam long userId,
                                                     @RequestParam String processId,
                                                     @RequestParam String trigger,
                                                     @RequestParam String accountId,
                                                     @RequestParam String callerId,
                                                     @RequestParam long typeId) {

        ProcessSipTriggerWSModel response = processSipTriggerMiddleware.createProcessSipTrigger(userId,processId,trigger,accountId,callerId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessSipTrigger(@RequestParam long userId,
                                                     @RequestParam String triggerId,
                                                     @RequestParam String trigger,
                                                     @RequestParam String accountId,
                                                     @RequestParam String callerId) {

        ProcessSipTriggerWSModel response = processSipTriggerMiddleware.updateProcessSipTrigger(userId,triggerId,trigger,accountId,callerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_SIP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessSipTrigger(@RequestParam long userId,
                                                     @RequestParam String triggerId) {

        ProcessSipTriggerWSModel response = processSipTriggerMiddleware.removeProcessSipTrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
