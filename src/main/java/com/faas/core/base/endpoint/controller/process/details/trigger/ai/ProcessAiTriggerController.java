package com.faas.core.base.endpoint.controller.process.details.trigger.ai;

import com.faas.core.base.middleware.process.details.trigger.ai.ProcessAiTriggerMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.ai.ProcessAITriggerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/trigger/ai/")
public class ProcessAiTriggerController {


    @Autowired
    ProcessAiTriggerMiddleware processAiTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_AI_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessAITriggers(@RequestParam long userId,
                                                  @RequestParam String processId) {

        ProcessAITriggerWSModel response = processAiTriggerMiddleware.getProcessAITriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessAITrigger(@RequestParam long userId,
                                                 @RequestParam String triggerId) {

        ProcessAITriggerWSModel response = processAiTriggerMiddleware.getProcessAITrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessAITrigger(@RequestParam long userId,
                                                    @RequestParam String processId,
                                                    @RequestParam String trigger,
                                                    @RequestParam String accountId,
                                                    @RequestParam long typeId) {

        ProcessAITriggerWSModel response = processAiTriggerMiddleware.createProcessAITrigger(userId,processId,trigger,accountId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessAITrigger(@RequestParam long userId,
                                                    @RequestParam String triggerId,
                                                    @RequestParam String trigger,
                                                    @RequestParam String accountId) {

        ProcessAITriggerWSModel response = processAiTriggerMiddleware.updateProcessAITrigger(userId,triggerId,trigger,accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_AI_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessAITrigger(@RequestParam long userId,
                                                    @RequestParam String triggerId) {

        ProcessAITriggerWSModel response = processAiTriggerMiddleware.removeProcessAITrigger(userId,triggerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
