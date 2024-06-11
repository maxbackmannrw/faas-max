package com.faas.core.base.endpoint.controller.process.details.channel.temp.details;

import com.faas.core.base.middleware.process.details.channel.temp.details.ProcessWappTempMiddleware;
import com.faas.core.base.model.ws.process.details.channel.temp.details.ProcessWappMessageTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/channel/temp/wapp/")
public class ProcessWappTempController {


    @Autowired
    ProcessWappTempMiddleware processWappTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_MESSAGE_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappMessageTemps(@RequestParam long userId,
                                                        @RequestParam String processId) {

        ProcessWappMessageTempWSModel response = processWappTempMiddleware.getProcessWappMessageTemps(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappMessageTemp(@RequestParam long userId,
                                                       @RequestParam String tempId) {

        ProcessWappMessageTempWSModel response = processWappTempMiddleware.getProcessWappMessageTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessWappMessageTemp(@RequestParam long userId,
                                                          @RequestParam String processId,
                                                          @RequestParam String wappTitle,
                                                          @RequestParam String wappBody,
                                                          @RequestParam long typeId) {

        ProcessWappMessageTempWSModel response = processWappTempMiddleware.createProcessWappMessageTemp(userId,processId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessWappMessageTemp(@RequestParam long userId,
                                                          @RequestParam String tempId,
                                                          @RequestParam String wappTitle,
                                                          @RequestParam String wappBody,
                                                          @RequestParam long typeId) {

        ProcessWappMessageTempWSModel response = processWappTempMiddleware.updateProcessWappMessageTemp(userId,tempId,wappTitle,wappBody,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessWappMessageTemp(@RequestParam long userId,
                                                          @RequestParam String tempId) {

        ProcessWappMessageTempWSModel response = processWappTempMiddleware.removeProcessWappMessageTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
