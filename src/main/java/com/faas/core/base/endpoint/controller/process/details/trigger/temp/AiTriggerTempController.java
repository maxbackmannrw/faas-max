package com.faas.core.base.endpoint.controller.process.details.trigger.temp;

import com.faas.core.base.middleware.process.details.trigger.temp.AiTriggerTempMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.temp.AITriggerTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/trigger/temp/ai/")
public class AiTriggerTempController {


    @Autowired
    AiTriggerTempMiddleware aiTriggerTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_AI_TRIGGER_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getAITriggerTemps(@RequestParam long userId,
                                               @RequestParam String processId) {

        AITriggerTempWSModel response = aiTriggerTempMiddleware.getAITriggerTemps(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_AI_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getAITriggerTemp(@RequestParam long userId,
                                              @RequestParam String tempId) {

        AITriggerTempWSModel response = aiTriggerTempMiddleware.getAITriggerTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_AI_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createAITriggerTemp(@RequestParam long userId,
                                                 @RequestParam String processId,
                                                 @RequestParam String trigger,
                                                 @RequestParam String accountId,
                                                 @RequestParam long typeId) {

        AITriggerTempWSModel response = aiTriggerTempMiddleware.createAITriggerTemp(userId,processId,trigger,accountId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_AI_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateAITriggerTemp(@RequestParam long userId,
                                                 @RequestParam String tempId,
                                                 @RequestParam String trigger,
                                                 @RequestParam String accountId) {

        AITriggerTempWSModel response = aiTriggerTempMiddleware.updateAITriggerTemp(userId,tempId,trigger,accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_AI_TRIGGER_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeAITriggerTemp(@RequestParam long userId,
                                                 @RequestParam String tempId) {

        AITriggerTempWSModel response = aiTriggerTempMiddleware.removeAITriggerTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
