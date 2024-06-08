package com.faas.core.base.endpoint.controller.process.details.trigger.content;

import com.faas.core.base.middleware.process.details.trigger.content.ProcessTriggerMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.content.ProcessTriggerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/trigger/")
public class ProcessTriggerController {


    @Autowired
    ProcessTriggerMiddleware processTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_TRIGGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessTriggers(@RequestParam long userId,
                                                @RequestParam String processId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.getProcessTriggers(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}