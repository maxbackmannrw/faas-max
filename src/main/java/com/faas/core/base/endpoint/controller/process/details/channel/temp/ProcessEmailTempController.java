package com.faas.core.base.endpoint.controller.process.details.channel.temp;

import com.faas.core.base.middleware.process.details.channel.temp.ProcessEmailTempMiddleware;
import com.faas.core.base.model.ws.process.details.channel.temp.ProcessEmailTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/channel/temp/email/")
public class ProcessEmailTempController {


    @Autowired
    ProcessEmailTempMiddleware processEmailTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_EMAIL_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessEmailTemps(@RequestParam long userId,
                                                  @RequestParam String processId) {

        ProcessEmailTempWSModel response = processEmailTempMiddleware.getProcessEmailTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessEmailTemp(@RequestParam long userId,
                                                 @RequestParam String tempId) {

        ProcessEmailTempWSModel response = processEmailTempMiddleware.getProcessEmailTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessEmailTemp(@RequestParam long userId,
                                                    @RequestParam String processId,
                                                    @RequestParam String emailSubject,
                                                    @RequestParam String emailBody,
                                                    @RequestParam String emailSender,
                                                    @RequestParam long typeId) {

        ProcessEmailTempWSModel response = processEmailTempMiddleware.createProcessEmailTemp(userId,processId,emailSubject,emailBody,emailSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessEmailTemp(@RequestParam long userId,
                                                    @RequestParam String tempId,
                                                    @RequestParam String emailSubject,
                                                    @RequestParam String emailBody,
                                                    @RequestParam String emailSender,
                                                    @RequestParam long typeId) {

        ProcessEmailTempWSModel response = processEmailTempMiddleware.updateProcessEmailTemp(userId,tempId,emailSubject,emailBody,emailSender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessEmailTemp(@RequestParam long userId,
                                                    @RequestParam String tempId) {

        ProcessEmailTempWSModel response = processEmailTempMiddleware.removeProcessEmailTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
