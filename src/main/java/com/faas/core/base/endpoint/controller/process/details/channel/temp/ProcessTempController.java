package com.faas.core.base.endpoint.controller.process.details.channel.temp;

import com.faas.core.base.middleware.process.details.channel.temp.ProcessTempMiddleware;
import com.faas.core.base.model.ws.process.details.channel.temp.*;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/channel/temp/")
public class ProcessTempController {


    @Autowired
    ProcessTempMiddleware processTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessTemp(@RequestParam long userId,
                                            @RequestParam String processId) {

        ProcessTempWSModel response = processTempMiddleware.getProcessTemp(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
