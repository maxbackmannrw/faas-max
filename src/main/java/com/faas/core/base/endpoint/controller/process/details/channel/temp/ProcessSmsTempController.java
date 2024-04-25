package com.faas.core.base.endpoint.controller.process.details.channel.temp;

import com.faas.core.base.middleware.process.details.channel.temp.ProcessSmsTempMiddleware;
import com.faas.core.base.model.ws.process.details.channel.temp.ProcessSmsTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/channel/temp/sms/")
public class ProcessSmsTempController {


    @Autowired
    ProcessSmsTempMiddleware processSmsTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_SMS_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSmsTemps(@RequestParam long userId,
                                                @RequestParam String processId) {

        ProcessSmsTempWSModel response = processSmsTempMiddleware.getProcessSmsTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_SMS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSmsTemp(@RequestParam long userId,
                                               @RequestParam String tempId) {

        ProcessSmsTempWSModel response = processSmsTempMiddleware.getProcessSmsTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_SMS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessSmsTemp(@RequestParam long userId,
                                                  @RequestParam String processId,
                                                  @RequestParam String smsTitle,
                                                  @RequestParam String smsBody,
                                                  @RequestParam String senderId,
                                                  @RequestParam long typeId) {

        ProcessSmsTempWSModel response = processSmsTempMiddleware.createProcessSmsTemp(userId,processId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_SMS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessSmsTemp(@RequestParam long userId,
                                                  @RequestParam String tempId,
                                                  @RequestParam String smsTitle,
                                                  @RequestParam String smsBody,
                                                  @RequestParam String senderId,
                                                  @RequestParam long typeId) {

        ProcessSmsTempWSModel response = processSmsTempMiddleware.updateProcessSmsTemp(userId,tempId,smsTitle,smsBody,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_SMS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessSmsTemp(@RequestParam long userId,
                                                  @RequestParam String tempId) {

        ProcessSmsTempWSModel response = processSmsTempMiddleware.removeProcessSmsTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
