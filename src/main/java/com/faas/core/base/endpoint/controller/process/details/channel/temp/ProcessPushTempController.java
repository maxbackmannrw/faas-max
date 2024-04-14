package com.faas.core.base.endpoint.controller.process.details.channel.temp;

import com.faas.core.base.middleware.process.details.channel.temp.ProcessPushTempMiddleware;
import com.faas.core.base.model.ws.process.details.channel.temp.ProcessPushTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/channel/temp/push/")
public class ProcessPushTempController {


    @Autowired
    ProcessPushTempMiddleware processPushTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_PUSH_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessPushTemps(@RequestParam long userId,
                                                 @RequestParam String processId) {

        ProcessPushTempWSModel response = processPushTempMiddleware.getProcessPushTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessPushTemp(@RequestParam long userId,
                                                @RequestParam String tempId) {

        ProcessPushTempWSModel response = processPushTempMiddleware.getProcessPushTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessPushTemp(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam String pushHeader,
                                                   @RequestParam String pushBody,
                                                   @RequestParam String pushFooter,
                                                   @RequestParam String pushSender,
                                                   @RequestParam long typeId) {

        ProcessPushTempWSModel response = processPushTempMiddleware.createProcessPushTemp(userId,processId,pushHeader,pushBody,pushFooter,pushSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessPushTemp(@RequestParam long userId,
                                                   @RequestParam String tempId,
                                                   @RequestParam String pushHeader,
                                                   @RequestParam String pushBody,
                                                   @RequestParam String pushFooter,
                                                   @RequestParam String pushSender,
                                                   @RequestParam long typeId) {

        ProcessPushTempWSModel response = processPushTempMiddleware.updateProcessPushTemp(userId,tempId,pushHeader,pushBody,pushFooter,pushSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessPushTemp(@RequestParam long userId,
                                                   @RequestParam String tempId) {

        ProcessPushTempWSModel response = processPushTempMiddleware.removeProcessPushTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
