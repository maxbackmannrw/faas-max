package com.faas.core.utils.task.controller;

import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import com.faas.core.utils.task.model.ws.SystemStateWSModel;
import com.faas.core.utils.task.service.SystemTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/task/")
public class SystemTaskController {

    @Autowired
    SystemTaskService systemTaskService;

    @RequestMapping(value = BaseRoute.GET_SYSTEM_STATE, method = RequestMethod.GET)
    public ResponseEntity<?> getSystemState(@RequestParam("from") String from) {

        SystemStateWSModel response = systemTaskService.getSystemState(from);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
